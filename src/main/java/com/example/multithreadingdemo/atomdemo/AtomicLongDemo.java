package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName AtomicLongDemo
 * @Description AtomicLong示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicLongDemo {

    private static AtomicLong atomicLong = new AtomicLong(1L);

    public static void inCreate() {
        atomicLong.incrementAndGet();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                inCreate();
                System.out.println(atomicLong.get());
            }).start();
        }
    }
}
