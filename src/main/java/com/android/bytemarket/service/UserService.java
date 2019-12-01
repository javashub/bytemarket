package com.android.bytemarket.service;

import com.android.bytemarket.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
 *  服务类
 * @author lequal
 * @since 2019-11-30
 */
public interface UserService extends IService<User> {

    //用户注册
    User login(String username,String password);

    //用户登录
    int register(String nickName, String username, String password, Integer schoolId, String description, Date createTime);
}
