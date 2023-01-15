package service;

import config.DataPermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huql
 **/
public class DataPermissionService {


    @Before("@annotation(controllerDataScope)")
    public void doBefore(JoinPoint point, DataPermission controllerDataScope) throws Throwable
    {
        clearDataScope(point);
        handleDataScope(point, controllerDataScope);
    }

    protected void handleDataScope(final JoinPoint joinPoint, DataPermission controllerDataScope)
    {
        // 获取当前的用户
        //LoginUser loginUser = SecurityUtils.getLoginUser();
//        if (StringUtils.isNotNull(loginUser))
//        {
//            //用户校验前提
//        }
    }

    /**
     * 数据范围过滤
     *
     * @param joinPoint 切点
     */
    public static void dataScopeFilter(JoinPoint joinPoint, String tableName, String field, String permission)
    {
        StringBuilder sqlString = new StringBuilder();
        List<String> conditions = new ArrayList<String>();




//
//        for (SysRole role : user.getRoles())
//        {
//            String dataScope = role.getDataScope();
//            if (!DATA_SCOPE_CUSTOM.equals(dataScope) && conditions.contains(dataScope))
//            {
//                continue;
//            }
//            if (StringUtils.isNotEmpty(permission) && StringUtils.isNotEmpty(role.getPermissions())
//                    && !StringUtils.containsAny(role.getPermissions(), Convert.toStrArray(permission)))
//            {
//                continue;
//            }
//            if (DATA_SCOPE_ALL.equals(dataScope))
//            {
//                sqlString = new StringBuilder();
//                break;
//            }
//            else if (DATA_SCOPE_CUSTOM.equals(dataScope))
//            {
//                sqlString.append(StringUtils.format(
//                        " OR {}.dept_id IN ( SELECT dept_id FROM sys_role_dept WHERE role_id = {} ) ", deptAlias,
//                        role.getRoleId()));
//            }
//            else if (DATA_SCOPE_DEPT.equals(dataScope))
//            {
//                sqlString.append(StringUtils.format(" OR {}.dept_id = {} ", deptAlias, user.getDeptId()));
//            }
//            else if (DATA_SCOPE_DEPT_AND_CHILD.equals(dataScope))
//            {
//                sqlString.append(StringUtils.format(
//                        " OR {}.dept_id IN ( SELECT dept_id FROM sys_dept WHERE dept_id = {} or find_in_set( {} , ancestors ) )",
//                        deptAlias, user.getDeptId(), user.getDeptId()));
//            }
//            else if (DATA_SCOPE_SELF.equals(dataScope))
//            {
//                if (StringUtils.isNotBlank(userAlias))
//                {
//                    sqlString.append(StringUtils.format(" OR {}.user_id = {} ", userAlias, user.getUserId()));
//                }
//                else
//                {
//                    // 数据权限为仅本人且没有userAlias别名不查询任何数据
//                    sqlString.append(StringUtils.format(" OR {}.dept_id = 0 ", deptAlias));
//                }
//            }
//            conditions.add(dataScope);
//        }

//        if (StringUtils.isNotBlank(sqlString.toString()))
//        {
//            Object params = joinPoint.getArgs()[0];
//            if (StringUtils.isNotNull(params) && params instanceof BaseEntity)
//            {
//                BaseEntity baseEntity = (BaseEntity) params;
//                baseEntity.getParams().put(DATA_SCOPE, " AND (" + sqlString.substring(4) + ")");
//            }
//        }
    }

    /**
     * 拼接权限sql前先清空params.
     * dataScope参数防止注入
     */
    private void clearDataScope(final JoinPoint joinPoint)
    {
//        Object params = joinPoint.getArgs()[0];
//        if (StringUtils.isNotNull(params) && params instanceof BaseEntity)
//        {
//            BaseEntity baseEntity = (BaseEntity) params;
//            baseEntity.getParams().put(DATA_SCOPE, "");
//        }
    }
}
