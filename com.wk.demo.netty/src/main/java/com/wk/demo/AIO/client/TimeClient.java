package com.wk.demo.AIO.client;

/**
 * PackageName com.wk.demo.AIO.client
 * Created by wangkang on 2017/11/17.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),"AIO-AsyncTimeClientHandler-001").start();
    }
}
