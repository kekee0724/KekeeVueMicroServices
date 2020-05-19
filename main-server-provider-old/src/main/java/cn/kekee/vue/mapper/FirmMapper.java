package cn.kekee.vue.mapper;

import cn.kekee.vue.bean.FirmInfo;
import org.apache.ibatis.annotations.Mapper;
import cn.kekee.vue.bean.Firm;
import cn.kekee.vue.bean.JobDes;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author cocoa
 */
@Mapper
public interface FirmMapper {
    boolean insertJD(JobDes jobDes);

    List<Map> getAllJD();

    List<Map> getJDbyCid(Integer cid);

    JobDes getJDbyJid(Integer jid);

    List<Map> getJDListByKey(String key);

    boolean insertFirmInfo(FirmInfo firmInfo);

    FirmInfo getFirmInfoByCid(Integer cid);

    List<Map> getAllFirmInfo();

    Firm getFirmById(Integer cid);

    Firm getFirmByName(String cname);

    boolean insertFirm(Firm firm);

    Firm getFirmByNameAndPassword(String cname, String cpassword);

    int updateFirm(Firm firm);
}
