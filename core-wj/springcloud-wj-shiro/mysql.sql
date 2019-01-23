DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '菜单Id',
  `parent_id` INT(11) DEFAULT NULL COMMENT '上级Id',
  `menu_name` VARCHAR(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` VARCHAR(30) DEFAULT NULL COMMENT '菜单图标',
  `menu_url` VARCHAR(100) DEFAULT NULL COMMENT '菜单链接',
  `menu_type` VARCHAR(10) DEFAULT NULL COMMENT '菜单类型',
  `menu_order` VARCHAR(10) DEFAULT NULL COMMENT '菜单排序',
  `menu_status` VARCHAR(10) DEFAULT NULL COMMENT '菜单状态',
  PRIMARY KEY (`menu_id`)
) ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

INSERT  INTO `sys_menu`(`menu_id`,`parent_id`,`menu_name`,`menu_icon`,`menu_url`,`menu_type`,`menu_order`,`menu_status`) VALUES (1,0,'用户管理','&#xe610','#','1','1','1'),(2,1,'管理员管理','&#xe604','user/queryAll.do','2','2','1'),(3,1,'用户统计','&#xe604','test','2','3','1'),(4,0,'在线管理','&#xe610','#','1','4','1'),(5,4,'在线情况','&#xe604',NULL,'2','5','1'),(6,4,'在线聊天','&#xe604','article/list.do','2','6','1'),(7,0,'系统管理','&#xe610','#','1','7','1'),(8,7,'角色管理','&#xe604','role/queryAll.do','2','8','1'),(9,7,'权限管理','&#xe604','permission/queryAll.do','2','9','1'),(10,7,'菜单管理','&#xe604','menu/getMenus.do','2','10','1'),(11,0,'平台资料','&#xe610','#','1','11','1');

/*Table structure for table `sys_operation` */

DROP TABLE IF EXISTS `sys_operation`;

CREATE TABLE `sys_operation` (
  `id` INT(11) NOT NULL COMMENT '操作Id，主键',
  `desc` VARCHAR(100) DEFAULT NULL COMMENT '操作描述',
  `name` VARCHAR(100) DEFAULT NULL COMMENT '操作名称',
  `operation` VARCHAR(100) DEFAULT NULL COMMENT '操作标志',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_o_1` (`operation`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_operation` */

INSERT  INTO `sys_operation`(`id`,`desc`,`name`,`operation`) VALUES (1,'创建操作','创建','create'),(2,'编辑权限','编辑','edit'),(3,'删除权限','删除','delete'),(4,'浏览权限','浏览','view');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` INT(11) NOT NULL COMMENT '权限Id',
  `pdesc` VARCHAR(100) DEFAULT NULL COMMENT '权限描述',
  `name` VARCHAR(100) DEFAULT NULL COMMENT '权限名称',
  `menu_id` INT(11) DEFAULT NULL COMMENT '菜单Id',
  PRIMARY KEY (`id`),
  KEY `p_fk_1` (`menu_id`),
  CONSTRAINT `p_fk_1` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

INSERT  INTO `sys_permission`(`id`,`pdesc`,`name`,`menu_id`) VALUES (1,'用户管理的权限','用户管理',1),(2,'管理员管理的权限','管理员管理',2),(3,'用户统计的权限','用户统计',3),(4,'在线管理的权限','在线管理',4),(5,'在线情况的权限','在线情况',5),(6,'在线聊天的权限','在线聊天',6),(7,'系统管理的权限','系统管理',7),(8,'角色管理的权限','角色管理',8),(9,'权限管理的权限','权限管理',9),(10,'菜单管理的权限','菜单管理',10),(11,'平台资料的权限','平台资料',11);

/*Table structure for table `sys_permission_operation` */

DROP TABLE IF EXISTS `sys_permission_operation`;

CREATE TABLE `sys_permission_operation` (
  `permission_id` INT(11) NOT NULL,
  `operation_id` INT(11) NOT NULL,
  PRIMARY KEY (`permission_id`,`operation_id`),
  KEY `po_fk_1` (`operation_id`),
  CONSTRAINT `po_fk_1` FOREIGN KEY (`operation_id`) REFERENCES `sys_operation` (`id`),
  CONSTRAINT `po_fk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission_operation` */

INSERT  INTO `sys_permission_operation`(`permission_id`,`operation_id`) VALUES (1,1),(2,2),(3,3);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `role_name` VARCHAR(100) DEFAULT NULL COMMENT '角色名称',
  `role_desc` VARCHAR(100) DEFAULT NULL COMMENT '角色描述',
  `role` VARCHAR(100) DEFAULT NULL COMMENT '角色标志',
  PRIMARY KEY (`role_id`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

INSERT  INTO `sys_role`(`role_id`,`role_name`,`role_desc`,`role`) VALUES (1,'超级管理员','超级管理员拥有所有权限','role'),(2,'用户管理员','用户管理权限','role'),(3,'角色管理员','角色管理权限','role'),(4,'资源管理员','资源管理权限','role'),(6,'操作权限管理员','操作权限管理','role'),(7,'查看员','查看系统权限','role'),(9,'用户','可以查看','role');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `rp_id` VARCHAR(12) NOT NULL COMMENT '表Id',
  `role_id` INT(11) NOT NULL COMMENT '角色Id',
  `permission_id` INT(11) NOT NULL COMMENT '权限Id',
  PRIMARY KEY (`rp_id`),
  KEY `rp_fk_2` (`permission_id`),
  KEY `rp_fk_1` (`role_id`),
  CONSTRAINT `rp_fk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `rp_fk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

INSERT  INTO `sys_role_permission`(`rp_id`,`role_id`,`permission_id`) VALUES ('02a97146f6f4',2,1),('0bc217ced57a',1,1),('1623edee1d80',1,2),('2897c5ff0aa8',1,3),('421ddf008a05',1,4),('4b76f155fd74',9,1),('4dcadb89531b',1,7),('55eb164457e2',9,2),('59084a9f6914',2,2),('5a2b34b2f1a7',1,10),('63a5d5a8dae6',1,9),('9ad0b2c3be28',1,8),('9fa9725142c1',2,3),('ba83ae853640',1,6),('d5aec431edf6',1,5);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` VARCHAR(100) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `phone` VARCHAR(11) DEFAULT NULL COMMENT '手机',
  `sex` VARCHAR(6) DEFAULT NULL COMMENT '性别',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `mark` VARCHAR(100) DEFAULT NULL COMMENT '备注',
  `rank` VARCHAR(10) DEFAULT NULL COMMENT '账号等级',
  `last_login` DATE DEFAULT NULL COMMENT '最后一次登录时间',
  `login_ip` VARCHAR(30) DEFAULT NULL COMMENT '登录ip',
  `image_url` VARCHAR(100) DEFAULT NULL COMMENT '头像图片路径',
  `reg_time` DATE NOT NULL COMMENT '注册时间',
  `locked` TINYINT(1) DEFAULT NULL COMMENT '账号是否被锁定',
  `rights` VARCHAR(100) DEFAULT NULL COMMENT '权限（没有使用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_u_1` (`username`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

INSERT  INTO `sys_user`(`id`,`username`,`password`,`phone`,`sex`,`email`,`mark`,`rank`,`last_login`,`login_ip`,`image_url`,`reg_time`,`locked`,`rights`) VALUES (1,'admin','28dca2a7b33b7413ad3bce1d58c26dd679c799f1','1552323312','男','313222@foxmail.com','超级管理员','admin','2017-08-12','127.0.0.1','/static/images/','2017-03-15',0,NULL),(2,'sys','e68feeafe796b666a2e21089eb7aae9c678bf82d','1552323312','男','313222@foxmail.com','系统管理员','sys','2017-08-25','127.0.0.1','/static/images/','2017-03-15',0,NULL),(3,'user','adf8e0d0828bde6e90c2bab72e7a2a763d88a0de','1552323312','男','313222@foxmail.com','用户','user','2017-08-18','127.0.0.1','/static/images/','2017-03-15',0,NULL),(9,'test','123','12332233212','保密','2312@qq.com','没有备注','user','2017-11-25','127.0.0.1',NULL,'2017-11-25',0,NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` INT(11) NOT NULL COMMENT '用户Id,联合主键',
  `role_id` INT(11) NOT NULL COMMENT '角色Id，联合主键',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `ur_fk_2` (`role_id`),
  CONSTRAINT `ur_fk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `ur_fk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

INSERT  INTO `sys_user_role`(`user_id`,`role_id`) VALUES (1,1),(1,2),(2,2),(1,3),(2,3),(3,3),(1,4),(3,4),(1,6),(1,7),(3,7),(9,9);