package com.example.multithreadingdemo.pipelineflow;

import java.io.*;

/**
 * @ClassName Main
 * @Description 主启动类
 * @Author ZhangJia
 * @Date 2020/6/29
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) throws IOException {

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);

        new Thread(new Reader(pipedInputStream)).start();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        }finally {
            pipedOutputStream.close();
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
    }
}
