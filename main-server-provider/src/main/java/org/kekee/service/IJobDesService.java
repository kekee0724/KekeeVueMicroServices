package org.kekee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.JobDes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
public interface IJobDesService extends IService<JobDes> {

    List<JobDes> getJDbyKey(String key);

    List<JobDes> getJDbyCid(Integer cid);
}
