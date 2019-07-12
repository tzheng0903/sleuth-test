package cn.evun.test.sleuth.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SLEUTH-PROVIDER")
public interface HelloService {
    @GetMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);
}
