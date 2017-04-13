/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : rsxt

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-11-01 10:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `code` varchar(32) NOT NULL COMMENT '功能模块代码.\n            规则:上级代码_本级代码',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `url` varchar(200) DEFAULT NULL COMMENT '访问地址',
  `parent_code` varchar(32) DEFAULT '0' COMMENT '上级模块 如果是顶级为0',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `type` varchar(1) DEFAULT NULL COMMENT '类型 0系统 1模块 2功能按钮',
  `permit_url` varchar(2000) DEFAULT NULL COMMENT '权限地址,多个用","分割\n            一个功能可能对应多个地址\n            ',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用 1 启用 0停用',
  `icon` varchar(30) DEFAULT NULL COMMENT '模块图标',
  `sys_type` int(1) DEFAULT NULL COMMENT '系统类型  1：运维系统  2：客服系统  3：店家系统',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能模块表';

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('', '社保补缴单', null, '0', null, null, null, '1', null, null);
INSERT INTO `sys_module` VALUES ('peo-1', '系统管理', '', '', '2', '1', '', '1', '', '1');
INSERT INTO `sys_module` VALUES ('peo-1-0', '用户档案', '/userController/user', 'peo-1', '3', '2', null, '1', 'user-manage.png', '1');
INSERT INTO `sys_module` VALUES ('peo-1-1', '角色档案', '/role/initrole', 'peo-1', '3', '2', null, '1', 'role.png', '1');
INSERT INTO `sys_module` VALUES ('peo-1-2', '功能权限', '/auth/page.do', 'peo-1', '3', '2', null, '1', 'function_module.png', '1');
INSERT INTO `sys_module` VALUES ('peo-1-3', '操作日志', '/logManage/returnLoginLog', 'peo-1', '3', '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-1-4', '数据字典', '/data_item', 'peo-1', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2', '参数设置', null, '', null, '1', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-0', '社保基本参数设置', '/pages/canshu/shebao.jsp', 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-1', '公积金基本参数设置', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-2', '社保参数维护', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-3', '公积金参数维护', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-4', '社保缴费比例维护设置', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-5', '公积金缴费比例维护设置', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-6', '计算器', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-2-7', '补缴计算器', null, 'peo-2', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3', '基础档案', null, '', null, '1', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-0', '公司信息', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-1', '业务类型', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-10', '代理信息', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-11', '企业信息', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-12', '证书档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-13', '工伤费率', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-14', '员工信息', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-15', '文化程度档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-16', '民族档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-2', '城市档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-3', '区县档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-4', '产品档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-5', '材料档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-6', '条件档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-7', '缴费人员类别', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-8', '户口类型', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-3-9', '产品材料档案', null, 'peo-3', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5', '业务单据', null, '', null, '1', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-0', '代理服务约定单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-1', '特殊企业服务约定单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-10', '其他任务单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-2', '服务总览', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-3', '社保报增单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-4', '社保报减单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-6', '公积金报增单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-7', '公积金报减单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-8', '公积金补缴单', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-5-9', '社保个人信息变更', null, 'peo-5', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-6', '统计报表', null, '', null, '1', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-6-0', '月报统计表', null, 'peo-6', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-6-1', '代理信息统计表', null, 'peo-6', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-6-2', '账单管理', null, 'peo-6', null, '2', null, '1', null, '1');
INSERT INTO `sys_module` VALUES ('peo-6-3', '账单跟踪', null, 'peo-6', null, '2', null, '1', null, '1');
