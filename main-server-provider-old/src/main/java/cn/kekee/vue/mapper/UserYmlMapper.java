package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cocoa
 */
@Mapper
public interface UserYmlMapper {

    //增删查改

    User getUserById(Integer uid);

    User getUserByName(String uname);


    boolean insertUser(User user);

//    public List<User> getUsers();

//    public boolean updateUser(User user);
//
//    public boolean deleteUser(int id);
//
//    public boolean deleteAllUsers();

    User getUserByNameAndPassword(String uname, String upassword);


}
