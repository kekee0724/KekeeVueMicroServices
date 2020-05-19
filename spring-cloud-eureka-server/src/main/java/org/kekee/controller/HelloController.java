package org.kekee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Ide IntelliJ IDEA
 * @Date 2020-04-26 18:02
 * @Author <a href="https://github.com/kekee0724">可可</a>
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
