package com.android.bytemarket.controller;

import com.android.bytemarket.common.CodeUtil;
import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.entity.request.LoginRequest;
import com.android.bytemarket.entity.request.RegisterRequest;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.gson.Gson;
import lombok.Data;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    /**
     * 用户注册
     * @param request
     * @return
     */
    @PostMapping("/register")
    public ServerResponse register(@RequestBody RegisterRequest request) {

        int result = userService.register(request.getNickName(), request.getUsername(), request.getPassword(),
                request.getAvatar(), request.getDescription(), request.getSchoolId());

        if (result > 0) {
            return ServerResponse.ofSuccess("注册成功，请登录");
        } else if (result == -1){
            return ServerResponse.ofError("用户名已经存在，请更换用户名");
        } else {
            return ServerResponse.ofError("注册失败");
        }
    }

    /**
     * 用户登录
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ServerResponse login(@RequestBody LoginRequest request) {

        User user = userService.login(request.getUsername(), request.getPassword());

        if (user != null) {
            //设置token 可优化
            String token = user.getRongCloudToken();
            if (StringUtils.isEmpty(token)) {
                String ret = getCloudToken(String.valueOf(user.getId()),user.getNickName(),user.getAvatar());
                if (!StringUtils.isEmpty(ret)){
                    Wrapper<User> wrapper = new UpdateWrapper<User>().set("rong_cloud_token",ret).eq("id",user.getId());
                    userService.update(wrapper);
                    user.setRongCloudToken(ret);
                }
            }
            user.setPassword("");
            return ServerResponse.ofSuccess("登录成功", user);
        } else {
            return ServerResponse.ofError("用户名或密码错误");
        }

    }

    /**
     * 修改密码
     * @param request
     * @param newPwd
     * @return
     */
    @PostMapping("/updatepwd")
    public ServerResponse updatePwd(@RequestBody LoginRequest request,@RequestParam String oldPwd , @RequestParam(required = false) String newPwd) {
        int result = userService.updatePwd(request.getId(), oldPwd, newPwd);
        if (result > 0) {
            return ServerResponse.ofSuccess("密码修改成功！");
        } else {
            return ServerResponse.ofError("密码修改失败！");
        }
    }

    @GetMapping("/v1/getUserInfo")
    public ServerResponse getUserInfo(Integer uid){
        User user = userService.getById(uid);
        Map<String,String> map = new HashMap<>();
        if (user!=null){
            map.put("name",user.getNickName());
            map.put("avatar",user.getAvatar());
        }
        return ServerResponse.ofSuccess(map);
    }

    private String getCloudToken(String id,String name,String avatar){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120,TimeUnit.SECONDS).build();

        final String KEY = "RC-App-Key";
        final String NONCE = "RC-Nonce";
        final String TIMESTAMP = "RC-Timestamp";
        final String SIGNATURE = "RC-Signature";

        okhttp3.RequestBody formBody = new FormBody.Builder()
                .add("userId", id)
                .add("name",name)
                .add("portraitUri",avatar)
                .build();

        String nonce = String.valueOf(Math.random() * 1000000);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String sign = CodeUtil.hexSHA1("Q7MIhQYCKb" + nonce + timestamp);

        Request request = new Request.Builder()
                .addHeader(NONCE,nonce)
                .addHeader(KEY,"kj7swf8okn4q2")
                .addHeader(TIMESTAMP,timestamp)
                .addHeader(SIGNATURE,sign)
                .addHeader("Content-Type","application/x-www-form-urlencoded")
                .url("http://api-cn.ronghub.com/user/getToken.json")
                .post(formBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            Gson gson = new Gson();
            String res = Objects.requireNonNull(response.body()).string();
            CloudResponse cloudResponse = gson.fromJson(res, CloudResponse.class);
            return cloudResponse.token;

        } catch (IOException e) {
            //
        }
        return "";
    }


    @Data
    private static class CloudResponse{
        private int code;

        private String userId;

        private String token;
    }
}

