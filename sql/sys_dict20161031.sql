/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : rsxt

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-10-31 16:47:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `dict_code` varchar(32) NOT NULL,
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `update_datatime` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '最后操作人id',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1003', '岗位', '岗位', '31', '2016-05-26 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('1006', '民族', '民族', '33', '2016-05-20 13:33:21', '');
INSERT INTO `sys_dict` VALUES ('1007', '文化程度', '文化程度', '35', '2016-05-20 13:33:35', '');
INSERT INTO `sys_dict` VALUES ('1017', '证件类型', '证件类型', '37', '2016-06-01 15:27:34', '');
INSERT INTO `sys_dict` VALUES ('1022', '职业', '职业', '39', '2016-08-05 14:11:47', '');
INSERT INTO `sys_dict` VALUES ('1023', '婚姻', '婚姻', '41', '2016-08-12 10:11:54', '');
INSERT INTO `sys_dict` VALUES ('20001', '业务类型', '业务类型', '1', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20003', '缴费人员类别', '缴费人员类别', '3', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20005', '户口类型', '户口类型', '5', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20007', '个人身份', '个人身份', '7', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20009', '险种信息', '险种信息', '9', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20011', '获取账单方式', '获取账单方式', '11', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20013', '补缴类型', '补缴类型', '13', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20015', '报增类型', '报增类型', '15', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20017', '报减原因', '报减原因', '17', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20019', '户口性质', '户口性质', '19', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20021', '银行信息', '银行信息', '21', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20023', '省份信息', '省份信息', '23', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20025', '城市信息', '城市信息', '25', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20027', '区县信息', '区县信息', '27', '2016-10-31 15:21:46', '');
INSERT INTO `sys_dict` VALUES ('20029', '医院信息', '医院信息', '29', '2016-10-31 15:21:46', '');
