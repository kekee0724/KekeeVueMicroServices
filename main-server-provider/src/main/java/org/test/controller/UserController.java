package org.test.controller;


import org.test.entity.User;
import org.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 获取所有User
     * @return
     */
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> list = iUserService.list();
        return list;
    }
}
