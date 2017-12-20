package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * PackageName proxy
 * Created by wangkang on 2017/12/20.
 */
public class ProxyDemo {
    private  <T> T create(Class<?> interfaceCalss){
        return (T) Proxy.newProxyInstance(interfaceCalss.getClassLoader(),
                new Class<?>[]{interfaceCalss}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("create proxy object");
                        return null;
                    }
                });
    }

    public static void main(String[] args) {
        DemoAnnotation bean = new ProxyDemo().create(DemoAnnotation.class);
        if (bean != null && bean instanceof DemoEntity){
            System.out.println("create bean sucess!");
        }
        System.exit(0);
    }
}
