package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.Resume;
import cn.kekee.vue.bean.Send;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cocoa
 */
@Mapper
public interface ResumeMapper {

    boolean deliver(Send send);

    Send getSendByUidAndJid(Integer uid, Integer jid);

    boolean insertResume(Resume resume);

    void updateResume(Resume resume);

    Resume getResumeByuid(Integer uid);
}
