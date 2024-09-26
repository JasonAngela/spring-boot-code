package com.qilang.test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DelayTest {




    public static void main(String[] args) throws InterruptedException {

        // 创建定时任务线程池,核心线程数为2
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        Runnable task = new Runnable() {
            int a = 1;
            @Override
            public void run() {
                int b = a + 1;
                if(b==2) {
                    System.out.println("结束重新来");
                    scheduledThreadPoolExecutor.schedule(this, 1, TimeUnit.SECONDS);
                    return;
                }
                scheduledThreadPoolExecutor.schedule(this, 1, TimeUnit.SECONDS);
            }
        };
        scheduledThreadPoolExecutor.schedule(task, 1, TimeUnit.SECONDS);
    }


}
