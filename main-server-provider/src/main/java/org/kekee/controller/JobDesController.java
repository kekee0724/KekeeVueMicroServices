package org.kekee.controller;

import org.kekee.entity.JobDes;
import org.kekee.service.IJobDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cocoa
 */
@RestController
@CrossOrigin()
public class JobDesController {
    @Autowired
    private IJobDesService iJobDesService;

    @GetMapping("/allJD")
    public List<JobDes> getAllJD() {
        return iJobDesService.list();
    }

    @GetMapping("/JD/{jid}")
    public JobDes getJDByJid(@PathVariable("jid") Integer jid) {
        return iJobDesService.getById(jid);
    }

    @GetMapping("/JDbyC/{cid}")
    public List<JobDes> getJDByCid(@PathVariable("cid") Integer cid) {
        return iJobDesService.getJDbyCid(cid);
    }

    @GetMapping("/job/{key}")
    public List<JobDes> getJDbyKey(@PathVariable("key") String key) {
        System.out.println(key);
        return iJobDesService.getJDbyKey(key);
    }

    @PostMapping("/JD")
    public int addJD(@RequestBody JobDes jobDes) {

        boolean res = iJobDesService.save(jobDes);
        if (res) {
            return 1;
        }
        return 0;
    }
}
