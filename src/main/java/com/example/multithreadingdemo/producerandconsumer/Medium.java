package com.example.multithreadingdemo.producerandconsumer;

/**
 * @ClassName Consumer
 * @Description 中间商
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Medium {

    private int num = 0;

    private static final int TOTAL = 20;

    /**
     * @Author ZhangJia
     * @Description 生产操作
     * @Date 2020/6/29
     * @Param []
     * @return void
     **/
    public synchronized void put() {
        //判断当前库存是否为最大容量
        if (num < TOTAL) {
            //如果不是，生产完成后通知消费者来消费
            System.out.println("新增库存，当前库存 " + ++num);
            notifyAll();
        } else {
            try {
                //如果是，通知生产者等待
                System.out.println("新增库存，库存已满 " + num);
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * @Author ZhangJia
     * @Description 消费操作
     * @Date 2020/6/29
     * @Param []
     * @return void
     **/
    public synchronized void take() {
        //判断当前库存是否不足
        if (num > 0) {
            //如果充足，在消费完成后通知生产者进行生产
            System.out.println("消费库存，当前库存 " + --num);
            notifyAll();
        } else {
            try {
                //如果不足，通知消费者等待
                System.out.println("消费库存，库存不足 " + num);
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
