/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : agriclturalsystem

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 09/01/2024 14:16:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for easybuy_comment
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_comment`;
CREATE TABLE `easybuy_comment`  (
  `EC_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EC_CONTENT` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EC_CREATE_TIME` datetime NOT NULL,
  `EC_REPLY` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EC_REPLY_TIME` datetime NULL DEFAULT NULL,
  `EC_NICK_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`EC_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_comment
-- ----------------------------
INSERT INTO `easybuy_comment` VALUES (7, '农场主在么？', '2018-12-19 11:06:52', '在的！', '2018-12-19 00:00:00', '白菜');
INSERT INTO `easybuy_comment` VALUES (9, '可以多上架土豆嘛！', '2018-12-19 14:30:42', '1', '2024-01-09 00:00:00', '小张');
INSERT INTO `easybuy_comment` VALUES (10, '好喜欢西红柿！', '2018-12-19 14:31:06', '', NULL, '阿朱');
INSERT INTO `easybuy_comment` VALUES (11, '这个农场的产品真好!', '2018-12-19 14:35:35', '', NULL, '慢慢来');

-- ----------------------------
-- Table structure for easybuy_news
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_news`;
CREATE TABLE `easybuy_news`  (
  `EN_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EN_TITLE` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EN_CONTENT` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EN_CREATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`EN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_news
-- ----------------------------
INSERT INTO `easybuy_news` VALUES (2, ' \"农场租赁与农产品销售：农业领域的新篇章\"', '农业领域正在见证一场变革，那就是农场租赁与农产品销售的新模式。这一模式为农业生产和销售带来了新的机遇，为农业经济的可持续发展注入了新的活力。\r\n\r\n这一模式的出现，解决了租赁期间农作物销售问题，优化了农作物的销售流程，减少了中间环节，为农民提供了更多的销售选择。出租方和承租方共同参与农作物种植和销售环节，实现资源共享，提高了经济效益。\r\n\r\n该模式不仅注重经济效益，更注重可持续发展。双方将加大对农业科技的投入，推广绿色、环保的种植方式，提高农产品的品质和安全性，以满足消费者对健康、环保的需求。这一模式有助于推动农业现代化进程，促进农业经济的可持续发展。\r\n\r\n该模式的推广和应用，对于农业经济的发展具有重要意义。它能够激发农业生产的活力，提高农产品的市场竞争力，带动相关产业的发展，增加就业机会，推动农村经济的繁荣。\r\n\r\n未来，随着更多实践经验的积累和模式的不断完善，我们有理由相信这一模式将在更广泛的范围内得到推广和应用。让我们共同期待一个更加美好的未来！', '2018-04-24 13:01:31');
INSERT INTO `easybuy_news` VALUES (3, ' \"农场租赁与农产品销售：共谋发展，共创未来\"', '日，农业领域的一项新合作模式——农场租赁与农产品销售，正成为推动农业经济发展的新动力。这一模式通过整合资源，优化配置，为农业生产和销售带来了新的机遇。\r\n\r\n据了解，该模式的核心理念在于“合作共赢”。出租方和承租方在租赁期间，共同参与农作物的种植和销售环节，充分发挥各自的优势，实现资源共享。通过紧密的合作，双方能够更好地应对市场风险，提高农产品的附加值，从而实现经济效益的最大化。\r\n\r\n此外，该模式还注重可持续发展。出租方和承租方在合作过程中，不仅要考虑眼前的利益，更要着眼于长远的可持续发展。因此，他们将加大对农业科技的投入，推广绿色、环保的种植方式，提高农产品的品质和安全性，以满足消费者对健康、环保的需求。\r\n\r\n这一模式的推广和应用，对于农业经济的发展具有重要意义。它不仅能够激发农业生产的活力，提高农产品的市场竞争力，还能带动相关产业的发展，增加就业机会，推动农村经济的繁荣。', '2018-04-24 13:02:04');
INSERT INTO `easybuy_news` VALUES (4, ' \"共创美好未来：农场租赁与农产品销售新模式\"', '近日，农业领域迎来了一项新的变革——农场租赁与农产品销售的新模式。这一模式的出现，旨在解决租赁期间农作物销售问题，为农业经济的可持续发展注入新的活力。\r\n\r\n据了解，这一新模式的核心在于协商确定销售权。在租赁合同中，出租方和承租方将就农作物的销售权进行明确约定。通过这样的方式，双方可以共同参与农作物销售决策，确保农产品的顺利销售。\r\n\r\n此外，为了更好地促进农作物的销售，双方还将就销售责任与分配进行约定。通过明确的责任划分，出租方和承租方将共同承担农作物销售的责任，确保农产品的顺利销售。\r\n\r\n这一新模式的出现，不仅优化了农作物的销售流程，减少了中间环节，还为农民提供了更多的销售选择。同时，这也促进了农场租赁市场的健康发展，为农业经济的可持续发展奠定了基础。\r\n\r\n专家表示，这一模式是对传统农业经营方式的创新和提升，有助于推动农业现代化进程。未来，随着更多实践经验的积累，这一模式有望在更广泛的范围内得到推广和应用。\r\n\r\n', '2018-04-24 13:13:04');
INSERT INTO `easybuy_news` VALUES (5, '商城须知', '注册的时候所有的字段都要填写', '2018-04-24 13:13:48');
INSERT INTO `easybuy_news` VALUES (6, '会员注册须知', '会员注册须知', '2018-04-24 13:23:47');
INSERT INTO `easybuy_news` VALUES (7, '会员购买须知', '会员购买须知', '2018-04-24 13:24:01');
INSERT INTO `easybuy_news` VALUES (8, ' \"共建共赢：农场租赁与农产品销售的新篇章\"', '近日，我们见证了一个农业领域的新合作模式——农场租赁与农产品销售的深度融合。这一创新模式旨在解决租赁期间农作物销售问题，促进农业经济的持续发展。\r\n\r\n据了解，租赁双方在签订合同时，已经明确约定了农作物的销售权。这种做法确保了出租方在销售过程中的主导地位，同时也充分考虑了承租方的建议和意见。这样的协商机制不仅保证了双方的权益，也有助于建立长期稳定的合作关系。\r\n\r\n此外，双方还就农作物销售的责任与分配进行了细致的约定。通过明确的责任划分，出租方和承租方能够共同参与到农作物的销售决策中，确保农产品的顺利销售，同时也实现了资源的优化配置。\r\n\r\n这一模式的出现，为农业领域带来了新的活力。它不仅优化了农作物的销售流程，减少了中间环节，还为农民提供了更多的销售选择。同时，这也促进了农场租赁市场的健康发展，为农业经济的可持续发展奠定了基础。\r\n\r\n专家表示，这一模式是对传统农业经营方式的创新和提升，有助于推动农业现代化进程。未来，随着更多实践经验的积累，这一模式有望在更广泛的范围内得到推广和应用。\r\n\r\n若您想要探索更多内容，随时可以继续输入。', '2018-04-24 13:24:49');

-- ----------------------------
-- Table structure for easybuy_order
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order`  (
  `EO_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EO_USER_ID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EO_USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EO_USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EO_CREATE_TIME` datetime NOT NULL,
  `EO_COST` decimal(10, 2) NOT NULL,
  `EO_STATUS` decimal(6, 0) NOT NULL,
  `EO_TYPE` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`EO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_order
-- ----------------------------
INSERT INTO `easybuy_order` VALUES (8, 'admin', '管理员', '上海', '2024-01-09 14:12:35', 16.00, 1, 1);

-- ----------------------------
-- Table structure for easybuy_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail`  (
  `EOD_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EO_ID` decimal(10, 0) NOT NULL,
  `EP_ID` decimal(10, 0) NOT NULL,
  `EOD_QUANTITY` decimal(6, 0) NOT NULL,
  `EOD_COST` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`EOD_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_order_detail
-- ----------------------------
INSERT INTO `easybuy_order_detail` VALUES (11, 8, 20, 1, 16.00);

-- ----------------------------
-- Table structure for easybuy_product
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product`  (
  `EP_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EP_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EP_DESCRIPTION` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EP_PRICE` decimal(10, 2) NOT NULL,
  `EP_STOCK` decimal(10, 0) NOT NULL,
  `EPC_ID` decimal(10, 0) NULL DEFAULT NULL,
  `EPC_CHILD_ID` decimal(10, 0) NULL DEFAULT NULL,
  `EP_FILE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EP_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES (20, '袁隆平爷爷的杰作', '袁隆平爷爷的杰作', 16.00, 18, 16, 20, 'goods1438050944_m.jpg');
INSERT INTO `easybuy_product` VALUES (21, '小麦', '小麦', 27.00, 22, 16, 21, 'goods13772354821288127790_m.jpg');
INSERT INTO `easybuy_product` VALUES (22, '玉米', '玉米', 23.00, 45, 16, 22, '201308231504346196_m.jpg');
INSERT INTO `easybuy_product` VALUES (24, '高粱', '高粱', 32.00, 32, 16, 23, 'goods1438591037_m.jpg');
INSERT INTO `easybuy_product` VALUES (25, '樱桃', '樱桃', 4.00, 323, 17, 24, 'goods1411022636_m.jpg');
INSERT INTO `easybuy_product` VALUES (26, '菠萝', '菠萝', 33.00, 32, 17, 25, 'u=4093368452,440755421&fm=27&gp=0.jpg');
INSERT INTO `easybuy_product` VALUES (27, '草莓', '草莓', 12.00, 323, 17, 26, 'u=189404210,2788192053&fm=27&gp=0.jpg');
INSERT INTO `easybuy_product` VALUES (28, '山药', '山药', 32.00, 3223, 18, 27, 'goods13801796061288130653_m.jpg');
INSERT INTO `easybuy_product` VALUES (29, '香菇', '香菇', 8.00, 32, 18, 28, 'u=702189391,3456313470&fm=58.jpg');
INSERT INTO `easybuy_product` VALUES (30, '番茄', '番茄', 44.00, 323, 18, 29, 'u=1921186747,914205630&fm=200&gp=0.jpg');
INSERT INTO `easybuy_product` VALUES (31, '蜂蜜', '蜂蜜', 33.00, 32, 19, 30, 'u=2313857963,2992583774&fm=58&bpow=650&bpoh=433.jpg');
INSERT INTO `easybuy_product` VALUES (32, '豆腐', '豆腐', 78.00, 323, 19, 31, 'u=3416364401,1008420908&fm=202&src=781&mola=new&crop=v1.jpg');
INSERT INTO `easybuy_product` VALUES (33, '虾', '虾', 323.00, 888, 19, 32, 'u=3893092790,864232993&fm=27&gp=0.jpg');

-- ----------------------------
-- Table structure for easybuy_product_category
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category`  (
  `EPC_ID` int(10) NOT NULL AUTO_INCREMENT,
  `EPC_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EPC_PARENT_ID` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`EPC_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_product_category
-- ----------------------------
INSERT INTO `easybuy_product_category` VALUES (16, '粮食作物', 0);
INSERT INTO `easybuy_product_category` VALUES (17, '水果', 0);
INSERT INTO `easybuy_product_category` VALUES (18, '蔬菜', 0);
INSERT INTO `easybuy_product_category` VALUES (19, '其他农副产品', 0);
INSERT INTO `easybuy_product_category` VALUES (20, '稻谷', 16);
INSERT INTO `easybuy_product_category` VALUES (21, '小麦', 16);
INSERT INTO `easybuy_product_category` VALUES (22, '玉米', 16);
INSERT INTO `easybuy_product_category` VALUES (23, '高粱', 16);
INSERT INTO `easybuy_product_category` VALUES (24, '樱桃', 17);
INSERT INTO `easybuy_product_category` VALUES (25, '菠萝', 17);
INSERT INTO `easybuy_product_category` VALUES (26, '草莓', 17);
INSERT INTO `easybuy_product_category` VALUES (27, '山药', 18);
INSERT INTO `easybuy_product_category` VALUES (28, '香菇', 18);
INSERT INTO `easybuy_product_category` VALUES (29, '番茄', 18);
INSERT INTO `easybuy_product_category` VALUES (30, '蜂蜜', 19);
INSERT INTO `easybuy_product_category` VALUES (31, '豆腐', 19);
INSERT INTO `easybuy_product_category` VALUES (32, '虾', 19);

-- ----------------------------
-- Table structure for easybuy_shop
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_shop`;
CREATE TABLE `easybuy_shop`  (
  `es_id` int(11) NOT NULL AUTO_INCREMENT,
  `es_ep_file_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `es_ep_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `es_ep_price` decimal(10, 0) NULL DEFAULT NULL,
  `es_eod_quantity` int(11) NULL DEFAULT NULL,
  `es_ep_stock` int(11) NULL DEFAULT NULL,
  `es_ep_id` int(11) NULL DEFAULT NULL,
  `es_eu_user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `es_valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`es_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_shop
-- ----------------------------
INSERT INTO `easybuy_shop` VALUES (12, 'goods1438050944_m.jpg', '袁隆平爷爷的杰作', 16, 1, 19, 20, 'admin', 2);

-- ----------------------------
-- Table structure for easybuy_user
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user`  (
  `EU_USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EU_BIRTHDAY` datetime NULL DEFAULT NULL,
  `EU_IDENTITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_EMAIL` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EU_STATUS` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`EU_USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('admin', '管理员', 'admin', 'T', '2018-04-11 00:00:00', NULL, 'llqqxf@163.com', '13666666666', '上海', 2);
INSERT INTO `easybuy_user` VALUES ('zyl', '长', '123', 'T', '2024-01-16 00:00:00', NULL, '2239485748@qq.com', '13456633222', '奥欧尼亚', 1);
INSERT INTO `easybuy_user` VALUES ('猿来入此', '小张', '123456', 'T', '2018-12-13 00:00:00', NULL, 'llqqxf@163.com', '13666666666', '上海市 浦东新区  ', 1);

SET FOREIGN_KEY_CHECKS = 1;
