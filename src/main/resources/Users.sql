/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : directories

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-11-22 10:19:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `Sex` varchar(255) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '赵振伟', '男', '27', '13237155807', '上海市徐汇区');
INSERT INTO `users` VALUES ('3', '用户1', '男', '18', '15003943003', '上海市松江区');
INSERT INTO `users` VALUES ('4', '用户2', null, '0', null, null);
INSERT INTO `users` VALUES ('5', '用户3', null, '0', null, null);
INSERT INTO `users` VALUES ('6', '用户4', null, '0', null, null);
INSERT INTO `users` VALUES ('7', '用户5', null, '0', null, null);
INSERT INTO `users` VALUES ('8', '用户6', null, '0', null, null);
INSERT INTO `users` VALUES ('9', '用户7', null, '0', null, null);
INSERT INTO `users` VALUES ('10', '用户8', null, '0', null, null);
INSERT INTO `users` VALUES ('11', '用户9', null, '0', null, null);
INSERT INTO `users` VALUES ('12', '用户10', null, '0', null, null);
