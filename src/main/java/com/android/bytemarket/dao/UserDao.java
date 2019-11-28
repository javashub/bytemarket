package com.android.bytemarket.dao;

import com.android.bytemarket.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author: 15760
 * @Date: 2019/11/28
 * @Descripe:
 */
public interface UserDao extends BaseMapper<User> {
    void registerUser();

}
