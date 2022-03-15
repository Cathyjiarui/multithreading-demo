package com.example.multithreadingdemo.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InterruptDemo
 * @Description Interrupt中断演示
 * @Author ZhangJia
 * @Date 2020/6/3
 * @Version 1.0
 **/
public class InterruptDemo implements Runnable{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
