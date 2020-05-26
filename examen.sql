/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : localhost:3306
 Source Schema         : examen

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 25/05/2020 23:29:07
*/

CREATE DATABASE IF NOT EXISTS examen;
USE examen;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario`  (
  `idUsuario` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `usuario` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`idUsuario`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES (1, 'Administrador del sistema', 'admin', '6567179ccea113ad22ae0f5856954247');

SET FOREIGN_KEY_CHECKS = 1;
