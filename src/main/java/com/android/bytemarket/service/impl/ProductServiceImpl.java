package com.android.bytemarket.service.impl;

import com.android.bytemarket.entity.Product;
import com.android.bytemarket.dao.ProductDao;
import com.android.bytemarket.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}
