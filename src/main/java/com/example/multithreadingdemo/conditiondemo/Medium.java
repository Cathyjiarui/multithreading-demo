package com.example.multithreadingdemo.conditiondemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Consumer
 * @Description 中间商
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Medium {

    private int num = 0;

    private static final int TOTAL = 20;

    private Lock lock = new ReentrantLock();
    private Condition ConsumerCondition = lock.newCondition();
    private Condition ProducerCondition = lock.newCondition();

    /**
     * @return void
     * @Author ZhangJia
     * @Description 生产操作
     * @Date 2020/6/29
     * @Param []
     **/
    public void put() {
        lock.lock();
        try {
            //判断当前库存是否为最大容量
            if (num < TOTAL) {
                //如果不是，生产完成后通知消费者来消费
                System.out.println("新增库存，当前库存 " + ++num);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                ConsumerCondition.signalAll();
            } else {
                try {
                    //如果是，通知生产者等待
                    System.out.println("新增库存，库存已满 " + num);
                    ProducerCondition.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * @return void
     * @Author ZhangJia
     * @Description 消费操作
     * @Date 2020/6/29
     * @Param []
     **/
    public void take() {
        lock.lock();
        try {
            //判断当前库存是否不足
            if (num > 0) {
                //如果充足，在消费完成后通知生产者进行生产
                System.out.println("消费库存，当前库存 " + --num);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                ProducerCondition.signalAll();
            } else {
                try {
                    //如果不足，通知消费者等待
                    System.out.println("消费库存，库存不足 " + num);
                    ConsumerCondition.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
