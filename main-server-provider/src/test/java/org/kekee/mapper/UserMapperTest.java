package org.kekee.mapper;

import org.kekee.entity.User;
import org.kekee.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 安详的苦丁茶
 * @date 2020/4/30 14:22
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private IUserService IUserService;

    @Test
    public void list(){
        List<User> list= IUserService.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}