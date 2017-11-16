package com.wk.demo.BIO.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * PackageName com.wk.demo.BIO.server
 * Created by wangkang on 2017/11/16.
 */
public class TimeServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (Exception e){

            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is start in port:" + port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally {
            if(server != null){
                System.out.println("the time server close");
                server.close();
                server = null;
            }
        }
    }
}
