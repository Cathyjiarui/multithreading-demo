package com.example.multithreadingdemo.toolsclassdemo;

import java.util.concurrent.Exchanger;

/**
 * @ClassName ExchangerDemo
 * @Description ExchangerDemo
 * @Author ZhangJia
 * @Date 2020/7/1
 * @Version 1.0
 **/
public class ExchangerDemo {

    public static void main(String[] args) {

        Exchanger<String> stringExchanger = new Exchanger<>();

        String str1 = "zhangjia";
        String str2 = "zhangrui";

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "初始值为：" + str1);
            try {
                String exchange = stringExchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName() + "交换后的数据：" + exchange);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }, "线程1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "初始值为：" + str2);
            try {
                String exchange = stringExchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + "交换后的数据：" + exchange);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }, "线程2").start();
    }
}
