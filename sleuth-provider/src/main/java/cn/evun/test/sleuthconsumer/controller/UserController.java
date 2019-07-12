package cn.evun.test.sleuthconsumer.controller;

import cn.evun.test.sleuth.api.UserApi;
import cn.evun.test.sleuth.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController implements UserApi {

//    @GetMapping("/add")
    public String addUser(User user){
        return "add hello"+ user.getName();
    }

//    @PostMapping("/update")
    public String updateUser( User user){
        return "update hello" + user.getName();
    }

//    @PostMapping("/batch")
    public String updateBatch( List<User> users){
        return users.size()+"";
    }
//    @PostMapping("/upload")
    public String upload(MultipartFile file){
        System.out.println(file.getName());
        File f  = new File("D:\\" + file.getOriginalFilename());
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
            return "失败";
        }
        return "上传成功";
    }
}
