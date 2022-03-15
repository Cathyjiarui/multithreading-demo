package com.example.multithreadingdemo.myblockingqueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadStatusDemo
 * @Description 简单队列的实现
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class MyBlockingQueue<E> {

    //阻塞队列最大容量
    int size;

    ReentrantLock lock = new ReentrantLock();

    //队列底层实现
    LinkedList<E> list = new LinkedList<>();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size)
                //队列已满,在notFull条件上等待
            {
                notFull.await();
            }
            //入队:加入链表末尾
            list.add(e);
            System.out.println("入队：" + e);
            //通知在notEmpty条件上等待的线程
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while (list.size() == 0)
                //队列为空,在notEmpty条件上等待
            {
                notEmpty.await();
            }
            //出队:移除链表首元素
            e = list.removeFirst();
            System.out.println("出队：" + e);
            //通知在notFull条件上等待的线程
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
