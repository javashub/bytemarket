package com.android.bytemarket.service.impl;

import com.android.bytemarket.entity.User;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: 15760
 * @Date: 2019/11/28
 * @Descripe:
 */
@Service
public class UserServiceImpl implements UserService {

    private int result = 0;
    @Autowired
    private UserService userService;
    //UserServiceImpl userImpl = new UserServiceImpl();


    @Override
    public void registerUser() {
        User user = new User();
        user.setUserName("sanbiaoge");
        user.setPassword("1234567");
        result = userService.insert(user);
    }

    @Override
    public int insert(User entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<User> wrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(User entity) {
        return 0;
    }

    @Override
    public int update(User entity, Wrapper<User> updateWrapper) {
        return 0;
    }

    @Override
    public User selectById(Serializable id) {
        return null;
    }

    @Override
    public List<User> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<User> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public User selectOne(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public Integer selectCount(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<User> selectList(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }
}
