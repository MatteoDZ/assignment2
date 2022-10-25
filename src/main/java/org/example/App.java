package org.example;
import redis.clients.jedis.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String redisHost = "localhost";
        Integer redisPort = 6379;

        JedisPool pool = new JedisPool(redisHost, redisPort);

        try (Jedis jedis = pool.getResource()) {
            jedis.set("Hello", "World");
        }
        pool.close();
    }
}
