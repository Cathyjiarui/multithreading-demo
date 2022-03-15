package com.example.multithreadingdemo.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OOMDemo
 * @Description 模拟OOM
 * @Author ZhangJia
 * @Date 2020/7/2
 * @Version 1.0
 **/
public class OomDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true){
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            });
        }
    }
}
