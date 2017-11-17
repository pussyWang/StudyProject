package com.wk.demo.AIO.server;

/**
 * PackageName com.wk.demo.AIO.server
 * Created by wangkang on 2017/11/16.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler,"AIO-AsyncTimeServerHandler-001").start();
    }
}
