package com.wk.demo.BIO.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * PackageName com.wk.demo.BIO.client
 * Created by wangkang on 2017/11/16.
 */
public class TimeClient {
    public static void main(String[] args) throws Exception{
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed.");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        }finally {
            if (out != null){
                out.close();
                out = null;
            }
            if (in != null){
                in.close();
                in = null;
            }
            if(socket != null){
                socket.close();
                socket = null;
            }
        }
    }


}
