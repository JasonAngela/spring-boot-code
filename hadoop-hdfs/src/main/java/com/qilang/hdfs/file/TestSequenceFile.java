package com.qilang.hdfs.file;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author hql
 */
public class TestSequenceFile {

    private static final  String HDFS_PATH = "hdfs://114.116.71.114:9000";

    private static void write(String inputDir, String outputPath) throws IOException {
        //获取hdfs配置信息
        Configuration configuration = new Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");
        configuration.set("fs.defaultFs", HDFS_PATH);
        //获取操作Hdfs对象

        //删除输出文件


        /**
         * 1.选择输出目录
         * 2.描述key
         * 3.描述value(文件内容）
         */
        SequenceFile.Writer.Option[] opts = new SequenceFile.Writer.Option[] {
                SequenceFile.Writer.file(new Path(outputPath)),
                SequenceFile.Writer.keyClass(Text.class),
                SequenceFile.Writer.valueClass(Text.class)
        };
        //创建writer实例
        SequenceFile.Writer writer = SequenceFile.createWriter(configuration, opts);
        //指定需要压缩的文件目录
        File inputFile = new File(inputDir);
        if (inputFile.isDirectory()) {

            for (File file : inputFile.listFiles()) {
                //文件内容
                String fileValue = FileUtils.readFileToString(file, "UTF-8");
                //文件名
                String fileName = file.getName();

                Text key = new Text(fileName);
                Text value = new Text(fileValue);

                writer.append(key, value);
            }

        }

        writer.close();
    }

    public static void main(String[] args) throws URISyntaxException {

    }
}
