package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where uid =#{uid}")
    User getUserById(Integer uid);

    @Select("select * from user")
    List<User> getAllUser();

    @Delete("delete from user where uid =#{uid}")
    int deleteUserById(Integer id);

    @Update("update user set uname =#{uname},uemail =#{uemail},upassword  = #{upassword} where uid = #{uid}")
    int updateUser(User user);
}
