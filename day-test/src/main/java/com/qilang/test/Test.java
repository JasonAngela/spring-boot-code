package com.qilang.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {


    private static final String upperStr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerStr="abcdefghijklmnopqrstuvwxyz";
    private static final String numStr="1234567890";



    public static void main(String[] args) {


        String str = "";
        System.out.println(str.substring(2000));
//        DataTaskSaveDTO dataTaskSaveDTO = new DataTaskSaveDTO();
//        dataTaskSaveDTO.setModelCode("asasa");
//
//        List<DataTaskSaveDTO.TaskData> taskDataList = new ArrayList<>();
//        DataTaskSaveDTO.TaskData taskData1 = new DataTaskSaveDTO.TaskData();
//        taskData1.setTaskCode("asasas");
//
//        List<DataTaskSaveDTO.AuditRole> roles = new ArrayList<>();
//
//        DataTaskSaveDTO.AuditRole role1 = new DataTaskSaveDTO.AuditRole();
//        role1.setRoleId(2391031236666666666L);
//        role1.setRoleName("asasa");
//        roles.add(role1);
//
//        DataTaskSaveDTO.AuditRole role2 = new DataTaskSaveDTO.AuditRole();
//        role2.setRoleId(44444444L);
//        role2.setRoleName("asjaskalsa");
//        roles.add(role2);
//        taskData1.setAuditRoles(roles);
//
//        List<DataTaskSaveDTO.AuditUser> users = new ArrayList<>();
//        DataTaskSaveDTO.AuditUser user1 = new DataTaskSaveDTO.AuditUser();
//        user1.setUserId(239156603123L);
//        user1.setUserName("哈哈哈哈哈");
//        users.add(user1);
//
//        DataTaskSaveDTO.AuditUser user2 = new DataTaskSaveDTO.AuditUser();
//        user2.setUserId(2391566077873123L);
//        user2.setUserName("哈哈哈哈哈11111");
//        users.add(user2);
//        taskData1.setAuditRoles(roles);
//        taskData1.setAuditUsers(users);
//        taskDataList.add(taskData1);
//
//        DataTaskSaveDTO.TaskData taskData2 = new DataTaskSaveDTO.TaskData();
//        taskData2.setTaskCode("asasaasasasas");
//        taskDataList.add(taskData2);
//
//        dataTaskSaveDTO.setTaskData(taskDataList);
//
//
//        FlowSaveDTO flowSaveDTO = BeanUtil.copyProperties(dataTaskSaveDTO, FlowSaveDTO.class);
//        System.out.println(JSON.toJSONString(flowSaveDTO));

        //System.out.println(ObjectUtil.equal(HttpStatus.HTTP_OK, 200));


//        Map<String, String> map = new HashMap<>();
//        map.put("a", "b");
//        map.put("b", "c");
//        System.out.println(map.keySet());
//
//
//        List<String> list = new ArrayList<>();
//        Map<String,String> map1 = list.stream().collect(Collectors.toMap(k -> k, v -> v));
//        List<String> list1 = new ArrayList<>();
//        list1.add("12");
//        map1.keySet().removeAll(list1);
//        System.out.println(map1.keySet());
//        int randomIntA = RandomUtil.randomInt(4, 9);
//        int randomIntB = RandomUtil.randomInt(4, 9);

//        String a = RandomUtil.randomString(4);
//        String b = RandomUtil.randomStringUpper(4);
//
//        System.out.println(CharSequenceUtil.appendIfMissing(a, b));


//        String randomString="";
//        while (!(StrUtil.containsAny(randomString, upperStr) && StrUtil.containsAny(randomString,lowerStr) && StrUtil.containsAny(randomString,numStr))){
//            // 生成8到17之间的随机整数(包含8不包含17)
            int randomInt = RandomUtil.randomInt(8, 17);
//            randomString = RandomUtil.randomString(upperStr + lowerStr + numStr, randomInt);
//        }
//        System.out.println(randomString);


//        Simple simple = new Simple();
//        simple.setId("asasa");
//        simple.setName("9231jsak");
//
//        System.out.println(BeanUtil.beanToMap(simple));
//
//
//        String str = "1231212a";
//
//        Pattern p = Pattern.compile("[a-zA-z]");
//
//        System.out.println(p.matcher(str).find());
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("1122");
//        list1.add("2321");
//        list1.add("2asa321");
//
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("1122");
//        list2.add("2320");
//        list2.add("2321");
//        list2.add("2321xxx");
//        list2.add("2asa321");
//
//        System.out.println(list1.containsAll(list2));
//
//        System.out.println(CollUtil.containsAll(list1, list2));
//        List<String> sub = (List<String>) CollUtil.subtract(list2, list1);
//        System.out.println(sub);

//        Set<String> mdmCodes = new HashSet<>();
//        mdmCodes.add("12sasa");
//        mdmCodes.add("opo09102");
//        mdmCodes.add("8723nksada");
//
//        AtomicReference<String> param = new AtomicReference<>("");
//        mdmCodes.forEach(m -> param.set(param.get() + "mdm_code = '" + m + "' || "));
//
//        System.out.println(param.get());
//
//
//        System.out.println(CharSequenceUtil.subBefore(param.get(),"||", true));

//        System.out.println(UUID.fastUUID());
    }
}
