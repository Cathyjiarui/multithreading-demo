package com.example.multithreadingdemo.toolsclassdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreDemo
 * @Description  Semaphore示例
 * @Author ZhangJia
 * @Date 2020/7/1
 * @Version 1.0
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(8);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
