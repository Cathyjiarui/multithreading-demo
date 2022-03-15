package com.example.multithreadingdemo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName ReentrantReadWriteLockDemo
 * @Description ReentrantReadWriteLock演示
 * @Author ZhangJia
 * @Date 2020/6/19
 * @Version 1.0
 **/
public class ReentrantReadWriteLockDemo {

    private int num1 = 0;
    private int num2 = 0;

    //创建ReentrantReadWriteLock实例
    private ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //获取读锁
    Lock readLock = reentrantReadWriteLock.readLock();
    //获取写锁
    Lock writeLock = reentrantReadWriteLock.writeLock();

    public void out() {
        //读取之前加读锁
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "num1 = " + num1 + " num2 = " + num2);
        } finally {
            //读取之后释放读锁
            readLock.unlock();
        }
    }

    public void inCreate() {
        //写之前加写锁
        writeLock.lock();
        try {
            num1++;
            TimeUnit.MILLISECONDS.sleep(500);
            num2++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //写之后释放写锁
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                reentrantReadWriteLockDemo.inCreate();
                reentrantReadWriteLockDemo.out();
            }).start();
        }
    }
}
