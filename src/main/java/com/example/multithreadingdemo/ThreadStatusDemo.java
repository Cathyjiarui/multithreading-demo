package com.example.multithreadingdemo;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadStatusDemo
 * @Description 线程状态演示
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class ThreadStatusDemo {

    @SneakyThrows
    public static void main(String[] args) {
        //RUNNABLE
//        new Thread(() -> {
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();

        //BLOCKED
//        Object object = new Object();
//        new Thread(() -> {
//            synchronized (object){
//                try {
//                    TimeUnit.MINUTES.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(2000L);
//        new Thread(() -> {
//            synchronized (object){
//
//            }
//        }).start();

        //WAITING
        Object object = new Object();
        new Thread(() -> {
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
