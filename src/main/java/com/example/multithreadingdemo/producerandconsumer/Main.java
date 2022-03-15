package com.example.multithreadingdemo.producerandconsumer;

/**
 * @ClassName Main
 * @Description 主方法
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {

        Medium medium = new Medium();

        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(medium)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(medium)).start();
        }
    }
}
