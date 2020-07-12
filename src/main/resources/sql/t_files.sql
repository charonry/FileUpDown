/*
Navicat MySQL Data Transfer

Source Server         : localMysq
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : fileupdown

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-07-12 21:37:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_files`
-- ----------------------------
DROP TABLE IF EXISTS `t_files`;
CREATE TABLE `t_files` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `oldFileName` varchar(200) DEFAULT NULL,
  `newFileName` varchar(200) DEFAULT NULL,
  `ext` varchar(20) DEFAULT NULL,
  `path` varchar(300) DEFAULT NULL,
  `size` varchar(200) DEFAULT NULL,
  `type` varchar(120) DEFAULT NULL,
  `isImg` varchar(8) DEFAULT NULL,
  `downcounts` int(6) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_t_user` (`userId`),
  CONSTRAINT `fk_t_user` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_files
-- ----------------------------
INSERT INTO `t_files` VALUES ('9', '邮箱设置图片.png', '2020071221a6f1ea.png', '.png', 'files/2020-07-12', '44989', 'image/png', '是', '1', '2020-07-12 13:18:05', '1');
INSERT INTO `t_files` VALUES ('10', '页面设计.xls', '202007122120808d.xls', '.xls', 'files/2020-07-12', '196608', 'application/vnd.ms-excel', '否', '0', '2020-07-12 13:18:10', '1');
