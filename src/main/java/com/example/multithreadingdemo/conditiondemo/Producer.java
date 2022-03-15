package com.example.multithreadingdemo.conditiondemo;

/**
 * @ClassName Consumer
 * @Description 生产者
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Producer implements Runnable{

    private Medium medium;

    public Producer(Medium medium){
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.put();
        }
    }
}
