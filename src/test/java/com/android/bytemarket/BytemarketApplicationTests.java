package com.android.bytemarket;

import com.android.bytemarket.common.OrderUtils;
import com.android.bytemarket.dao.ProdutDao;
import com.android.bytemarket.dao.UserDao;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class BytemarketApplicationTests {

//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private ProdutDao produtDao;
//
//    @Test
//    void contextLoads() {
//        List<User> list = userDao.selectList(null);
//        for (User user: list) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testProduct() {
//        List<Product> products = produtDao.selectList(null);
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
//
//    @Test
//    public void testOrder() {
//        System.out.println("测试一下。。。。");
//        System.out.println(OrderUtils.createNo());
//        System.out.println(OrderUtils.createNo().length());
//    }
}
