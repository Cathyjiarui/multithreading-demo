package com.example.multithreadingdemo;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocalDemo
 * @Description ThreadLocal示例
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class ThreadLocalDemo {

    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    /**
     * @Author ZhangJia
     * @Description 自增并输出num的值
     * @Date 2020/6/29
     * @Param []
     * @return void
     **/
    public void create(){
        Integer myNum = num.get();
        myNum++;
        System.out.println(Thread.currentThread().getName() + "的MyNum值是: " + myNum);
        num.set(myNum);
    }

    public static void main(String[] args) {

        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        for (int i = 1; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true){
                    threadLocalDemo.create();
                    try {
                        TimeUnit.MILLISECONDS.sleep( finalI * 1000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
