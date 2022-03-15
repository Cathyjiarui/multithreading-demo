package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @ClassName AtomicLongArrayDemo
 * @Description AtomicLongArray示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicLongArrayDemo {

    public static void main(String[] args) {

        long[] arr = new long[]{1L,2L,3L,4L,5L};
        AtomicLongArray atomicLongArray = new AtomicLongArray(arr);

        //指定下标更新值后获取值
        System.out.println(atomicLongArray.addAndGet(0,2L));

        //指定下标指定值指定公示计算后返回
        long accumulateAndGet = atomicLongArray.accumulateAndGet(3, 4, (left, right) ->
                left > right ? left : right);
        System.out.println(accumulateAndGet);

    }
}
