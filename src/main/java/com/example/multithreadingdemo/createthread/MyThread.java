package com.example.multithreadingdemo.createthread;

/**
 * @ClassName myThread
 * @Description 方式一 继承Thread类，重写run方法
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class MyThread extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("TestThread");
        myThread.start();
    }

}
