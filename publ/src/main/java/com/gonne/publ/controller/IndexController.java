package com.gonne.publ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zxcv9455@naver.com on 2021-02-24
 * Blog : http://velog.io/@namgonkim
 * Github : http://github.com/namgonkim
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
