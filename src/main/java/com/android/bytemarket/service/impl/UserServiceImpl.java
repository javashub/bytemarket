package com.android.bytemarket.service.impl;


import com.android.bytemarket.dao.CartDao;
import com.android.bytemarket.dao.ProdutDao;
import com.android.bytemarket.dao.UserDao;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  服务实现类
 * @author lequal
 * @since 2019-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    ProdutDao produtDao;
    @Autowired
    CartDao cartDao;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {

        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username).eq("password", password);
        return userDao.selectOne(wrapper);
    }


    /**
     *  用户注册
     * @param nickName
     * @param username
     * @param password
     * @param avatar
     * @param description
     * @param schoolId
     * @return
     */
    @Override
    public int register(String nickName, String username, String password, String avatar, String description, Integer schoolId) {

        LocalDateTime currentTime = LocalDateTime.now();
        User user = new User();
        user.setNickName(nickName);
        user.setUsername(username);
        user.setPassword(password);
        user.setAvatar(avatar);
        user.setSchoolId(schoolId);
        user.setDescription(description);
        user.setCreateTime(currentTime);
        user.setUpdateTime(currentTime);

        //判断用户名重复
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        if (userDao.selectCount(wrapper) > 0) {
            return -1;
        } else {
            return userDao.insert(user);
        }

    }

    /**
     * 修改密码
     * @param userId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @Override
    public int updatePwd(Integer userId, String oldPwd, String newPwd) {

        if (StringUtils.isEmpty(newPwd)) {
            QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("id", userId).eq("password", oldPwd);
            int result = userDao.selectCount(wrapper);
            if (result > 0) {
                // 说明旧密码匹配，可进行修改
                User user = userDao.selectOne(wrapper);
                user.setPassword(newPwd);
                userDao.updateById(user);
                return 1;
            } else {
                // 旧密码错误
                return -1;
            }
        }
        return -1;
    }

    /**
     * 显示给其他用户看的主页
     * 只需要显示对方的昵称、头像、正在出售的商品即可
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> showMain(Integer userId) {

        QueryWrapper<User> wrapper1 = new QueryWrapper<User>().eq("id", userId);
        User user = userDao.selectOne(wrapper1);
        // 返回昵称、头像地址
        String avatar = user.getAvatar();
        String nickName = user.getNickName();

        // 构造查询对应用户的商品列表条件
        QueryWrapper<Product> wrapper2 = new QueryWrapper<Product>().eq("user_id", userId);

        // 返回对方的商品列表
        List<Product> products = produtDao.selectList(wrapper2);

        Map<String, Object> map = new HashMap<>();
        map.put("avatar", avatar);
        map.put("nickName", nickName);
        map.put("products", products);

        return map;
    }

    /**
     * 用户个人中心数据显示
     * 显示已买到、已卖出、收藏等数据
     * @param userId 当前登录的用户的ID
     * @return
     */
    @Override
    public List userCenter(Integer userId) {

        // 用户存储数据集并返回“我的”页面填充数据
        Map<String, Object> map = new HashMap<>();

        // 构造根据当前登录用户id查询其发布的商品的条件
        QueryWrapper<Product> wrapper1 = new QueryWrapper<Product>().eq("user_id", userId);
        // 获取已发布的商品，显示数量，点击进去后显示已发布的商品列表
        List<Product> products = produtDao.selectList(wrapper1);
        // 显示数量，这句可要可不要
        int myProducts = products.size();

        // 构造查询已卖出条件，0表示未卖出，1表示已卖出
        QueryWrapper<Product> wrapper2 = new QueryWrapper<Product>().eq("user_id", userId).eq("status", 1);
        // 已卖出
        List<Product> sold = produtDao.selectList(wrapper2);
        // 数量
        int mySolds = sold.size();


        return null;
    }


}
