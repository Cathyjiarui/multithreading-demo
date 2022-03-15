package com.example.multithreadingdemo.designpatterns.singleton;

/**
 * @ClassName HungerSingleton
 * @Description 饿汉式 在类加载的时候，就已经进行实例化，无论之后用不用到。如果该类比较占内存，之后又没用到，就白白浪费了资源
 * @Author ZhangJia
 * @Date 2020/6/17
 * @Version 1.0
 **/
public class HungerSingleton {

    private static HungerSingleton outInstance = new HungerSingleton();

    public static HungerSingleton getInstance(){
        return outInstance;
    }

    private HungerSingleton(){

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(HungerSingleton.getInstance());
            }).start();
        }
    }
}
