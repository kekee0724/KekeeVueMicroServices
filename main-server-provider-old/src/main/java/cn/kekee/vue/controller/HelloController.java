package cn.kekee.vue.controller;

import cn.kekee.vue.bean.Data;
import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.User;
import cn.kekee.vue.mapper.FirmMapper;
import cn.kekee.vue.mapper.ResumeMapper;
import cn.kekee.vue.mapper.UserMapper;
import cn.kekee.vue.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.kekee.vue.mapper.UserYmlMapper;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 测试用
 *
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    UserYmlMapper userYmlMapper;
    @Autowired(required = false)
    FirmMapper firmMapper;
    @Autowired(required = false)
    ResumeMapper resumeMapper;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/userxml/{uid}")
    public User getxmlUser(@PathVariable("uid") Integer id) {
        return userYmlMapper.getUserById(id);
    }

    @GetMapping("/firmtest/{cid}")
    public Firm getfirm(@PathVariable("cid") Integer cid) {
        return firmMapper.getFirmById(cid);
    }

    @PostMapping("/test")
    public int test(@RequestBody Map<String, Object> models) {
        Map<String, Object> userobj = (Map<String, Object>) models.get("user");
        ArrayList<Map<String, Object>> test = (ArrayList<Map<String, Object>>) models.get("test");
        try {
            User user = JsonUtil.map2obj(userobj, User.class);
            for (Map<String, Object> item : test) {
                Data data = JsonUtil.map2obj(item, Data.class);
                // System.out.println(data);
                logger.info(String.valueOf(data));
                // System.out.println(data.getB());
                logger.info(data.getB());
            }
            // System.out.println(user.getUname());
            logger.info(user.getUname());
        } catch (Exception e) {
            // System.out.println(e);
            logger.error("Error!", e);
        }
        return 1;
    }
}
