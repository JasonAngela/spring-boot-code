package itg.hbase;

import lombok.Data;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Data
@Component
@Configuration
public class HbaseConfig {

    private String zookeeper;

    private String parent;

    private String port;

    public Connection getConnection() throws IOException {
        org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", zookeeper);
        config.set("hbase.zookeeper.property.clientPort", port);
        if (parent != null && !"".equals(parent)) {
            config.set("zookeeper.znode.parent", parent);
        }
        return ConnectionFactory.createConnection(config);
    }

}
