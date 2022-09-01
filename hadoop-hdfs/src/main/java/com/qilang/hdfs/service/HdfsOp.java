package com.qilang.hdfs.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class HdfsOp {
    public static void main(String[] args) throws IOException {

        //获取hdfs配置信息
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://114.116.71.114:9000");

        //获取操作Hdfs对象
        FileSystem fileSystem = FileSystem.get(configuration);

        //获取本地文件输入流
        FileInputStream fileInputStream = new FileInputStream("/Users/huqilang/Desktop/setting-bcs.xml");

        //获取HDFS系统的输出流
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/test.xml"));

        //上传文件 通过工具类把输入流拷贝到输出流中，实现本地文件上传到HDFS
        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, 1024, false);

    }
}
