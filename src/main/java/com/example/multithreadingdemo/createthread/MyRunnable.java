package com.example.multithreadingdemo.createthread;

/**
 * @ClassName myRunnable
 * @Description 方式二 实现Runnable接口并实现run方法
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("TestRunnable");
        thread.start();
    }
}
