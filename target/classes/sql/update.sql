-- add by wyx 2018-06-05 @master start
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bisoo_website` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bisoo_website`;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员用户表'COLLATE=utf8_general_ci;


CREATE TABLE `bs_admin_role` (
  `admin_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_aid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`admin_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宣传表'COLLATE=utf8_general_ci;


CREATE TABLE `bs_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色'COLLATE=utf8_general_ci;


CREATE TABLE `bs_role_permisssion` (
  `role_id` varchar(32) NOT NULL,
  `permission_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_aid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表'COLLATE=utf8_general_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表'COLLATE=utf8_general_ci;


CREATE TABLE `bsi_permission` (
  `id` varchar(32) NOT NULL,
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `permission_nid` varchar(50) DEFAULT NULL COMMENT '权限简写',
  `permission_link` varchar(100) DEFAULT NULL COMMENT '全线连接',
  `type` tinyint(1) DEFAULT NULL COMMENT '权限类型',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_aid` varchar(32) DEFAULT NULL COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表' COLLATE=utf8_general_ci;

-- add by wyx 2018-06-05 @master end