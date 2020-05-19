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
@TableName("workExp")
public class WorkExp implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 行业类型
     */
    private String type;

    /**
     * 职位
     */
    private String ocp;

    /**
     * 部门
     */
    private String dep;

    /**
     * 任职时间
     */
    @TableField("opcDate")
    private String opcDate;

    /**
     * 详细
     */
    private String text;


}
