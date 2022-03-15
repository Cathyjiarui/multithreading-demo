package com.example.multithreadingdemo.threadpooldemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CallableDemo
 * @Description Callable示例
 * @Author ZhangJia
 * @Date 2020/7/1
 * @Version 1.0
 **/
public class CallableDemo implements Callable<String> {

    /**
     * Callable与Runable功能相似
     * Callable的call有返回值，可以返回给客户端
     * 而Runable没有返回值，一般情况下，Callable与FutureTask一起使用
     * 或者通过线程池的submit方法返回相应的Future
     */

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        return "over";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableDemo);
        new Thread(stringFutureTask).start();
        System.out.println(stringFutureTask.get());
    }
}
