# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: v5cms
# Generation Time: 2015-08-09 09:02:39 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table adv
# ------------------------------------------------------------

DROP TABLE IF EXISTS `adv`;

CREATE TABLE `adv` (
  `advId` bigint(20) NOT NULL AUTO_INCREMENT,
  `advName` varchar(200) NOT NULL COMMENT '广告名称',
  `advType` int(11) NOT NULL COMMENT '广告类型1:图片，2：Flash，3：文字，4：代码',
  `advPosId` bigint(20) NOT NULL COMMENT '广告版位ID',
  `advCode` varchar(3000) DEFAULT NULL COMMENT '广告代码',
  `advStartTime` date DEFAULT NULL COMMENT '广告开始时间',
  `advEndTime` date DEFAULT NULL COMMENT '广告结束时间',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `advTypeInfo` varchar(3000) DEFAULT NULL COMMENT '广告类型信息JSON字符串',
  `startUsing` int(11) DEFAULT '0' COMMENT '广告状态1：启用，0：关闭',
  PRIMARY KEY (`advId`),
  KEY `FK_38p04ou19ne63k5bm55k0bl55` (`advPosId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='广告表';

LOCK TABLES `adv` WRITE;
/*!40000 ALTER TABLE `adv` DISABLE KEYS */;

INSERT INTO `adv` (`advId`, `advName`, `advType`, `advPosId`, `advCode`, `advStartTime`, `advEndTime`, `createDate`, `advTypeInfo`, `startUsing`)
VALUES
	(10000,'广告1',3,10000,'','2014-07-30','2014-08-06','2014-07-30 14:36:36','{\"adv_text_color\":\"#d41c1c\",\"adv_text_content\":\"广告1\",\"adv_text_link\":\"http://www.baidu.com\",\"adv_text_openType\":\"_blank\",\"adv_text_size\":\"21px\"}',1);

/*!40000 ALTER TABLE `adv` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table advpos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advpos`;

CREATE TABLE `advpos` (
  `advPosId` bigint(20) NOT NULL AUTO_INCREMENT,
  `advPosName` varchar(100) NOT NULL COMMENT '版位名称',
  `advPosState` int(11) DEFAULT '0' COMMENT '状态0:关闭，1:启用',
  `advPosDes` varchar(2000) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`advPosId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='广告版位';

LOCK TABLES `advpos` WRITE;
/*!40000 ALTER TABLE `advpos` DISABLE KEYS */;

INSERT INTO `advpos` (`advPosId`, `advPosName`, `advPosState`, `advPosDes`)
VALUES
	(10000,'页头banner',1,'页头banner');

/*!40000 ALTER TABLE `advpos` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table banner
# ------------------------------------------------------------

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `bannerId` bigint(110) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(200) NOT NULL COMMENT 'banner名称',
  `bannerPic` varchar(1000) NOT NULL COMMENT 'banner图片',
  `bannerLink` varchar(200) DEFAULT NULL COMMENT 'banner跳转链接',
  `isstart` int(11) DEFAULT '0' COMMENT '是否启用，1：启用，0：不启用',
  `bannerds` int(11) DEFAULT NULL COMMENT 'banner显示顺序',
  `bcontent` text COMMENT '设置banner上显示的文本',
  PRIMARY KEY (`bannerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='banner表';

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;

INSERT INTO `banner` (`bannerId`, `bannerName`, `bannerPic`, `bannerLink`, `isstart`, `bannerds`, `bcontent`)
VALUES
	(10000,'3','banner/1384961216.jpg',NULL,1,3,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),
	(10002,'2','banner/1385462644.jpg',NULL,1,2,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),
	(10003,'1','banner/1385462613.jpg',NULL,1,1,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),
	(10006,'4','banner/1385465240.jpg',NULL,1,5,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),
	(10007,'5','banner/1385532115.jpg',NULL,1,4,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>');

/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cols
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cols`;

CREATE TABLE `cols` (
  `colsId` bigint(110) NOT NULL AUTO_INCREMENT,
  `columnName` varchar(200) NOT NULL COMMENT '栏目名称',
  `colTypeId` bigint(110) DEFAULT NULL COMMENT '栏目类型',
  `sortNum` int(11) DEFAULT NULL COMMENT '栏目显示顺序',
  `columndisplay` int(11) DEFAULT NULL COMMENT '是否显示',
  `openWay` varchar(20) DEFAULT NULL COMMENT '连接打开方式',
  `columnOutside` varchar(1000) DEFAULT NULL COMMENT '外链地址',
  `columnpic` varchar(200) DEFAULT NULL COMMENT '栏目图片',
  `parentId` int(11) DEFAULT NULL COMMENT '父栏目ID',
  `parentIds` varchar(200) DEFAULT NULL COMMENT 'treetable排序使用',
  `siteId` bigint(110) NOT NULL COMMENT '栏目所属站点',
  PRIMARY KEY (`colsId`),
  KEY `FK_k4569jw8smav0a9o9ewriq0pt` (`colTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章标签表';

LOCK TABLES `cols` WRITE;
/*!40000 ALTER TABLE `cols` DISABLE KEYS */;

INSERT INTO `cols` (`colsId`, `columnName`, `colTypeId`, `sortNum`, `columndisplay`, `openWay`, `columnOutside`, `columnpic`, `parentId`, `parentIds`, `siteId`)
VALUES
	(10002,'Lucene',1000,5,1,'_self','','',0,'0/',10005),
	(10003,'Java',1000,3,1,'_self','','',0,'0/',10005),
	(10004,'WorldWind',1000,2,1,'_self','','columnpic/1385431453.png',0,'0/',10005),
	(10005,'Solr',1006,0,1,'_self','','',10002,'0/10002/',10005),
	(10008,'Web前端',1006,0,1,'_self','','',0,'0/',10005),
	(10009,'jQuery',1006,0,1,'_self','','',10008,'0/10008/',10005),
	(10010,'jQueryEasyUI',1004,1,1,'_self','','',10008,'0/10008/',10005),
	(10015,'Struts2',1000,0,1,'_self','','',10003,'0/10003/',10005),
	(10016,'Swing',1004,1,1,'_self','','',10003,'0/10003/',10005),
	(10019,'新闻',1000,5,1,'_self','','',10008,'0/10008/',10005);

/*!40000 ALTER TABLE `cols` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table coltype
# ------------------------------------------------------------

DROP TABLE IF EXISTS `coltype`;

CREATE TABLE `coltype` (
  `colTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `colTypeName` varchar(200) NOT NULL COMMENT '类型名称',
  `coltpl` varchar(200) NOT NULL COMMENT '栏目模板名称',
  `contenttpl` varchar(200) DEFAULT NULL COMMENT '内容模板名称',
  `colsort` int(11) NOT NULL DEFAULT '0' COMMENT '栏目排序',
  `hasContent` int(11) DEFAULT NULL COMMENT '是否有内容页',
  `isDisabled` int(11) DEFAULT NULL COMMENT '是否可用',
  `siteId` bigint(110) NOT NULL COMMENT '栏目类型所属站点',
  PRIMARY KEY (`colTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='栏目类型表';

LOCK TABLES `coltype` WRITE;
/*!40000 ALTER TABLE `coltype` DISABLE KEYS */;

INSERT INTO `coltype` (`colTypeId`, `colTypeName`, `coltpl`, `contenttpl`, `colsort`, `hasContent`, `isDisabled`, `siteId`)
VALUES
	(1000,'新闻2','news2.ftl','news-detail.ftl',0,0,1,10005),
	(1004,'新闻3','news3.ftl','products-detail.ftl',0,0,1,10005),
	(1005,'测试2','about.ftl','about.ftl',0,0,1,10005),
	(1006,'新闻','news.ftl','news-detail.ftl',0,0,1,10005),
	(1007,'a','about.ftl','about.ftl',0,0,1,10005),
	(1008,'ddd','news.ftl','about.ftl',0,0,1,10005),
	(1009,'dd','news.ftl','about.ftl',0,0,1,10005),
	(1010,'d','about.ftl','about.ftl',0,0,1,10005),
	(1011,'ddd','about.ftl','about.ftl',0,0,1,10005),
	(1012,'ddd','about.ftl','about.ftl',0,0,1,10005),
	(1013,'dddd','about.ftl','about.ftl',0,0,1,10005),
	(1014,'addda','about.ftl','about.ftl',0,0,1,10005),
	(1015,'dda','about.ftl','about.ftl',0,0,1,10005),
	(1016,'adfdf','about.ftl','about.ftl',0,0,1,10005),
	(1017,'dddd','about.ftl','about.ftl',0,0,1,10005),
	(1018,'aaaa','about.ftl','about.ftl',0,0,1,10005),
	(1019,'ddd','about.ftl','about.ftl',0,0,1,10005),
	(1020,'aaaa','about.ftl','about.ftl',0,0,1,10005),
	(1021,'sdfsdf','about.ftl','about.ftl',0,0,1,10005),
	(1022,'dsfdfsdf','about.ftl','about.ftl',0,0,1,10005),
	(1023,'dsdf','about.ftl','contact.ftl',0,0,1,10005),
	(1024,'sdfsdf','about.ftl','about.ftl',0,0,1,10005),
	(1025,'sdfsdf','about.ftl','about.ftl',0,0,1,10005),
	(1026,'d','about.ftl','about.ftl',0,0,1,10005),
	(1027,'sdfsdfsdf','about.ftl','about.ftl',0,0,1,10005),
	(1028,'ddd','about.ftl','about.ftl',0,0,1,10005);

/*!40000 ALTER TABLE `coltype` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table comments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `commentsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `contentId` bigint(20) NOT NULL COMMENT '评语所属内容ID',
  `commentAuthor` varchar(100) NOT NULL COMMENT '评论者姓名',
  `email` varchar(100) NOT NULL COMMENT '评论者的Email地址',
  `commentContent` longtext NOT NULL COMMENT '评语内容',
  `reply` longtext COMMENT '评论回复',
  `siteURL` varchar(500) DEFAULT NULL COMMENT '评论者的站点URL',
  `commentIP` varchar(200) DEFAULT NULL COMMENT '评语者的IP地址',
  `commentDate` datetime DEFAULT NULL COMMENT '评语时间',
  `recommend` int(11) DEFAULT '0' COMMENT '是否推荐',
  `commentApproved` int(11) DEFAULT '0' COMMENT '评语是否批准 0:待审批，1:通过审批，2:垃圾评语',
  `commentParent` bigint(20) DEFAULT '0' COMMENT '父评语ID',
  PRIMARY KEY (`commentsId`),
  KEY `FK_r5l8mupp8i3dkqye48l6ydwvy` (`contentId`),
  CONSTRAINT `FK_r5l8mupp8i3dkqye48l6ydwvy` FOREIGN KEY (`contentId`) REFERENCES `content` (`contentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评语表';



# Dump of table content
# ------------------------------------------------------------

DROP TABLE IF EXISTS `content`;

CREATE TABLE `content` (
  `contentId` bigint(110) NOT NULL AUTO_INCREMENT,
  `columnId` bigint(110) DEFAULT NULL COMMENT '所属栏目ID',
  `cname` varchar(500) NOT NULL COMMENT '内容标题',
  `cbody` text COMMENT '发布的内容',
  `lastdt` datetime DEFAULT NULL COMMENT '最后更新的时间',
  `stick` int(11) DEFAULT NULL COMMENT '是否置顶，1：置顶，0：反之',
  `stickNum` int(11) DEFAULT NULL COMMENT '置顶序号，只有是置顶状态，才起作用',
  `cpics` varchar(2000) DEFAULT NULL COMMENT '与文章关联的图片',
  `cattas` varchar(1000) DEFAULT NULL COMMENT '文章中使用的附件，多个使用丢号分割',
  `dispic` varchar(200) DEFAULT NULL COMMENT '展示图',
  `writerId` bigint(110) DEFAULT NULL COMMENT '作者ID',
  `author` varchar(255) DEFAULT NULL,
  `contentDes` varchar(255) DEFAULT NULL,
  `contentKey` varchar(255) DEFAULT NULL,
  `outside` int(11) DEFAULT NULL,
  `outsideURL` varchar(255) DEFAULT NULL,
  `publishDT` varchar(255) DEFAULT NULL,
  `siteId` bigint(20) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `sourceURL` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '内容状态，2：发布，1：待审核，0：草稿',
  `allowComment` int(11) DEFAULT '0' COMMENT '是否允许评论，1：运行 0：禁止',
  `titleBold` int(11) DEFAULT NULL,
  `titleColor` varchar(255) DEFAULT NULL,
  `titleItalic` int(11) DEFAULT NULL,
  PRIMARY KEY (`contentId`),
  KEY `FK_k1h1131b4uj8qpsivxll3m2vo` (`columnId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='创建内容表';

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;

INSERT INTO `content` (`contentId`, `columnId`, `cname`, `cbody`, `lastdt`, `stick`, `stickNum`, `cpics`, `cattas`, `dispic`, `writerId`, `author`, `contentDes`, `contentKey`, `outside`, `outsideURL`, `publishDT`, `siteId`, `source`, `sourceURL`, `state`, `allowComment`, `titleBold`, `titleColor`, `titleItalic`)
VALUES
	(10017,10009,'jquery入门','<p>jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386148510.jpg\"/></p>','2013-12-09 22:35:49',0,0,'','','',10000,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,NULL,0,0,NULL,NULL,NULL),
	(10018,10004,'WorldWind入门','<p>WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门</p>','2013-12-10 21:11:28',0,0,'','','',10000,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,NULL,1,0,NULL,NULL,NULL),
	(10019,10015,'Struts2入门','<p>Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386141341.jpg\"/></p>','2013-12-10 21:28:58',0,0,'','','',10000,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,NULL,1,0,NULL,NULL,NULL),
	(10020,10016,'Swing入门','<p>Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门</p><pre class=\"brush:php;toolbar:false\">if($m&nbsp;===&nbsp;&#39;cont_list&#39;){\n&nbsp;&nbsp;&nbsp;&nbsp;$cid&nbsp;=&nbsp;$_GET[&#39;cid&#39;];\n\n&nbsp;&nbsp;&nbsp;&nbsp;if($cid){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$wsql&nbsp;=&nbsp;&quot;SELECT&nbsp;c.tbId&nbsp;as&nbsp;tbId,cname,columnName,managerLoginname,managername,lastdt,stick,stickNum,publish&nbsp;FROM&nbsp;(SELECT&nbsp;*&nbsp;FROM&nbsp;content&nbsp;WHERE&nbsp;columnId&nbsp;IN&nbsp;(SELECT&nbsp;tbId&nbsp;FROM&nbsp;cols&nbsp;WHERE&nbsp;parentId&nbsp;=&nbsp;$cid&nbsp;OR&nbsp;tbId=$cid))&nbsp;AS&nbsp;c&nbsp;INNER&nbsp;JOIN&nbsp;cols&nbsp;AS&nbsp;cls&nbsp;INNER&nbsp;JOIN&nbsp;manager&nbsp;AS&nbsp;m&nbsp;WHERE&nbsp;c.columnId&nbsp;=&nbsp;cls.tbId&nbsp;AND&nbsp;c.writerId&nbsp;=&nbsp;m.tbId&quot;;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$totalCount&nbsp;=&nbsp;v5_complex(&#39;content&#39;,$wsql,0,0,2,&quot;&quot;);\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$pInfo&nbsp;=&nbsp;new&nbsp;Pagination($totalCount,PAGE_COUNT);\n\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$conts&nbsp;=&nbsp;v5_complex(&#39;content&#39;,$wsql,$pInfo-&gt;getStartCount(),$pInfo-&gt;getPageCount(),1,&#39;&#39;,&#39;tbId&nbsp;desc&#39;);\n&nbsp;&nbsp;&nbsp;&nbsp;}else{\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result&nbsp;=&nbsp;find_all_content();\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$pInfo&nbsp;=&nbsp;$result[1];\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$conts&nbsp;=&nbsp;$result[0];\n&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;include_once&nbsp;M_VIEW_PATH.&#39;content&#39;.DIRECTORY_SEPARATOR.&#39;content_list.php&#39;;\n}</pre><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386148510.jpg\"/></p>','2013-12-11 21:13:29',0,0,'','','',10000,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,NULL,2,0,NULL,NULL,NULL),
	(10021,10005,'Solr入门（1）','<p>Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）<img src=\"/v5cms/res/uploads/10005/content/image/20150806/1438875404457020097.jpg\" title=\"1438875404457020097.jpg\" alt=\"20130814153055714.jpg\"/></p>','2015-08-06 23:37:19',1,1,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10022,10005,'Solr入门（2）','<p>Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）</p>','2013-12-15 21:52:20',0,0,'','','contentpic/1387115510.jpg',10000,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,NULL,2,0,NULL,NULL,NULL),
	(10023,10005,'Solr入门（3）','<p>Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）</p>','2015-07-20 15:26:39',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10024,10019,'Swing晋级','<p>Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1387115518.jpg\"/><br/></p><pre class=\"brush:php;toolbar:false\">//递归输出栏目为&lt;option&nbsp;value=&quot;&quot;&gt;&lt;option&gt;\r\nfunction&nbsp;columnprint($columnId,$pid=0,$retract=&quot;&quot;){\r\n&nbsp;&nbsp;&nbsp;&nbsp;$result&nbsp;=&nbsp;&quot;&quot;;\r\n&nbsp;&nbsp;&nbsp;&nbsp;$pid_zero&nbsp;=&nbsp;v5_select(&#39;cols&#39;,1,&quot;and&nbsp;parentId=$pid&nbsp;and&nbsp;columndisplay=1&quot;,&#39;*&#39;,&#39;columnds&nbsp;ASC&#39;);\r\n&nbsp;&nbsp;&nbsp;&nbsp;if(!$pid&nbsp;&amp;&amp;&nbsp;!count($pid_zero)){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;&quot;&lt;option&nbsp;value=&#39;&#39;&gt;--还没有栏目--&lt;/option&gt;&quot;;\r\n&nbsp;&nbsp;&nbsp;&nbsp;}\r\n&nbsp;&nbsp;&nbsp;&nbsp;foreach($pid_zero&nbsp;as&nbsp;$zero){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$tbId&nbsp;=&nbsp;$zero-&gt;getTbId();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$name&nbsp;=&nbsp;$zero-&gt;getColumnName();\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if($columnId&nbsp;==&nbsp;$tbId){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=&nbsp;&quot;&lt;option&nbsp;value=&#39;$tbId&#39;&nbsp;selected&gt;&quot;.$retract.$name.&#39;&lt;/option&gt;&#39;;\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}else{\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=&nbsp;&quot;&lt;option&nbsp;value=&#39;$tbId&#39;&gt;&quot;.$retract.$name.&#39;&lt;/option&gt;&#39;;\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$count&nbsp;=&nbsp;v5_select(&#39;cols&#39;,3,&quot;and&nbsp;parentId=$tbId&quot;);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if($count){\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=columnprint($columnId,$tbId,$retract.&quot;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&quot;);\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\r\n&nbsp;&nbsp;&nbsp;&nbsp;}\r\n&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;$result;\r\n}</pre><p>淡淡的<br/></p>','2015-07-20 15:26:59',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10025,10005,'dadafdf','<p>sdfasdfsdf</p>','2015-07-20 15:12:45',0,0,NULL,NULL,NULL,NULL,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10026,10005,'测试3','<p>测试3测试3测试3测试3测试3测试3测试3测试3测试3测试3</p>','2015-07-20 15:12:21',0,0,NULL,NULL,NULL,NULL,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10027,10005,'dfsdf','<p>sdfsdfsdfsdfdf</p>','2015-08-05 23:50:54',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,1,NULL,'',NULL),
	(10028,10005,'Sorl新','<p>Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新Sorl新</p>','2015-08-06 21:28:28',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,1,NULL,'',NULL),
	(10029,10005,'Solr新2','<p>Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2Solr新2</p>','2015-08-06 21:35:02',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,1,NULL,'',NULL),
	(10030,10008,'Web前端2','<p>Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2Web前端2</p>','2015-08-06 21:37:28',1,8,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10031,10008,'Web前端3','<p>Web前端3Web前端3Web前端3Web前端3Web前端3Web前端3Web前端3Web前端3Web前端3Web前端3</p>','2015-08-06 21:38:38',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,1,NULL,'',NULL),
	(10032,10008,'Web前端4','<p>Web前端4Web前端4Web前端4Web前端4Web前端4Web前端4Web前端4</p>','2015-08-06 21:39:44',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL),
	(10033,10010,'jQueryEasyUI2','<p>jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2jQueryEasyUI2</p>','2015-08-06 21:43:27',0,0,NULL,NULL,NULL,1000,'','','',0,'','',10005,'','',2,0,NULL,'',NULL);

/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table content_label
# ------------------------------------------------------------

DROP TABLE IF EXISTS `content_label`;

CREATE TABLE `content_label` (
  `content_labelId` bigint(110) NOT NULL AUTO_INCREMENT,
  `contentId` int(11) DEFAULT NULL,
  `labelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`content_labelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章标签中间表';

LOCK TABLES `content_label` WRITE;
/*!40000 ALTER TABLE `content_label` DISABLE KEYS */;

INSERT INTO `content_label` (`content_labelId`, `contentId`, `labelId`)
VALUES
	(10007,10017,10005),
	(10008,10017,10009),
	(10009,10017,10018),
	(10010,10018,10007),
	(10011,10018,10019),
	(10012,10019,10019),
	(10013,10019,10011),
	(10014,10020,10019),
	(10015,10020,10020),
	(10016,10021,10008),
	(10017,10021,10019),
	(10018,10022,10008),
	(10019,10022,10019),
	(10020,10023,10008),
	(10021,10023,10019),
	(10022,10024,10006),
	(10023,10024,10009);

/*!40000 ALTER TABLE `content_label` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table label
# ------------------------------------------------------------

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `labelId` bigint(110) NOT NULL AUTO_INCREMENT,
  `labelName` varchar(200) NOT NULL COMMENT '标签名称',
  `alias` varchar(200) DEFAULT NULL COMMENT '标签别名',
  PRIMARY KEY (`labelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;

INSERT INTO `label` (`labelId`, `labelName`, `alias`)
VALUES
	(10005,'Web前端','Web前端'),
	(10006,'Lucene','Lucene'),
	(10007,'WorldWind','WorldWind'),
	(10008,'Solr','Solr'),
	(10009,'jquery','jquery'),
	(10010,'bootstarp','bootstarp'),
	(10011,'Struts2','Struts2'),
	(10012,'SpringMVC','SpringMVC'),
	(10013,'Node.js','Node.js'),
	(10014,'PHP','PHP'),
	(10015,'Python','Python'),
	(10018,'jqueryeasyui','jqueryeasyui'),
	(10019,'java','java'),
	(10020,'swing','swing');

/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table leave_word
# ------------------------------------------------------------

DROP TABLE IF EXISTS `leave_word`;

CREATE TABLE `leave_word` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lwtId` bigint(20) DEFAULT NULL COMMENT '留言类型ID',
  `title` varchar(500) NOT NULL COMMENT '留言标题',
  `content` longtext NOT NULL COMMENT '留言内容',
  `reply` longtext COMMENT '回复内容',
  `author` varchar(100) DEFAULT NULL COMMENT '留言作者',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `recommend` int(11) DEFAULT '0' COMMENT '是否推荐，1：推荐，0：不推荐',
  `approved` int(11) DEFAULT '0' COMMENT '留言是否批准 0:待审批，1:通过审批，2:垃圾评语',
  `lwtime` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`),
  KEY `FK_3e6kv5mrpkii2uruvqi7ex66f` (`lwtId`),
  CONSTRAINT `FK_3e6kv5mrpkii2uruvqi7ex66f` FOREIGN KEY (`lwtId`) REFERENCES `leave_word_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table leave_word_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `leave_word_type`;

CREATE TABLE `leave_word_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '留言类型名称',
  `sortNum` int(11) DEFAULT NULL COMMENT '留言类型顺序',
  `lwdes` varchar(2000) DEFAULT NULL COMMENT '留言类型描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table link
# ------------------------------------------------------------

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `linkId` bigint(110) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(200) NOT NULL COMMENT '连接名称',
  `link` varchar(1000) NOT NULL COMMENT '连接',
  `linkPic` varchar(200) DEFAULT NULL COMMENT '连接图片',
  `openType` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `isstart` int(11) DEFAULT NULL COMMENT '是否启用。1：启用，2：不启用',
  PRIMARY KEY (`linkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;

INSERT INTO `link` (`linkId`, `linkName`, `link`, `linkPic`, `openType`, `isstart`)
VALUES
	(10008,'ssss','http://www.v5cn.cn','linkpic/1384694319.jpg','_blank',0);

/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table site
# ------------------------------------------------------------

DROP TABLE IF EXISTS `site`;

CREATE TABLE `site` (
  `siteId` bigint(110) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(100) NOT NULL COMMENT '网站标题',
  `domain` varchar(200) NOT NULL COMMENT '网站域名，必须唯一',
  `protocol` varchar(100) NOT NULL COMMENT '访问协议，http://或者https://',
  `siteDeputyTitle` varchar(200) DEFAULT NULL COMMENT '网站副标题',
  `siteKey` varchar(500) DEFAULT NULL COMMENT '网站关键字',
  `siteDescribed` varchar(1000) DEFAULT NULL COMMENT '网站描述',
  `createDate` varchar(50) NOT NULL COMMENT '创建时间',
  `siteicp` varchar(100) DEFAULT NULL COMMENT '网站备案号',
  `siteStatisticCode` varchar(3000) DEFAULT NULL COMMENT '统计代码',
  `siteFooterInfo` varchar(3000) DEFAULT NULL COMMENT '网站底部信息',
  `isclosesite` int(11) DEFAULT '0' COMMENT '网站是否关闭 1关闭    0 开启',
  `themeName` varchar(200) DEFAULT 'default' COMMENT '使用的网站主题名称',
  PRIMARY KEY (`siteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='网站信息表';

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;

INSERT INTO `site` (`siteId`, `siteName`, `domain`, `protocol`, `siteDeputyTitle`, `siteKey`, `siteDescribed`, `createDate`, `siteicp`, `siteStatisticCode`, `siteFooterInfo`, `isclosesite`, `themeName`)
VALUES
	(10005,'V5CMS','localhost:8080','http://','java,WorldWind,Lucene','java,WorldWind,Lucene,Spring,SpringMVC','讲述java,WorldWind,Lucene,Spring,SpringMVC的博客网站','2015-07-22 12:59:56','陕ICP','<script type=\"text/javascript\">\r\nvar _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\r\ndocument.write(unescape(\"%3Cscript src=\'\" + _bdhmProtocol + \"hm.baidu.com/h.js%3Fbff6c22bb9ae0fcbf0fc35e23b9b02e8\' type=\'text/javascript\'%3E%3C/script%3E\"));\r\n</script>','<h3>V5Blog 平常心博客</h3>',1,'default'),
	(10010,'DemoSite','localhost:8081','https://','','DemoSite','DemoSite','2014-11-24 11:06:21','DemoSite','DemoSite','DemoSite',1,'default2');

/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_res
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_res`;

CREATE TABLE `system_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(111) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sortNum` int(11) DEFAULT '1',
  `icon` varchar(100) DEFAULT NULL,
  `pids` varchar(100) DEFAULT NULL COMMENT 'TreeTable排序',
  `type` int(1) DEFAULT '2' COMMENT '1 菜单 2 按钮',
  `available` int(11) DEFAULT '1' COMMENT '1 可用 0 不可用',
  `des` varchar(255) DEFAULT NULL,
  `isParent` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `system_res` WRITE;
/*!40000 ALTER TABLE `system_res` DISABLE KEYS */;

INSERT INTO `system_res` (`id`, `pid`, `name`, `permission`, `url`, `sortNum`, `icon`, `pids`, `type`, `available`, `des`, `isParent`)
VALUES
	(3,0,'仪表盘','index:view','/index',0,'fa-dashboard','0/',1,1,'仪表盘',00000000),
	(4,0,'系统管理','system:*','',2,NULL,'0/',1,1,'系统管理一级菜单',00000000),
	(5,4,'资源管理','res:view','/res/list',0,NULL,'0/4/',1,1,'资源管理',00000000),
	(6,4,'角色管理','role:view','/role/list/1',1,NULL,'0/4/',1,1,'角色管理',00000000),
	(7,4,'用户管理','user:view','/user/list/1',2,NULL,'0/4/',1,1,'用户管理',00000000),
	(8,5,'资源新增','res:create','',0,NULL,'0/4/5/',2,1,'资源新增',00000000),
	(9,5,'资源修改','res:update','',1,NULL,'0/4/5/',2,1,'资源修改',00000000),
	(10,5,'资源删除','res:delete','',2,NULL,'0/4/5/',2,1,'资源删除',00000000),
	(11,6,'角色新增','role:create','',0,'','0/4/6/',2,1,'角色新增',00000000),
	(12,6,'角色修改','role:update','',1,'','0/4/6/',2,1,'角色修改',00000000),
	(13,6,'角色删除','role:delete','',2,'','0/4/6/',2,1,'角色删除',00000000),
	(14,7,'用户新增','user:create','',0,'','0/4/7/',2,0,'用户新增',00000000),
	(15,7,'用户修改','user:update','',1,NULL,'0/4/7/',2,1,'用户修改',00000000),
	(16,7,'用户删除','user:delete','',2,NULL,'0/4/7/',2,1,'用户删除',00000000),
	(17,7,'用户密码修改','user:pwd:update','',3,NULL,'0/4/7/',2,1,'用户密码修改',00000000);

/*!40000 ALTER TABLE `system_res` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_role`;

CREATE TABLE `system_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) DEFAULT NULL,
  `sortNum` int(11) DEFAULT '1',
  `pid` bigint(20) DEFAULT '0',
  `des` varchar(55) DEFAULT NULL,
  `available` int(11) DEFAULT '1' COMMENT '1 可用 0 不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `system_role` WRITE;
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;

INSERT INTO `system_role` (`id`, `name`, `sortNum`, `pid`, `des`, `available`)
VALUES
	(9,'admin',1,0,'超级管理员',1),
	(10,'超级管理员',3,0,'超级管理员',1),
	(15,'网站编辑',10,0,'网站编辑',1),
	(16,'test1',20,0,'是的方式的',0),
	(17,'主站管理员',1,NULL,'主站管理员',1),
	(18,'站点编辑',2,NULL,'站点编辑',1),
	(19,'a',NULL,NULL,'',1),
	(20,'网站策划',5,NULL,'网站策划',1),
	(21,'ab',0,NULL,'abdef',1);

/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_role_res
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_role_res`;

CREATE TABLE `system_role_res` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SYSTEM_ROLE_RES_RES_ID` (`res_id`),
  KEY `FK_SYSTEM_ROLE_RES_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_SYSTEM_ROLE_RES_RES_ID` FOREIGN KEY (`res_id`) REFERENCES `system_res` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SYSTEM_ROLE_RES_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `system_role_res` WRITE;
/*!40000 ALTER TABLE `system_role_res` DISABLE KEYS */;

INSERT INTO `system_role_res` (`id`, `res_id`, `role_id`)
VALUES
	(29,4,10),
	(30,3,10),
	(31,5,10),
	(32,6,10),
	(33,7,10),
	(34,8,10),
	(35,9,10),
	(104,4,9),
	(105,3,9),
	(106,5,9),
	(107,6,9),
	(108,7,9),
	(109,8,9),
	(110,9,9),
	(111,10,9),
	(112,11,9),
	(113,12,9),
	(114,13,9),
	(115,14,9),
	(116,15,9),
	(117,16,9),
	(118,17,9),
	(119,3,16),
	(120,4,15),
	(121,6,15),
	(122,11,15),
	(123,12,15),
	(124,13,15),
	(125,9,17),
	(126,10,17),
	(127,11,17),
	(128,3,17),
	(129,4,17),
	(130,7,17),
	(131,16,17),
	(132,5,17),
	(133,15,17),
	(134,14,17),
	(135,8,17),
	(136,17,17),
	(137,6,17),
	(138,12,17),
	(139,13,17),
	(140,12,18),
	(141,8,18),
	(142,7,18),
	(143,16,18),
	(144,15,18),
	(145,10,18),
	(146,4,18),
	(147,9,18),
	(148,17,18),
	(149,11,18),
	(150,5,18),
	(151,6,18),
	(152,14,18),
	(153,13,18),
	(154,10,20),
	(155,16,20),
	(156,6,20),
	(157,4,20),
	(158,9,20),
	(159,11,20),
	(160,17,20),
	(161,5,20),
	(162,13,20),
	(163,7,20),
	(164,15,20),
	(165,14,20),
	(166,12,20),
	(167,8,20);

/*!40000 ALTER TABLE `system_role_res` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_user`;

CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sex` int(1) DEFAULT '1' COMMENT '1:男，0:女',
  `mobilephone` varchar(11) DEFAULT NULL COMMENT '移动电话',
  `loginCount` int(11) DEFAULT '0' COMMENT '登录次数',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `originalPic` varchar(200) DEFAULT NULL COMMENT '头像',
  `available` int(1) DEFAULT '1' COMMENT '#1 不在线 2.封号状态 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;

INSERT INTO `system_user` (`id`, `loginname`, `password`, `salt`, `name`, `email`, `sex`, `mobilephone`, `loginCount`, `lastLoginTime`, `originalPic`, `available`)
VALUES
	(1000,'zhangsan','887152dfd71fb7bfbb95c4d5ddb8d711','51dc770e65e4e2c2d5a63ba81f4110fc','张三','zhangsan@163.com',1,'',46,'2014-10-30 14:57:49','avatar1.jpg',1),
	(1002,'lisi','894431bb71c1776a70a98eacf7ef3257','2eaa12542970e016e9afbfb713258d37','李四','lisi@163.com',1,'12345678963',29,'2014-11-05 19:34:37','1414391284915.png',1),
	(1006,'wangwu','c1373439cee253ce306bce3f0c06b587','b646727c2c3581e7f8ec82327868df7a','王五','wangwu@163.com',0,'12345678963',7,'2014-10-30 10:03:58','avatar0.jpg',1);

/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table system_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `system_user_role`;

CREATE TABLE `system_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SYSTME_USER_ROLE_USER_ID` (`user_id`),
  KEY `FK_SYSTME_USER_ROLE_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_SYSTME_USER_ROLE_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_SYSTME_USER_ROLE_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `system_user_role` WRITE;
/*!40000 ALTER TABLE `system_user_role` DISABLE KEYS */;

INSERT INTO `system_user_role` (`id`, `user_id`, `role_id`)
VALUES
	(13,1006,16),
	(14,1000,15),
	(15,1002,9);

/*!40000 ALTER TABLE `system_user_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_site_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_site_role`;

CREATE TABLE `user_site_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_site_role_USER_ID` (`user_id`),
  KEY `FK_user_site_role_SITE_ID` (`site_id`),
  KEY `FK_user_site_rol_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_user_site_rol_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `system_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_site_role_SITE_ID` FOREIGN KEY (`site_id`) REFERENCES `site` (`siteId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_site_role_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
