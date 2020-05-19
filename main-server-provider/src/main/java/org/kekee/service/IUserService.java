package org.kekee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.User;

/**
 * TODO
 * @param  @return
 * @author 可可
 * @date 2020/5/18
 */
public interface IUserService extends IService<User> {
    User authUser(String uname, String upassword);
}
