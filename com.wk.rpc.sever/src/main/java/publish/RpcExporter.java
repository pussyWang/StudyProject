package publish;

import javax.management.relation.RoleUnresolved;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * PackageName publish
 * Created by wangkang on 2017/10/18.
 */
public class RpcExporter {
    public static void main(String[] args) throws Exception{
        exporter("localhost",8088);
    }

    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static void exporter(String hostname,int port) throws Exception{
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostname,port));
        try {
            while (true){
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        }finally {
            serverSocket.close();
        }
    }

    private static class ExporterTask implements Runnable{
        Socket client = null;
        public ExporterTask(Socket client){
            this.client = client;
        }
        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                input = new ObjectInputStream(client.getInputStream());
                String interfaceName = input.readUTF();
                Class<?> service = Class.forName(interfaceName);
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                Object[] arguments = (Object[])input.readObject();
                Method method = service.getMethod(methodName,parameterTypes);
                Object result = method.invoke(service.newInstance(),arguments);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (output != null){
                    try {
                        output.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(input != null){
                    try {
                        input.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(client != null){
                    try {
                        client.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
