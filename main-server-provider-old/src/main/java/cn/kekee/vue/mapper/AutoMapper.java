package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.Firm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AutoMapper {
    @Select("select * from firm")
    List<Firm> getAllfirm();

    @Delete("delete from firm where cid =#{cid}")
    int deleteFirmById(Integer cid);
}
