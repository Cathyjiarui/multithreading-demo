package com.example.multithreadingdemo.designpatterns.singleton;


import java.util.concurrent.TimeUnit;

/**
 * @ClassName LazySingletion
 * @Description 懒汉式 最简单的写法是非线程安全的,在需要的时候再实例化
 * @Author ZhangJia
 * @Date 2020/6/17
 * @Version 1.0
 **/
public class LazySingleton {

    private static volatile LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (null == lazySingleton){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingleton.class){
                if (null == lazySingleton){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }
}
