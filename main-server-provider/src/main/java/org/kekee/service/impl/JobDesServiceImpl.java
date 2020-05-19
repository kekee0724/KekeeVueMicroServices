package org.kekee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.JobDes;
import org.kekee.mapper.JobDesMapper;
import org.kekee.service.IJobDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
@Service
public class JobDesServiceImpl extends ServiceImpl<JobDesMapper, JobDes> implements IJobDesService {
    @Autowired
    private JobDesMapper jobDesMapper;

    @Override
    public List<JobDes> getJDbyKey(String key) {
        QueryWrapper<JobDes> wrapper = Wrappers.query();
        wrapper.like("tab", key).or().like("type", key).or().like("cname", key).or().like("location", key);
        List<JobDes> jobDes = jobDesMapper.selectList(wrapper);
        return jobDes;
    }

    @Override
    public List<JobDes> getJDbyCid(Integer cid) {
        Map<String, Object> params = new HashMap<>();
        params.put("cid", cid);
        List<JobDes> jobDes = jobDesMapper.selectByMap(params);
        return jobDes;
    }
}
