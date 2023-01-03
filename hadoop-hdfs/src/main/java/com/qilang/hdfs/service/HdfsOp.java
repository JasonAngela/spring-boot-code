package com.qilang.hdfs.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class HdfsOp {


    private static final  String HDFS_PATH = "hdfs://10.0.0.46:9000";

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        //获取hdfs配置信息
        Configuration configuration = new Configuration();
        configuration.set("dfs.client.use.datanode.hostname", "true");
        //获取操作Hdfs对象
        FileSystem fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, "root");

        fileSystem.copyFromLocalFile(new Path("C:\\Users\\hql\\Desktop\\向日葵远程控制_3716383.exe"), new Path("/向日葵.exe"));
        fileSystem.close();

//        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/user.txt"));
//
//        fsDataOutputStream.write("你好啊，老婆111".getBytes());
//        fsDataOutputStream.close();

        //获取本地文件输入流
        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hql\\Desktop\\asas.txt");

        //获取HDFS系统的输出流
      //  FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/asas.txt"));

        //上传文件 通过工具类把输入流拷贝到输出流中，实现本地文件上传到HDFS
      //  IOUtils.copyBytes(fileInputStream, fsDataOutputStream, 1024, true);

        //fileSystem.delete(new Path("/asas.txt"), true);

    }
}
