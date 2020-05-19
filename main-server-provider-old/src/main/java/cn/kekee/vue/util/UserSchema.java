package cn.kekee.vue.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserSchema {
    private String userid;
    private String username;
    private String userpsw;
    private String usertype;
    private String userheader; // 头像
    private String salt = "kekee";

    /* 随机生成UUID */
    public void setUserId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String[] ids = id.split("-");
        this.userid = (ids[0] + ids[1]).toUpperCase();
    }

    /* md5加密 */
    public void setUserPwd(String userPwd) {
        String saltPassword = salt + "/" + userPwd;
        String md5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());
        this.userpsw = md5Password;
    }

    public UserSchema(String username,
                      String userPwd,
                      String userType,
                      String userHeader) {
        this.setUserId();
        this.username = username;
        this.setUserPwd(userPwd);
        this.usertype = userType;
        this.userheader = userHeader;
    }
}
