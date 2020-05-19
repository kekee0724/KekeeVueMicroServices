package org.kekee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.FirmInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
public interface IFirmInfoService extends IService<FirmInfo> {

    List<FirmInfo> getAllFirmInfoLimit();
}
