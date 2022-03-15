package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @ClassName LongAccumulatorDemo
 * @Description LongAccumulator示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class LongAccumulatorDemo {

    /**
     * @Author ZhangJia
     * @Description 输入一个数字，如果比上一个大，则直接返回，如果小，则返回上一个
     * @Date 2020/6/30
     * @Param []
     * @return java.util.concurrent.atomic.LongAccumulator
     **/
    public static LongAccumulator longAccumulatorDemo(Long num){
        LongAccumulator accumulator = new LongAccumulator((left, right) ->
                left > right ? left : right, 4L);
        accumulator.accumulate(num);
        return accumulator;
    }

    /**
     * @Author ZhangJia
     * @Description 返回两数之和
     * @Date 2020/6/30
     * @Param [num]
     * @return java.util.concurrent.atomic.DoubleAccumulator
     **/
    public static DoubleAccumulator doubleAccumulatorDemo(Double num){
        DoubleAccumulator doubleAccumulator = new DoubleAccumulator((left, right) ->
                left + right, 1.25);
        doubleAccumulator.accumulate(num);
        return doubleAccumulator;
    }

    public static void main(String[] args) {

        //多线程调用longAccumulatorDemo
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("longAccumulatorDemo : " + longAccumulatorDemo((long) finalI));
            }).start();
        }
        //多线程调用doubleAccumulatorDemo
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("doubleAccumulatorDemo" + doubleAccumulatorDemo((double) finalI));
            }).start();
        }
    }
}
