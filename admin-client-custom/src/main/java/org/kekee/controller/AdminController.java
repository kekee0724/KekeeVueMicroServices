package org.kekee.controller;

import org.kekee.service.AdminService;
import org.kekee.vo.Firm;
import org.kekee.vo.User;
import org.kekee.service.GatewayClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminService adminService;
    @Autowired
    private GatewayClient gatewayClient;

    @GetMapping("/AllUser")
    public ModelAndView getAllUser(Model model) {
        model.addAttribute("title", "所有求职者列表:选择一个删除");
        List<User> userList = null;
        try {
            userList = gatewayClient.getAllUser();
            logger.info("userList", userList);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        model.addAttribute("userList", userList);
        return new ModelAndView("admin/user", "result", model);
    }

    @GetMapping("/deletUser/{uid}")
    public ModelAndView deletUser(@PathVariable("uid") Integer uid, Model model) throws Exception {
        model.addAttribute("title", "所有求职者列表:选择一个删除");
        model.addAttribute("userId", uid);
        List<User> userList = null;
        try {
            userList = gatewayClient.getAllUser();
            logger.info("userList", userList);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        model.addAttribute("userList", userList);
        model.addAttribute("success", adminService.deleteUserById(uid));
        return new ModelAndView("admin/user", "result", model);
    }

    /*添加用户页面*/
    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelMap map) {
        map.addAttribute("user", new User());
        logger.info(String.valueOf(map));
        return new ModelAndView("admin/addUser");
    }

    /*添加完用户后重定向到list页面*/
    @RequestMapping("/doAddUser")
    public ModelAndView doAddUser(@ModelAttribute User user) {
        logger.info(String.valueOf(user));
        gatewayClient.addUser(user);
        return new ModelAndView("redirect:/admin/AllUser");
    }

    /*更新用户页面*/
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(ModelMap map) {
        map.addAttribute("user", new User());
//        map.addAttribute("user", user);
        logger.info(String.valueOf(map),"--------------------------");
        return new ModelAndView("admin/updateUser");
    }

    /*更新完用户后重定向到list页面*/
    @RequestMapping("/doUpdateUser")
    public ModelAndView doUpdateUser(@ModelAttribute User user) {
        gatewayClient.updateUser(user);
        logger.info(String.valueOf(user),"--------------------------");
        return new ModelAndView("redirect:/admin/AllUser");
    }

    //统计当前Zuul调用次数
    int count = 0;

    //获取Zuul服务端口号
    @Value("${server.port}")
    private String port;

    @GetMapping("/AllFirm")
    public ModelAndView getAllFirm(Model model) {
        model.addAttribute("title", "所有hr列表:选择一个删除"+"\n"+"API服务访问次数为："+( ++count) );
        List<Firm> firmList = null;
        try {
            firmList = gatewayClient.getAllFirm();
            logger.info("firmList", firmList);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        model.addAttribute("firmList", firmList);
        return new ModelAndView("admin/firm", "result", model);
    }

    @GetMapping("/deletFirm/{cid}")
    public ModelAndView deletFirm(@PathVariable("cid") Integer cid, Model model) throws Exception {
        model.addAttribute("title", "所有hr列表:选择一个删除");
        model.addAttribute("companyId", cid);
        List<Firm> firmList = null;
        try {
            firmList = gatewayClient.getAllFirm();
            logger.info("firmList", firmList);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        model.addAttribute("firmList", firmList);
        model.addAttribute("success", adminService.deleteFirmById(cid));
        return new ModelAndView("admin/firm", "result", model);
    }

    /*添加用户页面*/
    @RequestMapping("/addFirm")
    public ModelAndView addFirm(ModelMap map) {
        map.addAttribute("firm", new Firm());
        return new ModelAndView("admin/addFirm");
    }

    /*添加完用户后重定向到list页面*/
    @RequestMapping("/doAddFirm")
    public ModelAndView doAddFirm(@ModelAttribute Firm firm) {
        gatewayClient.addFirm(firm);
        return new ModelAndView( "redirect:/admin/AllFirm");
    }

    /*更新用户页面*/
    @RequestMapping("/updateFirm")
    public ModelAndView updateFirm(ModelMap map) {
        map.addAttribute("firm", new Firm());
        logger.info(String.valueOf(map),"--------------------------");
        return new ModelAndView("admin/updateFirm");
    }

    /*更新完用户后重定向到list页面*/
    @RequestMapping("/doUpdateFirm")
    public ModelAndView doUpdateFirm(@ModelAttribute Firm firm) {
        gatewayClient.updateFirm(firm);
        logger.info(String.valueOf(firm),"--------------------------");
        return new ModelAndView( "redirect:/admin/AllFirm");
    }
}
