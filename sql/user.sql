/*
Navicat MySQL Data Transfer

Source Server         : b_plus_db
Source Server Version : 50541
Source Host           : 192.168.0.234:3306
Source Database       : user_center

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-05-24 21:53:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `zhaoid` int(11) unsigned DEFAULT NULL,
  `type` tinyint(4) unsigned DEFAULT '0',
  `group` tinyint(4) DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '登录名',
  `real_name` varchar(255) DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `pay_password` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT '' COMMENT '身份证',
  `email` varchar(255) DEFAULT '',
  `mobile` varchar(64) DEFAULT '',
  `qq` varchar(64) DEFAULT '',
  `weixin` varchar(64) DEFAULT '',
  `weibo` varchar(64) DEFAULT '',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态(0可用, 1禁用)',
  `checklist` bigint(20) DEFAULT '0',
  `modified` timestamp NULL DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_lid` (`name`),
  KEY `email` (`email`),
  KEY `mobile` (`mobile`),
  KEY `qq` (`qq`),
  KEY `weixin` (`weixin`),
  KEY `weibo` (`weibo`),
  KEY `identity` (`identity`)
) ENGINE=MyISAM AUTO_INCREMENT=8039169 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';
