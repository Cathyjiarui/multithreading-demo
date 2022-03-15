package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceDemo
 * @Description AtomicReference示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<Student1> student1AtomicReference = new AtomicReference<>();
        Student1 zhangjia = new Student1(1L, "zhangjia");
        Student1 zhangrui = new Student1(2L, "zhangrui");
        //step1:对student1AtomicReference进行set操作
        student1AtomicReference.set(zhangjia);
        //step2:执行更新
        student1AtomicReference.compareAndSet(zhangjia,zhangrui);
        //step3:获取更新后的对象
        Student1 student1 = student1AtomicReference.get();
        System.out.println("zhangjia = " + student1.getName());
    }
}

class Student1{

    private long id;
    private String name;

    public Student1(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
