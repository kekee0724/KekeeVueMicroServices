package org.kekee.controller.auth;

import org.kekee.entity.Firm;
import org.kekee.entity.User;
import org.kekee.service.IFirmService;
import org.kekee.service.IUserService;
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
    private IUserService iUserService;
    @Autowired
    private IFirmService iFirmService;

    /**
     * 注册用户（求职）
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public int registerUser(@RequestBody User user) {
        int result = 0;
        boolean res = iUserService.save(user);
        if (res) {
            result = 1;
        }
        return result;
    }

    /**
     * 注册公司
     *
     * @param firm
     * @return
     */
    @PostMapping("/firm")
    public int registerFirm(@RequestBody Firm firm) {
        int result = 0;
        System.out.println(firm.getCname());
        boolean res = iFirmService.save(firm);
        if (res) {
            result = 1;
        }
        return result;
    }
}
