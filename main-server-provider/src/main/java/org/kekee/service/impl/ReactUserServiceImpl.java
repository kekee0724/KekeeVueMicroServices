package org.kekee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.ReactUser;
import org.kekee.mapper.ReactUserMapper;
import org.kekee.service.IReactUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
@Service
public class ReactUserServiceImpl extends ServiceImpl<ReactUserMapper, ReactUser> implements IReactUserService {

}
