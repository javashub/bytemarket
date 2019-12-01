package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.entity.request.LoginRequest;
import com.android.bytemarket.entity.request.RegisterRequest;
import com.android.bytemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/register")
    public ServerResponse register(@RequestBody RegisterRequest request) {

        int result = userService.register(request.getNickName(),request.getUsername(),request.getPassword(),
                request.getSchoolId(),request.getDescription(),request.getCreateTime());

        if (result > 0) {
            return ServerResponse.ofSuccess("注册成功，请登录");
        } else if (result == -1){
            return ServerResponse.ofError("用户名已经存在，请更换用户名");
        } else {
            return ServerResponse.ofError("注册失败");
        }
    }

    @PostMapping(value = "/login")

    public ServerResponse login(@RequestBody LoginRequest request) {

        User user = userService.login(request.getUsername(), request.getPassword());
        if (user!= null) {
            return ServerResponse.ofSuccess("登录成功", user);
        } else {
            return ServerResponse.ofError("用户名或密码错误");
        }
    }
}

