package com.example.multithreadingdemo.toolsclassdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CountDownLatchDemo
 * @Description CountDownLatch示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println("所有进程运行完毕啦～");
        }).start();

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "结束了～");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
