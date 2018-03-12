package com.wk.study;

import redis.clients.jedis.Jedis;

/**
 * Created by aloneboy on 2018/3/11.
 */
public class JedisUtil {
    private static final String host = "192.168.205.128";
    private static final int port = 6379;
    private static Jedis jedis = new Jedis(host,port);

    private static void set(String key,String value){
        jedis.set(key,value);
    }

    public static void main(String[] args) {
//        set("wk1_jedis","this is a test");
        Jedis jedis1 = new Jedis("192.168.205.128",6379,5000);
        System.out.println(jedis1.ping() + "=====");
        System.exit(0);
    }
}
