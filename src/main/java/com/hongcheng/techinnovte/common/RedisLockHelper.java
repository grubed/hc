package com.hongcheng.techinnovte.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RedisLockHelper {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param targetId   targetId
     * @param timeStamp  当前时间+超时时间 也就是时间戳
     * @return
     */
    public boolean lock(String targetId,Long timeStamp){
        if(stringRedisTemplate.opsForValue().setIfAbsent(targetId,timeStamp.toString())){
            // 对应setnx命令，可以成功设置,也就是key不存在
            return true;
        }

        // 判断锁超时 - 防止原来的操作异常，没有运行解锁操作  防止死锁
        String currentLock = stringRedisTemplate.opsForValue().get(targetId);
        // 如果锁过期 currentLock不为空且小于当前时间
        if(!StringUtils.isBlank(currentLock) && Long.parseLong(currentLock) < System.currentTimeMillis()){
            // 获取上一个锁的时间value 对应getset，如果lock存在
            String preLock =stringRedisTemplate.opsForValue().getAndSet(targetId,timeStamp.toString());

            // 假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentLock=A(get取的旧的值肯定是一样的),两个线程的timeStamp都是B,key都是K.锁时间已经过期了。
            // 而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的timeStamp已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if(!StringUtils.isBlank(preLock) && preLock.equals(currentLock) ){
                // preLock不为空且preLock等于currentLock，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     * @param target
     * @param timeStamp
     */
    public void unlock(String target,Long timeStamp){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(target);
            if(!StringUtils.isBlank(currentValue) && currentValue.equals(timeStamp) ){
                // 删除锁状态
                stringRedisTemplate.opsForValue().getOperations().delete(target);
            }
        } catch (Exception e) {
            log.error("警报！警报！警报！解锁异常{}",e);
        }
    }


}
