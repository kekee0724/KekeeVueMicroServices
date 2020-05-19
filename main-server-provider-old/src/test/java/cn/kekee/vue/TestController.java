package cn.kekee.vue;

import cn.kekee.vue.bean.Result;
import cn.kekee.vue.util.UserSchema;
import cn.kekee.vue.util.UserSchemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

/**
 * @author cocoa
 */
@RestController
@RequestMapping("/react")
public class TestController {

    @Autowired
    private UserSchemaMapper userMapperReact;

    @PostMapping("/register")
    public Result register(@RequestBody UserSchema user) {
        try {
            int result = userMapperReact.insertUser(user);
            if (result == 1) {
                return Result.ok(user);
            } else {
                return Result.error(500, "注册失败");
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }
    }

    @GetMapping("/test")
    public Result test() {
        UserSchema user = new UserSchema("test2",
                "12345",
                "0",
                null
        );
        try {
            int result = userMapperReact.insertUser(user);
            System.out.println(result);
            if (result == 1) {
                return Result.ok(user);
            } else {
                return Result.error(500, "注册失败");
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }
    }
}
