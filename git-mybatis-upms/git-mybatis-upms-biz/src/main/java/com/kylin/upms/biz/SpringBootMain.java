package com.kylin.upms.biz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={RedisAutoConfiguration.class})
@MapperScan(basePackages={"com.kylin.upms.biz.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
@RefreshScope
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class,args);
    }
}
