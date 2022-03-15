package com.example.multithreadingdemo.producerandconsumer;

/**
 * @ClassName Consumer
 * @Description 消费者
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Consumer implements Runnable{

    private Medium medium;

    public Consumer(Medium medium){
        this.medium = medium;
    }

    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
