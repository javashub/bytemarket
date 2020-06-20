/*
 Navicat Premium Data Transfer

 Source Server         : 134.175.118.250
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 134.175.118.250:3306
 Source Schema         : byte_market

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/03/2020 09:46:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (14, '王小小', '15555555555', '我家', 24);
INSERT INTO `tb_address` VALUES (34, '胡天霸', '17714232086', '湖南省人民医院', 39);
INSERT INTO `tb_address` VALUES (35, '梁总', '13572458658', '广西桂林市灵川县桂电大学', 38);
INSERT INTO `tb_address` VALUES (36, '黄总', '18777777777', '桂林电子科技大学', 20);

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------
INSERT INTO `tb_banner` VALUES (1, 'http://image.imhtb.cn/3f5ff03fa0c024b930f515e63ae2c702.jpg_945x288_7dff4510.jpg', '服务器图片1');
INSERT INTO `tb_banner` VALUES (2, 'http://q1u4jkqnr.bkt.clouddn.com/ad.png', '广告');
INSERT INTO `tb_banner` VALUES (3, 'http://image.imhtb.cn/76e68eda4ed089c0e5b0ce2367efe428.jpg', '服务器图片2');

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_id` int(11) NOT NULL COMMENT '商品的id',
  `user_id` int(11) NOT NULL COMMENT '加购用户id',
  `seller_id` int(11) NULL DEFAULT NULL COMMENT '发布者id',
  `num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  `ischecked` tinyint(1) NULL DEFAULT NULL COMMENT '0未选中，1选中',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '数码');
INSERT INTO `tb_category` VALUES (2, '文具');
INSERT INTO `tb_category` VALUES (4, '外设');
INSERT INTO `tb_category` VALUES (5, '衣服');
INSERT INTO `tb_category` VALUES (6, '其它');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表id',
  `order_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '下单用户id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '购买的商品id',
  `total_money` decimal(11, 2) NULL DEFAULT NULL COMMENT '订单总金额',
  `pay_type` int(11) NULL DEFAULT NULL COMMENT '支付方式，0为支付宝支付，1为微信支付',
  `status` int(11) NULL DEFAULT 0 COMMENT '订单状态，0为无效，1为有效',
  `is_pay` int(11) NULL DEFAULT NULL COMMENT '支付状态，0表示未支付或者支付失败，1表示支付成功',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注信息',
  `pay_from` int(11) NULL DEFAULT NULL COMMENT '支付来源',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家收货地址',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家名字',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家联系方式',
  `trade_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付回执单号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `owner_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (5, '20191220314129', 24, 64, 6500.00, 0, 1, 0, NULL, NULL, '我家', '王小小', '15555555555', NULL, '2019-12-20 13:09:33', '2019-12-20 13:09:33', NULL);
INSERT INTO `tb_order` VALUES (6, '20191220149594', 39, 80, 3.00, 0, 1, 0, NULL, NULL, '湖南省人民医院', '胡天霸', '17714232086', NULL, '2019-12-20 13:38:10', '2019-12-20 13:38:10', NULL);
INSERT INTO `tb_order` VALUES (7, '20191220871704', 38, 74, 899.00, 0, 1, 0, NULL, NULL, '广西桂林市灵川县桂电大学', '梁总', '13572458658', NULL, '2019-12-20 13:39:53', '2019-12-20 13:39:53', NULL);
INSERT INTO `tb_order` VALUES (8, '20191221626524', 20, 108, 10000.00, 0, 1, 0, NULL, NULL, '桂林电子科技大学', '黄总', '18777777777', NULL, '2019-12-21 08:38:57', '2019-12-21 08:38:57', NULL);

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品标题',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `description` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '发布者',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '默认0表示未卖出，1表示已经卖出',
  `images` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT 0,
  `category_id` int(11) NULL DEFAULT NULL,
  `school_id` int(11) NULL DEFAULT NULL,
  `buyer_id` int(11) NULL DEFAULT NULL COMMENT '购买者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (62, '红米k20 pro尊享版', 2399.00, '24期免息等于不要钱，赶快下手吧，晚了就没有了哦', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FvHj7_xVwcgTPzlwi7vt52m_kUjr', '2019-12-20 07:27:31', '2019-12-20 07:27:31', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (63, '茶杯', 30.00, '定制茶杯dota2哈哈哈哈哈哈哈哈啊哈哈', 24, 0, 'http://q2caan54b.bkt.clouddn.com/FgZJHf4d4-j6ZPuxk69XVdSCDjpb', '2019-12-20 08:41:06', '2019-12-20 08:41:06', 0, 6, 3, NULL);
INSERT INTO `tb_product` VALUES (64, '套房出租，可看到深圳湾', 6500.00, '本人有多套房，房子留着也没用，出租6500一个月', 20, 1, 'http://q2caan54b.bkt.clouddn.com/FmUZNV3BJCD1eok3T-1OO3N4Ci-f,http://q2caan54b.bkt.clouddn.com/FsyQJuuHgGlZVjOFQQoDFDSLsSHd,http://q2caan54b.bkt.clouddn.com/FooFyFPOUGMPMsh6udNSbsV-ipp9,http://q2caan54b.bkt.clouddn.com/FtZsefMIOqnyEVjB2JiUR8kc2ber,http://q2caan54b.bkt.clouddn.com/Fjlabrt6gHoTOPNgAm_uhcEg1yI5', '2019-12-20 11:05:48', '2019-12-20 11:05:48', 0, 6, 2, 24);
INSERT INTO `tb_product` VALUES (65, '二手摩托', 600.00, '不想开了 所以卖掉  可以自驾', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FkJDYXw4ZhLCXM4_0WREhcLOy1O-', '2019-12-20 13:07:35', '2019-12-20 13:07:35', 0, 6, 1, NULL);
INSERT INTO `tb_product` VALUES (66, '烧仙草', 6.00, '啦咯啦咯啦咯        意味着', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FuOJ_ec7GefjKKtewWo1SfH3PoWr', '2019-12-20 13:08:17', '2019-12-20 13:08:17', 1, 1, 1, NULL);
INSERT INTO `tb_product` VALUES (67, '一只猫', 899.00, '一只会点赞的猫咪，一只会点赞的猫咪，一只猫咪', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fh_e0b6LRmg0A_Q8ef3biGIhsA27', '2019-12-20 13:20:27', '2019-12-20 13:20:27', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (68, '红米蓝牙耳机', 998.00, '红米蓝牙耳机高音质，居家旅行必备之物，只要998真的只要998！', 24, 0, 'http://q2caan54b.bkt.clouddn.com/FhaSpKkMdQ8krkQvRivVKP_Gkn_1', '2019-12-20 13:25:35', '2019-12-20 13:25:35', 0, 1, 3, NULL);
INSERT INTO `tb_product` VALUES (69, '无间道版诺基亚', 98.00, '无间道版诺基亚，开核桃，防身，垫桌脚，无所不可。', 24, 0, 'http://q2caan54b.bkt.clouddn.com/FoC2NUn4xuy_ZTY1VwrLRKTtluEf', '2019-12-20 13:27:30', '2019-12-20 13:27:30', 0, 1, 3, NULL);
INSERT INTO `tb_product` VALUES (70, '羽绒衣', 298.00, '梁总牌羽绒衣，穿上它就像是投入梁总的怀抱，给你带来温暖。', 24, 0, 'http://q2caan54b.bkt.clouddn.com/FvB73FwbXsUuqJP-CG56W3kqy7Wh', '2019-12-20 13:29:37', '2019-12-20 13:29:37', 0, 5, 3, NULL);
INSERT INTO `tb_product` VALUES (71, '程序媛必备书籍', 90.00, '全部打包 90带走 不议价    ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FstJHB6d4-loeNkW7gvFZLjLrRMX', '2019-12-20 13:30:25', '2019-12-20 13:30:25', 0, 2, 1, NULL);
INSERT INTO `tb_product` VALUES (72, '烧烤串批发', 99.00, '学校门口信科商业街第二排，路口进入右转即可看到店面', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FlEmUUb_zkJsro-7Q1gFkm2a5jf6', '2019-12-20 13:31:48', '2019-12-20 13:31:48', 1, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (73, '联想笔记本电脑', 2999.00, '电脑去年差不多8000买的，现在不要了，低价出售，需要的联系我。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FlcQvWyEEgaLL6EYBn_cRnFjoQuz', '2019-12-20 13:33:42', '2019-12-20 13:33:42', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (74, '大型工地施工套装', 899.00, '全品种齐全。快来买啊啊啊啊啊啊啊啊', 39, 1, 'http://q2caan54b.bkt.clouddn.com/Fn4kOVjqFncI1uJqV3kYieJly0Ct', '2019-12-20 13:33:53', '2019-12-20 13:33:53', 0, 6, NULL, 38);
INSERT INTO `tb_product` VALUES (75, '黑苹果系统代装', 50.00, '上门代装，购买前请给我发一下配置图，鉴定是否可以安装再拍下', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fur3qeQ6dTkYyb_D1zzPE_QSGsfs', '2019-12-20 13:34:59', '2019-12-20 13:34:59', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (76, '东风汽车', 888888.00, '绝版东风汽车，仅此一辆谢绝还价，欲购从速。', 40, 0, 'http://q2caan54b.bkt.clouddn.com/Fh92uo_n95yD1gRTntOCbSsjhREY', '2019-12-20 13:35:03', '2019-12-20 13:35:03', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (77, '品如的衣柜', 288.00, '品如的衣柜，一套套睡衣从中取出，你好骚啊', 24, 0, 'http://q2caan54b.bkt.clouddn.com/Fg7D3fQkywQpyW2evH7mPmJYV0uK', '2019-12-20 13:35:27', '2019-12-20 13:35:27', 0, 6, 3, NULL);
INSERT INTO `tb_product` VALUES (78, '漫画', 19999.00, '非常具有收藏价值，此画已流传千年，仅此一幅。', 40, 0, 'http://q2caan54b.bkt.clouddn.com/FtIguYAXVSRl2tdrTsRmeWO3m0UP', '2019-12-20 13:36:23', '2019-12-20 13:36:23', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (79, '华为p30 pro手机', 3999.00, '今年6月份买的，换了5g手机了，现在用不到这台了，外观99新，需要的当面看机子哦', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FjxJy1R5aRf35-8g5uTJ9GXgvEPN,http://q2caan54b.bkt.clouddn.com/FkRQ6jZcK8oVBlIbAuNRggYKLf_U,http://q2caan54b.bkt.clouddn.com/FgdiQV7ZRSfl3R_jJPg4J5qsmQKJ,http://q2caan54b.bkt.clouddn.com/FiGf3iAeFkuuGSdVQyw-ib8tIsuO', '2019-12-20 13:36:36', '2019-12-20 13:36:36', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (80, '配钥匙', 3.00, '配钥匙了，3元一把，10元3把，您配吗', 24, 1, 'http://q2caan54b.bkt.clouddn.com/FmfdrtkWku8uJD1B6VHV7cIRfBmV', '2019-12-20 13:37:16', '2019-12-20 13:37:16', 0, 6, 3, 39);
INSERT INTO `tb_product` VALUES (81, '毕业设计代做', 2000.00, '请详细描述毕业设计的需求，注意事项再定价格。嫌贵的那就自己做，别找我。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FosAmswFlnbKvLJ8i5_nMraheNHv,http://q2caan54b.bkt.clouddn.com/FgJCWUWSQwMq9CG9f13n-G-XzRqw', '2019-12-20 13:38:33', '2019-12-20 13:38:33', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (82, '虎啸山居图', 12345.00, '唐寅（唐伯虎真迹），经过了国家鉴宝协会的鉴定。', 40, 0, 'http://q2caan54b.bkt.clouddn.com/FoFAoxvWyA5tSduHnNIYQri0ANQN', '2019-12-20 13:39:05', '2019-12-20 13:39:05', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (83, '个人定制进口气球。', 900.00, '国内著名设计师杰尼龟亲自设计，定制logo。', 39, 0, 'http://q2caan54b.bkt.clouddn.com/Fj58m2CrHUiBVTKz2-bvbiiQHZg2', '2019-12-20 13:41:12', '2019-12-20 13:41:12', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (84, '固态雪碧', 188.00, '经过我公司历史三年研究开发的会动会叫还会咬人的固态雪碧，188，你买不了吃亏，买不了上当，快来购买吧！', 40, 0, 'http://q2caan54b.bkt.clouddn.com/FintitQ9bxwKQ4r_lIZDEcbVNeNl', '2019-12-20 13:42:37', '2019-12-20 13:42:37', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (85, '大疆精灵3 se', 2999.00, '去年买的，就玩过几次，很新很新，保护得很好，可以小刀，有诚意的来', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Ft1o02REKDEhxKJKgrxOJ3lkM9oR,http://q2caan54b.bkt.clouddn.com/Fl-jnduleUn2FLJfcqAvhjFcsKg6,http://q2caan54b.bkt.clouddn.com/FvYv-LxUieD-vDngdr_MibHgw5In', '2019-12-20 13:42:48', '2019-12-20 13:42:48', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (86, '大众途岳', 200000.00, '今年买的车，无维修无暗病，一切完好，用车比较少，打算出了。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Ft1MaHWA8GXadnp-dzJpKEVj9gJf', '2019-12-20 13:44:06', '2019-12-20 13:44:06', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (87, '酸奶', 1000.00, '由纯牛奶转化而成，喝一半放置49天。够酸够味。', 39, 0, 'http://q2caan54b.bkt.clouddn.com/Fqqv-mtcBetSd-C3-07BJwWG_cR9', '2019-12-20 13:44:38', '2019-12-20 13:44:38', 0, 2, NULL, NULL);
INSERT INTO `tb_product` VALUES (88, '小爱同学触屏版', 99.00, '很少用，卖给有需要的同学，可以直接来609宿舍看实物哦。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FrwcYE6ASEp6REt_MziONGGmHSkr,http://q2caan54b.bkt.clouddn.com/Fnble6ViecYHn44mkqiM7PUoyG8a,http://q2caan54b.bkt.clouddn.com/Fr7lIwR5sgLbKXFPwTfRq5ixyHrX,http://q2caan54b.bkt.clouddn.com/FpqesCMN9IND99YFUmic_aQHRRQZ', '2019-12-20 13:46:18', '2019-12-20 13:46:18', 0, 4, NULL, NULL);
INSERT INTO `tb_product` VALUES (89, '收购二手物品，价格从优。', 0.00, '我全部都要。不管值不值钱，是个什么东西。', 39, 0, 'http://q2caan54b.bkt.clouddn.com/Fsr-l-RKZgISo___Y0cParrU08_6', '2019-12-20 13:46:44', '2019-12-20 13:46:44', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (90, '全新Airpos2第二代 ', 999.00, '买来都不舍得用             ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FpnllHEQD5jsFZFC3TcryWjG9ksx', '2019-12-20 13:47:15', '2019-12-20 13:47:15', 0, 1, 1, NULL);
INSERT INTO `tb_product` VALUES (91, 'amd rx5500显卡', 1999.00, '刚到手的，需要的同学直接来宿舍看评测，订单还在这里', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fm8Hmt_ywEOp0Lyba4ZJulbjDXzN', '2019-12-20 13:47:37', '2019-12-20 13:47:37', 0, 4, NULL, NULL);
INSERT INTO `tb_product` VALUES (92, '墨菲定律', 99.00, '买回来看完了，现在低价出给需要的同学，保护得很好', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FnT6HRgl_JK-EQaGzdFxn6xEmdcN', '2019-12-20 13:48:40', '2019-12-20 13:48:40', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (93, '关羽千里走单骑', 19999999.00, '绝品两幅，欲购从速，价廉物美，机不可失，失不再来。', 40, 0, 'http://q2caan54b.bkt.clouddn.com/FlDdQkG6IMTsXzcl1p_VY-Sbe6-F,http://q2caan54b.bkt.clouddn.com/Fql-GIvM8HeeM8Je-Ku4dENfmad8', '2019-12-20 13:48:57', '2019-12-20 13:48:57', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (94, '迷你电脑', 2999.00, '7.5寸屏幕，预装linux系统。欢迎前来试机，坐标11-609', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FtdMCCKm8VYAZeuUViAOxOetarYb', '2019-12-20 13:50:05', '2019-12-20 13:50:05', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (95, '叫你一声靓仔', 500.00, '500块钱一声靓仔，你买不了吃亏，你买不了上当，快来购买吧~', 40, 0, 'http://q2caan54b.bkt.clouddn.com/FgLNfx7H6MVPADwn_xCPQG0Yp8WV', '2019-12-20 13:51:22', '2019-12-20 13:51:22', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (96, '卖猪了，不要钱。', 1.00, '养不起了，送人送猫粮。还给钱。', 39, 0, 'http://q2caan54b.bkt.clouddn.com/FsQPTPSGs1tkWTTQh387Nu568LVa', '2019-12-20 13:51:41', '2019-12-20 13:51:41', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (97, '正品米酒', 99.00, '55°米酒，欢迎各位老板下单，偏远地区不包邮。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FumzQ7NejoYinuXvLxZbX4hw4apA', '2019-12-20 13:51:52', '2019-12-20 13:51:52', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (98, '毛线', 199.00, '可以缠住。。。。。。。。。。。', 41, 0, 'http://q2caan54b.bkt.clouddn.com/Fs88xNxyGuNYaE70xnQB8qvHQjnJ', '2019-12-20 13:53:33', '2019-12-20 13:53:33', 0, 5, NULL, NULL);
INSERT INTO `tb_product` VALUES (99, '生命一号', 9999.00, '提高抵抗力。降低群主发际线。嘿嘿嘿', 41, 0, 'http://q2caan54b.bkt.clouddn.com/FkaKSgAUN8lZB1w6r3mAX6D0rmcq', '2019-12-20 13:56:25', '2019-12-20 13:56:25', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (100, '超级跑车', 400000.00, '一女找一大师摸骨算命，摸了半响，大师表情越来越严厉，女小心谨慎地问：', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FqD9n-0erQ0I4FvaQ3SW8Kmy6vLn', '2019-12-20 13:56:33', '2019-12-20 13:56:33', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (101, '泰迪狗', 1999.00, '白羊座   综合指数两颗星 运势稍有下滑的势头，你虽有远见，但行动却没有跟上来。你对于工作和学习都有很多的想法，也能想到长远的未来，只是行动上迟迟看不到实际的改进。恋爱还是会维持着现状，平淡得有点像老夫老妻，相处中缺少了点心动的感觉。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fsn2xhWVmr1UKszn3nXSRf5IhPhS,http://q2caan54b.bkt.clouddn.com/Fv6DzV5PxLnQFEv6mLDxCODur92K', '2019-12-20 13:57:25', '2019-12-20 13:57:25', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (102, '黑泰迪狗', 1999.00, '这世间青山灼灼星光杳杳，春风翩翩晚风渐渐，也抵不过你眉目间的星辰点点。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FqivGIyoixqHdRI_QbzwSVMyNuPM,http://q2caan54b.bkt.clouddn.com/FpuoiXsK5yPv-PHqcSZiWk2cik5q', '2019-12-20 13:58:18', '2019-12-20 13:58:18', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (103, '主板套装', 3999.00, '【整点强迫症】 释义：说好了7点开始复习，一看时间过了7点，便告诉自己，那就再玩一会，到8点再开始吧。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FsDkKiA7S0MLA_DDRJX4E74a6Net,http://q2caan54b.bkt.clouddn.com/FmCH10R-nSpzTbR1OVhQlk9wp_Di', '2019-12-20 13:59:01', '2019-12-20 13:59:01', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (104, '好菜', 99.00, '小偷、黑客、工程师都靠什么吃饭？  靠嘴（不用嘴试试）', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FtGl1pgcDOimiiFlK2xvZgh0HCOb,http://q2caan54b.bkt.clouddn.com/FhwLnb67hBeBYvpLEqw_xiJVKk7L', '2019-12-20 14:00:31', '2019-12-20 14:00:31', 0, 4, NULL, NULL);
INSERT INTO `tb_product` VALUES (105, 'AMD锐龙处理器 3700X', 1999.00, '乞丐：能不能给我一百块钱？路人： 我只有八十块钱。乞丐： 那你就欠我二十块钱吧 道理： 有些人总以为是别人欠他的，老觉得老天爷给的不够多、不够好，贪婪之欲早已代替了感恩之心。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/FktZAgvKNPgOMh2vyPMCcFBtoGO8', '2019-12-20 14:02:18', '2019-12-20 14:02:18', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (106, 'vega1660显卡', 1299.00, ' 金牛座  综合指数三颗星  你的态度会很慎重，行动也会略显保守，但走得很稳。你做事的时候总有自己的考虑，每一步都是经过深思熟虑，会选择对自己比较有优势的任务来做。恋爱会有些零零散散的思绪，不如好好陪伴恋人，与Ta交心聊聊天。', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fr4RvIFYIAiaBSPFANCeaexBoJJC', '2019-12-20 14:03:35', '2019-12-20 14:03:35', 0, 1, NULL, NULL);
INSERT INTO `tb_product` VALUES (107, '月饼', 199.00, '小偷、黑客、工程师都靠什么吃饭？  靠嘴（不用嘴试试）小偷、黑客、工程师都靠什么吃饭？  靠嘴（不用嘴试试）小偷、黑客、工程师都靠什么吃饭？  靠嘴（不用嘴试试）', 38, 0, 'http://q2caan54b.bkt.clouddn.com/Fu2pe_eYF9gXMvl7U3idcS4o19n-,http://q2caan54b.bkt.clouddn.com/Fpz40mjbZbmK6zbse_DBplhd8Ze8', '2019-12-20 14:05:33', '2019-12-20 14:05:33', 0, 6, NULL, NULL);
INSERT INTO `tb_product` VALUES (108, '特质电脑。', 10000.00, '高端人士专属电脑。低端人士勿扰。', 39, 1, 'http://q2caan54b.bkt.clouddn.com/FnQ4EBGR0kEAxkQCOOOqQzCE1kKt', '2019-12-20 14:07:34', '2019-12-20 14:07:34', 0, 4, NULL, 20);
INSERT INTO `tb_product` VALUES (109, '啦咯啦咯啦咯', 88.00, '啦咯啦咯啦咯              ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FmGDkFstmouPWm9NSYxbC3c_VWE7,http://q2caan54b.bkt.clouddn.com/Fik3NPyLANL0DXu23VyzaJQkKZle', '2019-12-21 00:54:57', '2019-12-21 00:54:57', 1, 6, 1, NULL);
INSERT INTO `tb_product` VALUES (110, '测试发布', 60.00, '     你跟你自信在真转在真转在真在真转在真转在真', 43, 0, 'http://q2caan54b.bkt.clouddn.com/FlOqWCYiSXPnK9J1yz7Jv75I4eys,http://q2caan54b.bkt.clouddn.com/FrSQB-NKfUJQHMjzxUnVwCzAIGYh', '2019-12-21 02:27:41', '2019-12-21 02:27:41', 1, 6, 3, NULL);
INSERT INTO `tb_product` VALUES (111, '二狗子出来挨打', 999.99, '                              ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FhTJHKRP53Bqj6RJhkfs9d90qh4d', '2019-12-21 07:19:38', '2019-12-21 07:19:38', 1, 1, 1, NULL);
INSERT INTO `tb_product` VALUES (112, '啊啊啊', 22.00, '擦擦擦擦擦擦愤怒             ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FrDKa9GjrUxcAkaqydvlA08Te8km', '2019-12-21 09:25:51', '2019-12-21 09:25:51', 1, 1, 1, NULL);
INSERT INTO `tb_product` VALUES (113, '上去在真转在真转在真', 9999999.00, '哦哦搜狗你在在真转在真转在真下午他 ', 20, 0, 'http://q2caan54b.bkt.clouddn.com/FtWeNNhvTJj754aENw-HUzt9zsy7,http://q2caan54b.bkt.clouddn.com/Fuq5SJTbalebtNifs2EneYg3tkeP', '2019-12-30 06:45:51', '2019-12-30 06:45:51', 0, 5, 1, NULL);

-- ----------------------------
-- Table structure for tb_school
-- ----------------------------
DROP TABLE IF EXISTS `tb_school`;
CREATE TABLE `tb_school`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名字',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_school
-- ----------------------------
INSERT INTO `tb_school` VALUES (1, 'http://image.imhtb.cn/guet_logo.jpg', '桂林电子科技大学', '欢迎加入桂林电子科技大学二手字节交易市场', NULL, NULL, 0);
INSERT INTO `tb_school` VALUES (2, 'http://image.imhtb.cn/gxsf_logo.jpg', '广西师范大学', '欢迎加入广西师范大学二手字节交易市场', NULL, NULL, 0);
INSERT INTO `tb_school` VALUES (3, 'http://image.imhtb.cn/gxdx_logo.jpg', '广西大学', '欢迎加入广西大学二手字节交易市场', NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_store
-- ----------------------------
DROP TABLE IF EXISTS `tb_store`;
CREATE TABLE `tb_store`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏商品id',
  `user_id` int(11) NOT NULL COMMENT '收藏用户id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品表中对应商品id',
  `type` int(11) NULL DEFAULT NULL COMMENT '0表示收藏，1表示历史记录，2表示买到的商品',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 254 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_store
-- ----------------------------
INSERT INTO `tb_store` VALUES (220, 20, 100, 1001, '2019-12-21 06:35:14', '2019-12-21 15:47:01');
INSERT INTO `tb_store` VALUES (221, 20, 107, 1001, '2019-12-21 06:35:46', '2019-12-21 06:43:22');
INSERT INTO `tb_store` VALUES (222, 20, 101, 1001, '2019-12-21 06:35:56', '2019-12-21 08:33:55');
INSERT INTO `tb_store` VALUES (223, 20, 106, 1001, '2019-12-21 06:36:23', '2019-12-21 08:44:56');
INSERT INTO `tb_store` VALUES (224, 20, 95, 1001, '2019-12-21 07:11:08', '2019-12-21 09:52:50');
INSERT INTO `tb_store` VALUES (225, 20, 108, 1001, '2019-12-21 07:18:52', '2019-12-21 07:46:24');
INSERT INTO `tb_store` VALUES (226, 20, 111, 1001, '2019-12-21 07:19:38', '2019-12-21 07:19:43');
INSERT INTO `tb_store` VALUES (227, 20, 91, 1001, '2019-12-21 07:25:21', '2019-12-21 08:48:45');
INSERT INTO `tb_store` VALUES (228, 20, 81, 1001, '2019-12-21 07:31:08', '2019-12-21 07:47:19');
INSERT INTO `tb_store` VALUES (229, 20, 77, 1001, '2019-12-21 07:47:22', '2019-12-22 02:32:42');
INSERT INTO `tb_store` VALUES (230, 20, 89, 1001, '2019-12-21 08:32:30', '2019-12-22 11:13:29');
INSERT INTO `tb_store` VALUES (231, 20, 94, 1001, '2019-12-21 08:32:49', '2019-12-21 08:34:13');
INSERT INTO `tb_store` VALUES (232, 20, 96, 1001, '2019-12-21 08:32:54', NULL);
INSERT INTO `tb_store` VALUES (233, 20, 71, 1001, '2019-12-21 08:33:15', '2019-12-21 08:34:25');
INSERT INTO `tb_store` VALUES (234, 20, 67, 1001, '2019-12-21 08:33:17', NULL);
INSERT INTO `tb_store` VALUES (235, 20, 86, 1001, '2019-12-21 08:34:18', '2019-12-23 08:34:27');
INSERT INTO `tb_store` VALUES (236, 20, 85, 1001, '2019-12-21 08:34:33', NULL);
INSERT INTO `tb_store` VALUES (237, 20, 104, 1001, '2019-12-21 08:48:48', '2019-12-21 09:52:44');
INSERT INTO `tb_store` VALUES (238, 20, 87, 1001, '2019-12-21 08:48:53', NULL);
INSERT INTO `tb_store` VALUES (239, 20, 105, 1001, '2019-12-21 09:00:20', NULL);
INSERT INTO `tb_store` VALUES (240, 20, 112, 1001, '2019-12-21 09:25:51', NULL);
INSERT INTO `tb_store` VALUES (241, 20, 65, 1001, '2019-12-21 09:53:24', '2019-12-21 10:08:10');
INSERT INTO `tb_store` VALUES (242, 20, 93, 1001, '2019-12-21 09:55:28', '2019-12-21 10:08:50');
INSERT INTO `tb_store` VALUES (243, 20, 90, 1001, '2019-12-21 10:08:05', '2019-12-21 10:13:42');
INSERT INTO `tb_store` VALUES (244, 20, 107, 1000, '2019-12-21 10:09:18', NULL);
INSERT INTO `tb_store` VALUES (245, 20, 99, 1001, '2019-12-21 10:09:42', NULL);
INSERT INTO `tb_store` VALUES (246, 20, 76, 1001, '2019-12-21 10:12:37', NULL);
INSERT INTO `tb_store` VALUES (247, 20, 106, 1000, '2019-12-21 15:47:22', NULL);
INSERT INTO `tb_store` VALUES (248, 20, 75, 1001, '2019-12-21 15:47:56', '2020-03-14 11:13:53');
INSERT INTO `tb_store` VALUES (249, 20, 88, 1001, '2019-12-23 08:34:24', NULL);
INSERT INTO `tb_store` VALUES (250, 24, 107, 1001, '2019-12-25 08:12:04', '2019-12-25 08:17:19');
INSERT INTO `tb_store` VALUES (251, 24, 98, 1001, '2019-12-25 08:14:59', NULL);
INSERT INTO `tb_store` VALUES (252, 24, 107, 1000, '2019-12-25 08:18:12', NULL);
INSERT INTO `tb_store` VALUES (253, 20, 113, 1001, '2019-12-30 06:45:52', NULL);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nick_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `avatar` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://q1u4jkqnr.bkt.clouddn.com/gray_avatar.jpg' COMMENT '头像',
  `school_id` int(11) NULL DEFAULT NULL COMMENT '所在学校',
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '这个人很懒~什么都没留下' COMMENT '个性签名',
  `rong_cloud_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (20, '黄总', '666', '666', '2019-12-18 14:57:39', '2020-03-14 11:49:11', 'http://q2caan54b.bkt.clouddn.com/FrkQ0gz7Grnllu3kftgnOKtSANxK', 1, '这个人很懒~什么都没留下', 'akZfFVrVrDbOKtUnBC4Fx6gPyxLY3uLYCd+Gr468txg7vubrul9lR46QFpVmGjyoU54Zt6AlkqXApiA4gYGhmA==');
INSERT INTO `tb_user` VALUES (24, '老王王王', '19980225', 'wyk1998', '2019-12-18 15:00:19', '2019-12-20 08:46:06', 'http://q2caan54b.bkt.clouddn.com/FgZJHf4d4-j6ZPuxk69XVdSCDjpb', 3, '狼', 'h24zlj2R2borBz13/KoCWxrO7FEyNFvGAlR98nCBhwqQvYEIpEQjLjvwDl6Fl7gjE43xxovoMo4=');
INSERT INTO `tb_user` VALUES (38, '社会梁总', 'lequal', '123456', '2019-12-20 07:11:23', '2019-12-20 13:53:32', 'http://q2caan54b.bkt.clouddn.com/FpXGCz9Pu3ePhki3fXPeTDu8LSdr', NULL, '大家好，本人经营各种二手物品，欢迎咨询。', 'YoxiQAT/tiWfLFh5K/PcmSfFINvFv3J+MrmdHpcnnkA5WgQSOEu95DxC/VxFEdeknDBJqgvDoSOjd/BjK8pVaA==');
INSERT INTO `tb_user` VALUES (39, '杰尼龟233', '123456', '1234567', '2019-12-20 13:31:23', '2019-12-20 13:32:01', 'http://q2caan54b.bkt.clouddn.com/FgYd0esvcziSLVJuk-Y64JGvjz1C', NULL, '这个人很懒~什么都没留下', 'Np9eGLd0ddb5f0Jjw2+J7CfFINvFv3J+MrmdHpcnnkA5WgQSOEu95MpuR6tBV0BgDu0icyZKOWKjd/BjK8pVaA==');
INSERT INTO `tb_user` VALUES (40, '咸鱼咸鱼没放盐', '咸鱼咸鱼咸鱼', '123456789', '2019-12-20 13:32:59', '2019-12-20 13:32:59', 'http://q1u4jkqnr.bkt.clouddn.com/gray_avatar.jpg', NULL, '这个人很懒~什么都没留下', 'uT6lRSA2KfL3eO52d5oYTagPyxLY3uLYCd+Gr468txg7vubrul9lR3VCR7GopHVedmHBUmsZ4inApiA4gYGhmA==');
INSERT INTO `tb_user` VALUES (41, '生命一号', '生命一号999', '123456', '2019-12-20 13:48:34', '2019-12-20 13:48:34', 'http://q1u4jkqnr.bkt.clouddn.com/gray_avatar.jpg', NULL, '这个人很懒~什么都没留下', 'uvRukdA2Qy/gjahTs5zI1SfFINvFv3J+MrmdHpcnnkA5WgQSOEu95LiI3z8HDlloSb8Be+PiWkejd/BjK8pVaA==');
INSERT INTO `tb_user` VALUES (42, 'liangyike', 'liangyike', '1234567', '2019-12-21 01:43:16', '2019-12-21 01:44:38', 'http://q2caan54b.bkt.clouddn.com/Fh_e0b6LRmg0A_Q8ef3biGIhsA27', NULL, '老铁，稳。喜欢请直接下单', '8KGm8E9o5EXXeSu8wM0Y7qgPyxLY3uLYCd+Gr468txg7vubrul9lR/vzArH5FxBOaXc/rNE6T3nApiA4gYGhmA==');
INSERT INTO `tb_user` VALUES (43, '测试用户', '666666', '666666', '2019-12-21 02:26:29', '2019-12-21 06:04:38', 'http://q2caan54b.bkt.clouddn.com/FuEd_HHaWTG_UeTePyO8GKqY6lkK', 1, '这个人很懒~什么都没留下', 'N5+G77ILzIlUSQj7YQ8gxSfFINvFv3J+MrmdHpcnnkA5WgQSOEu95GrqfCzVxYZlh2iKrOcqDDSjd/BjK8pVaA==');

SET FOREIGN_KEY_CHECKS = 1;
