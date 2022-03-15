package com.example.multithreadingdemo.container;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName CopyOnWriteDemo
 * @Description CopyOnWrite示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class CopyOnWriteDemo {

    public static final int MAX = 1000;

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < MAX; i++) {
            strings.add("demo" + i);
        }

//        //forEach访问
//        strings.forEach(e -> {
//            if (e.equals("demo2")){
//                strings.remove(e);
//            }
//        });

//        //不支持
//        Iterator<String> stringIterator = strings.iterator();
//        while (stringIterator.hasNext()){
//            String next = stringIterator.next();
//            if (next.equals("demo3")){
//                stringIterator.remove();
//            }
//        }

        //多线程
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                strings.forEach(e -> {
                    if (e.equals("demo3")){
                        strings.remove(e);
                    }
                });
            }).start();
        }
    }
}
