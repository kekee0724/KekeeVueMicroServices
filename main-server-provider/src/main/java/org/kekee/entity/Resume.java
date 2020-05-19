package org.kekee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键就是uid
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 所在地区
     */
    private String region;

    /**
     * 院校
     */
    private String school;

    /**
     * 学历
     */
    private String degree;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 自我评价
     */
    private String self;

    /**
     * 期望职位
     */
    private String occupation;

    /**
     * 职业类型
     */
    private String type;

    /**
     * 现在的状态
     */
    private String status;

    /**
     * 期望薪资
     */
    private String pay;

    @TableField("workExps")
    private String workExps;


}
