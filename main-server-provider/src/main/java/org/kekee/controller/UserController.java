package org.kekee.controller;

import org.kekee.entity.User;
import org.kekee.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 安详的苦丁茶
 * @date 2020/4/30 13:39
 */
@RestController
@CrossOrigin()
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService iUserService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/AllUser")
    public List<User> getAllUser() {
        return iUserService.list();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return iUserService.getById(id);
    }

    /**
     * 根据id查询
     *
     * @param uid
     * @return
     */
    @GetMapping("/userxml/{uid}")
    public User getxmlUser(@PathVariable("uid") Integer uid) {
        return iUserService.getById(uid);
    }

	/**
     *  根据id查询
      * @param id
     * @return
     */
    @GetMapping("/byid")
    public Object byid(Integer uid){
        System.out.println("查询成功");
        return iUserService.getById(uid);
    }

    /**
     * 根据id删除
     * @param uid
     * @return
     */
    @GetMapping("/deleteUser")
    public boolean delete(Integer uid){
        System.out.println("删除成功");
        return iUserService.removeById(uid);
    }

    /**
     * 根据id删除
     *
     * @param uid
     * @return
     */
    @GetMapping("/deletUser/{uid}")
    public int deleteUser(@PathVariable("uid") Integer uid) {
        int i = 0;
        try {
            if (iUserService.removeById(uid)) {
                i = 1;
            }
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return i;
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        int i = 0;
        try {
            if (iUserService.updateById(user)) {
                i = 1;
            }
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return i;
    }
}
