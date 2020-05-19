package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.WorkExp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkExpMapper {
    boolean insertWorkExp(WorkExp workExp);

    void updateWorkExp(WorkExp workExp);

    List<Map> getWorkExpByUid(Integer uid);



}
