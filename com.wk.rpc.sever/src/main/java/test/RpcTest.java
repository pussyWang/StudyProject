package test;

import annotation.EchoService;
import impl.EchoServiceImpl;
import proxy.RpcImporter;
import publish.RpcExporter;

import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PackageName test
 * Created by wangkang on 2017/10/18.
 */
public class RpcTest {
    public static void main(String[] args) throws Exception {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
//                    RpcExporter.exporter("localhost",8088);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(echo.echo("are you ok? "));
    }
}
