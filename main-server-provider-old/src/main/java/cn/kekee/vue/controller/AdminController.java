package cn.kekee.vue.controller;

import cn.kekee.vue.Service.FirmService;
import cn.kekee.vue.Service.UserService;
import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.User;
import cn.kekee.vue.mapper.AutoMapper;
import cn.kekee.vue.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private FirmService firmService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AutoMapper autoMapper;

    @GetMapping("/AllUser")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    //统计当前Zuul调用次数
    int count = 0;

    //获取Zuul服务端口号
    @Value("${server.port}")
    private String port;

    @GetMapping("/AllFirm")
    public List<Firm> getAllFirm() {
        logger.info("访问Zuul网关端口为：:"+ port +"（total："+( ++count) +"）");
        return autoMapper.getAllfirm();
    }

    @GetMapping("/deletUser/{uid}")
    public int deleteUser(@PathVariable("uid") Integer uid) {
        int i = 0;
        try {
            i = userMapper.deleteUserById(uid);
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
        }
        return i;
    }

    @GetMapping("/deletFirm/{cid}")
    public int deleteFirm(@PathVariable("cid") Integer cid) {
        int i = 0;
        try {
            i = autoMapper.deleteFirmById(cid);
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
        }
        return i;
    }


    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/updateFirm")
    public int updateFirm(@RequestBody Firm firm) {
        return firmService.updateFirm(firm);
    }

}
