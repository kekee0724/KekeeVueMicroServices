package org.kekee.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.Resume;
import org.kekee.entity.Send;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
public interface IResumeService extends IService<Resume> {

    boolean save(Map<String, Object> models);

    boolean update(Map<String, Object> models);

    Map<String, Object> getById(Integer id);
}
