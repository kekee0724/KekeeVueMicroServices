package org.kekee.controller;

import org.kekee.entity.Send;
import org.kekee.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class ResumeController {
    @Autowired
    private IResumeService iResumeService;

    @GetMapping("/resume/{uid}")
    public Map<String, Object> getResumeByUid(@PathVariable("uid") Integer uid) {
        return iResumeService.getById(uid);
    }

    @PostMapping("/checkPost")
    public int send(@RequestBody Map<String, Object> req) {
        Integer uid, jid;
        uid = (Integer) req.get("uid");
        jid = (Integer) req.get("jid");
        boolean res = iResumeService.checkPost(uid, jid);
        System.out.println(res);
        if (res) {
            return 1;
        }
        return 0;
    }

    @PostMapping("/updateResume")
    public int updateResume(@RequestBody Map<String, Object> models) {
        if (iResumeService.update(models)) {
            return 1;
        }
        return 0;
    }

    @PostMapping("/resume")
    public int addResume(@RequestBody Map<String, Object> models) {
        boolean res = iResumeService.save(models);
        if (res) {
            return 1;
        }
        return 0;
    }

    @PostMapping("/send")
    public int send(@RequestBody Send send) {
        boolean res = iResumeService.Deliver(send);
        if (res) {
            return 1;
        }
        return 0;
    }


}
