package cn.kekee.vue.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobDes {
    private Integer jid;         //自身id识别
    private Integer cid;        //所属公司id号
    private String opc;         //职位名称
    private String tab;         //职业类型
    private String pay;        //薪资范围
    private String location;    //所在地
    private String exp;         //经验限制
    private String degree;      //学历
    private String type;        //职业类型 全 兼 实习
    private String attr;        //职业吸引
    private String intro;       //职业描述
    private String must;        //职业要求
    private String hit;        //提示
    private String intv;        //面试地点
    private String endDate;     //截至时间
    private String relDate;     //发布时间
    private String cname;       //公司名称
}
