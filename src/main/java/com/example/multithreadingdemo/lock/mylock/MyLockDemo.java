package com.example.multithreadingdemo.lock.mylock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName LockDemo
 * @Description MyLock使用示例
 * @Author ZhangJia
 * @Date 2020/5/27
 * @Version 1.0
 **/
public class MyLockDemo {

    /**
     * step1:定义int变量赋值0
     */
    private static int num = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static Lock lock = new MyLock();

    /**
     * 每次调用时对num进行++的操作
     */
    public static void inCreate() {

        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        /**
         * step2:启动10个线程
         */
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                /**
                 * step3:每个线程循环100次调用inCreate方法
                 */
                for (int j = 0; j < 100; j++) {
                    /**
                     * 此时有可能多个线程取到num的值相同，然后去进行++操作
                     */
                    inCreate();
                    try {
                        //调用后休眠10毫秒
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        while (true) {
            /**
             * step4:如果countDownLatch的大小为0时输出num值跳出循环
             */
            if (countDownLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }

    }
}
