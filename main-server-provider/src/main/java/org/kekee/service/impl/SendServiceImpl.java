package org.kekee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.FirmInfo;
import org.kekee.entity.Send;
import org.kekee.mapper.SendMapper;
import org.kekee.service.ISendService;
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
public class SendServiceImpl extends ServiceImpl<SendMapper, Send> implements ISendService {
    @Autowired
    private SendMapper sendMapper;

    @Override
    public List<Send> getSendByCid(Integer cid) {
        Map<String, Object> params = new HashMap<>();
        params.put("cid", cid);
        List<Send> sends = sendMapper.selectByMap(params);
        return sends;
    }

    @Override
    public List<Send> getSendByUid(Integer uid) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        List<Send> sends = sendMapper.selectByMap(params);
        return sends;
    }

    @Override
    public boolean updateSendStutas(Integer id, Integer replay) {
        Send send = new Send();
        send.setId(id);
        send.setReplay(replay);
        UpdateWrapper<Send> wrapper = Wrappers.update();
        wrapper.eq("id", id);
        sendMapper.update(send, wrapper);
        if (sendMapper.update(send, wrapper) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPost(Integer uid, Integer jid) {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("jid", jid);
        List<Send> sends = sendMapper.selectByMap(params);
        if (sends != null) {
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
}
