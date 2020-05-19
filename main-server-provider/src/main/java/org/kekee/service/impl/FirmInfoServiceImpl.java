package org.kekee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.FirmInfo;
import org.kekee.mapper.FirmInfoMapper;
import org.kekee.service.IFirmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
@Service
public class FirmInfoServiceImpl extends ServiceImpl<FirmInfoMapper, FirmInfo> implements IFirmInfoService {
    @Autowired
    private FirmInfoMapper firmInfoMapper;

    @Override
    public List<FirmInfo> getAllFirmInfoLimit() {
        QueryWrapper<FirmInfo> wrapper = Wrappers.query();
        wrapper.orderByDesc("cid").last("limit 8");
        List<FirmInfo> firmInfos = firmInfoMapper.selectList(wrapper);
        return firmInfos;
    }
}
