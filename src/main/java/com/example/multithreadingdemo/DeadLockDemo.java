package com.example.multithreadingdemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DeadLockDemo
 * @Description 死锁演示(揪头发演示) 程序运行太快时不易死锁，将HAIR_A休眠几秒钟
 * 查询死锁方式一：终端jps查询java对应线程的PID，jstack PID 查看线程的堆栈信息
 * 查询死锁方式二：jdk提供的工具jconsole,打开界面后找到对应线程，点击检测死锁
 * @Author ZhangJia
 * @Date 2020/5/27
 * @Version 1.0
 **/
public class DeadLockDemo {

    /**
     * 对象A
     */
    public static final Object HAIR_A = new Object();
    /**
     * 对象B
     */
    public static final Object HAIR_B = new Object();

    public static void main(String[] args) {
        //HAIR_A
        new Thread(() -> {
            //护住自己的头发
            synchronized (HAIR_A){
                //休眠50毫秒
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //尝试揪对方的头发
                synchronized (HAIR_B){
                    System.out.println("HAIR_A 揪住 HAIR_B 的头发啦 !!");
                }
            }
        }).start();

        //HAIR_B
        new Thread(() -> {
            //护住自己的头发
            synchronized (HAIR_B){
                //尝试揪对方的头发
                synchronized (HAIR_A){
                    System.out.println("HAIR_B 揪住 HAIR_A 的头发啦 !!");
                }
            }
        }).start();
    }
}
