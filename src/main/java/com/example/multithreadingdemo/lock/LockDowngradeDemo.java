package com.example.multithreadingdemo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName LockDowngradeDemo
 * @Description 锁降级演示
 * @Author ZhangJia
 * @Date 2020/6/19
 * @Version 1.0
 **/
public class LockDowngradeDemo {

    private int num = 0;

    public ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //获取读锁
    Lock readLock = reentrantReadWriteLock.readLock();
    //获取写锁
    Lock writeLock = reentrantReadWriteLock.writeLock();

    public void ThreadMethod() {
        //进行写操作之前获取写锁
        writeLock.lock();
        try {
            //写操作
            num++;
        }finally {
            //获取读锁
            readLock.lock();
            writeLock.unlock();
            //锁降级，释放写锁
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            /**
             * 进行读取操作
             */
            if (num == 1) {
                System.out.println("num = " + num + "!!!");
            } else {
                System.out.println("num = " + num);
            }
        }finally {
            //释放读锁
            readLock.unlock();
        }

    }

    public static void main(String[] args) {

        /**
         * 启动3个线程调用ThreadMethod方法
         */
        LockDowngradeDemo lockDowngradeDemo = new LockDowngradeDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lockDowngradeDemo.ThreadMethod();
            }).start();
        }
    }
}
