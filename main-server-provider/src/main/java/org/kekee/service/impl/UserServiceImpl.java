package org.kekee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.User;
import org.kekee.mapper.UserMapper;
import org.kekee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * @param  @return
 * @author 可可
 * @date 2020/5/18
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User authUser(String uname, String upassword) {
        Map<String, Object> params = new HashMap<>();
        params.put("uname", uname);
        params.put("upassword", upassword);
        List<User> users = userMapper.selectByMap(params);
//        users.forEach(System.out::println);
        if (users.size()==0 ) {
            return null;
        }
        return users.get(0);
    }
}
