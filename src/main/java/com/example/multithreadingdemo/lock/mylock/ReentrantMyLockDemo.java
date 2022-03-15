package com.example.multithreadingdemo.lock.mylock;

import java.util.concurrent.locks.Lock;

/**
 * @ClassName ReentrantMyLockDemo
 * @Description MyLock重入示例
 * @Author ZhangJia
 * @Date 2020/6/17
 * @Version 1.0
 **/
public class ReentrantMyLockDemo {

    private Lock lock = new MyLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println("调用了A方法！");
            methodB();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println("调用了B方法！");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantMyLockDemo reentrantMyLockDemo = new ReentrantMyLockDemo();
        reentrantMyLockDemo.methodA();
    }
}
