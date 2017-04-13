/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : rsxt

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-10-31 16:48:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `id` varchar(32) NOT NULL,
  `code` varchar(10) NOT NULL COMMENT '代码',
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `data_dict_code` varchar(32) DEFAULT NULL COMMENT '字典id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '最后操作人id',
  `update_datatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典项';

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('01536137ac284378813f556590358665', '44', '俄罗斯族', 'Russian ethnic minority', '1006', '44', null, '2016-05-20 14:29:45');
INSERT INTO `sys_dict_item` VALUES ('03de24a7dba040078d4d38823f04e80f', '17', '哈萨克族', 'Hani ethnic minority', '1006', '17', null, '2016-05-20 14:07:34');
INSERT INTO `sys_dict_item` VALUES ('074f9fbd02ed40b69a6db7f7a7993ca0', '43', '乌孜别克', 'Ozbek ethnic minority', '1006', '43', null, '2016-05-20 14:28:02');
INSERT INTO `sys_dict_item` VALUES ('13c3111351c141b9874ec8f1a329b499', '16', '哈尼族', 'Hani ethnic minority', '1006', '16', null, '2016-05-20 14:07:04');
INSERT INTO `sys_dict_item` VALUES ('13f0b44190c84ae294fdcc7aa2c2cdd6', '13', '瑶族', 'Yao ethnic minority', '1006', '13', null, '2016-05-20 14:04:57');
INSERT INTO `sys_dict_item` VALUES ('18a3e794173745fab0893d63d86440ed', '4', '中专', '', '1007', '5', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('1ab9221055de4f3d95cf71972ff4d00e', '2', '已婚', '已婚', '1023', null, null, '2016-07-08 15:58:15');
INSERT INTO `sys_dict_item` VALUES ('1b82db0cfef3429aa963074165c5e281', '12', '侗族', 'Dong ethnic minority', '1006', '12', null, '2016-05-20 14:04:22');
INSERT INTO `sys_dict_item` VALUES ('2575dfb602164508a61bb0c64955dd1c', '47', '保安族', 'Bonan ethnic minority', '1006', '47', null, '2016-05-20 14:32:28');
INSERT INTO `sys_dict_item` VALUES ('28ba6a6722794a6185eb478d1abc59b8', '28', '景颇族', 'Jingpo ethnic minority', '1006', '28', null, '2016-05-20 14:16:34');
INSERT INTO `sys_dict_item` VALUES ('290eca7678cb4ca7b10da8994602d53a', '4', '藏族', 'Tibetan ethnic minority', '1006', '4', null, '2016-05-20 13:55:25');
INSERT INTO `sys_dict_item` VALUES ('292ba6bc23c94d9d87731df3f65f4b81', '5', '维吾尔族', 'Uygur ethnic minority', '1006', '5', null, '2016-05-20 13:55:58');
INSERT INTO `sys_dict_item` VALUES ('2b833e93737248a48e06376a2993cd94', '39', '阿昌族', 'Achang ethnic minority', '1006', '39', null, '2016-05-20 14:24:15');
INSERT INTO `sys_dict_item` VALUES ('2c46701331e9423e909bc99498624de0', '41', '塔吉克族', 'Tajik ethnic minority', '1006', '41', null, '2016-05-20 14:26:47');
INSERT INTO `sys_dict_item` VALUES ('307bedf6c5234ee4bdc11bd05561eb62', '01', '全职太太', '全职太太', '1022', '1', null, '2016-06-29 18:40:43');
INSERT INTO `sys_dict_item` VALUES ('3396b6a60ac1478ebc4cd23748e24521', '37', '仡佬族', 'Gelo ethnic minority', '1006', '37', null, '2016-05-20 14:22:56');
INSERT INTO `sys_dict_item` VALUES ('39085148dbc0430a820679fdae712606', '15', '土家族', 'Tujia ethnic minority', '1006', '15', null, '2016-05-20 14:06:29');
INSERT INTO `sys_dict_item` VALUES ('39deeb7724c74cd4b287bb9fdd239290', '38', '锡伯族', 'Xibe ethnic minority', '1006', '38', null, '2016-05-20 14:23:39');
INSERT INTO `sys_dict_item` VALUES ('4b50303db201463cb1f37520184fb617', '35', '撒拉族', 'Salar ethnic minority', '1006', '35', null, '2016-05-20 14:20:12');
INSERT INTO `sys_dict_item` VALUES ('4cd60e4a76b6423cbaa7c92b2ffedb87', '3', '初中', '', '1007', '4', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('4ef7df0745c6417fbdaee3f261bb3ee6', '2', '小学', '', '1007', '3', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('53dec09f9e3f453e99a250572ac92bc2', '25', '水族', 'Shui ethnic minority', '1006', '25', null, '2016-05-20 14:14:35');
INSERT INTO `sys_dict_item` VALUES ('549d44af3b1b4e8fae05ccdd14635b52', '11', '满族', 'Manchu ethnic minority', '1006', '11', null, '2016-05-20 14:03:41');
INSERT INTO `sys_dict_item` VALUES ('57baa939befe4dc7b7080810307e01bb', '002', '企业领袖', '企业领袖', '1022', '2', null, '2016-08-15 15:35:27');
INSERT INTO `sys_dict_item` VALUES ('586f576e5400499f9bddeeb0caadbeda', '7', '大学专科', '', '1007', '8', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('5ae51c480cf74f14b9057ade8cfdf2ab', '1', '汉族', 'Han', '1006', '1', null, '2016-05-20 13:45:51');
INSERT INTO `sys_dict_item` VALUES ('5dbe956307554a398bb21f1345c77f3c', '49', '京族', 'Jing ethnic minority', '1006', '49', null, '2016-05-20 14:34:32');
INSERT INTO `sys_dict_item` VALUES ('5f54f3ae748b440ab7ea6f92b1d9673f', '29', '柯尔克孜', 'Kirgiz ethnic minority', '1006', '29', null, '2016-05-20 14:17:12');
INSERT INTO `sys_dict_item` VALUES ('5f5baf4408d742bb9f60217e4eb7a0ed', '21', '佤族', 'Va ethnic minority', '1006', '21', null, '2016-05-20 14:11:14');
INSERT INTO `sys_dict_item` VALUES ('5f9aa13f9d2f43f994413188f741c794', '56', '基诺族', 'Jino ethnic minority', '1006', '56', null, '2016-05-20 14:38:45');
INSERT INTO `sys_dict_item` VALUES ('612b69cbd25c4a0488aed91d8943cb12', '19', '黎族', 'Li ethnic minority', '1006', '19', null, '2016-05-20 14:09:46');
INSERT INTO `sys_dict_item` VALUES ('639c923848d04929bde6941fde21c16b', '1', '未婚', '未婚', '1023', null, null, '2016-07-08 15:58:02');
INSERT INTO `sys_dict_item` VALUES ('65b59f2628204a7c9ba7531f6194d9a0', '6', '苗族', 'Miao ethnic minority', '1006', '6', null, '2016-05-20 13:57:00');
INSERT INTO `sys_dict_item` VALUES ('6b023873e5e5405ab3040d3bc63f6793', '5', '职业高中', '', '1007', '6', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('6b0d859c24dd47d69292b462f1232596', '36', '毛南族', 'Maonan ethnic minority', '1006', '36', null, '2016-05-20 14:22:29');
INSERT INTO `sys_dict_item` VALUES ('6b855b04f175479193edfde814052bb6', '55', '珞巴族', 'Lhoba ethnic minority', '1006', '55', null, '2016-05-20 14:38:18');
INSERT INTO `sys_dict_item` VALUES ('6c7c98ddb0c14afd84d2db56db082df1', '42', '怒族', 'Nu ethnic minority', '1006', '42', null, '2016-05-20 14:27:27');
INSERT INTO `sys_dict_item` VALUES ('6eea5038610042469f99240458e9f1c5', '1', '无', '', '1007', '2', '', '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('784fdde2a0b2491cbfd6cded939a07c4', '07', '其它', '其它', '1022', '7', null, '2016-06-29 18:42:12');
INSERT INTO `sys_dict_item` VALUES ('787dec2e6dbf480c85e4faade492ba70', '4', '丧偶', '丧偶', '1023', null, null, '2016-07-08 15:58:42');
INSERT INTO `sys_dict_item` VALUES ('7b1520ff05074d60a9636eea20eb97d0', '6', '普通高中', '', '1007', '7', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('7ebf0381e9224a839d1f3d48d1ddfe05', '2', '军官证', '军官证', '1017', '2', null, '2016-08-19 19:28:32');
INSERT INTO `sys_dict_item` VALUES ('7fb5bdd3b1d14e76a86fa1575a6a84a8', '33', '羌族', 'Qiang ethnic minority', '1006', '33', null, '2016-05-20 14:19:13');
INSERT INTO `sys_dict_item` VALUES ('7fbafcbe47b34915a6175969c8181ce8', '8', '壮族', 'Zhuang ethnic minority', '1006', '8', null, '2016-05-20 13:59:24');
INSERT INTO `sys_dict_item` VALUES ('80a4466cf2e24132b3269dc227979750', '20', '傈僳族', 'Lisu ethnic minority', '1006', '20', null, '2016-05-20 14:10:20');
INSERT INTO `sys_dict_item` VALUES ('836a395fb9cc4846a0bde079247e2c6a', '18', '傣族', 'Dai ethnic minority', '1006', '18', null, '2016-05-20 14:08:37');
INSERT INTO `sys_dict_item` VALUES ('89cfbd12be9f44e78f589b35f9973c2b', '05', '个体经商', '个体经商', '1022', '5', null, '2016-06-29 18:41:41');
INSERT INTO `sys_dict_item` VALUES ('8eff6a20e5484228a61119a760f2e51d', '7', '彝族', 'Yi ethnic minority', '1006', '7', null, '2016-05-20 13:58:26');
INSERT INTO `sys_dict_item` VALUES ('96b4968ae4084b86a5fdecfb0fba4e99', '0', '未设置', '', '1007', '1', null, '2016-08-16 16:13:46');
INSERT INTO `sys_dict_item` VALUES ('99c34036e1ff4d5fa2e72584601fd051', '10', '博士研究生', '', '1007', '11', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('9db36f6fe18042eeb5db7b5fd8fded5a', '9', '布依族', 'Bouyei ethnic minority', '1006', '9', null, '2016-05-20 14:00:29');
INSERT INTO `sys_dict_item` VALUES ('9e460e709f2e45e3ad352083406da506', '8', '大学本科', '', '1007', '9', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('9f340ba174904491be9c66e87e10e5fd', '23', '高山族', 'Gaoshan ethnic minority', '1006', '23', null, '2016-05-20 14:12:50');
INSERT INTO `sys_dict_item` VALUES ('9f76ea078ad54b40a3b58221b6208fe1', '34', '布朗族', 'Blang ethnic minority', '1006', '34', null, '2016-05-20 14:19:42');
INSERT INTO `sys_dict_item` VALUES ('a0d06e73c014454591440c4b9a238a44', '06', '白领职员', '白领职员', '1022', '6', null, '2016-06-29 18:41:56');
INSERT INTO `sys_dict_item` VALUES ('a328b0cb1b584f0d9663b73210a11b71', '53', '赫哲族', 'Hezhe ethnic minority', '1006', '53', null, '2016-05-20 14:37:17');
INSERT INTO `sys_dict_item` VALUES ('a5cbcfa6d6d64446a08f78e7e8bafffb', '00', '管理员', '人事系统管理员', '1003', '1', null, '2016-10-31 16:41:50');
INSERT INTO `sys_dict_item` VALUES ('af5efe140b194c5185d96e92f9f0ce2f', '26', '东乡族', 'Dongxiang ethnic minority', '1006', '26', null, '2016-05-20 14:15:03');
INSERT INTO `sys_dict_item` VALUES ('b238a6fb8bbf46e1ac0de4256965f657', '45', '鄂温克族', 'Ewenki ethnic minority', '1006', '45', null, '2016-05-20 14:30:31');
INSERT INTO `sys_dict_item` VALUES ('b24d894c21c74cbb882a52fb7625a554', '2', '蒙古族', 'Mongolian ethnic minority', '1006', '2', null, '2016-05-20 13:50:58');
INSERT INTO `sys_dict_item` VALUES ('b831670de10e47328b07ab88f41746a2', '0', '其他', '其他', '1023', null, null, '2016-09-19 10:21:26');
INSERT INTO `sys_dict_item` VALUES ('bae42d377852497c83f9a2d10158962c', '3', '离异', '离异', '1023', null, null, '2016-07-08 15:58:29');
INSERT INTO `sys_dict_item` VALUES ('befe6ae25c854a1aacb7aaabc8c32063', '48', '裕固族', 'Yugur ethnic minority', '1006', '48', null, '2016-05-20 14:34:01');
INSERT INTO `sys_dict_item` VALUES ('c362d1280a8b49bbaae77e651cbc05f3', '51', '独龙族', 'Drung ethnic minority', '1006', '51', null, '2016-05-20 14:36:15');
INSERT INTO `sys_dict_item` VALUES ('c3fb9685d58e45ccad00727445a2678b', '22', '畲族', 'She ethnic minority', '1006', '22', null, '2016-05-20 14:12:04');
INSERT INTO `sys_dict_item` VALUES ('c725f90867fd46268096c3566e6ad79d', '50', '塔塔尔族', 'Tartar ethnic minority', '1006', '50', null, '2016-05-20 14:35:07');
INSERT INTO `sys_dict_item` VALUES ('cc952454722a40818d27156a11d4b7b7', '46', '崩龙族', 'Deang ethnicity minority', '1006', '46', null, '2016-05-20 14:44:25');
INSERT INTO `sys_dict_item` VALUES ('d1fd07f6a9f24b3a85f1737b82887ae2', '30', '土族', 'Tu ethnic minority', '1006', '30', null, '2016-05-20 14:17:38');
INSERT INTO `sys_dict_item` VALUES ('d84078f055764b5e99a50316aa43ff11', '40', '普米族', 'Pumi ethnic minority', '1006', '40', null, '2016-05-20 14:26:20');
INSERT INTO `sys_dict_item` VALUES ('dee3d017de564020935e4022d1451630', '24', '拉祜族', 'Lahu ethnic minority', '1006', '24', null, '2016-05-20 14:13:34');
INSERT INTO `sys_dict_item` VALUES ('dfa1c1a2e0d24b75a511e0de0e585ad2', '04', '政府要员', '政府要员', '1022', '4', null, '2016-06-29 18:41:25');
INSERT INTO `sys_dict_item` VALUES ('e27eac079fb8424a9b946211b1e76e6a', '14', '白族', 'Bai ethnic minority', '1006', '14', null, '2016-05-20 14:05:45');
INSERT INTO `sys_dict_item` VALUES ('e3eeb07156f147b3bd4bd2f05d0aac24', '31', '达斡尔族', 'Daur ethnic minority', '1006', '31', null, '2016-05-20 14:18:08');
INSERT INTO `sys_dict_item` VALUES ('e5119cca0b604ac3812edd84f79b4203', '1', '身份证', '身份证 ', '1017', '1', null, '2016-06-20 14:28:32');
INSERT INTO `sys_dict_item` VALUES ('e8637528a32d4b47bd2821f2a6cb06a8', '32', '仫佬族', 'Mulam ethnic minority', '1006', '32', null, '2016-05-20 14:18:37');
INSERT INTO `sys_dict_item` VALUES ('ea55baa38bf14fab820739f0e0582f82', '27', '纳西族', 'Naxi ethnic minority', '1006', '27', null, '2016-05-20 14:15:59');
INSERT INTO `sys_dict_item` VALUES ('eb831f8e0ec4424fa97f25adf369a87b', '54', '门巴族', 'Moinba ethnic minority', '1006', '54', null, '2016-05-20 14:37:52');
INSERT INTO `sys_dict_item` VALUES ('ec9b5abb71a74d3ba00bc52ce9936442', '03', '公司高管', '公司高管', '1022', '3', null, '2016-06-29 18:41:10');
INSERT INTO `sys_dict_item` VALUES ('f05e18d63c574b95b3250cff0b2ae99b', '3', '回族', 'Hui ethnic miniroty', '1006', '3', null, '2016-05-20 13:51:41');
INSERT INTO `sys_dict_item` VALUES ('f4243f56f4d047748f782b00eb1e5729', '9', '硕士研究生', '', '1007', '10', null, '2016-08-16 16:20:27');
INSERT INTO `sys_dict_item` VALUES ('f485753aa8944700ae280c6b9eda1f4b', '10', '朝鲜族', 'Korean ethnic minority', '1006', '10', null, '2016-05-20 14:02:19');
INSERT INTO `sys_dict_item` VALUES ('f74e9ca5bca548f7936125498a9c7f7e', '52', '鄂伦春族', 'Oroqen ethnic minority', '1006', '52', null, '2016-05-20 14:36:53');
INSERT INTO `sys_dict_item` VALUES ('f84e3ed8fd7b4096a1e3e0oo40671122', '0', '未设置', '未设置', '1006', '0', null, '2016-06-29 14:44:05');
