package com.example.multithreadingdemo.hangandrestore;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadSuspendDemo
 * @Description suspend死锁演示
 * @Author ZhangJia
 * @Date 2020/6/3
 * @Version 1.0
 **/
public class DeadSuspendDemo implements Runnable {

    public static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "调用suspend挂起");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName() + "suspend挂起的线程已被唤醒");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeadSuspendDemo(),"对比线程");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.resume();
        Thread deadThread = new Thread(new DeadSuspendDemo(),"死锁线程");
        deadThread.start();
        deadThread.resume();
    }
}
