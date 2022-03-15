package com.example.multithreadingdemo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName LinkedBlockingQueueDemo
 * @Description LinkedBlockingQueue
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();

        /**
         * 同为向队列添加元素
         * add -- 实际上调用的是offer，区别是在队列满的时候，add会报异常
         * offer -- 对列如果满了，直接入队失败
         * put -- 在队列满的时候，会进入阻塞的状态
         */
        strings.add("zhangjia");
        strings.offer("zhangrui");
        strings.put("anan");

        /**
         * 从队列取元素
         * remove -- 直接调用poll，唯一的区别即使remove会抛出异常
         * poll -- 在队列为空的时候直接返回null
         * take -- 在队列为空的时候，会进入等待的状态
         */
        String remove = strings.remove();
        String poll = strings.poll();
        String take = strings.take();
    }
}
