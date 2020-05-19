package org.kekee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Send implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 投递人id
     */
    private Integer uid;

    /**
     * 投递人姓名
     */
    private String uname;

    /**
     * 被投递公司
     */
    private Integer cid;

    /**
     * 被投递职位主键
     */
    private Integer jid;

    /**
     * 被投递的岗位名
     */
    private String jname;

    /**
     * 是否接收面试 -1->未查看 0->已查看 1->面试 2->拒绝
     */
    private Integer replay;


}
