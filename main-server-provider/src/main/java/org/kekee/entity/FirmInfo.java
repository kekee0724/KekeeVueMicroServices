package org.kekee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("firmInfo")
public class FirmInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private String name;

    private String email;

    private String phone;

    private String region;

    private String intro;

    private String type;

    private String num;

    private String brief;

    private String logo;


}
