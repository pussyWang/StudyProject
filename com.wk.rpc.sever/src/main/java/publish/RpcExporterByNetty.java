package publish;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * PackageName publish
 * Created by wangkang on 2017/10/19.
 */
public class RpcExporterByNetty {
    public static void exporter(String hostname,int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new NettyMessageDecoder(1024*1024,4,4));
//                        socketChannel.pipeline().addLast(new NettyMessageEncoder());
//
//                        socketChannel.pipeline().addLast("readTimeouthandler",new ReadTimeoutHandler(50));
//                        socketChannel.pipeline().addLast(new LoginAuthRespHandler());
//                        socketChannel.pipeline().addLast("HeartBeathandler",new HeartBeatRespHandler());
                    }
                });
//        b.bind(NettyConstant.REMOTEIP,NettyConstant.PORT).sync();
    }
}
