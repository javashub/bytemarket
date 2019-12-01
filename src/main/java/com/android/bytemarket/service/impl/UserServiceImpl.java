package com.android.bytemarket.service.impl;

import com.android.bytemarket.entity.User;
import com.android.bytemarket.dao.UserDao;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lequal
 * @since 2019-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username).eq("password", password);
        return userDao.selectOne(wrapper);
    }

    @Override
    public int register(String nickName, String username, String password, Integer schoolId,
                        String description, Date createTime) {

        LocalDateTime currentTime = LocalDateTime.now();
        User user = new User();
        user.setNickName(nickName);
        user.setUsername(username);
        user.setPassword(password);
        user.setSchoolId(schoolId);
        user.setDescription(description);
        user.setCreateTime(currentTime);

        //判断用户名重复
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        if (userDao.selectCount(wrapper) > 0) {
            return -1;
        } else {
            return userDao.insert(user);
        }

//        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("nickName", nickName).eq("username", username)
//                .eq("password", password).eq("schoolId", schoolId).eq("description", description);
    }
}
