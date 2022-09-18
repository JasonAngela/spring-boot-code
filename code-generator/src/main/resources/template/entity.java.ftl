package ${package.Entity};

import com.itg.bcs.base.entity.SuperDO;
import com.baomidou.mybatisplus.annotation.TableField;
<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
</#if>

/**
 * @author huql
 * @since ${date}
 */
<#if entityLombokModel>
@Data
@EqualsAndHashCode
</#if>
<#if swagger2>
@ApiModel(value="${entity}对象", description="${table.comment!}")
</#if>
public class ${entity} extends ${superEntityClass} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

<#if "${field.name}"!='pk_id' && "${field.name}"!='alive_flag'  && "${field.name}"!='version' && "${field.name}"!='create_user_id' && "${field.name}"!='create_user_name' && "${field.name}"!='create_time' && "${field.name}"!='update_user_id' && "${field.name}"!='update_user_name' && "${field.name}"!='update_time' && "${field.name}"!='app_code'>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
        <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    <#if field.keyFlag>
        <#-- 主键 -->
        <#if field.keyIdentityFlag>
    @TableId(value = "${field.name}", type = IdType.AUTO)
        <#elseif idType??>
    @TableId(value = "${field.name}", type = IdType.${idType})
        <#elseif field.convert>
    @TableId("${field.name}")
        </#if>
        <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
        <#if field.convert>
    @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
        <#else>
    @TableField(fill = FieldFill.${field.fill})
        </#if>
    <#elseif field.convert>
    @TableField("${field.name}")
    </#if>
    <#-- 乐观锁注解 -->
    <#if (versionFieldName!"") == field.name>
    @Version
    </#if>
    <#-- 逻辑删除注解 -->
    <#if (logicDeleteFieldName!"") == field.name>
    @TableLogic
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#if>
</#list>
}
