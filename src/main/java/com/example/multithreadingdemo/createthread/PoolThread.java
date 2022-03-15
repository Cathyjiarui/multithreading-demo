package com.example.multithreadingdemo.createthread;

import java.util.concurrent.*;

/**
 * @ClassName PoolThread
 * @Description 方式五 线程池
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class PoolThread {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,10,3L, TimeUnit.SECONDS,new SynchronousQueue<>());
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
