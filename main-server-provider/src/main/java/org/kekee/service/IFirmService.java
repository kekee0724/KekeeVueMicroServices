package org.kekee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kekee.entity.Firm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 可可
 * @since 2020-05-18
 */
public interface IFirmService extends IService<Firm> {

    Firm authFirm(String cname, String cpassword);
}
