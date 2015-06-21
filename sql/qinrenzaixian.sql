drop database if exists qinrendb;
create database qinrendb character set UTF8;
use qinrendb;
set character set UTF8;
set character_set_results=UTF8;
set character_set_client=UTF8;
set character_set_connection=UTF8;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- version 数据库版本信息表 该表中只能存储一条记录
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
 `version` varchar(16) NOT NULL COMMENT '当前数据库脚本的版本号',
 `upgrade_time` datetime NOT NULL COMMENT '执行升级时的时间'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `version` VALUES ('1.0.0',now());


-- ----------------------------
-- cities 省、市、县表
-- ----------------------------
DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `ID` int(11) NOT NULL,
  `PARENT_ID` int(11) unsigned NOT NULL DEFAULT '0',
  `NAME` varchar(120) NOT NULL DEFAULT '' COMMENT '简体',
  `NAME_HK` varchar(120) NOT NULL DEFAULT '' COMMENT '繁体',
  `NAME_EN` varchar(120) NOT NULL DEFAULT '' COMMENT '英文',
  `NAME_PY` varchar(20) DEFAULT '' COMMENT '拼音首字母',
  `TYPE` tinyint(1) NOT NULL DEFAULT '2' COMMENT '0:国家,1:省,2:市,3区',
  `AREA` tinyint(1) DEFAULT NULL COMMENT '经济协作区 1华北2华东3华中4华南5东北6西北7西南8港澳台',
  PRIMARY KEY (`ID`),
  KEY `parent_id` (`PARENT_ID`),
  KEY `type` (`TYPE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) unsigned DEFAULT '0'  COMMENT '0 管理员,1 父母，2子女，3 好心人，4 其他',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '登录名',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别 0男，1女',
  `birthday`  datetime  NULL COMMENT '生日',
  `real_name` varchar(255) DEFAULT '' COMMENT '姓名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `picture` varchar(512) DEFAULT '' COMMENT '个人图片',
  `identity` varchar(32) DEFAULT '' COMMENT '身份证',
  `identity_pic` varchar(512) DEFAULT '' COMMENT '身份证图片',
  `email` varchar(64) DEFAULT '' COMMENT '电子邮箱',
  `mobile` varchar(64) DEFAULT '' COMMENT '手机',
  `telephone` varchar(64) DEFAULT '' COMMENT '座机',
  `qq` varchar(64) DEFAULT '' COMMENT 'qq',
  `weixin` varchar(64) DEFAULT '' COMMENT '微信号',
  `weibo` varchar(64) DEFAULT '' COMMENT '微博',
  `address`  int(11) COMMENT '联系地址',
  `login_times` int(11) default 0 COMMENT '用户登录次数',
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(255)  NULL COMMENT '最后登录IP',
  `create_ip` varchar(255)  NULL COMMENT '创建IP',
  `createtime` datetime  NULL COMMENT '创建时间',
  `creater` int(11)  NULL COMMENT '创建人',
  `update_ip` varchar(255)  NULL COMMENT '修改IP',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_lid` (`name`),
  KEY `email` (`email`),
  KEY `mobile` (`mobile`),
  KEY `qq` (`qq`),
  KEY `weixin` (`weixin`),
  KEY `weibo` (`weibo`),
  KEY `identity` (`identity`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户表';



-- ----------------------------
-- addresses 地址表
-- ----------------------------
DROP TABLE IF EXISTS `addresses`;
CREATE TABLE `addresses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `country_id` int(11) NOT NULL COMMENT '国家',
  `province_id` int(11) NOT NULL COMMENT '省',
  `city_id` int(11) NOT NULL COMMENT '市',
  `district_id` int(11) NOT NULL COMMENT '区县',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `zone` varchar(20) DEFAULT NULL COMMENT '区号',
  `phone_number` varchar(100) DEFAULT NULL COMMENT '电话号',
  `ext_number` varchar(20) DEFAULT NULL COMMENT '分机号',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
   PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8 COMMENT='地址表';


-- ----------------------------
-- softtip 用户欢迎语
-- ----------------------------
DROP TABLE IF EXISTS `softtip`;
CREATE TABLE `softtip` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(11) NOT NULL COMMENT '类型 1 父母寻子，2 子寻父母 ，3 好人线索',
  `content` varchar(1024) NOT NULL COMMENT '提示内容',
  `sort` tinyint(4) DEFAULT '0'  COMMENT '排序号',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
   PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8 COMMENT='用户欢迎语';

-- ----------------------------
-- pictrue 图片表
-- ----------------------------
DROP TABLE IF EXISTS `pictrue`;
CREATE TABLE `pictrue` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `path` tinyint(11) NOT NULL COMMENT '类型 1 父母寻子，2 子寻父母 ，3 好人线索',
  `sort` tinyint(4) DEFAULT '0'  COMMENT '排序号',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
   PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8 COMMENT='图片表';


-- ----------------------------
-- user 联系人表
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '联系人名',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 0男，1女',
  `birthday` varchar(32) DEFAULT '' COMMENT '生日',
  `picture` varchar(512) DEFAULT '' COMMENT '个人图片',
  `identity` varchar(32) DEFAULT '' COMMENT '身份证',
  `identity_pic` varchar(512) DEFAULT '' COMMENT '身份证图片',
  `email` varchar(64) DEFAULT '' COMMENT '电子邮箱',
  `mobile` varchar(64) DEFAULT '' COMMENT '手机',
  `telephone` varchar(64) DEFAULT '' COMMENT '座机',
  `qq` varchar(64) DEFAULT '' COMMENT 'qq',
  `weixin` varchar(64) DEFAULT '' COMMENT '微信号',
  `weibo` varchar(64) DEFAULT '' COMMENT '微博',
  `address` int(11) COMMENT '地址',
  `user_id` int(11) NOT NULL COMMENT '用户ID ',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_lid` (`name`),
  KEY `email` (`email`),
  KEY `mobile` (`mobile`),
  KEY `qq` (`qq`),
  KEY `weixin` (`weixin`),
  KEY `weibo` (`weibo`),
  KEY `identity` (`identity`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- publicmessage 发布信息表
-- ----------------------------
DROP TABLE IF EXISTS `publicmessage`;
CREATE TABLE `publicmessage` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` tinyint(11) NOT NULL COMMENT '类型 1 父母寻子，2 子寻父母 ，3 好人线索',
  `parent_id` int(11) unsigned NOT NULL COMMENT '发表信息父消息',
  `happen_addr`  int(11)  NOT NULL COMMENT '失散地点 丢失地点 发现地点 ',
  `description` varchar(2048) NOT NULL COMMENT '特征描述',
  `remark` varchar(1024)  NULL COMMENT '备注',
  `sort` int(11) DEFAULT '0'  COMMENT '排序号',
  `contract_id`  int(11) NOT NULL COMMENT '联系人ID',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `creater` int(11) NOT NULL COMMENT '创建人',
  `updatetime` datetime  NULL COMMENT '修改时间',
  `updater` int(11)  NULL COMMENT '修改人',
  `delflag` tinyint(1) DEFAULT '0'  COMMENT '删除标志0 可用，1 删除',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
   PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COMMENT='发布信息表';

