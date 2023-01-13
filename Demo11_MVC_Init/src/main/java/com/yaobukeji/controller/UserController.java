package com.yaobukeji.controller;

import com.yaobukeji.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/check")
    @ResponseBody
    public User check() {
        return new User("Matthew", 22);
    }
}