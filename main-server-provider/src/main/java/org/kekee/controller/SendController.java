package org.kekee.controller;

import org.kekee.entity.Send;
import org.kekee.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cocoa
 */
@RestController
public class SendController {
    @Autowired
    private ISendService iSendService;

    @GetMapping("/send/{cid}")
    public List<Send> getSendByCid(@PathVariable("cid") Integer cid) {
        return iSendService.getSendByCid(cid);
    }

    @GetMapping("/sendbyUser/{uid}")
    public List<Send> getSendByUid(@PathVariable("uid") Integer uid) {
        return iSendService.getSendByUid(uid);
    }

    @PutMapping(value = "/replay/{id}")
    public int updateSendStatus(@PathVariable("id") Integer id, @RequestBody Send send) {
        if (iSendService.updateSendStutas(id, send.getReplay())) {
            return 0;
        } else {
            return 1;
        }
    }
}
