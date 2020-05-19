package org.kekee.controller;

import org.kekee.entity.Firm;
import org.kekee.service.IFirmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class FirmController {
    private static final Logger logger = LoggerFactory.getLogger(FirmController.class);
    @Autowired
    private IFirmService iFirmService;

    //统计当前Zuul调用次数
    int count = 0;
    //获取Zuul服务端口号
    @Value("${server.port}")
    private String port;

    @GetMapping("/AllFirm")
    public List<Firm> getAllFirm() {
        logger.info("访问Zuul网关端口为：:" + port + "（total：" + (++count) + "）");
        return iFirmService.list();
    }

    @GetMapping("/firmtest/{cid}")
    public Firm getfirm(@PathVariable("cid") Integer cid) {
        return iFirmService.getById(cid);
    }

    @PostMapping("/updateFirm")
    public int updateFirm(@RequestBody Firm firm) {
        int i = 0;
        try {
            if (iFirmService.updateById(firm)) {
                i = 1;
            }
            ;
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
        }
        return i;
    }

    @GetMapping("/deletFirm/{cid}")
    public int deleteFirm(@PathVariable("cid") Integer cid) {
        int i = 0;
        try {
            if (iFirmService.removeById(cid)) {
                i = 1;
            }
            ;
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
        }
        return i;
    }
}
