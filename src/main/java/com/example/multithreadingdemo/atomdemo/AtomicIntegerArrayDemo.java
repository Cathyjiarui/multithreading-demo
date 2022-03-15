package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @ClassName AtomicIntegerArrayDemo
 * @Description AtomicIntegerArray示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        //指定下标更新值后获取值
        System.out.println(atomicIntegerArray.addAndGet(2,2));
        //指定下标指定值指定公示计算后返回
        int accumulateAndGet = atomicIntegerArray.accumulateAndGet(4, 5, (left, right) ->
                left * right);
        System.out.println(accumulateAndGet);
    }
}
