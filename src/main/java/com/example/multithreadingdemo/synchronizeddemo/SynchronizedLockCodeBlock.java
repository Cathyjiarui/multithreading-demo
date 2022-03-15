package com.example.multithreadingdemo.synchronizeddemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronizedLockCodeBlock
 * @Description synchronized修饰代码块: 锁住一个对象
 * @Author ZhangJia
 * @Date 2020/6/16
 * @Version 1.0
 **/
public class SynchronizedLockCodeBlock {

    Object lock = new Object();

    public void printThreadName(){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedLockCodeBlock synchronizedLockCodeBlock = new SynchronizedLockCodeBlock();
        new Thread(() -> {
            synchronizedLockCodeBlock.printThreadName();
        }).start();
        new Thread(() -> {
            synchronizedLockCodeBlock.printThreadName();
        }).start();
    }
}