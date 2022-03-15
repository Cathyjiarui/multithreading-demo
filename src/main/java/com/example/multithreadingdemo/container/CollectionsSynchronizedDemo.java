package com.example.multithreadingdemo.container;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName CollectionsSynchronizedDemo
 * @Description Collections.synchronizedXXX示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class CollectionsSynchronizedDemo {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        Collections.synchronizedList(strings);
    }
}
