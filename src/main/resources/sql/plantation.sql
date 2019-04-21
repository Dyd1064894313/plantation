/*
Navicat MySQL Data Transfer

Source Server         : conn1
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : plantation

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2019-04-21 19:53:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `character_def`
-- ----------------------------
DROP TABLE IF EXISTS `character_def`;
CREATE TABLE `character_def` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '特征名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='特征定义表';

-- ----------------------------
-- Records of character_def
-- ----------------------------
INSERT INTO `character_def` VALUES ('1', '温度', '2019-04-21 19:26:53', '2019-04-21 19:26:53');
INSERT INTO `character_def` VALUES ('2', '湿度', '2019-04-21 19:27:07', '2019-04-21 19:27:07');
INSERT INTO `character_def` VALUES ('3', 'CO2浓度', '2019-04-21 19:27:31', '2019-04-21 19:27:31');
INSERT INTO `character_def` VALUES ('4', '光照强度', '2019-04-21 19:27:45', '2019-04-21 19:27:45');
INSERT INTO `character_def` VALUES ('5', '风速', '2019-04-21 19:27:53', '2019-04-21 19:27:53');

-- ----------------------------
-- Table structure for `climate`
-- ----------------------------
DROP TABLE IF EXISTS `climate`;
CREATE TABLE `climate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `place_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '场所ID',
  `temperature` decimal(12,2) NOT NULL DEFAULT '-99999.00' COMMENT '温度',
  `humidity` decimal(12,2) NOT NULL DEFAULT '-99999.00' COMMENT '湿度',
  `light` decimal(12,2) NOT NULL DEFAULT '-99999.00' COMMENT '光照强度',
  `co2` decimal(12,2) NOT NULL DEFAULT '-99999.00' COMMENT '二氧化碳浓度',
  `wind_speed` decimal(12,2) NOT NULL DEFAULT '-99999.00' COMMENT '风速',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='气候表';

-- ----------------------------
-- Records of climate
-- ----------------------------

-- ----------------------------
-- Table structure for `place`
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `location` varchar(64) NOT NULL DEFAULT '' COMMENT '位置',
  `purpose` tinyint(4) DEFAULT '1' COMMENT '用途：1 大棚',
  `remark` varchar(256) NOT NULL DEFAULT '' COMMENT '说明备注',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0 无效 1 有效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场所表';

-- ----------------------------
-- Records of place
-- ----------------------------

-- ----------------------------
-- Table structure for `species`
-- ----------------------------
DROP TABLE IF EXISTS `species`;
CREATE TABLE `species` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) NOT NULL COMMENT '父ID',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `remark` varchar(256) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='物种表';

-- ----------------------------
-- Records of species
-- ----------------------------
INSERT INTO `species` VALUES ('1', '-1', '植物', '植物', '2019-04-21 19:29:30', '2019-04-21 19:32:28');
INSERT INTO `species` VALUES ('2', '-1', '动物', '动物', '2019-04-21 19:29:46', '2019-04-21 19:32:32');
INSERT INTO `species` VALUES ('3', '1', '番茄', '番茄', '2019-04-21 19:30:43', '2019-04-21 19:30:57');
INSERT INTO `species` VALUES ('4', '3', '樱桃番茄', '樱桃番茄', '2019-04-21 19:31:32', '2019-04-21 19:31:37');

-- ----------------------------
-- Table structure for `species_config`
-- ----------------------------
DROP TABLE IF EXISTS `species_config`;
CREATE TABLE `species_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `species_id` bigint(20) NOT NULL COMMENT '物种ID',
  `cha_id` bigint(20) NOT NULL COMMENT '规格ID',
  `value_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '值类型 1：固定值 2：范围',
  `min_value` decimal(20,5) NOT NULL DEFAULT '0.00000' COMMENT '最小值',
  `max_value` decimal(20,5) NOT NULL DEFAULT '0.00000' COMMENT '最大值',
  `begin_time` varchar(16) NOT NULL DEFAULT '' COMMENT '开始时间',
  `end_time` varchar(16) NOT NULL DEFAULT '' COMMENT '结束时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态 0：无效 1 ：有效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物种配置表';

-- ----------------------------
-- Records of species_config
-- ----------------------------
