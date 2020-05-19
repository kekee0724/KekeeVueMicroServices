package cn.kekee.vue.bean;

import lombok.Data;

/**
 * 记录投递简历-公司 中间表
 * @author 可可
 */
@Data
public class Send {
    private Integer id;     //唯一主键
    private Integer uid;    //投递人id
    private String uname;   //投递人姓名
    private Integer cid;    //被投递公司
    private Integer jid;    //被投递职位主键
    private String  jname;  //被投递的岗位名
    private Integer replay; //是否接收面试
    // -1->未查看 0->已查看 1->面试 2->拒绝
}
