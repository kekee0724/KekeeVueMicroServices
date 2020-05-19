package org.kekee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kekee.entity.Firm;
import org.kekee.mapper.FirmMapper;
import org.kekee.service.IFirmService;
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
public class FirmServiceImpl extends ServiceImpl<FirmMapper, Firm> implements IFirmService {
    @Autowired
    private FirmMapper firmMapper;

    @Override
    public Firm authFirm(String cname, String cpassword) {
        Map<String, Object> params = new HashMap<>();
        params.put("cname", cname);
        params.put("cpassword", cpassword);
        List<Firm> firms = firmMapper.selectByMap(params);
        return firms.get(0);
    }
}
