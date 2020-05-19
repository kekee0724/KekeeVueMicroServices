package cn.kekee.vue.bean;

import lombok.Data;

/**
 * @author cocoa
 */
@Data
public class FirmInfo {
    //主键，不自动递增
    private Integer cid;
    private String name;
    private String phone;
    private String email;
    private String region;
    private String intro;
    private String type;
    private String num;
    private String brief;
    private String logo;
}
