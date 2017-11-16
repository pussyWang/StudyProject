package com.wk.demo.NIO.server;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * PackageName com.wk.demo.NIO.server
 * Created by wangkang on 2017/11/16.
 */
public class MultiplexerTimeServer implements Runnable{
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;
    public MultiplexerTimeServer(int port){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the time server is start in port: " + port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void stop(){
        this.stop = stop;
    }
    public void run() {
        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    }catch (Exception e){
                        if (key != null){
                            key.cancel();
                            if (key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }
        if (selector != null){
            try {
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()){
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
            }
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer readbuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readbuffer);
                if (readBytes > 0){
                    readbuffer.flip();//将当前缓冲区的limit设置为position，position设置为0，用于后续对缓冲区的读取操作
                    byte[] bytes = new byte[readbuffer.remaining()];
                    readbuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("the time server receive order :" + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                            new Date(System.currentTimeMillis()).toString() :
                            "BAD ORDER";
                    doWrite(sc,currentTime);
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel channel,String response) throws IOException{
        if (response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //writeBuffer.hasRemaining();判断消息是否发送完成
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
