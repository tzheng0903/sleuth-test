package cn.evun.test.sleuthconsumer;

import cn.evun.test.swagger.Config;
import cn.springcloud.feign.VenusFeignAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.evun.test.sleuth.api")
@Import({Config.class, VenusFeignAutoConfig.class})
public class SleuthConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthConsumerApplication.class, args);
    }

}
