package cn.kekee.vue.bean;




import lombok.Data;


/**
 * 属user简历
 * @author cocoa
 */
@Data
public class Resume {
    private Integer uid;            //主键就是uid
    /* 所属的简历持有用户 */
    private String name;            //姓名
    private String email;           //邮箱
    private String phone;           //电话
    private String region;          //所在地区
    private String school;          //院校
    private String degree;          //学历
    private String age;             //年龄
    private String self;            //自我评价
    private String occupation;      //期望职位
    private String type;            //职业类型
    private String status;          //现在的状态
    private String pay;             //期望薪资
    private WorkExp workExps;        //工作经验
}
