package cn.kekee.vue.bean;

import lombok.Data;

/**
 * 属于user工作经验
 * @author cocoa
 */
@Data
public class WorkExp {
    private Integer id;
    private Integer uid;
    private String name;    //公司名称
    private String type;    //行业类型
    private String ocp;     //职位
    private String dep;     //部门
    private String opcDate; //任职时间  time-time
    private String text;    //详细
}

