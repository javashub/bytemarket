/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : byte_market

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 19/06/2020 22:48:33
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (1, '梁艺可', '18888888888', '广西壮族自治区桂林市灵川县桂林电子科技大学花江校区', 1);
INSERT INTO `tb_address` VALUES (2, '王胤凯', '18778731412', '广西壮族自治区桂林市灵川县桂林电子科技大学花江校区', 2);

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------
INSERT INTO `tb_banner` VALUES (1, 'http://image.imhtb.cn/3f5ff03fa0c024b930f515e63ae2c702.jpg_945x288_7dff4510.jpg', '服务器图片1');
INSERT INTO `tb_banner` VALUES (2, 'http://image.imhtb.cn/76e68eda4ed089c0e5b0ce2367efe428.jpg', '服务器图片2');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, '其他');
INSERT INTO `tb_category` VALUES (2, '手机');
INSERT INTO `tb_category` VALUES (3, '书籍');
INSERT INTO `tb_category` VALUES (4, '外设');
INSERT INTO `tb_category` VALUES (5, '衣服');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(1) NOT NULL COMMENT '订单表id',
  `order_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `user_id` int(11) NOT NULL COMMENT '下单用户id',
  `product_id` int(11) NOT NULL COMMENT '购买的商品id',
  `total_money` decimal(11, 2) NOT NULL COMMENT '订单总金额',
  `pay_type` int(11) NOT NULL COMMENT '支付方式，0为支付宝支付，1为微信支付',
  `status` int(11) NOT NULL COMMENT '订单状态，0为无效，1为有效',
  `is_pay` int(11) NOT NULL COMMENT '支付状态，0表示未支付或者支付失败，1表示支付成功',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注信息',
  `pay_from` int(11) NULL DEFAULT NULL COMMENT '支付来源',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家收货地址',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `user_pthone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家联系方式',
  `trade_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付回执单号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (1, '小米机械键盘', 99.00, '小米机械键盘全新未拆封，喜欢请联系哦', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg', '2019-12-01 18:06:20', '2019-12-01 18:07:01', 0, 1, 2);
INSERT INTO `tb_product` VALUES (2, '小米2', 22.00, '小米9', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/%E8%BD%A6%E7%AA%97%20%E5%B0%91%E5%A5%B3%E5%A5%B3%E5%AD%90%20%E8%81%86%E5%90%AC%E9%9F%B3%E4%B9%90%206k%E5%8A%A8%E6%BC%AB%E5%A3%81%E7%BA%B8_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg', '2019-12-01 18:06:23', '2019-12-01 18:07:03', 0, 2, 1);
INSERT INTO `tb_product` VALUES (3, '小米3', 2134.00, '小米8', 3, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (4, '小米4', 2134.00, '小米8', 3, 0, 'http://q1u4jkqnr.bkt.clouddn.com/%E8%BD%A6%E7%AA%97%20%E5%B0%91%E5%A5%B3%E5%A5%B3%E5%AD%90%20%E8%81%86%E5%90%AC%E9%9F%B3%E4%B9%90%206k%E5%8A%A8%E6%BC%AB%E5%A3%81%E7%BA%B8_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (5, '小米5', 2134.00, '小米8', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (6, '小米6', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (7, '小米7', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (8, '小米8', 2134.00, '小米8', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (9, '小米9', 2134.00, '小米8', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (10, '小米10', 2134.00, '小米8', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (11, '小米11', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/%E8%BD%A6%E7%AA%97%20%E5%B0%91%E5%A5%B3%E5%A5%B3%E5%AD%90%20%E8%81%86%E5%90%AC%E9%9F%B3%E4%B9%90%206k%E5%8A%A8%E6%BC%AB%E5%A3%81%E7%BA%B8_%E5%BD%BC%E5%B2%B8%E5%9B%BE%E7%BD%91.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (12, '小米12', 2134.00, '小米8', 3, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (13, '小米13', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (14, '小米14', 2134.00, '小米8', 3, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (15, '小米15', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (16, '小米16', 2134.00, '小米8', 3, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (17, '小米17', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (18, '小米18', 2134.00, '小米8', 2, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods1.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (19, '小米19', 2134.00, '小米8', 1, 0, 'http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods2.jpg,http://q1u4jkqnr.bkt.clouddn.com/goods3.jpg', '2019-12-05 22:39:45', '2019-12-05 22:39:48', 0, 2, 1);
INSERT INTO `tb_product` VALUES (21, '2', 20.00, '2', 1, 0, 'http://q2caan54b.bkt.clouddn.com/FvVSp-chixujt4Elu-HHzplshOrZ,http://q2caan54b.bkt.clouddn.com/FuNJtZRpGe5NNVQh6gn5NMI3Q5cA', NULL, NULL, 0, 1, 1);
INSERT INTO `tb_product` VALUES (22, '3', 3.00, '3', 1, 0, 'http://q2caan54b.bkt.clouddn.com/Fi7iHWMqPCuOz5hhDj3kQQ0F5rzS,http://q2caan54b.bkt.clouddn.com/FuNJtZRpGe5NNVQh6gn5NMI3Q5cA', NULL, NULL, 0, 1, 1);
INSERT INTO `tb_product` VALUES (24, ' 噢啦', 3.00, '克拉', 1, 0, 'http://q2caan54b.bkt.clouddn.com/FvVSp-chixujt4Elu-HHzplshOrZ,http://q2caan54b.bkt.clouddn.com/FuNJtZRpGe5NNVQh6gn5NMI3Q5cA', NULL, NULL, 0, 3, NULL);
INSERT INTO `tb_product` VALUES (25, '可乐', 555.00, '咯哦哦', 1, 0, 'http://q2caan54b.bkt.clouddn.com/FqH377UHKW8PMewvyUlC8zPswShr', NULL, NULL, 0, 3, NULL);
INSERT INTO `tb_product` VALUES (28, '落落', 250.00, '', 1, 0, 'http://q2caan54b.bkt.clouddn.com/FuNJtZRpGe5NNVQh6gn5NMI3Q5cA,http://q2caan54b.bkt.clouddn.com/FvVSp-chixujt4Elu-HHzplshOrZ', NULL, NULL, 0, 1, NULL);
INSERT INTO `tb_product` VALUES (30, '就两件接口', 250.00, '', 1, 0, 'http://q2caan54b.bkt.clouddn.com/Fpl8x2r8OcsTONWLaEB6etU8db9w', NULL, NULL, 0, 1, NULL);
INSERT INTO `tb_product` VALUES (31, '明年', 250.00, '哦红米', 1, 0, 'http://q2caan54b.bkt.clouddn.com/Fpl8x2r8OcsTONWLaEB6etU8db9w', NULL, NULL, 0, 1, NULL);
INSERT INTO `tb_product` VALUES (33, '傻逼', 250.00, '', 1, 0, 'http://q2caan54b.bkt.clouddn.com/Fkf6i2rRXk9ZbsfOLMp4JQWSqXfe,http://q2caan54b.bkt.clouddn.com/Fu3A5B3a-J549CHEbo7mpiV_ThVc', NULL, NULL, 0, 5, NULL);
INSERT INTO `tb_product` VALUES (39, '吃鸡', 333.00, '', 3, 0, 'http://q2caan54b.bkt.clouddn.com/FhAD4gJa_Of4bWcZBd6TkMxXfqm3', NULL, NULL, 0, 1, NULL);
INSERT INTO `tb_product` VALUES (40, '中国福利彩票', 2.00, '两块抽一次', 2, 0, 'http://q2caan54b.bkt.clouddn.com/FuB_IKUoq27ZgFDhsVPFmHpKhtlh', NULL, NULL, 0, 1, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nick_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `avatar` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `school_id` int(11) NULL DEFAULT NULL COMMENT '所在学校',
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '梁总-打饭哥', '123', '123', NULL, NULL, 'http://q1.qlogo.cn/g?b=qq&nk=1576070851&s=100', NULL, '钱是什么东西？');
INSERT INTO `tb_user` VALUES (2, '王总-报告哥', '1234', '1234', NULL, NULL, 'http://q1.qlogo.cn/g?b=qq&nk=857070498&s=100', NULL, '');
INSERT INTO `tb_user` VALUES (3, '黄总-帅哥', '12345', '12345', NULL, NULL, 'http://q1.qlogo.cn/g?b=qq&nk=794409767&s=100', NULL, ' ');
INSERT INTO `tb_user` VALUES (4, '测试1', '123456', '123456', NULL, NULL, 'http://q1.qlogo.cn/g?b=qq&nk=1576070851&s=100', NULL, NULL);
INSERT INTO `tb_user` VALUES (5, '测试2', '1234567', '1234567', NULL, NULL, 'http://q1.qlogo.cn/g?b=qq&nk=1576070851&s=100', NULL, '');

SET FOREIGN_KEY_CHECKS = 1;
