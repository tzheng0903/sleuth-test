package cn.evun.test.sleuth.api;

import cn.evun.test.sleuth.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient("SLEUTH-PROVIDER")
public interface UserApi {

    @GetMapping("/user/add")
    String addUser(User user);

    @PostMapping("/user/update")
    String updateUser(@RequestBody User user);

    @PostMapping("/user/batch")
    String updateBatch(@RequestBody List<User> users);

    @PostMapping(value = "/user/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(MultipartFile file);
}
