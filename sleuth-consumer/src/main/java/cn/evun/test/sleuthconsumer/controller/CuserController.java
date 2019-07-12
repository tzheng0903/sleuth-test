package cn.evun.test.sleuthconsumer.controller;

import cn.evun.test.sleuth.api.UserApi;
import cn.evun.test.sleuth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/user")
public class CuserController {

    @Autowired
    private UserApi userApi;

    @PostMapping("/add")
    public String addUser(  User user){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return userApi.addUser(user);
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user){
        return userApi.updateUser(user);
    }

    @PostMapping("/batch")
    public String updateBatch(@RequestBody List<User> users){
        return userApi.updateBatch(users);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file){
        return userApi.upload(file);
    }
}
