package cn.evun.test.sleuthconsumer.controller;

import cn.evun.test.sleuthconsumer.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
public class ConsumerController {
    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    HelloService helloService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ExecutorService executorService;

    @GetMapping("/helloByFeign")
    public String helloByFeign(String name){
        log.info("client sent .feign方式，参数{}",name);
        String result = helloService.sayHello(name);
        log.info("client recieved .feign方式，结果{}",result);
        return result;
    }

    @GetMapping("/helloByExecutors")
    public String helloByExecutors(String name) throws ExecutionException, InterruptedException {
        log.info("client sent .异步线程方式，参数{}",name);
        Future<String> submit = executorService.submit(() -> {
            log.info("client sent .异步线程方式，进入子线程，参数{}", name);
            return helloService.sayHello(name);
        });
        String result = submit.get();
        log.info("client recieved .异步线程方式，结果{}",result);
        return result;
    }

    @GetMapping("/helloByRestTemplate")
    public String helloByRestTemplate(String name, ServletRequest request){
        log.info("ssessionid:" + ((HttpServletRequest)request).getSession().getId());
        log.info("client sent .resttemplate方式，参数{}",name);
        String result = restTemplate.getForObject("http://SLEUTH-PROVIDER/sayHello?name=" + name, String.class);
        log.info("client recieved .resttemplate方式，结果{}",result);
        return result;
    }

}
