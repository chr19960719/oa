/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-05-21 16:24:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptID` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `deptName` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `deptText` varchar(255) DEFAULT NULL COMMENT '部门介绍',
  PRIMARY KEY (`deptID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人事部', '管理人员');
INSERT INTO `dept` VALUES ('3', '123', '456');
INSERT INTO `dept` VALUES ('4', null, null);
INSERT INTO `dept` VALUES ('5', null, null);
INSERT INTO `dept` VALUES ('6', '123', '456');
INSERT INTO `dept` VALUES ('7', '88', 'hh');

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `employeeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `employeeName` varchar(255) DEFAULT NULL COMMENT '用户名字',
  `sex` varchar(255) NOT NULL COMMENT '用户性别',
  `birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `NOcode` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `learn` varchar(255) DEFAULT NULL COMMENT '学历',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `jobID` int(11) DEFAULT NULL COMMENT '职位ID',
  `deptID` int(11) DEFAULT NULL COMMENT '部门ID',
  `workState` varchar(255) DEFAULT NULL COMMENT '状态',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `agreement` varchar(255) DEFAULT NULL COMMENT '就职协议',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `userLevel` int(11) DEFAULT NULL COMMENT '用户级别',
  PRIMARY KEY (`employeeID`),
  KEY `jobID` (`jobID`),
  KEY `deptID` (`deptID`),
  CONSTRAINT `deptID` FOREIGN KEY (`deptID`) REFERENCES `dept` (`deptID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `jobID` FOREIGN KEY (`jobID`) REFERENCES `job` (`jobID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------

-- ----------------------------
-- Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `jobID` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `deptID` int(11) DEFAULT NULL COMMENT '部门ID',
  `jobName` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `jobText` text COMMENT '职位介绍',
  PRIMARY KEY (`jobID`),
  KEY `deptID2` (`deptID`),
  CONSTRAINT `deptID2` FOREIGN KEY (`deptID`) REFERENCES `dept` (`deptID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `noteID` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `employeeID` int(11) DEFAULT NULL COMMENT '发布人ID',
  `noteName` varchar(255) DEFAULT NULL COMMENT '公告名称',
  `noteInfo` text COMMENT '公告介绍',
  `noteTime` varchar(255) DEFAULT NULL COMMENT '公告时间',
  PRIMARY KEY (`noteID`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `employeeID` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `receivefile`
-- ----------------------------
DROP TABLE IF EXISTS `receivefile`;
CREATE TABLE `receivefile` (
  `receiveID` int(11) NOT NULL COMMENT '接收表id',
  `fileID` int(11) DEFAULT NULL COMMENT '文件ID',
  `employeeID` int(11) DEFAULT NULL COMMENT '文件接收人',
  `isLook` int(11) DEFAULT NULL COMMENT '查看状态',
  `isDelete` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`receiveID`),
  KEY `fileID` (`fileID`),
  KEY `fileTO` (`employeeID`),
  CONSTRAINT `receivefile_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `receivefile_ibfk_1` FOREIGN KEY (`fileID`) REFERENCES `sendfile` (`fileID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receivefile
-- ----------------------------

-- ----------------------------
-- Table structure for `sendfile`
-- ----------------------------
DROP TABLE IF EXISTS `sendfile`;
CREATE TABLE `sendfile` (
  `fileID` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `fileTime` datetime DEFAULT NULL COMMENT '文件发送时间',
  `fileName` varchar(255) DEFAULT NULL COMMENT '文件名',
  `fileText` text COMMENT '文件描述',
  `employeeID` int(11) DEFAULT NULL COMMENT '文件发送人ID',
  `issend` int(11) DEFAULT NULL COMMENT '发送状态',
  `filesrc` varchar(255) DEFAULT NULL COMMENT '附件路径',
  PRIMARY KEY (`fileID`),
  KEY `fileFrom` (`employeeID`),
  CONSTRAINT `sendfile_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sendfile
-- ----------------------------

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskID` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `taskName` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `taskInfo` text COMMENT '任务介绍',
  `getTime` datetime DEFAULT NULL COMMENT '添加任务时间',
  `taskState` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `employeeID` int(11) DEFAULT NULL COMMENT '任务添加人ID',
  PRIMARY KEY (`taskID`),
  KEY `employeeID2` (`employeeID`),
  CONSTRAINT `employeeID2` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`employeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
