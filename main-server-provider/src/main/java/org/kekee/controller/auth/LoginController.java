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

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class LoginController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IFirmService iFirmService;

    /**
     * 登录
     * @param uname
     * @param upassword
     * @return
     */
    @PostMapping("/doLogin")
    public Map doLogin(ServletResponse res, String uname, String upassword){
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "content-type, x-requested-with");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Map map = new HashMap();
        if ( iUserService.authUser(uname, upassword)!=null){
            map.put("code",200);
            map.put("result","登录成功");
        }else {
            map.put("result","no");
        }
        return map;
    }

    @PostMapping("/authUser")
    public User authUser(@RequestBody User user) {
        User res = iUserService.authUser(user.getUname(), user.getUpassword());
        if (res != null) {
            System.out.println("res" + res);
            return res;
        }
        return null;
    }

    @PostMapping("/authFirm")
    public Firm authFirm(@RequestBody Firm firm) {
        Firm res = iFirmService.authFirm(firm.getCname(), firm.getCpassword());
        if (res != null) {
            System.out.println("res" + res);
            return res;
        }
        return null;
    }
}
