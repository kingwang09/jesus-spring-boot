package org.jesus.spring.redis.connect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@Slf4j
@Service
public class JedisConnectionService {

    JedisPool pool;
    public JedisConnectionService(){
        pool =  new JedisPool("localhost", 6379);
    }

    public boolean set(String key, String value){
        try (Jedis jedis = pool.getResource()) {
            log.debug("redis set {} : {}", key, value);
            jedis.set(key, value);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public boolean set(String key, Map values){
        try (Jedis jedis = pool.getResource()) {
            log.debug("redis set hash: {}", values);
            jedis.hset(key, values);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}
