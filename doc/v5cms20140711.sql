/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - v5cms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`v5cms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `v5cms`;

/*Table structure for table `adv` */

DROP TABLE IF EXISTS `adv`;

CREATE TABLE `adv` (
  `advId` bigint(110) NOT NULL AUTO_INCREMENT,
  `advName` varchar(100) NOT NULL COMMENT '广告名称',
  `advCode` varchar(3000) DEFAULT NULL COMMENT '广告代码',
  `advState` int(11) DEFAULT '0' COMMENT '广告状态',
  PRIMARY KEY (`advId`)
) ENGINE=MyISAM AUTO_INCREMENT=10029 DEFAULT CHARSET=utf8 COMMENT='友情连接表';

/*Data for the table `adv` */

insert  into `adv`(`advId`,`advName`,`advCode`,`advState`) values (10009,'s','s',0),(10004,'首页广告2','ddd--首页广告2',1),(10005,'首页广告1','广告代码',1),(10008,'s','s',0),(10010,'s','s',0),(10011,'s','s',0),(10012,'s','s',0),(10013,'ssss','ssss',0),(10014,'ssss','ssss',0),(10015,'ssss','ssss',0),(10016,'ssss','ssss',0),(10017,'ssss','sssss',0),(10018,'eeeee','eeeeeeeeee',0),(10019,'rrrrrrrrrrr','eeeeeeeeeeeee',0),(10020,'rrrrrrrrrr','ttttttttttttttttt',0),(10021,'4444','4444',0),(10022,'44444','4444444',0);

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `bannerId` bigint(110) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(200) NOT NULL COMMENT 'banner名称',
  `bannerPic` varchar(1000) NOT NULL COMMENT 'banner图片',
  `isstart` int(11) DEFAULT '0' COMMENT '是否启用，1：启用，0：不启用',
  `bannerds` int(11) DEFAULT NULL COMMENT 'banner显示顺序',
  `bcontent` text COMMENT '设置banner上显示的文本',
  PRIMARY KEY (`bannerId`)
) ENGINE=MyISAM AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COMMENT='banner表';

/*Data for the table `banner` */

insert  into `banner`(`bannerId`,`bannerName`,`bannerPic`,`isstart`,`bannerds`,`bcontent`) values (10000,'3','banner/1384961216.jpg',1,3,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),(10002,'2','banner/1385462644.jpg',1,2,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),(10003,'1','banner/1385462613.jpg',1,1,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),(10006,'4','banner/1385465240.jpg',1,5,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>'),(10007,'5','banner/1385532115.jpg',1,4,'<h1>banner演示</h1>\r\n                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n                    <p><a class=\"btn btn-large btn-primary\" href=\"#\">今天登录</a></p>');

/*Table structure for table `cols` */

DROP TABLE IF EXISTS `cols`;

CREATE TABLE `cols` (
  `colsId` bigint(110) NOT NULL AUTO_INCREMENT,
  `columnName` varchar(200) NOT NULL COMMENT '栏目名称',
  `columnlht` varchar(200) DEFAULT NULL COMMENT '栏目列表页头模板',
  `columnlbt` varchar(200) DEFAULT NULL COMMENT '栏目列表主体模板',
  `columncht` varchar(200) DEFAULT NULL COMMENT '内容页头模板',
  `columncbt` varchar(200) DEFAULT NULL COMMENT '内容也主体模板',
  `columnds` int(11) DEFAULT NULL COMMENT '栏目显示顺序',
  `columndisplay` int(11) DEFAULT NULL COMMENT '是否显示',
  `columnot` int(11) DEFAULT NULL COMMENT '连接打开方式',
  `columnOutside` varchar(1000) DEFAULT NULL COMMENT '外链地址',
  `columnpic` varchar(200) DEFAULT NULL COMMENT '栏目图片',
  `parentId` int(11) DEFAULT NULL COMMENT '父栏目ID',
  PRIMARY KEY (`colsId`)
) ENGINE=MyISAM AUTO_INCREMENT=10017 DEFAULT CHARSET=utf8 COMMENT='文章标签表';

/*Data for the table `cols` */

insert  into `cols`(`colsId`,`columnName`,`columnlht`,`columnlbt`,`columncht`,`columncbt`,`columnds`,`columndisplay`,`columnot`,`columnOutside`,`columnpic`,`parentId`) values (10002,'Lucene','index_header.php','index.php','index_header.php','content.php',5,1,0,'','',0),(10003,'Java','index_header.php','index.php','index_header.php','content.php',3,1,0,'','',0),(10004,'WorldWind','index_header.php','index.php','index_header.php','content.php',2,1,0,'','columnpic/1385431453.png',0),(10005,'Solr','index_header.php','index.php','index_header.php','content.php',0,1,0,'','',10002),(10015,'Struts2','index_header.php','article_list.php','index_header.php','content.php',0,1,0,'','',10003),(10016,'Swing','index_header.php','article_list.php','index_header.php','content.php',1,1,0,'','',10003),(10008,'Web前端','index_header.php','index.php','index_header.php','content.php',0,1,0,'','',0),(10009,'jQuery','index_header.php','index.php','index_header.php','content.php',0,1,0,'','',10008),(10010,'jQueryEasyUI','index_header.php','index.php','index_header.php','content.php',1,1,0,'','',10008);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `commentsId` bigint(110) NOT NULL AUTO_INCREMENT,
  `contentId` int(11) NOT NULL COMMENT '评语所属内容ID',
  `commentAuthor` varchar(100) NOT NULL COMMENT '评论者姓名',
  `email` varchar(100) NOT NULL COMMENT '评论者的Email地址',
  `commentContent` longtext NOT NULL COMMENT '评语内容',
  `siteURL` varchar(500) DEFAULT NULL COMMENT '评论者的站点URL',
  `commentIP` varchar(200) DEFAULT NULL COMMENT '评语者的IP地址',
  `commentDate` datetime DEFAULT NULL COMMENT '评语时间',
  `commentApproved` int(11) DEFAULT '0' COMMENT '评语是否批准 0:待审批，1:通过审批，2:垃圾评语',
  `commentParent` int(11) DEFAULT '0' COMMENT '父评语ID',
  PRIMARY KEY (`commentsId`)
) ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='评语表';

/*Data for the table `comments` */

/*Table structure for table `content` */

DROP TABLE IF EXISTS `content`;

CREATE TABLE `content` (
  `contentId` bigint(110) NOT NULL AUTO_INCREMENT,
  `columnId` int(11) DEFAULT NULL COMMENT '所属栏目ID',
  `cname` varchar(500) NOT NULL COMMENT '内容标题',
  `cbody` text COMMENT '发布的内容',
  `lastdt` datetime DEFAULT NULL COMMENT '最后更新的时间',
  `stick` int(11) DEFAULT NULL COMMENT '是否置顶，1：置顶，2：反之',
  `stickNum` int(11) DEFAULT NULL COMMENT '置顶序号，只有是置顶状态，才起作用',
  `isdraft` int(11) DEFAULT NULL COMMENT '是否是草稿，1：是，0：否',
  `publish` int(11) DEFAULT NULL COMMENT '是否发布，1：是，0：否',
  `cpics` varchar(2000) DEFAULT NULL COMMENT '与文章关联的图片',
  `cattas` varchar(1000) DEFAULT NULL COMMENT '文章中使用的附件，多个使用丢号分割',
  `dispic` varchar(200) DEFAULT NULL COMMENT '展示图',
  `writerId` int(11) DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`contentId`)
) ENGINE=MyISAM AUTO_INCREMENT=10025 DEFAULT CHARSET=utf8 COMMENT='创建内容表';

/*Data for the table `content` */

insert  into `content`(`contentId`,`columnId`,`cname`,`cbody`,`lastdt`,`stick`,`stickNum`,`isdraft`,`publish`,`cpics`,`cattas`,`dispic`,`writerId`) values (10017,10009,'jquery入门','<p>jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门jquery入门</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386148510.jpg\"/></p>','2013-12-09 22:35:49',0,0,1,1,'','','',10000),(10018,10004,'WorldWind入门','<p>WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门WorldWind入门</p>','2013-12-10 21:11:28',0,0,1,1,'','','',10000),(10019,10015,'Struts2入门','<p>Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门Struts2入门</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386141341.jpg\"/></p>','2013-12-10 21:28:58',0,0,1,1,'','','',10000),(10020,10016,'Swing入门','<p>Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门Swing入门</p><pre class=\"brush:php;toolbar:false\">if($m&nbsp;===&nbsp;&#39;cont_list&#39;){\n&nbsp;&nbsp;&nbsp;&nbsp;$cid&nbsp;=&nbsp;$_GET[&#39;cid&#39;];\n\n&nbsp;&nbsp;&nbsp;&nbsp;if($cid){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$wsql&nbsp;=&nbsp;&quot;SELECT&nbsp;c.tbId&nbsp;as&nbsp;tbId,cname,columnName,managerLoginname,managername,lastdt,stick,stickNum,publish&nbsp;FROM&nbsp;(SELECT&nbsp;*&nbsp;FROM&nbsp;content&nbsp;WHERE&nbsp;columnId&nbsp;IN&nbsp;(SELECT&nbsp;tbId&nbsp;FROM&nbsp;cols&nbsp;WHERE&nbsp;parentId&nbsp;=&nbsp;$cid&nbsp;OR&nbsp;tbId=$cid))&nbsp;AS&nbsp;c&nbsp;INNER&nbsp;JOIN&nbsp;cols&nbsp;AS&nbsp;cls&nbsp;INNER&nbsp;JOIN&nbsp;manager&nbsp;AS&nbsp;m&nbsp;WHERE&nbsp;c.columnId&nbsp;=&nbsp;cls.tbId&nbsp;AND&nbsp;c.writerId&nbsp;=&nbsp;m.tbId&quot;;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$totalCount&nbsp;=&nbsp;v5_complex(&#39;content&#39;,$wsql,0,0,2,&quot;&quot;);\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$pInfo&nbsp;=&nbsp;new&nbsp;Pagination($totalCount,PAGE_COUNT);\n\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$conts&nbsp;=&nbsp;v5_complex(&#39;content&#39;,$wsql,$pInfo-&gt;getStartCount(),$pInfo-&gt;getPageCount(),1,&#39;&#39;,&#39;tbId&nbsp;desc&#39;);\n&nbsp;&nbsp;&nbsp;&nbsp;}else{\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result&nbsp;=&nbsp;find_all_content();\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$pInfo&nbsp;=&nbsp;$result[1];\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$conts&nbsp;=&nbsp;$result[0];\n&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;include_once&nbsp;M_VIEW_PATH.&#39;content&#39;.DIRECTORY_SEPARATOR.&#39;content_list.php&#39;;\n}</pre><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1386148510.jpg\"/></p>','2013-12-11 21:13:29',0,0,1,1,'','','',10000),(10021,10005,'Solr入门（1）','<p>Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）Solr入门（1）<img style=\"width: 500px; height: 532px;\" src=\"http://localhost/v5blog/content/public_res/contentpic/1387114865.jpg\" title=\"index2.jpg\" border=\"0\" height=\"532\" hspace=\"0\" vspace=\"0\" width=\"500\"/></p>','2013-12-15 21:42:32',0,0,1,1,'','','',10000),(10022,10005,'Solr入门（2）','<p>Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）Solr入门（2）</p>','2013-12-15 21:52:20',0,0,1,1,'','','contentpic/1387115510.jpg',10000),(10023,10005,'Solr入门（3）','<p>Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）Solr入门（3）</p>','2013-12-15 22:04:04',0,0,1,1,'','','contentpic/1387115587.png,contentpic/1387115592.jpg',10000),(10024,10016,'Swing晋级','<p>Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级Swing晋级</p><p><img src=\"http://localhost/v5blog/content/public_res/contentpic/1387115518.jpg\"/><br/></p><pre class=\"brush:php;toolbar:false\">//递归输出栏目为&lt;option&nbsp;value=&quot;&quot;&gt;&lt;option&gt;\nfunction&nbsp;columnprint($columnId,$pid=0,$retract=&quot;&quot;){\n&nbsp;&nbsp;&nbsp;&nbsp;$result&nbsp;=&nbsp;&quot;&quot;;\n&nbsp;&nbsp;&nbsp;&nbsp;$pid_zero&nbsp;=&nbsp;v5_select(&#39;cols&#39;,1,&quot;and&nbsp;parentId=$pid&nbsp;and&nbsp;columndisplay=1&quot;,&#39;*&#39;,&#39;columnds&nbsp;ASC&#39;);\n&nbsp;&nbsp;&nbsp;&nbsp;if(!$pid&nbsp;&amp;&amp;&nbsp;!count($pid_zero)){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;&quot;&lt;option&nbsp;value=&#39;&#39;&gt;--还没有栏目--&lt;/option&gt;&quot;;\n&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;foreach($pid_zero&nbsp;as&nbsp;$zero){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$tbId&nbsp;=&nbsp;$zero-&gt;getTbId();\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$name&nbsp;=&nbsp;$zero-&gt;getColumnName();\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if($columnId&nbsp;==&nbsp;$tbId){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=&nbsp;&quot;&lt;option&nbsp;value=&#39;$tbId&#39;&nbsp;selected&gt;&quot;.$retract.$name.&#39;&lt;/option&gt;&#39;;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}else{\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=&nbsp;&quot;&lt;option&nbsp;value=&#39;$tbId&#39;&gt;&quot;.$retract.$name.&#39;&lt;/option&gt;&#39;;\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$count&nbsp;=&nbsp;v5_select(&#39;cols&#39;,3,&quot;and&nbsp;parentId=$tbId&quot;);\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if($count){\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$result.=columnprint($columnId,$tbId,$retract.&quot;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&amp;nbsp;&quot;);\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;}\n&nbsp;&nbsp;&nbsp;&nbsp;return&nbsp;$result;\n}</pre><p>淡淡的<br/></p>','2013-12-24 10:36:30',0,0,1,1,'','','',10000);

/*Table structure for table `content_label` */

DROP TABLE IF EXISTS `content_label`;

CREATE TABLE `content_label` (
  `content_labelId` bigint(110) NOT NULL AUTO_INCREMENT,
  `contentId` int(11) DEFAULT NULL,
  `labelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`content_labelId`)
) ENGINE=MyISAM AUTO_INCREMENT=10024 DEFAULT CHARSET=utf8 COMMENT='文章标签中间表';

/*Data for the table `content_label` */

insert  into `content_label`(`content_labelId`,`contentId`,`labelId`) values (10010,10018,10007),(10009,10017,10018),(10008,10017,10009),(10007,10017,10005),(10011,10018,10019),(10012,10019,10019),(10013,10019,10011),(10014,10020,10019),(10015,10020,10020),(10016,10021,10008),(10017,10021,10019),(10018,10022,10008),(10019,10022,10019),(10020,10023,10008),(10021,10023,10019),(10022,10024,10006),(10023,10024,10009);

/*Table structure for table `label` */

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `labelId` bigint(110) NOT NULL AUTO_INCREMENT,
  `labelName` varchar(200) NOT NULL COMMENT '标签名称',
  `alias` varchar(200) DEFAULT NULL COMMENT '标签别名',
  PRIMARY KEY (`labelId`)
) ENGINE=MyISAM AUTO_INCREMENT=10021 DEFAULT CHARSET=utf8;

/*Data for the table `label` */

insert  into `label`(`labelId`,`labelName`,`alias`) values (10007,'WorldWind','WorldWind'),(10005,'Web前端','Web前端'),(10006,'Lucene','Lucene'),(10008,'Solr','Solr'),(10009,'jquery','jquery'),(10010,'bootstarp','bootstarp'),(10011,'Struts2','Struts2'),(10012,'SpringMVC','SpringMVC'),(10013,'Node.js','Node.js'),(10014,'PHP','PHP'),(10015,'Python','Python'),(10018,'jqueryeasyui','jqueryeasyui'),(10019,'java','java'),(10020,'swing','swing');

/*Table structure for table `link` */

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `linkId` bigint(110) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(200) NOT NULL COMMENT '连接名称',
  `link` varchar(1000) NOT NULL COMMENT '连接',
  `linkPic` varchar(200) DEFAULT NULL COMMENT '连接图片',
  `openType` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `isstart` int(11) DEFAULT NULL COMMENT '是否启用。1：启用，2：不启用',
  PRIMARY KEY (`linkId`)
) ENGINE=MyISAM AUTO_INCREMENT=10018 DEFAULT CHARSET=utf8;

/*Data for the table `link` */

insert  into `link`(`linkId`,`linkName`,`link`,`linkPic`,`openType`,`isstart`) values (10005,'ddd','http://www.v5cn.cn','linkpic/1384694271.jpg','_blank',0),(10006,'ddd','http://www.v5cn.cn','linkpic/1384694288.jpg','_self',0),(10007,'dddd','http://www.v5cn.cn','linkpic/1384694303.jpg','_self',0),(10008,'ssss','http://www.v5cn.cn','linkpic/1384694319.jpg','_blank',0),(10009,'dddddddd','http://www.v5cn.cn','linkpic/1384694345.jpg','_self',0),(10010,'gggg','http://www.v5cn.cn','linkpic/1384694463.jpg','_self',0),(10017,'ooooooooo','http://www.v5cn.cn','','_blank',0);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `managerId` bigint(110) NOT NULL AUTO_INCREMENT,
  `managerLoginname` varchar(100) NOT NULL,
  `managerPassword` varchar(32) NOT NULL,
  `managerName` varchar(100) NOT NULL,
  `managerEmail` varchar(100) NOT NULL,
  `managerIP` varchar(100) DEFAULT NULL,
  `loginCount` int(11) DEFAULT '0' COMMENT '登录次数',
  `mobilephone` varchar(11) DEFAULT NULL COMMENT '移动电话',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `originalPic` varchar(200) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`managerId`)
) ENGINE=MyISAM AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `manager` */

insert  into `manager`(`managerId`,`managerLoginname`,`managerPassword`,`managerName`,`managerEmail`,`managerIP`,`loginCount`,`mobilephone`,`lastLoginTime`,`originalPic`) values (10000,'zhangsan','670b14728ad9902aecba32e22fa4f6bd','张三','zhangsan@163.com',NULL,0,NULL,NULL,NULL),(10001,'zhangsan','670b14728ad9902aecba32e22fa4f6bd','张三1','zhangsan@163.com',NULL,0,NULL,NULL,NULL);

/*Table structure for table `site` */

DROP TABLE IF EXISTS `site`;

CREATE TABLE `site` (
  `siteId` bigint(110) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(100) NOT NULL COMMENT '网站标题',
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
) ENGINE=MyISAM AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8 COMMENT='网站信息表';

/*Data for the table `site` */

insert  into `site`(`siteId`,`siteName`,`siteDeputyTitle`,`siteKey`,`siteDescribed`,`createDate`,`siteicp`,`siteStatisticCode`,`siteFooterInfo`,`isclosesite`,`themeName`) values (10005,'V5CMS','java,WorldWind,Lucene','java,WorldWind,Lucene,Spring,SpringMVC','讲述java,WorldWind,Lucene,Spring,SpringMVC的博客网站','2014-02-22','陕ICP','<script type=\"text/javascript\">\nvar _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\ndocument.write(unescape(\"%3Cscript src=\'\" + _bdhmProtocol + \"hm.baidu.com/h.js%3Fbff6c22bb9ae0fcbf0fc35e23b9b02e8\' type=\'text/javascript\'%3E%3C/script%3E\"));\n</script>','<h3>V5Blog 平常心博客</h3>',1,'default');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
