package cn.kekee.vue.controller.auth;

import cn.kekee.vue.Service.FirmService;
import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.User;
import cn.kekee.vue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private FirmService firmService;

    //注册用户（求职）
    @PostMapping("/user")
    public int registerUser(@RequestBody User user) {
        int result = 0;
        boolean res = userService.addUser(user);
        if (res) {
            result = 1;
        }
        return result;
    }

    //注册公司
    @PostMapping("/firm")
    public int registerFirm(@RequestBody Firm firm) {
        int result = 0;
        System.out.println(firm.getCname());
        boolean res = firmService.addFirm(firm);
        if (res) {
            result = 1;
        }
        return result;
    }
}
