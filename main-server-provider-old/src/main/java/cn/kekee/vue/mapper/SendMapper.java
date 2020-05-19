package cn.kekee.vue.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SendMapper {

    boolean updateSendById(Integer id, Integer replay);

    List<Map> getSendByCid(Integer cid);

    List<Map> getSendByUid(Integer uid);

}
