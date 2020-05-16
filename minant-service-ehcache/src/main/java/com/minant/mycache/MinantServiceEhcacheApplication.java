package com.minant.mycache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages={"com.minant.mycache"})
@MapperScan(basePackages = {"com.minant.mycache.mapper"})
public class MinantServiceEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinantServiceEhcacheApplication.class, args);
    }

}
