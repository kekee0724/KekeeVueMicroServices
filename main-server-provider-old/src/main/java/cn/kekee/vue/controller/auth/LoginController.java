package cn.kekee.vue.controller.auth;

import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.User;
import cn.kekee.vue.Service.FirmService;
import cn.kekee.vue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private FirmService firmService;

    @PostMapping("/authUser")
    public User authUser(@RequestBody User user) {
        User res = userService.authUser(user.getUname(), user.getUpassword());
        if (res != null) {
            System.out.println("res" + res);
            return res;
        }
        return null;
    }

    @PostMapping("/authFirm")
    public Firm authFirm(@RequestBody Firm firm) {
        Firm res = firmService.authFirm(firm.getCname(), firm.getCpassword());
        if (res != null) {
            System.out.println("res" + res);
            return res;
        }
        return null;
    }
}
