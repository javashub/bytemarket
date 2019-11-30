package com.android.bytemarket.service.impl;

import com.android.bytemarket.entity.Category;
import com.android.bytemarket.dao.CategoryDao;
import com.android.bytemarket.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}
