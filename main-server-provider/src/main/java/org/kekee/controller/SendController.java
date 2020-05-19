package org.kekee.controller;

import org.kekee.entity.Send;
import org.kekee.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/checkPost")
    public int send(@RequestBody Map<String, Object> req) {
        Integer uid, jid;
        uid = (Integer) req.get("uid");
        jid = (Integer) req.get("jid");
        boolean res = iSendService.checkPost(uid, jid);
        System.out.println(res);
        if (res) {
            return 1;
        }
        return 0;
    }

    @PostMapping("/send")
    public int send(@RequestBody Send send) {
        boolean res = iSendService.Deliver(send);
        if (res) {
            return 1;
        }
        return 0;
    }
}
