package ${package.ServiceImpl};

import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * ${table.comment!} 服务实现类
 *
 * @author huql
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ServiceImpl<${table.mapperName}, ${entity}> implements ${table.serviceName} {

}