/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 10.3.7-MariaDB : Database - bisoo_website
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bisoo_website` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bisoo_website`;

/*Table structure for table `bs_admin` */

CREATE TABLE `bs_admin` (
  `id` varchar(32) NOT NULL,
  `group_id` int(2) DEFAULT NULL COMMENT '所在工作组',
  `login_name` varchar(10) DEFAULT NULL COMMENT '登录名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `job_number` int(5) DEFAULT NULL COMMENT '工号',
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员用户表';

/*Table structure for table `bs_admin_role` */

CREATE TABLE `bs_admin_role` (
  `admin_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_aid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���ɫ��Ϣ';

/*Table structure for table `bs_data_dictionary` */

CREATE TABLE `bs_data_dictionary` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父节点ID',
  `name` varchar(50) DEFAULT NULL COMMENT '属性名',
  `code` int(10) DEFAULT NULL COMMENT '属性码',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `sort_sign` int(4) DEFAULT NULL COMMENT '排序',
  `status` tinyint(2) DEFAULT NULL COMMENT '0-有效 1-无效',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_market_info` */

CREATE TABLE `bs_market_info` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `market_asset_id` varchar(32) DEFAULT NULL,
  `deal_asset_id` varchar(32) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `portfolioAssets` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_notice` */

CREATE TABLE `bs_notice` (
  `id` varchar(32) NOT NULL,
  `type_id` tinyint(4) DEFAULT NULL COMMENT '分类',
  `title` varchar(32) DEFAULT NULL COMMENT '标题',
  `keywords` varchar(10) DEFAULT NULL COMMENT '关键词',
  `summary` varchar(50) DEFAULT NULL COMMENT '摘要',
  `content` text DEFAULT NULL COMMENT '内容',
  `action_time` datetime DEFAULT NULL COMMENT '时间',
  `cover_image` varchar(32) DEFAULT NULL COMMENT '封图',
  `link_path` varchar(100) DEFAULT NULL COMMENT '链接',
  `stick` tinyint(1) DEFAULT NULL COMMENT '置顶',
  `released` tinyint(1) DEFAULT NULL COMMENT '发布',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_permission` */

CREATE TABLE `bs_permission` (
  `id` varchar(32) NOT NULL,
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `permission_nid` varchar(50) DEFAULT NULL COMMENT '权限简写',
  `permission_link` varchar(100) DEFAULT NULL COMMENT '全线连接',
  `type` tinyint(1) DEFAULT NULL COMMENT '权限类型',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��¼Ȩ����Ϣ';

/*Table structure for table `bs_role` */

CREATE TABLE `bs_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/*Table structure for table `bs_role_permission` */

CREATE TABLE `bs_role_permission` (
  `role_id` varchar(32) NOT NULL,
  `permission_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_aid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��¼��ɫȨ��';

/*Table structure for table `bs_user` */

CREATE TABLE `bs_user` (
  `id` varchar(32) NOT NULL,
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `image_id` varchar(32) DEFAULT NULL COMMENT '头像',
  `invite_num` varchar(5) DEFAULT NULL COMMENT '邀请码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `tag` varchar(50) DEFAULT NULL COMMENT '标签',
  `signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `ip` varchar(15) DEFAULT NULL COMMENT '注册IP',
  `imei` varchar(50) DEFAULT NULL COMMENT '手机码',
  `recommend_id` varchar(32) DEFAULT NULL COMMENT '邀请人',
  `reg_type` tinyint(2) DEFAULT NULL COMMENT '注册类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û�������Ϣ��';

/*Table structure for table `bs_user_account` */

CREATE TABLE `bs_user_account` (
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `balance` decimal(30,8) DEFAULT 0.00000000 COMMENT '资产数量',
  `frozen` decimal(30,8) DEFAULT 0.00000000 COMMENT '冻结数量',
  `asset_address` varchar(100) DEFAULT NULL COMMENT '账户地址',
  `status` tinyint(2) DEFAULT NULL COMMENT '资产状态',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_asset_charge` */

CREATE TABLE `bs_user_asset_charge` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL COMMENT '充币金额',
  `fee` decimal(3,2) DEFAULT NULL COMMENT '提充币手续费',
  `status` tinyint(2) DEFAULT NULL COMMENT '0-处理中 1-成功  2-失败',
  `withdraw_address` varchar(100) DEFAULT NULL COMMENT '充币地址',
  `asset_id` varchar(10) DEFAULT NULL COMMENT '资产类型',
  `finish_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `source` tinyint(2) DEFAULT NULL COMMENT '1 - 微信 2 - app  3 - pc  4 - 其他',
  `imei` varchar(50) DEFAULT NULL COMMENT '手机码',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户充币表';

/*Table structure for table `bs_user_asset_withdraw` */

CREATE TABLE `bs_user_asset_withdraw` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL COMMENT '提币数量',
  `fee` decimal(3,2) DEFAULT NULL COMMENT '提币手续费',
  `status` tinyint(2) DEFAULT NULL COMMENT '0-处理中 1-成功  2-失败',
  `withdraw_address` varchar(100) DEFAULT NULL COMMENT '提币地址',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `source` tinyint(2) DEFAULT NULL COMMENT '1 - 微信 2 - app  3 - pc  4 - 其他',
  `imei` varchar(50) DEFAULT NULL COMMENT '手机码',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `asset_id` varchar(10) DEFAULT NULL COMMENT '资产类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户提币表';

/*Table structure for table `bs_user_bank_card` */

CREATE TABLE `bs_user_bank_card` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `card_num` varchar(20) DEFAULT NULL COMMENT '银行卡号',
  `bank_name` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `bank_province` varchar(32) DEFAULT NULL,
  `bank_city` varchar(32) DEFAULT NULL,
  `back_address` varchar(500) DEFAULT NULL COMMENT '开户地址',
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `source` tinyint(2) DEFAULT NULL,
  `imei` varchar(50) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_bch_account` */

CREATE TABLE `bs_user_bch_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_btc_account` */

CREATE TABLE `bs_user_btc_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_bth_account` */

CREATE TABLE `bs_user_bth_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_bts_account` */

CREATE TABLE `bs_user_bts_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_eos_account` */

CREATE TABLE `bs_user_eos_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_eth_account` */

CREATE TABLE `bs_user_eth_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_info` */

CREATE TABLE `bs_user_info` (
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `idcard_front` varchar(32) DEFAULT NULL COMMENT '身份证正面',
  `idcard_back` varchar(32) DEFAULT NULL COMMENT '身份证背面',
  `idcard_handheld` varchar(32) DEFAULT NULL COMMENT '手持身份证',
  `status` tinyint(2) DEFAULT NULL COMMENT '1-未认证 2-审核中 3-认证通过 4-认证不通过',
  `primary_time` datetime DEFAULT NULL COMMENT '初级认证时间',
  `advanced_time` datetime DEFAULT NULL COMMENT '高级认证时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Table structure for table `bs_user_login` */

CREATE TABLE `bs_user_login` (
  `user_id` varchar(32) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `source` smallint(6) DEFAULT NULL COMMENT '0-ios,1-androind,2-web,3-其他',
  `login_ip` varchar(10) DEFAULT NULL,
  `is_success` tinyint(1) DEFAULT NULL,
  `login_err_times` int(3) DEFAULT NULL,
  `imei` varchar(50) DEFAULT NULL,
  `is_next_verify` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_user_usdt_account` */

CREATE TABLE `bs_user_usdt_account` (
  `user_id` varchar(32) DEFAULT NULL,
  `balance` decimal(30,8) DEFAULT 0.00000000,
  `frozen` decimal(30,8) DEFAULT NULL,
  `asset_address` varchar(100) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bs_userss_account` */

CREATE TABLE `bs_userss_account` (
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `balance` decimal(30,8) DEFAULT 0.00000000 COMMENT '资产数量',
  `frozen` decimal(30,8) DEFAULT 0.00000000 COMMENT '冻结数量',
  `asset_address` varchar(100) DEFAULT NULL COMMENT '账户地址',
  `status` tinyint(2) DEFAULT NULL COMMENT '资产状态',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
