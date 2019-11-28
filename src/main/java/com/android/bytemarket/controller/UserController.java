package com.android.bytemarket.controller;

import com.android.bytemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 15760
 * @Date: 2019/11/28
 * @Descripe:
 */
@RestController
@RequestMapping(value = "/user", method = {RequestMethod.GET})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "注册成功";
    }

    @RequestMapping(value = "/addproduct")
    public String addProduct() {
        return "发布成功";
    }

    @RequestMapping(value = "login")
    public void login() {

    }
}
