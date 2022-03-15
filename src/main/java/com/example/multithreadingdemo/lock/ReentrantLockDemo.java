package com.example.multithreadingdemo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockDemo
 * @Description ReentrantLockDemo
 * @Author ZhangJia
 * @Date 2020/6/19
 * @Version 1.0
 **/
public class ReentrantLockDemo {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        } finally {
            reentrantLock.unlock();
        }
        System.out.println("程序结束了.");
    }
}
