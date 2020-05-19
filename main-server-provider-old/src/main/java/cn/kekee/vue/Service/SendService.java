package cn.kekee.vue.Service;

import cn.kekee.vue.mapper.SendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author cocoa
 */
@Service
public class SendService {

    @Autowired
    private SendMapper sendMapper;

    public List<Map> getSendByCid(Integer cid) {
        return sendMapper.getSendByCid(cid);
    }

    public List<Map> getSendByUid(Integer uid) {
        return sendMapper.getSendByUid(uid);
    }

    public boolean updateSendStutas(Integer id, Integer replay) {
        return sendMapper.updateSendById(id, replay);
    }
}
