package com.example.multithreadingdemo.myblockingqueue;

/**
 * @ClassName ThreadStatusDemo
 * @Description 简单队列演示
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class MyBlockingQueueDemo {

    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);
        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.enqueue(data);
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Integer dequeue = queue.dequeue();
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
