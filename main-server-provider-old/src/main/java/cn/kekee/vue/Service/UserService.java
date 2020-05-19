package cn.kekee.vue.Service;

import cn.kekee.vue.bean.User;
import cn.kekee.vue.mapper.UserMapper;
import cn.kekee.vue.mapper.UserYmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cocoa
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserYmlMapper usermapper;

    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        User check = usermapper.getUserByName(user.getUname());
        logger.info(String.valueOf(check));
        if (check != null) {
            return false;
        }
        return usermapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User authUser(String uname, String upassword) {
        try {
            return usermapper.getUserByNameAndPassword(uname, upassword);
        } catch (Exception e) {
            logger.error("Error!", e);
            return null;
        }
    }
}
