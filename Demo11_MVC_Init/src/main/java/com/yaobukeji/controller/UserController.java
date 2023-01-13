package com.yaobukeji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/check")
    @ResponseBody
    public String check() {
        return "{'hello':'world'}";
    }
}