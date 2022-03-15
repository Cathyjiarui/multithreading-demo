package com.example.multithreadingdemo.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName StopDemo
 * @Description stop线程不安全演示
 * @Author ZhangJia
 * @Date 2020/6/3
 * @Version 1.0
 **/
public class StopDemo extends Thread {

    private int num1 = 0;
    private int num2 = 0;

    @Override
    public void run() {
        num1++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num2++;
    }

    public void printf(){
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void main(String[] args) throws InterruptedException {
        StopDemo stopDemo = new StopDemo();
        stopDemo.start();
        TimeUnit.SECONDS.sleep(1);
        stopDemo.stop();
        stopDemo.printf();

    }
}
