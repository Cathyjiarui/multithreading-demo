package com.example.multithreadingdemo.toolsclassdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierDemo
 * @Description CyclicBarrier示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        /**
         * 每个线程执行完操作之后，就在等待其他线程操作完毕
         * 当所有线程线程操作完毕之后，所有线程就继续进行后续的操作
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("开始运行");
            }).start();
        }

        System.out.println("====================================================");

        /**
         * 每个线程执行完操作之后，就在等待其他线程操作完毕
         * 当所有线程都到达barrier状态后，会从所有线程中选择一个线程去执行Runnable
         * 然后继续进行后续的操作
         */
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(8, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "运行下一步操作");
            }
        });

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    System.out.println(Thread.currentThread().getName() + "准备就绪～");
                    cyclicBarrier1.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "开始运行了～");
            }).start();
        }
    }
}
