package cn.zzw.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {
    static Jedis jedis = null;

    public static Jedis getJedis(){
        jedis = new Jedis("47.101.196.82");
        return jedis;
    }

}
