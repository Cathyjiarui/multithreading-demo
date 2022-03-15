package com.example.multithreadingdemo.synchronizeddemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronizedLockMethod
 * @Description synchronized修饰普通方法:锁住对象的示例
 * @Author ZhangJia
 * @Date 2020/6/16
 * @Version 1.0
 **/
public class SynchronizedLockMethod {

    //synchronized关键字加在普通方法上
    public synchronized void printThreadName(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedLockMethod synchronizedLockMethod1 = new SynchronizedLockMethod();
        SynchronizedLockMethod synchronizedLockMethod2 = new SynchronizedLockMethod();

        new Thread(() -> {
            synchronizedLockMethod1.printThreadName();
        }).start();

        new Thread(() -> {
            synchronizedLockMethod2.printThreadName();
        }).start();
    }
}
