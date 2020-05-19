package org.kekee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * TODO
 * @param  @return
 * @author 可可
 * @date 2020/5/18
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    private String uname;

    private String uemail;

    private String upassword;

}
