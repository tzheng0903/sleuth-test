package cn.evun.test.sleuthconsumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("sleuth-provider")
public interface HelloService {
    @GetMapping("/sayHello")
    String sayHello(String name);
}
