package org.kekee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.Send;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
public interface ISendService extends IService<Send> {

    List<Send> getSendByCid(Integer cid);

    List<Send> getSendByUid(Integer uid);

    boolean updateSendStutas(Integer id, Integer replay);

    boolean checkPost(Integer uid, Integer jid);

    boolean Deliver(Send send);
}
