package com.qilang.hdfs.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Author huql
 *
 * @Description
 * @Date
 **/
public class WordCountJobNoReduce {

    /**
     * k1 v1-> 0 hello    10-you...这种格式
     * k2 v2-> hello 1   you 1...这种格式
     */
    public static class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

        /**
         * map阶段
         * @param k1
         * @param v1
         * @param context
         * @throws IOException
         * @throws InterruptedException
         */
        @Override
        protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {

            /**
             * 原文件内容
             * hello you
             * hello me
             */

            /**
             * v1 就是指文件内容
             * k1 指偏移量
             */
            String[] words = v1.toString().split(" ");
            for (String word : words) {
                context.write(new Text(word), new LongWritable(1L));
            }
        }
    }

//    public static class MyReduce extends Reducer<Text, LongWritable, Text, LongWritable> {
//
//        /**
//         * reduce阶段
//         * @param k2
//         * @param v2s
//         * @param context
//         * @throws IOException
//         * @throws InterruptedException
//         */
//        @Override
//        protected void reduce(Text k2, Iterable<LongWritable> v2s, Context context) throws IOException, InterruptedException {
//
//            /**
//             * 针对<k2, {v2...}>数据  输出k3 v3
//             */
//            long sum = 0L;
//            for (LongWritable v2 : v2s) {
//                sum += v2.get();
//            }
//
//            context.write(k2, new LongWritable(sum));
//        }
//    }


    /**
     * 组装job map+reduce
     */

    public static void main(String[] args) {
        try {
            Configuration conf =  new Configuration();
            Job job = Job.getInstance(conf);


            //这一行必须设置 集群必须找到Job类
            job.setJarByClass(WordCountJobNoReduce.class);

            //指定输入路劲--读文件
            FileInputFormat.setInputPaths(job, new Path("/hello.txt"));

            //指定输出路劲--输出结果
            FileOutputFormat.setOutputPath(job, new Path("/out/noReduce"));

            //指定mapper相关代码
            job.setMapperClass(MyMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(LongWritable.class);


            //reduce模块不是必须的 表示没有reduce任务模模块
            job.setNumReduceTasks(0);
            //指定reduce相关代码
//            job.setReducerClass(MyReduce.class);
//            job.setOutputKeyClass(Text.class);
//            job.setOutputValueClass(LongWritable.class);


            //提交job
            job.waitForCompletion(true);

        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }

}
