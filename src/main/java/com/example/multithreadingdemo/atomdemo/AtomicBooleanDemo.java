package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName AtomicBooleanDemo
 * @Description AtomicBoolean示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicBooleanDemo {

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void valueChange(){
        //无条件设置为给定值
        atomicBoolean.set(true);
        //如果当前值为第一个值，则变更为第二个值
        atomicBoolean.compareAndSet(true,false);
    }

    public static void main(String[] args) {
        valueChange();
        System.out.println(atomicBoolean.get());
    }
}
