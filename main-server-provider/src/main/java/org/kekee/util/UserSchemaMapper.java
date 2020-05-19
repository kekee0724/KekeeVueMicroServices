package org.kekee.util;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * @author cocoa
 */
@Mapper
public interface UserSchemaMapper {

    /**
     * mybatis 默认
     * 一次只修改一条语句 成功返回 1
     * 一次修改两条及以上语句 成功返回 -1
     * 其他：捕捉插入异常
     */
    int insertUser(@Param("user") UserSchema user) throws DataAccessException;
}
