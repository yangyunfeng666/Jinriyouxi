/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost
 Source Database       : account

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 07/12/2020 16:36:53 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `r_client`
-- ----------------------------
DROP TABLE IF EXISTS `r_client`;
CREATE TABLE `r_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_token_valid_seconds` int(11) DEFAULT NULL COMMENT 'access token 有效时间(秒)',
  `authorized_grant_types` varchar(255) DEFAULT NULL COMMENT '授权类型',
  `client_key` varchar(255) DEFAULT NULL COMMENT '授权key',
  `client_secret` varchar(255) DEFAULT NULL COMMENT '授权密钥',
  `name` varchar(255) DEFAULT NULL COMMENT '授权客户端名字',
  `raw_client_secret` varchar(255) DEFAULT NULL COMMENT '明文密钥',
  `redirect_uris` varchar(255) DEFAULT NULL COMMENT '重定向uris',
  `refresh_token_valid_second` int(11) DEFAULT NULL COMMENT 'refresh token 有效时间(秒)',
  `status` varchar(10) DEFAULT 'ENABLE' COMMENT '是否启用',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `resource_ids` varchar(100) DEFAULT NULL COMMENT '资源id',
  `scopes` varchar(100) DEFAULT NULL COMMENT '访问域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户端表';

-- ----------------------------
--  Records of `r_client`
-- ----------------------------
BEGIN;
INSERT INTO `r_client` VALUES ('1', '7200', 'password,refresh_token,authorization_code', 'clientapp', '112233', 'clientapp', '112233', null, '0', 'ENABLE', '', null, null, null, null, 'broker_web', 'all');
COMMIT;

-- ----------------------------
--  Table structure for `r_client_role`
-- ----------------------------
DROP TABLE IF EXISTS `r_client_role`;
CREATE TABLE `r_client_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` int(20) NOT NULL COMMENT 'client_id',
  `role_id` int(20) NOT NULL COMMENT 'role_id',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户端角色关联表';

-- ----------------------------
--  Records of `r_client_role`
-- ----------------------------
BEGIN;
INSERT INTO `r_client_role` VALUES ('1', '1', '1', '', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_menu`
-- ----------------------------
DROP TABLE IF EXISTS `r_menu`;
CREATE TABLE `r_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL COMMENT '页面url',
  `name` varchar(100) NOT NULL COMMENT '页面名称',
  `parent_menu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父menuId',
  `status` varchar(10) DEFAULT 'ENABLE' COMMENT '状态',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `type` varchar(10) NOT NULL COMMENT '页面类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限页面表';

-- ----------------------------
--  Records of `r_menu`
-- ----------------------------
BEGIN;
INSERT INTO `r_menu` VALUES ('1', '/index', '首页', '0', 'ENABLE', null, null, null, null, null, 'ADMIN'), ('14', 'set', '系统设置', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('15', 'customer', '客户管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('16', 'business', '业务管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('17', 'invoice', '发票管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('18', 'money', '资金管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('19', 'reconciliation', '对账管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('20', 'partner', '合伙人管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('21', 'report', '报备管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('22', 'contract', '合同管理', '0', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('24', 'setUser', '用户设置', '14', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('25', 'setRole', '角色设置', '14', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('26', 'setLog', '系统日志管理', '14', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('27', 'company', '企业商户', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('28', 'agent', '代理商', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('29', 'supplier', '供应商', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('30', 'bankOpens', '银行开户', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('31', 'merchants', '商户账号', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('32', 'signing', '个人签约管理', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('33', 'customerApi', 'API管理', '15', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('34', 'order', '委托受理订单管理', '16', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('35', 'daiFaLog', '代发记录查询', '16', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('36', 'errLog', '异常任务处理查询', '16', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('37', 'trading', '交易统计', '16', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('38', 'invoiceLog', '发票记录查询', '17', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('39', 'invoiceWarning', '发票预警', '17', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('40', 'invoiceList', '发票管理', '17', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('41', 'invoiceApproval', '发票审批', '17', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('42', 'recharge', '充值记录', '18', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('43', 'tixian', '提现记录', '18', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('44', 'moneyLog', '收支明细', '18', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('45', 'fenRun', '分润明细', '18', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('46', 'linesLog', '额度变更明细', '18', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('47', 'list', '流水勾兑', '19', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('48', 'tradingLog', '交易勾兑', '19', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('49', 'partnerList', '合伙人管理', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('50', 'statistical', '交易统计', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('51', 'feilv', '费率变更明细', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('52', 'bigKehu', '大客户补贴', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('53', 'ptixian', '合伙人提现', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('54', 'pFenRun', '合伙人分润', '20', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('55', 'reportList', '报备管理', '21', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM'), ('56', 'contractList', '合同管理', '22', 'ENABLE', null, '2020-07-11', null, null, null, 'SYSTEM');
COMMIT;

-- ----------------------------
--  Table structure for `r_menu_permission`
-- ----------------------------
DROP TABLE IF EXISTS `r_menu_permission`;
CREATE TABLE `r_menu_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` int(20) NOT NULL COMMENT 'menu_id',
  `permission_id` int(20) NOT NULL COMMENT 'permission_id',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='页面权限关联表';

-- ----------------------------
--  Records of `r_menu_permission`
-- ----------------------------
BEGIN;
INSERT INTO `r_menu_permission` VALUES ('1', '1', '2', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_permission`
-- ----------------------------
DROP TABLE IF EXISTS `r_permission`;
CREATE TABLE `r_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_root_permission` int(11) DEFAULT NULL COMMENT '是否是系统权限',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `service` varchar(255) NOT NULL COMMENT '服务名称',
  `controller` varchar(255) NOT NULL COMMENT 'controller名称',
  `method` varchar(20) NOT NULL COMMENT '方法名字',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
--  Records of `r_permission`
-- ----------------------------
BEGIN;
INSERT INTO `r_permission` VALUES ('1', '0', 'dd', 'oms', 'permission', 'quess', '', null, null, null, null), ('2', '0', '接口权限', 'oms', 'user', 'queryMenu', '', null, null, null, null), ('3', '0', '角色添加接口权限', 'oms', 'role', 'add', '', null, null, null, null), ('4', '0', '角色添加', 'oms', 'role', 'update', null, null, null, null, null), ('5', '0', '角色删除', 'oms', 'role', 'delete', null, null, null, null, null), ('6', '0', '角色查询', 'oms', 'role', 'query', null, null, null, null, null), ('7', '0', '页面添加', 'oms', 'menu', 'add', null, null, null, null, null), ('8', '0', '页面更新', 'oms', 'menu', 'update', null, null, null, null, null), ('9', '0', '页面删除', 'oms', 'menu', 'delete', null, null, null, null, null), ('10', '0', '页面查询', 'oms', 'menu', 'query', null, null, null, null, null), ('11', '0', '权限接口', 'oms', 'permission', 'add', null, null, null, null, null), ('12', '0', '权限查询', 'oms', 'permission', 'query', null, null, null, null, null), ('13', '0', '权限修改', 'oms', 'permission', 'update', null, null, null, null, null), ('14', '0', '权限删除', 'oms', 'permission', 'delete', null, null, null, null, null), ('15', null, '页面查询所有', 'oms', 'menu', 'queryAll', null, null, null, null, null), ('16', null, '用户查询所有', 'oms', 'user', 'queryAll', null, null, null, null, null), ('17', null, '用户添加角色', 'oms', 'user', 'addUserRole', null, null, null, null, null), ('18', '0', '用户删除', 'oms', 'user', 'delete', null, null, null, null, null), ('19', '0', '页面查询权限', 'oms', 'permission', 'queryMenu', null, null, null, null, null), ('20', null, 'sdf2', 'dsf', 'wer', 'addwew', null, null, null, null, null), ('21', null, 'erweer2', 'werw', 'werew', 'addwewrw', null, null, null, null, null), ('22', null, '页面添加权限', 'oms', 'menu', 'addPermissions', null, null, null, null, null), ('23', '0', '权限', 'oms', 'permission', 'queryAll', null, '2020-07-16', null, null, null), ('24', '0', '修改自己密码', 'oms', 'user', 'updateSelfPassword', null, null, null, null, null), ('25', '0', '添加系统用户', 'oms', 'user', 'addSystemUser', null, null, null, null, null), ('26', '0', '页面删除权限', 'oms', 'menu', 'deletePermission', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_role`
-- ----------------------------
DROP TABLE IF EXISTS `r_role`;
CREATE TABLE `r_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL COMMENT '角色代码',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `status` varchar(10) NOT NULL DEFAULT 'ENABLE' COMMENT '状态',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限角色表';

-- ----------------------------
--  Records of `r_role`
-- ----------------------------
BEGIN;
INSERT INTO `r_role` VALUES ('1', 'SYSTEM_ADMIN', 'broker平台用户', 'ENABLE', '', null, null, null, null), ('5', 'ADMIN', '系统管理员', 'ENABLE', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `r_role_menu`;
CREATE TABLE `r_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色代码',
  `menu_id` bigint(20) NOT NULL COMMENT '角色名称',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色页面关联表';

-- ----------------------------
--  Records of `r_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `r_role_menu` VALUES ('1', '1', '1', '', null, null, null, null), ('2', '1', '5', null, null, null, null, null), ('3', '1', '6', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `r_role_permission`;
CREATE TABLE `r_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_user` varchar(200) DEFAULT NULL COMMENT '申请人',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_user` varchar(200) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色页面关联表';

-- ----------------------------
--  Records of `r_role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `r_role_permission` VALUES ('1', '1', '1', '', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_user`
-- ----------------------------
DROP TABLE IF EXISTS `r_user`;
CREATE TABLE `r_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户自增ID',
  `origin_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `login_id` varchar(100) DEFAULT NULL COMMENT '登陆用户名',
  `name` varchar(100) DEFAULT NULL COMMENT '用户名字',
  `user_type` varchar(20) DEFAULT NULL COMMENT '用户类型 MemberType',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` varchar(100) DEFAULT NULL COMMENT '更新人',
  `is_deleted` tinyint(3) unsigned DEFAULT '0' COMMENT '是否删除:0 否, 1 是',
  `level` tinyint(4) DEFAULT '1' COMMENT '等级',
  `status` varchar(10) DEFAULT 'ENABLE' COMMENT 'ENABLE正常 UNABLE 禁用',
  `real_name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户登录表';

-- ----------------------------
--  Records of `r_user`
-- ----------------------------
BEGIN;
INSERT INTO `r_user` VALUES ('1', '1', 'admin', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-06-29 10:36:11', null, '2020-07-07 14:24:07', null, '0', '0', 'ENABLE', null, null), ('2', '1', 'test1', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-07-10 14:03:36', null, '2020-07-10 14:03:46', null, '0', '1', 'ENABLE', null, null), ('3', '1', 'test2', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-07-10 14:06:23', null, '2020-07-10 14:06:38', null, '0', '1', 'ENABLE', null, null), ('4', '1', 'test3', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-07-10 14:06:51', null, '2020-07-10 15:59:31', null, '0', '0', 'ENABLE', null, null), ('5', '1', 'test5', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-07-10 14:07:30', null, '2020-07-10 14:26:16', null, '0', '0', 'ENABLE', null, null), ('6', '1', 'test6', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9F', null, '2020-07-10 14:07:53', null, '2020-07-10 19:24:31', null, '0', '1', 'ENABLE', null, null), ('7', '1', 'test4', '开发账号', 'SYSTEM', 'AFDD0B4AD2EC172C586E2150770FBF9E', null, '2020-07-10 14:22:54', null, '2020-07-10 14:22:57', null, '0', '1', 'ENABLE', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `r_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户自增ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(100) DEFAULT NULL COMMENT '角色id',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user` varchar(100) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='权限用户登录表';

-- ----------------------------
--  Records of `r_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `r_user_role` VALUES ('1', '1', '1', null, '2020-06-29 10:40:37', null, '2020-06-29 10:40:37', null), ('2', '2', '1', null, '2020-07-10 14:04:01', null, '2020-07-10 14:04:01', null), ('3', '3', '1', null, '2020-07-10 14:07:14', null, '2020-07-10 14:07:14', null), ('4', '4', '1', null, '2020-07-10 14:07:20', null, '2020-07-10 14:07:20', null), ('5', '5', '1', null, '2020-07-10 14:08:14', null, '2020-07-10 14:08:14', null), ('6', '6', '1', null, '2020-07-10 14:08:17', null, '2020-07-10 14:08:21', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
