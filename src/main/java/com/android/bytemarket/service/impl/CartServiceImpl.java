package com.android.bytemarket.service.impl;

import com.android.bytemarket.dao.CartDao;
import com.android.bytemarket.entity.Cart;
import com.android.bytemarket.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lequal
 * @since 2019-11-30
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {

}
