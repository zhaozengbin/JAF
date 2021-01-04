/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : jaf

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2014-04-10 17:57:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_base_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_base_user`;
CREATE TABLE `sys_base_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUser` int(10) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_base_user
-- ----------------------------
INSERT INTO `sys_base_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', '2014-04-03', '0');

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `groupid` int(10) DEFAULT NULL COMMENT '字典分组编号',
  `name` varchar(100) DEFAULT NULL COMMENT '字典名称',
  `code` varchar(100) DEFAULT NULL COMMENT '字典编号',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUser` int(10) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `permissionName` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `parentId` int(10) DEFAULT NULL COMMENT '父级编号',
  `weight` int(5) DEFAULT NULL COMMENT '权重',
  `type` int(1) DEFAULT NULL COMMENT '类型 1菜单 2 按钮',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUser` int(10) DEFAULT NULL COMMENT '创建者',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `clazz` varchar(255) DEFAULT NULL COMMENT '样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '系统管理', '系统管理', '#', '0', '1', '1', '2013-10-28', '1', 'plugin/ui/accordion/images/group_add.png', 'group_add');
INSERT INTO `sys_permission` VALUES ('2', '用户管理', '用户管理', '/sysUser/toList.shtml', '1', '1', '1', '2013-10-28', '1', 'plugin/ui/accordion/images/pictures.png', 'pictures');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `roleName` varchar(32) DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUser` int(10) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '超级管理员', '2013-10-28', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `roleId` int(10) DEFAULT NULL COMMENT '系统角色编号',
  `permissionId` int(10) DEFAULT NULL COMMENT '系统权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for sys_team
-- ----------------------------
DROP TABLE IF EXISTS `sys_team`;
CREATE TABLE `sys_team` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `teamName` varchar(32) DEFAULT NULL COMMENT '组名',
  `description` varchar(255) DEFAULT NULL COMMENT '组描述',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `createUser` int(10) DEFAULT NULL COMMENT '创建者',
  `parentId` int(10) DEFAULT NULL COMMENT '父类编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_team
-- ----------------------------
INSERT INTO `sys_team` VALUES ('1', '网站管理组', '网站管理组', '2013-10-28', '1', '0');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `baseId` int(10) DEFAULT NULL COMMENT '用户基础编号',
  `number` varchar(32) DEFAULT NULL COMMENT '工号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `mobilePhone` varchar(32) DEFAULT NULL COMMENT '手机',
  `officePhone` varchar(32) DEFAULT NULL COMMENT '办公电话',
  `realName` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1', 'zhaozengbin@gmail.com', '18911656423', '18911656423', '超级管理员');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `userId` int(10) DEFAULT NULL COMMENT '系统用户编号',
  `roleId` int(10) DEFAULT NULL COMMENT '系统角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for sys_user_team
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_team`;
CREATE TABLE `sys_user_team` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `userId` int(10) DEFAULT NULL COMMENT '系统用户编号',
  `teamId` int(10) DEFAULT NULL COMMENT '系统用户组编号',
  `level` int(1) DEFAULT NULL COMMENT '系统用户组内级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户用户组中间表';

-- ----------------------------
-- Records of sys_user_team
-- ----------------------------
INSERT INTO `sys_user_team` VALUES ('1', '1', '1', '1');
