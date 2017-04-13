/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : rsxt

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-11-03 18:52:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_product`
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
  `id` varchar(32) NOT NULL,
  `city_id` varchar(32) DEFAULT NULL COMMENT '城市',
  `type_id` varchar(32) DEFAULT NULL COMMENT '业务类型',
  `name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `stand_price` float DEFAULT NULL COMMENT '标准报价',
  `apply_end_time` timestamp NULL DEFAULT NULL COMMENT '申报截止时间',
  `feedback_end_time` timestamp NULL DEFAULT NULL COMMENT '反馈截止时间',
  `feedback_loop` int(11) DEFAULT NULL COMMENT '反馈周期',
  `cost_price` float(100,0) DEFAULT NULL COMMENT '成本价格',
  `mouth_service` int(10) DEFAULT NULL COMMENT '是否包月 1：是 0：不是',
  `task_list` int(10) DEFAULT NULL COMMENT '对任务单 1：社保报增任务单 0：社保报减任务单',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建人id',
  `create_time` timestamp NULL DEFAULT NULL,
  `introduction` varchar(10000) DEFAULT NULL COMMENT '产品简介',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `typeName` varchar(100) DEFAULT NULL COMMENT '业务类型名称',
  `cityName` varchar(100) DEFAULT NULL COMMENT '城市名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO `sys_product` VALUES ('007e0017c7464d00be229bc8413b31f8', '0', '0', 'qxxz', '1', '2016-11-03 00:00:00', '2016-11-02 00:00:00', '1', '1', '0', '0', 'song', '2016-11-03 00:00:00', '', '', null, null);
INSERT INTO `sys_product` VALUES ('1771fe9e8a8648298e6652bf4b88b1cf', '0', '0', 'qqq', '12', '2016-11-03 00:00:00', '2016-11-27 00:00:00', '1', '12', '0', '0', 'song', '2016-11-03 17:05:17', '', '', null, null);
INSERT INTO `sys_product` VALUES ('188db1a293ad410db1c26db571411db5', '0', '0', 'qq', '1', '2016-11-20 00:00:00', '2016-11-03 00:00:00', '1', '12', '0', '0', 'song', '2016-11-03 16:41:50', '', '', null, null);
INSERT INTO `sys_product` VALUES ('470b62c811cc404fa9e0408be0e504bd', '0', '0', 'zzzz', '12', '2016-11-20 00:00:00', '2016-11-03 00:00:00', '1', '12', '0', '0', 'song', '2016-11-03 17:13:34', '', '', null, null);
INSERT INTO `sys_product` VALUES ('5feac1eb3dce4cfe81ebb5665eb3c869', '0', '0', '??1', '1223', '2016-11-03 00:00:00', '2016-11-03 00:00:00', '2147483647', '123', '0', '0', '???', '2016-11-03 14:24:55', '?', '???', null, null);
INSERT INTO `sys_product` VALUES ('6458c5e897c7484e941e7473cc7276e5', null, null, 'ferf', '1236.1', null, null, '1', null, null, null, null, '2016-11-03 15:59:45', null, null, null, null);
INSERT INTO `sys_product` VALUES ('6761aab6a7654c46ba59c34f02f8de8d', '0', '2', '66', '66', '2016-11-03 00:00:00', '2016-11-03 00:00:00', '2147483647', '66', '0', '0', 'song', '2016-11-03 00:00:00', '', '', null, null);
INSERT INTO `sys_product` VALUES ('810848f48d974ef2b2dddf33ba714a1f', '0', '0', 'xxx', '12', '2016-11-20 00:00:00', '2016-11-03 00:00:00', '1', '12', '0', '0', 'song', '2016-11-03 17:14:31', '', '', null, null);
INSERT INTO `sys_product` VALUES ('a6263549b204416993c681b604eb1836', '0', '0', 'zzz', '11', '2016-11-03 00:00:00', '2016-11-03 00:00:00', null, '22', '0', '0', 'zz', '2016-11-03 14:20:57', 'rer', '', null, null);
INSERT INTO `sys_product` VALUES ('aa7905f22cbd48348b7ca8113b7c5e4b', '0', '0', 'rer', '12', '2016-11-03 00:00:00', '2016-11-03 00:00:00', '1', '1', '0', '0', 'song', '2016-11-03 18:38:34', '', '', null, null);
INSERT INTO `sys_product` VALUES ('cc0119f9d86544af9e869deb50282f44', '0', '0', 'e', '12', '2016-11-03 00:00:00', '2016-11-03 00:00:00', '12', '123', '0', '0', 'song', '2016-11-03 16:01:26', '', '', null, null);
INSERT INTO `sys_product` VALUES ('d6206df98d1744589e481d96dcec871d', '0', '0', 'zz', '123', '2016-11-03 00:00:00', '2016-11-15 00:00:00', '12', '123', '0', '0', 'song', '2016-11-03 17:00:38', '', '', null, null);
