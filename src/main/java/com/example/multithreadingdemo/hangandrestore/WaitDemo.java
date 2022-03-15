package com.example.multithreadingdemo.hangandrestore;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName WaitDemo
 * @Description wait挂起线程演示
 * @Author ZhangJia
 * @Date 2020/6/3
 * @Version 1.0
 **/
public class WaitDemo implements Runnable {

    public static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "调用suspend挂起");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "suspend挂起的线程已被唤醒");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WaitDemo(),"对比线程");
        thread.start();
        Thread thread2 = new Thread(new WaitDemo(),"对比线程2");
        thread2.start();
        TimeUnit.SECONDS.sleep(3);
        synchronized (object){
            object.notify();
        }
    }
}
