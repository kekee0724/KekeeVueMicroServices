package org.kekee.controller;

import org.kekee.entity.User;
import org.kekee.util.Data;
import org.kekee.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * 测试用
 *
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/test")
    public int test(@RequestBody Map<String, Object> models) {
        Map<String, Object> userobj = (Map<String, Object>) models.get("user");
        ArrayList<Map<String, Object>> test = (ArrayList<Map<String, Object>>) models.get("test");
        try {
            User user = JsonUtil.map2obj(userobj, User.class);
            for (Map<String, Object> item : test) {
                Data data = JsonUtil.map2obj(item, Data.class);
                logger.info(String.valueOf(data));
                logger.info(data.getB());
            }
            logger.info(user.getUname());
        } catch (Exception e) {
            logger.error("Error!", e);
        }
        return 1;
    }
}
