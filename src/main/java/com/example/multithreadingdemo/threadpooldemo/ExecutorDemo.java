package com.example.multithreadingdemo.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @ClassName ExecutorDemo
 * @Description Executor示例
 * @Author ZhangJia
 * @Date 2020/7/1
 * @Version 1.0
 **/
public class ExecutorDemo {

    public static void main(String[] args) {

        /**
         * 创建一个可以根据需要创建新线程的线程池，如果有空闲线程，优先使用空闲的线程
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        /**
         * 创建一个固定大小的线程池，在任何时候，最多只有N个线程在处理任务
         */
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        /**
         * 能延迟执行、定时执行的线程池
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        /**
         * 工作窃取，使用多个队列来减少竞争
         */
        ExecutorService executorService2 = Executors.newWorkStealingPool();
        /**
         * 单一线程的线程次，只会使用唯一一个线程来执行任务，即使提交再多的任务，也都是会放到等待队列里进行等待
         */
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        /**
         * 单线程能延迟执行、定时执行的线程池
         */
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}