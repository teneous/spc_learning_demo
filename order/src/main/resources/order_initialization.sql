DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee`  (
  `id` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_time` date NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `index_no` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phoneno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `status` bit(1) NOT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_con_cid`(`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL,
  `create_time` date NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `order_money` decimal(19, 2) NOT NULL,
  `real_pay_money` decimal(19, 2) NOT NULL,
  `serial_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type` smallint(6) NOT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_serial`(`serial_no`) USING BTREE,
  INDEX `idx_cid`(`customer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;