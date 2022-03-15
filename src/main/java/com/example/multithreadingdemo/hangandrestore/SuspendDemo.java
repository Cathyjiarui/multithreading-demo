package com.example.multithreadingdemo.hangandrestore;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SuspendDemo
 * @Description suspend方法挂起演示(已废弃)
 * 不会释放线程所占用的资源。如果使用该方法将某个线程挂起，则可能会使其他等待资源的线程死锁
 * @Author ZhangJia
 * @Date 2020/6/3
 * @Version 1.0
 **/
public class SuspendDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "调用suspend方法");
        //调用suspend挂起线程
        Thread.currentThread().suspend();
        System.out.println(Thread.currentThread().getName() + "调用suspend方法结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SuspendDemo());
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        //唤醒线程
        thread.resume();
    }
}
