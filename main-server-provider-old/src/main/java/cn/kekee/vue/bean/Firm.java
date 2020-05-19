package cn.kekee.vue.bean;

import lombok.Data;

/**
 * @author cocoa
 */
@Data
public class Firm {
    private Integer cid;
    private String clabelname;
    private String cname;
    private String cemail;
    private String cpassword;

    public String getCname() {
        return cname;
    }

    public String getCpassword() {
        return cpassword;
    }
}
