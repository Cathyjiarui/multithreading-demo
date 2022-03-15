package com.example.multithreadingdemo.synchronizeddemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronizedLockStaticMethod
 * @Description synchronized修饰静态方法:锁住整个类
 * @Author ZhangJia
 * @Date 2020/6/16
 * @Version 1.0
 **/
public class SynchronizedLockStaticMethod {

    //synchronized关键字加在静态方法上
    public static synchronized void printThreadName(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedLockStaticMethod synchronizedLockStaticMethod1 = new SynchronizedLockStaticMethod();
        SynchronizedLockStaticMethod synchronizedLockStaticMethod2 = new SynchronizedLockStaticMethod();

        new Thread(() -> {
            synchronizedLockStaticMethod1.printThreadName();
        }).start();

        new Thread(() -> {
            synchronizedLockStaticMethod2.printThreadName();
        }).start();
    }
}
