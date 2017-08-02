package com.example.demo.cache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ll on 2017/8/2.
 */
@Component
public class BaseCacheKeyGenerator implements KeyGenerator {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Object generate(Object o, Method method, Object... objects) {

       Object key = sdf.format(new Date()) + objects ;
        return key;

    }
}
