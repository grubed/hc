package com.hongcheng.techinnovte.common.plus;

import com.hongcheng.techinnovte.common.Result;
import com.hongcheng.techinnovte.common.exception.RedisKeyFaileException;
import com.hongcheng.techinnovte.common.util.TextUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class VerificationCode {
    @Resource
    protected StringRedisTemplate stringRedisTemplate;
    private final String SEPARATOR = "_";
    private String prefix = "TechinnovteSmsVcode_";
    /**
     * 验证码获取间隔（毫秒）,客户端限制 60 秒，服务器限制 50 秒
     */
    private static final int VER_CODE_REQUEST_INTERVAL = 50 * 1000;

    private final int VER_CODE_EXPIRED_TIME = 10 * 60;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(prefix + key, generateRedisValue(value), VER_CODE_EXPIRED_TIME, TimeUnit.SECONDS);
    }

    public String get(String key) throws RedisKeyFaileException {
        String redisValue = stringRedisTemplate.opsForValue().get(prefix + key);
        if (TextUtils.isEmpty(redisValue)) { // && isFrequently(redisValue)) {
            throw new RedisKeyFaileException();
        }
        stringRedisTemplate.delete(prefix + key);
        return redisValue.split(SEPARATOR)[0];
    }

    public String generateRedisValue(String value) {
        return value + SEPARATOR + System.currentTimeMillis();
    }
    /**
     * 判断获取验证码是否过于频繁
     *
     * @param value redis 中的值（验证码_时间戳）
     * @return result
     */
    public boolean isFrequently(String value) {
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        // 判断两次获取的时间间隔
        long interval;
        if (value.contains(SEPARATOR)) {
            long lastSendTimeMills = Long.parseLong(value.split(SEPARATOR)[1]);
            interval = System.currentTimeMillis() - lastSendTimeMills;
        } else {
            interval = VER_CODE_REQUEST_INTERVAL;
        }
        return interval < VER_CODE_REQUEST_INTERVAL;
    }
}
