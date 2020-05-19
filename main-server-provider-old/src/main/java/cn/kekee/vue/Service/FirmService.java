package cn.kekee.vue.Service;

import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.FirmInfo;
import cn.kekee.vue.bean.JobDes;
import cn.kekee.vue.mapper.FirmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author cocoa
 */
@Service
public class FirmService {
    private static final Logger logger = LoggerFactory.getLogger(FirmService.class);
    @Autowired
    private FirmMapper firmMapper;

    public boolean addFirmInfo(FirmInfo firmInfo) {
        try {
            FirmInfo checkRept = firmMapper.getFirmInfoByCid(firmInfo.getCid());
            if (checkRept != null) {
                return false;
            }
            firmMapper.insertFirmInfo(firmInfo);
            return true;
        } catch (Exception e) {
            logger.error("Error!", e);
        }
        return false;
    }

    public FirmInfo getFirmInfoBycid(Integer cid) {
        return firmMapper.getFirmInfoByCid(cid);
    }

    public List<Map> getJDbyKey(String key) {
        return firmMapper.getJDListByKey(key);
    }

    public boolean addFirm(Firm firm) {
        Firm check = firmMapper.getFirmByName(firm.getCname());
        if (check != null) {
            return false;
        }
        return firmMapper.insertFirm(firm);
    }

    public Firm authFirm(String cname, String cpassword) {
        try {
            return firmMapper.getFirmByNameAndPassword(cname, cpassword);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Map> getAllFirmInfoLimit() {
        return firmMapper.getAllFirmInfo();
    }

    public boolean addJd(JobDes jobDes) {
        return firmMapper.insertJD(jobDes);
    }

    public JobDes getJDbyJid(Integer jid) {
        return firmMapper.getJDbyJid(jid);
    }

    public List<Map> getAllJD() {
        return firmMapper.getAllJD();
    }

    public List<Map> getJDbyCid(Integer cid) {
        return firmMapper.getJDbyCid(cid);
    }

    public int updateFirm(Firm firm) {
        return firmMapper.updateFirm(firm);
    }
}