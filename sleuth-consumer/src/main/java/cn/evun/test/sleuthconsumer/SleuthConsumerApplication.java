package cn.evun.test.sleuthconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.evun.test.sleuthconsumer.api")
public class SleuthConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthConsumerApplication.class, args);
    }

}
