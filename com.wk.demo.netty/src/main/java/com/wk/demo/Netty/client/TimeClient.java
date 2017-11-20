package com.wk.demo.Netty.client;

import com.wk.demo.Netty.server.TimeServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by aloneboy on 2017/11/18.
 */
public class TimeClient {

    public void connect(String host,int port) throws Exception{
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(work).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            // 异步发起连接
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        }finally {
            work.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception {
        int port = 8080;
        String host = "127.0.0.1";
        new TimeClient().connect(host,port);
    }
}
