package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.DoubleAdder;

/**
 * @ClassName DoubleAdderDemo
 * @Description DoubleAdder示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class DoubleAdderDemo {

    private static DoubleAdder doubleAdder = new DoubleAdder();

    public static void inCreate(){
        doubleAdder.add(1.1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                inCreate();
                System.out.println(doubleAdder.doubleValue());
            }).start();
        }
    }
}
