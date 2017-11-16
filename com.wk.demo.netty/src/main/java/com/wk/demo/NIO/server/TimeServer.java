package com.wk.demo.NIO.server;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * PackageName com.wk.demo.NIO.server
 * Created by wangkang on 2017/11/16.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
