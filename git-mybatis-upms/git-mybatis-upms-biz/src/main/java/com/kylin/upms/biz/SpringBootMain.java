package com.kylin.upms.biz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={RedisAutoConfiguration.class, SecurityAutoConfiguration.class})
@MapperScan(basePackages={"com.kylin.upms.biz.mapper"})
@EnableSwagger2
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class,args);
    }
}