package com.android.bytemarket.service;

import com.android.bytemarket.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;


/**
 *  服务类
 * @author lequal
 * @since 2019-11-30
 */
public interface UserService extends IService<User> {

    // 用户登录
    User login(String username,String password);

    // 用户注册
    int register(String nickName, String username, String password, String avatar, String description, Integer schoolId);

    // 修改密码
    int updatePwd(Integer userId, String oldPwd, String newPwd);

    // 显示用户主页信息
    Map<String, Object> showMain(Integer userId);

    // 用户个人中心数据显示
    List userCenter(Integer userId);

    // 修改个人资料
//    void updateUserInfo(Integer uid, String avartar, String nickname, String description, Integer schoolId);

}
