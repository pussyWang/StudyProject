package com.wk.study;

import redis.clients.jedis.Jedis;

/**
 * Created by aloneboy on 2018/3/11.
 */
public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",7776,5000);
        System.out.println(jedis.ping() + "========");
        System.exit(0);
    }
}
