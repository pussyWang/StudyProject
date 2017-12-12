package com.wk.demo;

/**
 * PackageName com.wk.demo
 * Created by wangkang on 2017/12/8.
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        return new Singleton();
    }

    /**
     * 多线程安全
     * @return
     */
    public static Singleton getInstan(){
        synchronized (instance){
            if (instance != null){
                synchronized (instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
