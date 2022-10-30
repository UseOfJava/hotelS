/*
 Navicat Premium Data Transfer

 Source Server         : JavaEE
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : data_hotel

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/10/2022 18:01:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `t_loginlog`;
CREATE TABLE `t_loginlog`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_loginlog
-- ----------------------------
INSERT INTO `t_loginlog` VALUES (7, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (8, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (9, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (10, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (11, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (12, 'admin', '2022-06-01 00:00:00');
INSERT INTO `t_loginlog` VALUES (13, 'admin', '2022-06-01 13:10:17');
INSERT INTO `t_loginlog` VALUES (14, 'admin', '2022-06-01 13:11:27');
INSERT INTO `t_loginlog` VALUES (15, 'admin', '2022-06-01 13:17:26');
INSERT INTO `t_loginlog` VALUES (16, 'admin', '2022-06-01 13:24:57');
INSERT INTO `t_loginlog` VALUES (17, 'LuLoneStar', '2022-06-01 14:25:24');
INSERT INTO `t_loginlog` VALUES (18, '1686520940', '2022-06-01 14:46:05');
INSERT INTO `t_loginlog` VALUES (19, '1686520940', '2022-06-01 14:47:23');
INSERT INTO `t_loginlog` VALUES (20, 'admin', '2022-06-01 15:10:07');
INSERT INTO `t_loginlog` VALUES (21, 'admin', '2022-06-01 15:10:13');
INSERT INTO `t_loginlog` VALUES (22, 'admin', '2022-06-01 15:27:57');
INSERT INTO `t_loginlog` VALUES (23, '1686520940', '2022-06-01 15:38:50');
INSERT INTO `t_loginlog` VALUES (24, '1686520940', '2022-06-01 15:43:35');
INSERT INTO `t_loginlog` VALUES (25, 'admin', '2022-06-02 07:48:21');
INSERT INTO `t_loginlog` VALUES (26, 'admin', '2022-06-02 07:59:55');
INSERT INTO `t_loginlog` VALUES (27, 'admin', '2022-06-02 08:02:00');
INSERT INTO `t_loginlog` VALUES (28, 'admin', '2022-06-02 08:10:24');
INSERT INTO `t_loginlog` VALUES (29, 'admin', '2022-06-02 08:42:53');
INSERT INTO `t_loginlog` VALUES (30, '1686520940', '2022-06-02 08:59:42');
INSERT INTO `t_loginlog` VALUES (31, '1686520940', '2022-06-02 09:00:34');
INSERT INTO `t_loginlog` VALUES (32, '1686520940', '2022-06-02 09:42:48');
INSERT INTO `t_loginlog` VALUES (33, '1686520940', '2022-06-02 10:21:10');
INSERT INTO `t_loginlog` VALUES (34, '1686520940', '2022-06-02 10:36:20');
INSERT INTO `t_loginlog` VALUES (35, '1686520940', '2022-06-02 10:39:11');
INSERT INTO `t_loginlog` VALUES (36, 'admin', '2022-06-02 10:39:21');
INSERT INTO `t_loginlog` VALUES (37, '1686520940', '2022-06-02 10:39:50');
INSERT INTO `t_loginlog` VALUES (38, '1686520940', '2022-06-02 16:04:52');
INSERT INTO `t_loginlog` VALUES (39, 'admin', '2022-06-12 19:57:22');
INSERT INTO `t_loginlog` VALUES (40, 'admin', '2022-06-16 11:41:19');
INSERT INTO `t_loginlog` VALUES (41, 'admin', '2022-06-16 15:01:27');
INSERT INTO `t_loginlog` VALUES (42, 'admin', '2022-06-19 10:04:50');
INSERT INTO `t_loginlog` VALUES (43, 'guoqian', '2022-06-19 10:09:45');
INSERT INTO `t_loginlog` VALUES (44, 'guoqian', '2022-06-19 10:11:02');
INSERT INTO `t_loginlog` VALUES (45, 'guoqian', '2022-06-19 17:58:26');
INSERT INTO `t_loginlog` VALUES (46, 'admin', '2022-06-19 18:05:14');
INSERT INTO `t_loginlog` VALUES (47, 'admin', '2022-07-04 18:53:23');
INSERT INTO `t_loginlog` VALUES (48, 'admin', '2022-07-04 18:58:54');
INSERT INTO `t_loginlog` VALUES (49, 'admin', '2022-10-30 17:44:28');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `room_id` int UNSIGNED NULL DEFAULT NULL,
  `vip_id` int UNSIGNED NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `stay_days` int UNSIGNED NULL DEFAULT NULL,
  `state` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '0=正在生效；1=已退房',
  `check_out_time` datetime NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '消费金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 1, 1, '2022-05-30 09:27:53', 4, 0, '2022-06-03 09:29:34', 800.00);
INSERT INTO `t_order` VALUES (2, 2, 1, '2022-06-05 15:11:34', 2, 0, '2022-06-02 15:12:26', 256.00);
INSERT INTO `t_order` VALUES (3, 1, 8, '2022-05-11 15:31:26', 10, 0, '2022-05-20 15:31:36', 2048.50);
INSERT INTO `t_order` VALUES (5, 1, 8, '2022-06-05 09:13:55', 3, 0, '2022-06-01 09:14:13', 310.54);
INSERT INTO `t_order` VALUES (7, 2, 4, '2021-02-18 13:18:36', 25, 0, '2021-03-13 13:18:52', 4456.79);

-- ----------------------------
-- Table structure for t_order_info
-- ----------------------------
DROP TABLE IF EXISTS `t_order_info`;
CREATE TABLE `t_order_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` int UNSIGNED NULL DEFAULT NULL,
  `check_in_date` date NULL DEFAULT NULL,
  `state` tinyint UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_info
-- ----------------------------
INSERT INTO `t_order_info` VALUES (1, 1, '2022-05-31', 0);
INSERT INTO `t_order_info` VALUES (2, 1, '2022-06-01', 0);
INSERT INTO `t_order_info` VALUES (3, 1, '2022-06-02', 0);
INSERT INTO `t_order_info` VALUES (4, 1, '2022-05-30', 0);
INSERT INTO `t_order_info` VALUES (5, 2, '2022-06-01', 0);
INSERT INTO `t_order_info` VALUES (6, 2, '2022-06-02', 0);
INSERT INTO `t_order_info` VALUES (7, 2, '2022-06-17', 0);
INSERT INTO `t_order_info` VALUES (8, 1, '2022-06-15', 0);
INSERT INTO `t_order_info` VALUES (9, 3, '2022-06-04', 0);
INSERT INTO `t_order_info` VALUES (10, 3, '2022-06-02', 0);
INSERT INTO `t_order_info` VALUES (11, 3, '2022-06-04', 0);
INSERT INTO `t_order_info` VALUES (12, 1, '2022-06-03', 0);

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
  `state` tinyint UNSIGNED NOT NULL COMMENT '0=可入住；1=已预订；2=已入住；3=正在维修',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, 'A101', 1);
INSERT INTO `t_room` VALUES (2, 'A202', 0);
INSERT INTO `t_room` VALUES (4, 'A516', 0);
INSERT INTO `t_room` VALUES (6, 'B516', 2);
INSERT INTO `t_room` VALUES (7, 'C110', 3);
INSERT INTO `t_room` VALUES (9, 'B518', 0);
INSERT INTO `t_room` VALUES (10, 'B519', 1);
INSERT INTO `t_room` VALUES (11, 'B517', 0);
INSERT INTO `t_room` VALUES (12, 'A810', 2);
INSERT INTO `t_room` VALUES (13, 'A910', 1);
INSERT INTO `t_room` VALUES (14, 'C666', 0);
INSERT INTO `t_room` VALUES (15, 'A123', 0);
INSERT INTO `t_room` VALUES (16, 'C610', 2);
INSERT INTO `t_room` VALUES (17, 'C555', 3);
INSERT INTO `t_room` VALUES (18, 'C621', 3);
INSERT INTO `t_room` VALUES (19, 'D612', 0);
INSERT INTO `t_room` VALUES (20, 'A111', 1);
INSERT INTO `t_room` VALUES (24, 'A222', 3);

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` tinyint NOT NULL COMMENT '0-可登录',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int UNSIGNED NULL DEFAULT NULL,
  `sex` tinyint UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES (2, 'root', '', 0, '超级管理员', 3, 0);
INSERT INTO `t_staff` VALUES (5, 'lihua', 'e0a7fe456209c299056e4f87a7404162dX', 1, '李华娟', 9, 0);
INSERT INTO `t_staff` VALUES (8, 'lixiaolu', ' ', 1, '李小路', 4, 0);
INSERT INTO `t_staff` VALUES (12, 'baosanniang', ' ', 1, '鲍三娘', 12, 0);
INSERT INTO `t_staff` VALUES (13, 'jingjie', 'e0a7fe456209c299056e4f87a7404162dX', 1, '田静', 9, 0);
INSERT INTO `t_staff` VALUES (14, 'yudie', '', 1, '张宇', 23, 1);
INSERT INTO `t_staff` VALUES (25, 'admin', 'c67622c30968a1eb91b4842ca89471bemb', 0, '老三', 5, 1);
INSERT INTO `t_staff` VALUES (45, 'HowCanUSleep', 'd3f1c2fe52e2ce3e03b887a58aa7251emw', 0, '汤家凤', 43, 1);
INSERT INTO `t_staff` VALUES (47, 'LuLoneStar', 'fb9e746b826f066c62b885ef6d08a297ew', 0, '鲁智深', 1, 1);
INSERT INTO `t_staff` VALUES (53, 'guoqian', 'f0c43a898287b2ac9017c07945b50f2aaj', 1, '鱼111', 20, 0);

-- ----------------------------
-- Table structure for t_vip
-- ----------------------------
DROP TABLE IF EXISTS `t_vip`;
CREATE TABLE `t_vip`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `state` tinyint UNSIGNED NOT NULL COMMENT '1:已经过期，0:正常使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_vip
-- ----------------------------
INSERT INTO `t_vip` VALUES (4, '李小路', '15253635667', 28, '2022-04-14 23:41:32', 0);
INSERT INTO `t_vip` VALUES (5, 'Fash', '13012290685', 22, '2022-05-28 23:41:01', 0);
INSERT INTO `t_vip` VALUES (6, '张飞', '13012866987', 21, '2022-05-26 23:39:55', 1);
INSERT INTO `t_vip` VALUES (7, '魏欢', '15163991775', 22, '2022-05-05 23:36:17', 1);
INSERT INTO `t_vip` VALUES (8, '李白', '13262598512', 45, '2022-06-01 00:00:00', 0);
INSERT INTO `t_vip` VALUES (9, '魏徵', '19860939399', 75, '2022-05-26 00:00:00', 0);
INSERT INTO `t_vip` VALUES (10, '张大仙', '13012790662', 22, '2022-05-20 00:00:00', 1);

SET FOREIGN_KEY_CHECKS = 1;
