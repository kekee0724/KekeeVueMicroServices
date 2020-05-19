package org.kekee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("jobDes")
public class JobDes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自身id识别
     */
    @TableId(value = "jid", type = IdType.AUTO)
    private Integer jid;

    /**
     * 所属公司id号
     */
    private Integer cid;

    /**
     * 职位名称
     */
    private String opc;

    /**
     * 职业类型
     */
    private String tab;

    /**
     * 薪资范围
     */
    private String pay;

    /**
     * 所在地
     */
    private String location;

    /**
     * 经验限制
     */
    private String exp;

    /**
     * 学历
     */
    private String degree;

    /**
     * 职业类型 全 兼 实习
     */
    private String type;

    /**
     * 职业吸引
     */
    private String attr;

    /**
     * 职业描述
     */
    private String intro;

    /**
     * 职业要求
     */
    private String must;

    /**
     * 提示
     */
    private String hit;

    /**
     * 面试地点
     */
    private String intv;

    /**
     * 截至时间
     */
    @TableField("endDate")
    private String endDate;

    /**
     * 发布时间
     */
    @TableField("relDate")
    private String relDate;

    /**
     * 公司名称
     */
    private String cname;


}
