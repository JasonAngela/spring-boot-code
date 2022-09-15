package com.qilang.hdfs.mr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author huql
 *
 * @Description
 * @Date
 **/
public class WordCountJob {

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

    public static class MyReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

        /**
         * reduce阶段
         * @param k2
         * @param v2s
         * @param context
         * @throws IOException
         * @throws InterruptedException
         */
        @Override
        protected void reduce(Text k2, Iterable<LongWritable> v2s, Context context) throws IOException, InterruptedException {

            /**
             * 针对<k2, {v2...}>数据  输出k3 v3
             */
            long sum = 0L;
            for (LongWritable v2 : v2s) {
                sum += v2.get();
            }

            context.write(k2, new LongWritable(sum));
        }
    }


    /**
     * 组装job map+reduce
     */

    public static void main(String[] args) {

    }

}
