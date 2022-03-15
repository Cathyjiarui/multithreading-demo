package com.example.multithreadingdemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName UnSafeThread
 * @Description wait示例
 * @Author ZhangJia
 * @Date 2020/6/24
 * @Version 1.0
 **/
public class WaitDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        Object o = new Object();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (!flag){
                    synchronized (o){
                        System.out.println("Object is false.");
                        try {
                            o.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
                System.out.println("Object is true.");
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        new Thread(() -> {
            flag = true;
            synchronized (o){
                o.notifyAll();
            }
        }).start();
    }
}
