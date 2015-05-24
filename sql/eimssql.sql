drop database if exists eimsdb;
create database eimsdb character set UTF8;
use eimsdb;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `version` VALUES ('1.0.19',now());
-- SET FOREIGN_KEY_CHECKS=1;

-- ----------------------------
-- cookies 用户输入框使用记录
-- ----------------------------
DROP TABLE IF EXISTS `cookies`;
CREATE TABLE `cookies` (
	`id` bigint(20) NOT NULL auto_increment COMMENT '主关键字',
	`createuserid` int(11) COMMENT '创建用户ID',
	`uuid` char(32) NOT NULL COMMENT '客户唯一标识',
	`name` varchar(64) NOT NULL COMMENT '使用对象的名称',
	`content` varchar(1024) NOT NULL COMMENT '使用对象的内容',
	`createtime` date NOT NULL COMMENT '创建时间',
	`lastvisittime` date default NULL COMMENT '最后一次访问时间',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create index cookies_uuid_name on cookies(`uuid`,`name`);
create index cookies_createtime on cookies(`createtime`);
create index cookies_lastvisittime on cookies(`lastvisittime`);
-- ----------------------------
-- cookies 用户输入框使用记录
-- ----------------------------

-- ----------------------------
-- Table structure for `logs`
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT 'ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `fullname` varchar(64) NOT NULL COMMENT '用户真实姓名',
  `object_type` int(11) NOT NULL COMMENT '日志类型',
  `description` text NOT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------

-- ----------------------------
-- Table structure for `userrole`
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` int(11) NOT NULL auto_increment COMMENT 'ID',
  `name` varchar(128) NOT NULL COMMENT '角色名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `userrole` VALUES ('1','超级管理员');
INSERT INTO `userrole` VALUES ('2','系统管理员');
INSERT INTO `userrole` VALUES ('3','操作员');


-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(128) NOT NULL COMMENT '用户名',
  `realname` varchar(128) NULL COMMENT '真实姓名',
  `pwd` varchar(128) NOT NULL COMMENT '密码',
  `login_times` int(11) default 0 COMMENT '用户登录次数',
  `create_time`  datetime default NULL COMMENT '创建时间',
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `used` int default 1 COMMENT '是否可用  1 可用 2 不可用',
  PRIMARY KEY  (`id`),
  unique key `unique_index_name` (`name`), 
  key `index_name_pwd` (`name`,`pwd`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `users` VALUES ('1', 'root' , 'root', '123456', 0, now() , null , 1 );

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) default 0 COMMENT '用户ID',
  `role_id` int(11) default 0 COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `userrole`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into  `user_role` values(1 , 1);
-- ----------------------------
-- Table structure for `competence`
-- ----------------------------
DROP TABLE IF EXISTS `competence`;
CREATE TABLE `competence` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(128)default NULL COMMENT '名称',
  `type`varchar(128)default NULL COMMENT '类型',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `competence` values(1 , '车辆监控', '1');
insert into `competence` values(2 , '车辆管理', '1');
insert into `competence` values(3 , '用户日志', '1');
insert into `competence` values(4 , '配置管理', '1');
insert into `competence` values(5 , '通行记录', '1');
insert into `competence` values(6 , '车辆统计', '1');
insert into `competence` values(7 , '录像管理', '1');
-- ----------------------------
-- Table structure for `role_competence`
-- ----------------------------
DROP TABLE IF EXISTS `role_competence`;
CREATE TABLE `role_competence` (
  `role_id` int(11) default 0 COMMENT '角色ID',
  `competence_id` int(11) default 0 COMMENT '权限ID',
   PRIMARY KEY (`competence_id`,`role_id`),
  CONSTRAINT `fk_rc_role_id` FOREIGN KEY (`role_id`) REFERENCES `userrole`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `role_competence` value(1, 1);
insert into `role_competence` value(1, 2);
insert into `role_competence` value(1, 3);
insert into `role_competence` value(1, 4);
insert into `role_competence` value(1, 5);
insert into `role_competence` value(1, 6);
insert into `role_competence` value(1, 7);
insert into `role_competence` value(2, 1);
insert into `role_competence` value(2, 2);
insert into `role_competence` value(2, 3);
insert into `role_competence` value(3, 1);
-- ----------------------------
-- version 数据库版本信息表 该表中只能存储一条记录
-- ----------------------------
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties` (
  `key` varchar(32) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY  (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into properties(`key`,`value`) values('key_ivm_wsdl','http://127.0.0.1:9999');
insert into properties(`key`,`value`) values('default_entry_count','4');
insert into properties(`key`,`value`) values('eims_title','出入口智能管理系统');
insert into properties(`key`,`value`) values('video_pre_stattime',15);
insert into properties(`key`,`value`) values('video_pre_endtime',15);
insert into properties(`key`,`value`) values('traffic_lights',0);
insert into properties(`key`,`value`) values('traffic_lights_delay_time',5000);
-- ----------------------------
-- Table structure for `ivm 上报vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `ivm_vehicle`;
CREATE TABLE `ivm_vehicle` (
  `id` int(11) NOT NULL auto_increment,
  `vehicle_id` varchar(128)  COMMENT '车辆信息编号',
  `point_name` varchar(128)  COMMENT '卡口名称',
  `point_id` int(11)  COMMENT '卡口编号',
  `device_id` varchar(128)  COMMENT '设备编号',
  `through_time`  datetime default NULL COMMENT '经过时间yyyy-mm-dd hh:mm:ss.fff',
  `lanenum` varchar(128)  COMMENT '车道编号（包括名称）',
  `direction` int  COMMENT '行驶方向',
  `direction_name` varchar(128)  COMMENT '方向名称',
  `frontplatenum` varchar(128)  COMMENT '车头车牌号码',
  `frontplatecolor` varchar(128)  COMMENT '车头车牌颜色',
  `imgcount` int(11) default 0 COMMENT '图像数量',
  `vehicle_speed` varchar(128)  COMMENT '车辆速度',
  `vehicle_speed_limit` varchar(128)  COMMENT '限速值',
  `state` varchar(2)  COMMENT '行驶状态',
  `vehicle_brand` varchar(128)  COMMENT '车辆品牌',
  `vehicle_colour` varchar(128)  COMMENT '车身颜色',
  `colour_depth` varchar(128)  COMMENT '颜色深浅',
  `vehicle_type` varchar(128)  COMMENT '车辆类型',
  `vehicle_plate_type` varchar(128)  COMMENT '车牌类型',
  `vehicle_length` varchar(128)  COMMENT '车外廓长度',
  `workmode` varchar(1)  COMMENT '0-普通抓拍，1-前后抓拍，2-其他',
  `photo_type` varchar(128)  COMMENT '0x01-前车牌 0x02-后车牌 0x12-合成后车牌',
  `throught_timemsec` bigint default 0 COMMENT '抓拍时间，毫秒数',
  `bigimg_timemsec` bigint default 0  COMMENT '图片抓拍的时间,毫秒数',
  `plate_coordinate` varchar(128)  COMMENT '车牌坐标',
  `status` int   default NULL COMMENT '车辆检测状态',
  `statusdes` varchar(64) default NULL   COMMENT '车辆检测状态描述',
  `eims_through_time` datetime default NULL   COMMENT '经过时间yyyy-mm-dd hh:mm:ss.fff',
  `shows` int default 1   COMMENT '是否显示 1：显示， 2不显示',
  `vehicle_status` int default 1   COMMENT '车辆状态 1：零时车辆， 2布控车辆 ，3固定车辆',
  `video_device_id` int(11) default NULL COMMENT '关联设备ID',
   PRIMARY KEY  (`id`),
   key `index_frontplatecolor` (`frontplatecolor`),
   key `index_vehicle_colour` (`vehicle_colour`),
   key `index_direction` (`direction`),
   key `index_eims_through_time` (`eims_through_time`),
   key `index_eims_through_time_point_id` (`eims_through_time`,`point_id`),
   key `index_vehicle_status` (`vehicle_status`),
   key `index_status` (`status`),
   key `index_frontplatenum_point_id` (`frontplatenum` ,`point_id`),
   CONSTRAINT `fk_point_id` FOREIGN KEY (`point_id`) REFERENCES `vehiclelane`(`id`),
   CONSTRAINT `fk_video_device_id` FOREIGN KEY (`video_device_id`) REFERENCES `video_device`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(128) COMMENT '图片类型',
  `path` varchar(128)  COMMENT '图片路径',
  `v_id` int(11) COMMENT '车辆编号',
   PRIMARY KEY  (`id`),
   CONSTRAINT `fk_image_vehicle_id` FOREIGN KEY (`v_id`) REFERENCES `ivm_vehicle`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `vehicle_types`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_types`;
CREATE TABLE `vehicle_types` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(128) NOT NULL COMMENT '汽车类型编码',
  `name` varchar(128) COMMENT '类型名称',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `vehicle_types` (id, code, name) values(1, '50000', '未识别');
insert into `vehicle_types` (id, code, name) values(2, '50001', '小型车');
insert into `vehicle_types` (id, code, name) values(3, '50002', '大型车');
insert into `vehicle_types` (id, code, name) values(4, '50003', '中型车');
insert into `vehicle_types` (id, code, name) values(5, '50004', '摩托车');
insert into `vehicle_types` (id, code, name) values(6, '50005', '行人');
insert into `vehicle_types` (id, code, name) values(7, '50006', '非机动车');

-- ----------------------------
-- Table structure for `颜色表colors	`
-- ----------------------------
DROP TABLE IF EXISTS `colors`;
CREATE TABLE `colors` (
  `id` int(11) NOT NULL auto_increment,
  `colortype` int(11) NOT NULL COMMENT '颜色类型',
  `code` varchar(128) NOT NULL COMMENT '颜色编码',
  `des` varchar(16) NOT NULL COMMENT '描述（如：白色）',
  `rgb`  varchar(16) NOT NULL COMMENT 'RGB格式颜色数据(如白色:FFFFFF)',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `colors` (id, colortype, code, des, rgb ) values(1, 1, '40001', '黑牌', '000000');
insert into `colors` (id, colortype, code, des, rgb ) values(2, 1, '40002', '蓝牌', '0000FF');
insert into `colors` (id, colortype, code, des, rgb ) values(3, 1, '40003', '白牌', 'FFFFFF');
insert into `colors` (id, colortype, code, des, rgb ) values(4, 1, '40004', '黄牌', 'FFFF00');
insert into `colors` (id, colortype, code, des, rgb ) values(5, 1, '40005', '绿牌', '00CD00');
insert into `colors` (id, colortype, code, des, rgb ) values(6, 2, '60001', '白色', 'FFFFFF');
insert into `colors` (id, colortype, code, des, rgb ) values(7, 2, '60009', '灰色', '8A8A8A');
insert into `colors` (id, colortype, code, des, rgb ) values(8, 2, '60003', '黄色', 'FFFF00');
insert into `colors` (id, colortype, code, des, rgb ) values(9, 2, '60004', '粉色', 'FF82AB');
insert into `colors` (id, colortype, code, des, rgb ) values(10, 2, '60005', '红色', 'FF0000');
insert into `colors` (id, colortype, code, des, rgb ) values(11, 2, '60010', '紫色', 'B23AEE');
insert into `colors` (id, colortype, code, des, rgb ) values(12, 2, '60006', '绿色', '00CD00');
insert into `colors` (id, colortype, code, des, rgb ) values(13, 2, '60007', '蓝色', '0000FF');
insert into `colors` (id, colortype, code, des, rgb ) values(14, 2, '60008', '棕色', '8B2500');
insert into `colors` (id, colortype, code, des, rgb ) values(15, 2, '60002', '黑色', '000000');
insert into `colors` (id, colortype, code, des, rgb ) values(16, 2, '60000', '其他', 'other');
insert into `colors` (id, colortype, code, des, rgb ) values(17, 1, '40000', '未识别','000000');

-- ----------------------------
-- Table structure for `布控原因controltype`
-- ----------------------------
DROP TABLE IF EXISTS `controltype`;
CREATE TABLE `controltype` (
  `id` int(11) NOT NULL auto_increment,
  `des` varchar(32) NOT NULL COMMENT '描述(如：黑名单)',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `controltype` (id, des) values(1, '黑名单');
insert into `controltype` (id, des) values(2, '欠费未缴');
insert into `controltype` (id, des) values(3, '作案嫌疑人');
insert into `controltype` (id, des) values(4, '限制次数');

-- ----------------------------
-- Table structure for `布控优先级controlpriority	`
-- ----------------------------
DROP TABLE IF EXISTS `controlpriority`;
CREATE TABLE `controlpriority` (
  `id` int(11) NOT NULL auto_increment,
  `des` varchar(32) NOT NULL COMMENT '描述',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `controlpriority` (id, des) values(1, '布控优先级低');
insert into `controlpriority` (id, des) values(2, '布控优先级中');
insert into `controlpriority` (id, des) values(3, '布控优先级高');


-- ----------------------------
-- Table structure for `报警联系方式alarmtype`
-- ----------------------------
DROP TABLE IF EXISTS `alarmtype`;
CREATE TABLE `alarmtype` (
  `id` int(11) NOT NULL auto_increment,
 `des` varchar(32) NOT NULL COMMENT '描述(如：低级、中级、高级)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- insert into `alarmtype` (id, des) values(1, '报警联系方式1');
-- insert into `alarmtype` (id, des) values(2, '报警联系方式2');
-- insert into `alarmtype` (id, des) values(3, '报警联系方式3');
-- insert into `alarmtype` (id, des) values(4, '报警联系方式4');
-- insert into `alarmtype` (id, des) values(5, '报警联系方式5');


-- ----------------------------
-- Table structure for `车辆布控vcontrol`
-- ----------------------------
DROP TABLE IF EXISTS `vcontrol`;
CREATE TABLE `vcontrol`(
  `id` int(11) NOT NULL auto_increment,
  `creater` int(11) NOT NULL COMMENT '创建人id(外键)',
  `starttime` datetime NOT NULL COMMENT '开始时间',
  `endtime`  datetime NOT NULL COMMENT '结束时间',
  `reasontype`  int(11) NOT NULL COMMENT '布控原因id',
  `priority`  int(11) NULL COMMENT '布控级别id',
  `linkman` varchar(128) DEFAULT NULL COMMENT '联系人',
  `linknum` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `alarmtype`  int(11) NULL COMMENT '报警联方式id',
  `department` varchar(256) DEFAULT NULL  COMMENT '布控单位',
  `countin` int(11) COMMENT '入口车辆布控次数限制',
  `countout` int(11) COMMENT '出口车辆布控次数限制',
  `des` varchar(256) DEFAULT NULL COMMENT '描述',
   PRIMARY KEY  (`id`),
   CONSTRAINT `fk_vcontrol_creater` FOREIGN KEY (`creater`) REFERENCES `users`(`id`),
   CONSTRAINT `fk_vcontrol_reasontype` FOREIGN KEY (`reasontype`) REFERENCES `controltype`(`id`),
   CONSTRAINT `fk_vcontrol_priority` FOREIGN KEY (`priority`) REFERENCES `controlpriority`(`id`),
   CONSTRAINT `fk_vcontrol_alarmtype` FOREIGN KEY (`alarmtype`) REFERENCES `alarmtype`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `车主表owners`
-- ----------------------------
DROP TABLE IF EXISTS `owners`;
CREATE TABLE `owners` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(128) COMMENT '姓名',
  `nationality` varchar(128) COMMENT '国籍',
  `sex` varchar(2)  COMMENT '性别',
  `birthday` datetime COMMENT '出生日期',
  `phonenum` varchar(128) COMMENT '电话号码',
  `address` varchar(128) COMMENT '住址',
  `email` varchar(128) COMMENT '电子邮箱',
  `photo` varchar(128) COMMENT '照片',
  `identifynum` varchar(128) COMMENT '证件号码',
   PRIMARY KEY  (`id`),
   key `index_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `车辆表vehicles`
-- ----------------------------
DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL auto_increment,
  `creater` int(11)  default NULL COMMENT '创建人id',
  `owner` int(11)  default NULL COMMENT '车主id',
  `control` int(11)  default NULL COMMENT '布控id外键，如果没有布控，则为null',
  `num` varchar(128)  NOT NULL COMMENT '车牌号',
  `type` int(11) NULL  COMMENT '车辆类型id',
  `brand` varchar(128) DEFAULT NULL COMMENT '品牌',
  `bcolor` int(11) NULL COMMENT '车身颜色',
  `lcolor` int(11) NULL COMMENT '车牌颜色',
  `regitime` datetime  NOT NULL COMMENT '注册时间',
  `effective_starttime` datetime  default NULL COMMENT '有效开始时间',
  `effective_endtime` datetime  default NULL COMMENT '有效结束时间',
  `des` varchar(255) COMMENT '备注',
   PRIMARY KEY  (`id`),
   UNIQUE KEY `index_vehicles_num` (`num`),
   CONSTRAINT `fk_vehicle_creater` FOREIGN KEY (`creater`) REFERENCES `users`(`id`),
   CONSTRAINT `fk_vehicle_owner` FOREIGN KEY (`owner`) REFERENCES `owners`(`id`),
   CONSTRAINT `fk_vehicle_control` FOREIGN KEY (`control`) REFERENCES `vcontrol`(`id`),
   CONSTRAINT `fk_vehicle_type` FOREIGN KEY (`type`) REFERENCES `vehicle_types`(`id`),
   CONSTRAINT `fk_vehicle_bcolor` FOREIGN KEY (`bcolor`) REFERENCES `colors`(`id`),
   CONSTRAINT `fk_vehicle_lcolor` FOREIGN KEY (`lcolor`) REFERENCES `colors`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `devices 设备信息表`
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
  `id` int(11) NOT NULL auto_increment,
  `puid`  varchar(32)  default NULL COMMENT '设备ＩＤ(与channel组合成联合唯索引)',
  `channel` int(2)  default NULL COMMENT '设备通道号',
  `name` varchar(128)  NOT NULL COMMENT '设备名称',
   PRIMARY KEY  (`id`),
   UNIQUE KEY `index_devices_puid_channel` (`puid` , `channel`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `entries出入口信息表`
-- ----------------------------
DROP TABLE IF EXISTS `entries`;
CREATE TABLE `entries` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL COMMENT '名称（唯一索引）',
  `used` int  default 1 COMMENT '是否启用:0：不起用；1：启用',
   UNIQUE KEY `index_entries_name` (`name`),
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `entries` (id, name ) values(1 , '出入口1');
insert into `entries` (id, name ) values(2 , '出入口2');
insert into `entries` (id, name ) values(3 , '出入口3');
insert into `entries` (id, name ) values(4 , '出入口4');
insert into `entries` (id, name ) values(5 , '出入口5');
insert into `entries` (id, name ) values(6 , '出入口6');
insert into `entries` (id, name ) values(7 , '出入口7');
insert into `entries` (id, name ) values(8 , '出入口8');

-- ----------------------------
-- Table structure for `vehiclelane车道信息表`
-- ----------------------------
DROP TABLE IF EXISTS `vehiclelane`;
CREATE TABLE `vehiclelane` (
  `id` int(11) NOT NULL auto_increment,
  `deviceid`  int(11)  default NULL COMMENT '设备信息id',
  `name` varchar(255) NOT NULL COMMENT '名称（唯一索引）',
  `direction` int  default 1 COMMENT '进出方向(1入口，2出口)',
  `type` int  default 1 COMMENT '放行方式 1:手动放行；2:自动识别放行 ; 3：全部放行',
  `comfirm` int  default 1 COMMENT '是否需要人工确认，除手动放行外，需它放行方式都需要,1:不需要；2:需要',
  `priority` int  default 1 COMMENT '放行级别:1：高；２：中：３低',
  `used` int  default 0 COMMENT '是否启用:0：不起用；1：启用	',
  `barrier_port` int  default null COMMENT '道闸端口：1:RS485 , 2:扩展盒 ,3 开关量',
  `barrier_port_id` int  default 1 COMMENT '道闸端口id',
  `des` text COMMENT '备注',
  `entryid` int(11) NOT NULL COMMENT '出入口信息id',
   PRIMARY KEY  (`id`),
   CONSTRAINT `fk_vehiclelane_deviceid` FOREIGN KEY (`deviceid`) REFERENCES `devices`(`id`),
   CONSTRAINT `fk_vehiclelane_entryid` FOREIGN KEY (`entryid`) REFERENCES `entries`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `vehiclelane` (id, name, entryid) values(1 , '车道1', 1);
insert into `vehiclelane` (id, name, entryid) values(2 , '车道1', 2);
insert into `vehiclelane` (id, name, entryid) values(3 , '车道1', 3);
insert into `vehiclelane` (id, name, entryid) values(4 , '车道1', 4);
insert into `vehiclelane` (id, name, entryid) values(5 , '车道1', 5);
insert into `vehiclelane` (id, name, entryid) values(6 , '车道1', 6);
insert into `vehiclelane` (id, name, entryid) values(7 , '车道1', 7);
insert into `vehiclelane` (id, name, entryid) values(8 , '车道1', 8);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(9, '车道2', 1);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(10, '车道3', 1);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(11, '车道4', 1);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(12, '车道2', 2);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(13, '车道3', 2);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(14, '车道4', 2);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(15, '车道2', 3);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(16, '车道3', 3);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(17, '车道4', 3);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(18, '车道2', 4);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(19, '车道3', 4);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(20, '车道4', 4);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(21, '车道2', 5);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(22, '车道3', 5);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(23, '车道4', 5);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(24, '车道2', 6);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(25, '车道3', 6);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(26, '车道4', 6);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(27, '车道2', 7);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(28, '车道3', 7);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(29, '车道4', 7);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(30, '车道2', 8);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(31, '车道3', 8);
INSERT INTO `vehiclelane` (id, name, entryid) VALUES(32, '车道4', 8);

-- ----------------------------
-- Table structure for ` LED信息表`
-- ----------------------------
DROP TABLE IF EXISTS `les`;
CREATE TABLE `les` (
  `id` int(11) NOT NULL auto_increment,
  `usings` int(1)  default 0 COMMENT '是否启用1:NO；２：YES',
  `showtip` int(1)  default NULL COMMENT '是否显示提示信息1:NO；２：YES',
  `showtime` int(1)  default NULL COMMENT '是否显示时间1:NO；２：YES',
  `timeformat` varchar(16)  default NULL COMMENT '时间格式',
  `showlicense` int(1)  default NULL  COMMENT '是否显示车牌1:NO；２：YES',
  `showmsg` int(1) DEFAULT NULL COMMENT '是否显示欢迎信息1:NO；２：YES',
  `msg` text  DEFAULT NULL COMMENT '欢迎信息',
  `ip` varchar(32)  DEFAULT NULL COMMENT 'IP地址',
  `port` int  DEFAULT NULL COMMENT '端口',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `les` values(1, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(2, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(3, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(4, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(5, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(6, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(7, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(8, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(9, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(10, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(11, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(12, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(13, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(14, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(15, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
insert into `les` values(16, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(17, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(18, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(19, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(20, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(21, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(22, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(23, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(24, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(25, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(26, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(27, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(28, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(29, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(30, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(31, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(32, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(33, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(34, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(35, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(36, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(37, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(38, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(39, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(40, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(41, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(42, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(43, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(44, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(45, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(46, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(47, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(48, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(49, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(50, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(51, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(52, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(53, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(54, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(55, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(56, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(57, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(58, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(59, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(60, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(61, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(62, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(63, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
INSERT INTO `les` VALUES(64, 1 ,1 , 1, 'yyyy-MM-dd MM:dd:ss' , 1 , 1 , null, null , null);
-- ----------------------------
-- Table structure for `vehiclelane_led 车道LED关联表`
-- ----------------------------
DROP TABLE IF EXISTS `vehiclelane_led`;
CREATE TABLE `vehiclelane_led` (
  `vehiclelaneid` int(11) default NULL COMMENT '车道信息表id(外键)',
  `ledid`  int(11) default NULL COMMENT 'LED信息表id(外键)',
   PRIMARY KEY  (`vehiclelaneid` , `ledid` ),
   CONSTRAINT `fk_vehiclelane_id` FOREIGN KEY (`vehiclelaneid`) REFERENCES `vehiclelane`(`id`),
   CONSTRAINT `fk_vehiclelane_led_id` FOREIGN KEY (`ledid`) REFERENCES `les`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `vehiclelane_led` values(1 ,1);
insert into `vehiclelane_led` values(1 ,2);
insert into `vehiclelane_led` values(2 ,3);
insert into `vehiclelane_led` values(2 ,4);
insert into `vehiclelane_led` values(3 ,5);
insert into `vehiclelane_led` values(3 ,6);
insert into `vehiclelane_led` values(4 ,7);
insert into `vehiclelane_led` values(4 ,8);
insert into `vehiclelane_led` values(5 ,9);
insert into `vehiclelane_led` values(5 ,10);
insert into `vehiclelane_led` values(6 ,11);
insert into `vehiclelane_led` values(6 ,12);
insert into `vehiclelane_led` values(7 ,13);
insert into `vehiclelane_led` values(7 ,14);
insert into `vehiclelane_led` values(8 ,15);
insert into `vehiclelane_led` values(8 ,16);
INSERT INTO `vehiclelane_led` VALUES(9, 17);
INSERT INTO `vehiclelane_led` VALUES(9, 18);
INSERT INTO `vehiclelane_led` VALUES(10, 19);
INSERT INTO `vehiclelane_led` VALUES(10, 20);
INSERT INTO `vehiclelane_led` VALUES(11, 21);
INSERT INTO `vehiclelane_led` VALUES(11, 22);
INSERT INTO `vehiclelane_led` VALUES(12, 23);
INSERT INTO `vehiclelane_led` VALUES(12, 24);
INSERT INTO `vehiclelane_led` VALUES(13, 25);
INSERT INTO `vehiclelane_led` VALUES(13, 26);
INSERT INTO `vehiclelane_led` VALUES(14, 27);
INSERT INTO `vehiclelane_led` VALUES(14, 28);
INSERT INTO `vehiclelane_led` VALUES(15, 29);
INSERT INTO `vehiclelane_led` VALUES(15, 30);
INSERT INTO `vehiclelane_led` VALUES(16, 31);
INSERT INTO `vehiclelane_led` VALUES(16, 32);
INSERT INTO `vehiclelane_led` VALUES(17, 33);
INSERT INTO `vehiclelane_led` VALUES(17, 34);
INSERT INTO `vehiclelane_led` VALUES(18, 35);
INSERT INTO `vehiclelane_led` VALUES(18, 36);
INSERT INTO `vehiclelane_led` VALUES(19, 37);
INSERT INTO `vehiclelane_led` VALUES(19, 38);
INSERT INTO `vehiclelane_led` VALUES(20, 39);
INSERT INTO `vehiclelane_led` VALUES(20, 40);
INSERT INTO `vehiclelane_led` VALUES(21, 41);
INSERT INTO `vehiclelane_led` VALUES(21, 42);
INSERT INTO `vehiclelane_led` VALUES(22, 43);
INSERT INTO `vehiclelane_led` VALUES(22, 44);
INSERT INTO `vehiclelane_led` VALUES(23, 45);
INSERT INTO `vehiclelane_led` VALUES(23, 46);
INSERT INTO `vehiclelane_led` VALUES(24, 47);
INSERT INTO `vehiclelane_led` VALUES(24, 48);
INSERT INTO `vehiclelane_led` VALUES(25, 49);
INSERT INTO `vehiclelane_led` VALUES(25, 50);
INSERT INTO `vehiclelane_led` VALUES(26, 51);
INSERT INTO `vehiclelane_led` VALUES(26, 52);
INSERT INTO `vehiclelane_led` VALUES(27, 53);
INSERT INTO `vehiclelane_led` VALUES(27, 54);
INSERT INTO `vehiclelane_led` VALUES(28, 55);
INSERT INTO `vehiclelane_led` VALUES(28, 56);
INSERT INTO `vehiclelane_led` VALUES(29, 57);
INSERT INTO `vehiclelane_led` VALUES(29, 58);
INSERT INTO `vehiclelane_led` VALUES(30, 59);
INSERT INTO `vehiclelane_led` VALUES(30, 60);
INSERT INTO `vehiclelane_led` VALUES(31, 61);
INSERT INTO `vehiclelane_led` VALUES(31, 62);
INSERT INTO `vehiclelane_led` VALUES(32, 63);
INSERT INTO `vehiclelane_led` VALUES(32, 64);

-- ----------------------------
-- Table structure for `用户权限access`
-- ----------------------------
DROP TABLE IF EXISTS `access`;
CREATE TABLE `access` (
  `id` bigint(20) NOT NULL auto_increment COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `object_type` int(11) NOT NULL COMMENT '权限类型',
  `object_type_name` varchar(128) default NULL COMMENT '权限类型名称',
  `object_id` varchar(128) default NULL COMMENT '所属ID',
  `object_name` varchar(128) NOT NULL COMMENT '所属名称',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `index_access_user_id_object_type_object_id` (`user_id`,`object_type`,`object_id`),
  KEY `index_access_user_id` (`user_id`),
  KEY `index_access_object_type` (`object_type`),
  KEY `index_access_object_id` (`object_id`),
  CONSTRAINT `fk_access_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `voices`
-- ----------------------------
DROP TABLE IF EXISTS `voices`;
CREATE TABLE `voices` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT 'ID',
  -- 1过期车辆 2临时车辆，3固定车辆，4布控车辆
  `type` int NOT NULL COMMENT '类型',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `creater` int(11)  COMMENT '创建人',
  `creater_time` datetime  COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  CONSTRAINT `fk_voice_voice` FOREIGN KEY (`creater`) REFERENCES `users`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `voices` VALUES(1 , 1 , 'guoqicheliang.wav', 1 , now());
INSERT INTO `voices` VALUES(2 , 2 , 'linshicheliang.wav', 1 , now());
INSERT INTO `voices` VALUES(3 , 3 , 'huanyinguanlin.wav', 1 , now());
INSERT INTO `voices` VALUES(4 , 4 , 'bukongcheliang.wav', 1 , now());
INSERT INTO `voices` VALUES(5 , 5 , 'wufashibie.wav', 1 , now());
-- ----------------------------
-- Table structure for `user_properties`
-- ----------------------------
DROP TABLE IF EXISTS `user_properties`;
CREATE TABLE `user_properties` (
  `id` int(11) NOT NULL auto_increment COMMENT 'ID',
  `user_id` int(11) NOT NULL  COMMENT 'ID',
  -- 1是否播报声音
  `type` int NOT NULL COMMENT '类型',
  -- 0 不播报 2播报
  `value` varchar(128) NOT NULL COMMENT '值',
  PRIMARY KEY  (`id`),
  CONSTRAINT `fk_pro_user` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `video_manager`
-- ----------------------------
DROP TABLE IF EXISTS `video_manager`;
CREATE TABLE `video_manager` (
  `id`  int(11)  NOT NULL auto_increment COMMENT 'ID',
  `lane_id` int(11) NOT NULL  COMMENT '车道ID',
  `type` int NOT NULL COMMENT '1全天录像,2过车',
  `value` varchar(128) NOT NULL COMMENT '值',
  PRIMARY KEY  (`id`),
  CONSTRAINT `fk_videomanage_lane` FOREIGN KEY (`lane_id`) REFERENCES `vehiclelane`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `video_device`
-- ----------------------------
DROP TABLE IF EXISTS `video_device`;
CREATE TABLE `video_device` (
  `id`  int(11)  NOT NULL auto_increment COMMENT 'ID',
  `puid` varchar(32) NOT NULL  COMMENT '设备ID',
  `channel` int(2) NULL COMMENT '通道ID',
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


