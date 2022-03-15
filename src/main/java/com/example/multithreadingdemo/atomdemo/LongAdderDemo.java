package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName LongAdderDemo
 * @Description LongAdder示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class LongAdderDemo {

    private static LongAdder longAdder = new LongAdder();

    public static void inCreate(Long num){
        longAdder.add(num);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                inCreate((long) finalI);
                System.out.println("doubleValue is : " + longAdder.doubleValue());
                System.out.println("floatValue is : " + longAdder.floatValue());
                System.out.println("intValue is : " + longAdder.intValue());
            }).start();
        }
    }
}
