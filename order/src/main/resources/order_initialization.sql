DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` date NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `order_money` decimal(19, 2) NOT NULL,
  `real_pay_money` decimal(19, 2) NOT NULL,
  `serial_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` smallint(6) NOT NULL,
  `update_time` date NULL DEFAULT NULL,
  `receiver_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receiver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receiver_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_serial`(`serial_no`) USING BTREE,
  INDEX `idx_cid`(`customer_id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;