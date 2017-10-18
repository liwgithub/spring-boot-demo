package com.baiding.redis.aspect;

import com.baiding.exception.BaiDingRequestException;
import com.baiding.redis.annotation.RedisCache;
import com.baiding.util.GlobalObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RedisCacheAspect {

	private static final Logger log = LoggerFactory.getLogger(RedisCacheAspect.class);

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Around("@annotation(cache)")
	public Object doAround(ProceedingJoinPoint pjp, RedisCache cache) throws Throwable {
		Object args[] = pjp.getArgs();
		String key = getKey(cache.reidsKey(), args);
		String value = stringRedisTemplate.opsForValue().get(key);
		if (value!=null && !Objects.equals(value, "")) {
			Signature signature = pjp.getSignature();
			Class returnType = ((MethodSignature) signature).getReturnType();
			return getClass(value, returnType);
		} else {
			Object object = pjp.proceed(args);
			value= GlobalObject.getJsonMapper().writeValueAsString(object);
			stringRedisTemplate.opsForValue().set(key,value,cache.timeout(), TimeUnit.SECONDS);
			return object;
		}
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		log.error("TokenValidationInterceptor:" + jp, ex);
		throw new BaiDingRequestException(ex);
	}

	private String getKey(String key, Object args[]) {
		StringBuilder sb = new StringBuilder();
		sb.append(key);
		for (int i = 0; i < args.length; i++) {
			sb.append(":").append(args[i]);
		}
		return sb.toString();
	}

	private <T> T getClass(String value, Class<T> T) throws  IOException {
		return GlobalObject.getJsonMapper().readValue(value, T);
	}

}
