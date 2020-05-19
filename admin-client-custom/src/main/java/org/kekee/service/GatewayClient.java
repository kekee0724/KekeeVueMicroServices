package org.kekee.service;

import org.kekee.vo.Firm;
import org.kekee.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname CityClient
 * @Description TODO
 * @Ide IntelliJ IDEA
 * @Date 2020-04-27 02:03
 * @Author <a href="https://github.com/kekee0724">可可</a>
 * , fallback = GatewayClientFallback.class
 */
@FeignClient(name = "SPRING-CLOUD-EUREKA-ZUUL", fallback = GatewayClientFallback.class)
public interface GatewayClient {
    @GetMapping("/admin/AllUser")
    List<User> getAllUser();

    @GetMapping("/admin/AllFirm")
    List<Firm> getAllFirm();

    @GetMapping("/admin/deletUser/{uid}")
    int deleteUserById(@PathVariable("uid") Integer uid);

    @GetMapping("/admin/deletFirm/{cid}")
    int deleteFirmById(@PathVariable("cid") Integer cid);

    //添加用户（求职）
    @PostMapping("/admin/user")
    int addUser(@RequestBody User user);

    //添加公司
    @PostMapping("/admin/firm")
    int addFirm(@RequestBody Firm firm);

    @PostMapping("/admin/updateUser")
    int updateUser(User user);

    @PostMapping("/admin/updateFirm")
    int updateFirm(Firm firm);
}
