package com.example.multithreadingdemo.lock.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MyLock
 * @Description 自定义实现Lock并实现重入功能
 * @Author ZhangJia
 * @Date 2020/6/17
 * @Version 1.0
 **/
public class MyLock implements Lock {

    //锁是否被持有
    private boolean isHoldLock = false;

    private Thread holdLockThread = null;

    //重入次数
    private int reentryCount = 0;

    @Override
    public synchronized void lock() {

        //判断是否持有锁且不是持有锁的线程
        if (isHoldLock && Thread.currentThread() != holdLockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        holdLockThread = Thread.currentThread();
        isHoldLock = true;
        reentryCount++;
    }

    @Override
    public synchronized void unlock() {
        //判断当前线程是否是持有锁的线程，是 -- 减1 不是 -- 不做任何操作
        if (Thread.currentThread() == holdLockThread){
            reentryCount--;
            if (reentryCount == 0){
                notify();
                isHoldLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
