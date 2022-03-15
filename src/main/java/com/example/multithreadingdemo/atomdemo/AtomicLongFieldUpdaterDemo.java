package com.example.multithreadingdemo.atomdemo;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @ClassName AtomicLongFieldUpdaterDemo
 * @Description AtomicLongFieldUpdater示例
 * @Author ZhangJia
 * @Date 2020/6/30
 * @Version 1.0
 **/
public class AtomicLongFieldUpdaterDemo {

    public static void main(String[] args) {
        //AtomicLongFieldUpdater更改id的值
        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");
        Student student = new Student(1L, "zhangjia");
        longFieldUpdater.compareAndSet(student, 1L, 2L);
        System.out.println("student id = " + student.getId());

        //AtomicReferenceFieldUpdater更改name的值
        AtomicReferenceFieldUpdater<Student, String> referenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        referenceFieldUpdater.compareAndSet(student,"zhangjia","zhangrui");
        System.out.println("student name = " + student.getName());
    }
}

class Student {

    volatile long id;
    volatile String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
