package com.example.multithreadingdemo.pipelineflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

/**
 * @ClassName Reader
 * @Description 管道流示例
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Reader implements Runnable{

    private PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream){
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        if (pipedInputStream != null){
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
