package com.example.multithreadingdemo.container;

import java.util.Iterator;
import java.util.Vector;

/**
 * @ClassName VectorDemo
 * @Description TODO
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class VectorDemo {

    public static void main(String[] args) {
        Vector<String> stringVector = new Vector<>();
        for (int i = 1; i < 1001; i++) {
            stringVector.add("demo" + i);
        }
//        //会抛出java.util.ConcurrentModificationException异常
//        stringVector.forEach(e -> {
//            if (e.equals("demo3")){
//                stringVector.remove(e);
//            }
//            System.out.println(e);
//        });

        //正确迭代
        Iterator<String> stringIterator = stringVector.iterator();
//        while (stringIterator.hasNext()) {
//            String next = stringIterator.next();
//            if (next.equals("demo3")) {
//                stringIterator.remove();
//                System.out.println(next + " is Deleted !!");
//            }
//        }

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                synchronized (stringIterator) {
                    while (stringIterator.hasNext()) {
                        String next = stringIterator.next();
                        if (next.equals("demo3")) {
                            stringIterator.remove();
                            System.out.println(next + " is Deleted !!");
                        }
                    }
                }
            }).start();
        }
    }
}
