package com.zees.redis.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class RedisCacheProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisCacheProviderApplication.class, args);
	}

}



