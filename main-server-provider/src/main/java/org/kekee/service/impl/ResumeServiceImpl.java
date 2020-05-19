package org.kekee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.Resume;
import org.kekee.entity.Send;
import org.kekee.entity.WorkExp;
import org.kekee.mapper.ResumeMapper;
import org.kekee.mapper.SendMapper;
import org.kekee.mapper.WorkExpMapper;
import org.kekee.service.IResumeService;
import org.kekee.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements IResumeService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private SendMapper sendMapper;
    @Autowired
    private WorkExpMapper workExpMapper;

    @Override
    public boolean checkPost(Integer uid, Integer jid) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("jid", jid);
        List<Resume> resumes = resumeMapper.selectByMap(params);
        if (resumes != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean Deliver(Send send) {
        boolean checkRepts = checkPost(send.getUid(), send.getJid());
        if (checkRepts) {
            return false;
        }
        if (sendMapper.insert(send) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Map<String, Object> models) {
        try {
            Map<String, Object> resumeobj =
                    (Map<String, Object>) models.get("resume");
            ArrayList<Map<String, Object>> workExpList =
                    (ArrayList<Map<String, Object>>) models.get("workExps");
            Resume resume = JsonUtil.map2obj(resumeobj, Resume.class);
            resumeMapper.updateById(resume);

            for (Map<String, Object> item : workExpList) {
                WorkExp workExp = JsonUtil.map2obj(item, WorkExp.class);
                workExpMapper.updateById(workExp);
            }
            return true;
        } catch (Exception e) {
            logger.error("Error!", e);
        }
        return false;
    }

    @Override
    public boolean save(Map<String, Object> models) {
        try {
            Map<String, Object> resumeobj =
                    (Map<String, Object>) models.get("resume");
            ArrayList<Map<String, Object>> workExpList =
                    (ArrayList<Map<String, Object>>) models.get("workExps");
            Resume resume = JsonUtil.map2obj(resumeobj, Resume.class);
            Resume checkRept = resumeMapper.selectById(resume.getUid());
            if (checkRept != null) {
                return false;
            }
            resumeMapper.insert(resume);
            for (Map<String, Object> item : workExpList) {
                WorkExp workExp = JsonUtil.map2obj(item, WorkExp.class);
                workExpMapper.insert(workExp);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Map<String, Object> getById(Integer uid) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        List<WorkExp> wlist = workExpMapper.selectByMap(params);
        Resume resume = resumeMapper.selectById(uid);
        map.put("workExps", wlist);
        map.put("resume", resume);
        return map;
    }
}
