package org.kekee.service;

import org.kekee.vo.Firm;
import org.kekee.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname GatewayClientFallback
 * @Description TODO
 * @Ide IntelliJ IDEA
 * @Date 2020-04-29 10:05
 * @Author <a href="https://github.com/kekee0724">可可</a>
 */
@Component //声明为 spring 的一个 bean
public class GatewayClientFallback implements GatewayClient {
    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<Firm> getAllFirm() {
        return null;
    }

    @Override
    public int deleteUserById(Integer uid) {
        return 0;
    }

    @Override
    public int deleteFirmById(Integer cid) {
        return 0;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int addFirm(Firm firm) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int updateFirm(Firm firm) {
        return 0;
    }
}
