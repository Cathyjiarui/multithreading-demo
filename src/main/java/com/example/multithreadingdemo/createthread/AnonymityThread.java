package com.example.multithreadingdemo.createthread;

/**
 * @ClassName anonymityThread
 * @Description 方式三 匿名内部类
 * @Author ZhangJia
 * @Date 2020/5/28
 * @Version 1.0
 **/
public class AnonymityThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.setName("anonymityTest");
        thread.start();
    }
}
