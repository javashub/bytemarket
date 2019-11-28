package com.android.bytemarket.service;

import com.android.bytemarket.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 15760
 * @Date: 2019/11/28
 * @Descripe:
 */

public interface UserService extends BaseMapper<User> {
    void registerUser();
}
