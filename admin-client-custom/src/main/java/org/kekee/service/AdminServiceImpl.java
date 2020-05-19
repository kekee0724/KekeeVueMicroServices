package org.kekee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname WeatherReportService
 * @Description TODO
 * @Ide IntelliJ IDEA
 * @Date 2020-04-25 14:46
 * @Author <a href="https://github.com/kekee0724">可可</a>
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private GatewayClient gatewayClient;


    @Override
    public boolean deleteFirmById(Integer cid) {
        if(gatewayClient.deleteFirmById(cid)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer uid) {
        if(gatewayClient.deleteUserById(uid)==1){
            return true;
        }
        return false;
    }
}
