package config;

import java.lang.annotation.*;


/**
 * @author huqilang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermission {

    /**
     * 业务方嵌入数据权限表面
     */
     String tableName() default "";

    /**
     * 业务方嵌入数据字段名
     */
    public String field() default "";

    /**
     * sapCodes,逗号隔开
     */
    String sapCodes() default "";

    /**
     * comCodes,逗号隔开
     */
    String comCodes() default "";

}
