package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicIntegerDemo
 * @Description AtomicInteger示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicIntegerDemo {

    private static AtomicInteger sum = new AtomicInteger(0);

    public static void inCreate() {
        sum.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inCreate();
                    System.out.println(sum);
                }
            }).start();
        }
    }
}
