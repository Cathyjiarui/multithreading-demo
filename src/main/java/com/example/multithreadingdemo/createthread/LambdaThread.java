package com.example.multithreadingdemo.createthread;

/**
 * @ClassName LambdaThread
 * @Description 方式四 Lambda表达式
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class LambdaThread {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
