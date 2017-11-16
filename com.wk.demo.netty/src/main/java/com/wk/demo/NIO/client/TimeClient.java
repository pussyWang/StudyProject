package com.wk.demo.NIO.client;

/**
 * PackageName com.wk.demo.NIO.client
 * Created by wangkang on 2017/11/16.
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandler("127.0.0.1",port),"TimeClient-001").start();
    }
}
