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


    @Before("@annotation(dataPermission)")
    public void doBefore(JoinPoint point, DataPermission dataPermission) throws Throwable {
        clearDataScope(point);
        handleDataScope(point, dataPermission);
    }

    protected void handleDataScope(final JoinPoint joinPoint, DataPermission dataPermission) {

    }

    /**
     * 数据范围过滤
     *
     * @param joinPoint 切点
     */
    public static void dataScopeFilter(JoinPoint joinPoint, String tableName,
                                       String field, String sapCodes, String comCodes) {
        StringBuilder sqlString = new StringBuilder();
        List<String> conditions = new ArrayList<String>();

    }

    /**
     * 拼接权限sql前先清空params.
     * dataScope参数防止注入
     */
    private void clearDataScope(final JoinPoint joinPoint) {

    }
}
