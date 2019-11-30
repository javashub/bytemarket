package com.android.bytemarket.controller;


import com.android.bytemarket.entity.User;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前端控制器
 * @author lequal
 * @since 2019-11-30
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public List<User> userRegister() {

        List<User> list = userService.list();

        return list;
    }

    @RequestMapping(value = "/login")
    public String userLogin() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        int count = userService.count(wrapper);
        if (count > 0) {
            return "登录成功";
        } else {
            return "用户名或密码错误";
        }
    }
}

