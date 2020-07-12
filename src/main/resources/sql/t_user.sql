/*
Navicat MySQL Data Transfer

Source Server         : localMysq
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : fileupdown

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-07-12 21:37:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'ISMvKXpXpadDiUoOSoAfww==');
INSERT INTO `t_user` VALUES ('2', 'charon', 'ISMvKXpXpadDiUoOSoAfww==');
