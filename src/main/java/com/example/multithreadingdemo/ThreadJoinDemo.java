package com.example.multithreadingdemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadJoinDemo
 * @Description Thread.join示例
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class ThreadJoinDemo {

    public static void main(String[] args) {

        //创建线程1
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行了～");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束了～");
        }, "线程1");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行了～");
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束了～");
        },"线程2").start();
    }
}
