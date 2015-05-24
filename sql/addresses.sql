/*
Navicat MySQL Data Transfer

Source Server         : b_plus_db
Source Server Version : 50541
Source Host           : 192.168.0.234:3306
Source Database       : b_plus_db2

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-05-24 22:08:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addresses
-- ----------------------------
DROP TABLE IF EXISTS `addresses`;
CREATE TABLE `addresses` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL COMMENT '用户id',
  `COUNTRY_ID` int(11) NOT NULL,
  `PROVINCE_ID` int(11) NOT NULL,
  `CITY_ID` int(11) NOT NULL,
  `DISTRICT_ID` int(11) NOT NULL COMMENT '区县',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `ZIP_CODE` varchar(20) DEFAULT NULL COMMENT '邮编',
  `CONTACT` varchar(255) DEFAULT NULL COMMENT '联系人',
  `MOBILE_PHONE` varchar(100) DEFAULT NULL COMMENT '手机号',
  `ZONE` varchar(20) DEFAULT NULL COMMENT '区号',
  `PHONE_NUMBER` varchar(100) DEFAULT NULL COMMENT '电话号',
  `EXT_NUMBER` varchar(20) DEFAULT NULL COMMENT '分机号',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `STATUS` char(1) NOT NULL,
  `TYPE` char(1) DEFAULT NULL,
  `CREATED_AT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATED_AT` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8 COMMENT='地址表';
