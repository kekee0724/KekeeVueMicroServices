package org.kekee.controller;

import org.kekee.entity.FirmInfo;
import org.kekee.service.IFirmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class FirmInfoController {
    @Autowired
    private IFirmInfoService firmInfoService;

    @GetMapping("/allFirmInfo")
    public List<FirmInfo> getAllFirmInfo() {
        return firmInfoService.getAllFirmInfoLimit();
    }

    @GetMapping("/firmInfo/{cid}")
    public FirmInfo getFirmInfoBycid(@PathVariable("cid") Integer cid) {
        return firmInfoService.getById(cid);
    }

    @PostMapping("/firmInfo")
    public int addFirmInfo(@RequestBody FirmInfo firmInfo) {
        boolean res = firmInfoService.save(firmInfo);
        if (res) {
            return 1;
        }
        return 0;
    }


}
