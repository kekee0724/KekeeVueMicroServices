package org.kekee.controller;

/**
 * LoginController class
 * IntelliJ IDEA: TODO
 *
 * @author <a href="https://github.com/kekee0724">可可</a>
 * @date 2020/05/05
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

//    @RequestMapping(value = "/login")
//    public ModelAndView login(ModelAndView mv) {
//        mv.setViewName("login");
//        return mv;
//    }

    @GetMapping(value = "/")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

//    @RequestMapping(value = "/submit")
//    public ModelAndView submit(@RequestParam("username") String username,
//                               @RequestParam("password") String password,HttpServletRequest request,ModelAndView mv) {
//        HttpSession session = request.getSession();
//        if("admin".equals(username) && "admin".equals(password)){
//            session.setAttribute("loginUser", username);
//            mv.setViewName("index");
//            mv.addObject("name","登录成功");
//        }else{
//            mv.setViewName("login");
//            mv.addObject("name","登录失败,请检查用户名密码");
//        }
//        return mv;
//    }
}
