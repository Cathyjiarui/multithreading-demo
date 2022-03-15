package com.example.multithreadingdemo.threadpooldemo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolDemo
 * @Description 线程池示例
 * @Author ZhangJia
 * @Date 2020/7/1
 * @Version 1.0
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,3L, TimeUnit.SECONDS,runnables);

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
