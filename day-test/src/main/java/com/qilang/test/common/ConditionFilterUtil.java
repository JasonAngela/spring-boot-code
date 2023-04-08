package com.qilang.test.common;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import cn.hutool.core.util.ReflectUtil;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.EqualPredicate;


/**
 * @ClassName: ConditionFilterUtil
 *
 * @Description: 条件过滤工具类
 */
public class ConditionFilterUtil {

    /**
     *    用于处理属性与属性值的类
     */
    public static class ConditionListMap {
        private Map<String, List<Object>> map = new HashMap<>();
        public List<Object> get(String key) {
            return map.get(key);
        };
        public Map<String, List<Object>> getMap() {
            return map;
        }
        public void put(String key, Object value) {
            List<Object> list = map.get(key);
            if (list != null) {
                list.add(value);
            } else {
                List<Object> arrayList = new ArrayList<Object>();
                arrayList.add(value);
                map.put(key, arrayList);
            }
        }
    }

    /**
     * 根据条件筛选出相应对象集合
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> findList(Collection<T> list, String propertyName, Object agers) {
        if (agers == null) {
            // 如果是空则返回一个复制的集合
            return new ArrayList<>(list);
        }
        EqualPredicate parameter = new EqualPredicate(agers);
        BeanPredicate tableCoulmn_paramerter = new BeanPredicate(propertyName, parameter);
        List<T> filteredCollection = null;
        synchronized (list) {
            filteredCollection = (List<T>) CollectionUtils.select(list, tableCoulmn_paramerter);
        }
        return filteredCollection;
    }

    /**
     * 根据条件筛选出相应对象集合,只对该对象本身的属性进行筛选，排除继承属性
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> findListByMultiCond(Collection<T> list, T obj) {
        try {
            if (obj == null) { // 如果是空则返回一个复制的集合
                return new ArrayList<T>(list);
            }
            Predicate allPredicate = getAllPredicateByList(obj);
            List<T> filteredCollection;
            synchronized (list) {
                filteredCollection = (List<T>) CollectionUtils.select(list, allPredicate);
            }
            return filteredCollection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    /**
     * 根据条件筛选出相应对象集合,只对该对象本身的属性进行筛选，排除继承属性
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> findListByMultiCond(List<T> list, T obj) {

        try {
            if (obj == null) { // 如果是空则返回一个复制的集合
                return new ArrayList<T>(list);
            }
            Predicate allPredicate = getAllPredicateByList(obj);
            List<T> filteredCollection = null;
            synchronized (list) {
                filteredCollection = (List<T>) CollectionUtils.select(list, allPredicate);
            }
            return filteredCollection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<T>();
    }

    /**
     * 获取满足所有条件的断言
     */
    public static Predicate getAllPredicateByList(ConditionListMap conditionListMap) {
        Map<String, List<Object>> propertyValMap = conditionListMap.getMap();
        List<Predicate> predicateList = new ArrayList<>();
        Set<Entry<String, List<Object>>> entrySet = propertyValMap.entrySet();
        for (Entry<String, List<Object>> entry : entrySet) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();
            for (Object value : values) {
                EqualPredicate parameter = new EqualPredicate(value);
                BeanPredicate tableCoulmn_paramerter = new BeanPredicate(key, parameter);
                predicateList.add(tableCoulmn_paramerter);
            }
        }
        Predicate predicate = PredicateUtils.allPredicate(predicateList);
        return predicate;
    }

    /**
     * 获取满足所有条件的断言
     */
    public static Predicate getAllPredicateByList(Map<String, Object> propertyValMap) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Set<Entry<String, Object>> entrySet = propertyValMap.entrySet();
        for (Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            EqualPredicate parameter = new EqualPredicate(value);
            BeanPredicate tableCoulmn_paramerter = new BeanPredicate(key, parameter);
            predicateList.add(tableCoulmn_paramerter);
        }
        Predicate predicate = PredicateUtils.allPredicate(predicateList);
        return predicate;
    }

    /**
     * 获取满足所有条件的断言
     */
    public static <T> Predicate getAllPredicateByList(T obj) {
        List<Predicate> predicateList = new ArrayList<>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers()))
                continue; // static或final遍历下一个
            Object fieldValue = ReflectUtil.getFieldValue(obj, field.getName());
            if (fieldValue == null)
                continue;
            EqualPredicate parameter = new EqualPredicate(fieldValue);
            BeanPredicate tableCoulmn_paramerter = new BeanPredicate(field.getName(), parameter);
            predicateList.add(tableCoulmn_paramerter);
        }

        Predicate finalPredicate = PredicateUtils.allPredicate(predicateList);
        return finalPredicate;
    }

    /**
     * 获取满足任意条件的断言EqualPredicate
     */
    public static Predicate getAnyPredicateByList(ConditionListMap conditionListMap) {
        Map<String, List<Object>> propertyValMap = conditionListMap.getMap();
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Set<Entry<String, List<Object>>> entrySet = propertyValMap.entrySet();
        for (Entry<String, List<Object>> entry : entrySet) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();
            for (Object value : values) {
                EqualPredicate parameter = new EqualPredicate(value);
                BeanPredicate tableCoulmn_paramerter = new BeanPredicate(key, parameter);
                predicateList.add(tableCoulmn_paramerter);

            }
        }
        Predicate predicate = PredicateUtils.anyPredicate(predicateList);
        return predicate;
    }

    /**
     * 获取满足任意条件的断言
     */
    public static Predicate getAnyPredicateByList(Map<String, List<Object>> propertyValMap) {

        List<Predicate> predicateList = new ArrayList<Predicate>();
        Set<Entry<String, List<Object>>> entrySet = propertyValMap.entrySet();
        for (Entry<String, List<Object>> entry : entrySet) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();
            for (Object value : values) {
                EqualPredicate parameter = new EqualPredicate(value);
                BeanPredicate tableCoulmn_paramerter = new BeanPredicate(key, parameter);
                predicateList.add(tableCoulmn_paramerter);

            }
        }
        Predicate predicate = PredicateUtils.anyPredicate(predicateList);
        return predicate;
    }

    /**
     * 获取满足所有条件的断言
     */
    public static <T> Predicate getAnyPredicateByList(T obj) {
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers()))
                continue; // static或final遍历下一个

            Object fieldValue = ReflectUtil.getFieldValue(obj, field.getName());
            if (fieldValue == null)
                continue;
            EqualPredicate parameter = new EqualPredicate(fieldValue);
            BeanPredicate tableCoulmn_paramerter = new BeanPredicate(field.getName(), parameter);
            predicateList.add(tableCoulmn_paramerter);
        }

        Predicate finalPredicate = PredicateUtils.anyPredicate(predicateList);
        return finalPredicate;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getFirst(Collection<T> list, String propertyName, Object agers) {
        EqualPredicate parameter = new EqualPredicate(agers);
        BeanPredicate tableCoulmn_paramerter = new BeanPredicate(propertyName, parameter);
        T finalResult = null;
        synchronized (list) {
            finalResult = (T) CollectionUtils.find(list, tableCoulmn_paramerter);
        }
        return finalResult;
    }

    /**
     * 根据条件筛选出相应对象集合
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFirst(List<T> list, String propertyName, Object agers) {
        Predicate finalPredicate = null;
        if (agers == null) {
            finalPredicate = PredicateUtils.truePredicate();
        } else {
            EqualPredicate parameter = new EqualPredicate(agers);
            BeanPredicate tableCoulmn_paramerter = new BeanPredicate(propertyName, parameter);
            T finalResult = null;
            synchronized (list) {
                finalResult = (T) CollectionUtils.find(list, tableCoulmn_paramerter);
            }
            return finalResult;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getFirstByMultiCond(Collection<T> list, T obj) {
        Predicate allPredicateByList = getAllPredicateByList(obj);
        T finalResult = null;
        synchronized (list) {
            finalResult = (T) CollectionUtils.find(list, allPredicateByList);
        }
        return finalResult;
    }

    /**
     * 根据条件筛选出相应对象集合
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFirstByMultiCond(List<T> list, T obj) {
        Predicate allPredicateByList = getAllPredicateByList(obj);
        T finalResult = null;
        synchronized (list) {
            finalResult = (T) CollectionUtils.find(list, allPredicateByList);
        }
        return finalResult;
    }

    /**
     * 获得ConditionListMap
     */
    public static ConditionListMap newConditionListMap() {
        return new ConditionListMap();
    }
}