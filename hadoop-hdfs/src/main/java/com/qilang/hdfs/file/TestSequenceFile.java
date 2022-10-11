package com.qilang.hdfs.file;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author hql
 */
public class TestSequenceFile {

    private static final  String HDFS_PATH = "hdfs://hadoop01:9000";

    private static void write(String inputDir, String outputPath) throws IOException, URISyntaxException, InterruptedException {
        //获取hdfs配置信息
        Configuration configuration = new Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");
        //configuration.set("fs.defaultFs", HDFS_PATH);
        //删除输出文件
        FileSystem fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "root");

        fileSystem.delete(new Path(outputPath), true);


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

            for (File file : Objects.requireNonNull(inputFile.listFiles())) {
                //文件内容
                String fileValue = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                //文件名
                String fileName = file.getName();

                Text key = new Text(fileName);
                Text value = new Text(fileValue);

                writer.append(key, value);
            }

        }

        writer.close();
    }


    private static void read(String inputPath) throws IOException {
        //获取hdfs配置信息
        Configuration configuration = new Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");

        SequenceFile.Reader reader = new SequenceFile.Reader(configuration, SequenceFile.Reader.file(new Path(inputPath)));

        Text key = new Text();
        Text value = new Text();

        while (reader.next(key, value)) {
            System.out.println("文件名:" + key);
            System.out.println("文件内容:" + value);
        }

        reader.close();

    }


    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        //write("D:\\smallfile", HDFS_PATH +"/seqfile");
        read(HDFS_PATH + "/seqfile");
    }
}
