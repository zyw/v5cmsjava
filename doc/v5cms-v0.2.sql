create database 'v5cms';

use 'v5cms'

/**创建用户名
create table manager
(
	managerId           BIGINT not null AUTO_INCREMENT,
	managerLoginname    varchar(100) not null,
	managerPassword     varchar(32) not null,
	managerName         varchar(100) not null,
	managerEmail        varchar(100) not null,
	managerIP           varchar(100),
	loginCount          int					default 0		comment '登录次数',
	mobilephone          varchar(11)							comment '移动电话',
	lastLoginTime        datetime								comment '最后登录时间',
	originalPic          varchar(200)							comment '头像',
	primary key (managerId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

alter table manager comment '用户表';**/

/**创建site表**/
create table site
(
	siteId			BIGINT not null AUTO_INCREMENT,
	siteName		    varchar(100) not null		comment '网站标题',
	domain          varchar(200) not null   comment '网站域名，必须唯一',
	protocol        varchar(100) not null   comment '访问协议，http://或者https://',
	siteDeputyTitle varchar(200)				comment '网站副标题',
	siteKey			    varchar(500)				comment '网站关键字',
	siteDescribed	  varchar(1000)				comment '网站描述',
	createDate      datetime            comment '创建时间',
	siteicp			    varchar(100)				comment '网站备案号',
	siteStatisticCode	varchar(3000)			comment '统计代码',
	siteFooterInfo	varchar(3000)				comment '网站底部信息',
	isclosesite		  int 	default 0			comment '网站是否关闭 1 开启    0 关闭',
	themeName		    varchar(200) default 'default' 	comment '使用的网站主题名称',
	primary key (siteId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

alter table site comment '网站信息表';

/**创建广告表**/
create table adv
(
  advId BIGINT not null AUTO_INCREMENT ,
  advName varchar(200) not null     comment '广告名称',
  advType int not null              comment '广告类型1:图片，2：Flash，3：文字，4：代码',
  advPosId BIGINT not null          comment '广告版位ID',
  advCode varchar(3000)             comment '广告代码',
  advStartTime date                 comment '广告开始时间',
  advEndTime   date                 comment '广告结束时间',
  createDate   datetime             comment '创建时间',
  advTypeInfo  varchar(3000)        comment '广告类型信息JSON字符串',
  startUsing int default 0            comment '广告状态1：启用，0：关闭',
  primary key (advId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment '广告表';

/**广告版位**/
CREATE TABLE advPos(
  advPosId BIGINT NOT NULL AUTO_INCREMENT,
  advPosName VARCHAR(100) NOT NULL        COMMENT '版位名称',
  advPosState INT DEFAULT 0               COMMENT '状态0:关闭，1:启用',
  advPosDes VARCHAR(2000)                  COMMENT '描述',
  PRIMARY KEY (advPosId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '广告版位';

/*友情连接表*/
create table link
(
  linkId    bigInt not null AUTO_INCREMENT ,
  linkName varchar(200) not null        comment '连接名称',
  link     varchar(1000) not null       comment '连接',
  linkPic  varchar(200)                 comment '连接图片',
  openType varchar(50)                  comment '打开方式',
  isstart  int         default 0        comment '是否启用，1：启用，0：不启用',
  primary key (linkId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment '友情连接表';

/*banner表*/
create table banner
(
  bannerId bigInt not null AUTO_INCREMENT ,
  bannerName  varchar(200) not null      comment 'banner名称',
  bannerPic   varchar(1000) not null     comment 'banner图片',
  bannerLink  varchar(200)               comment 'banner跳转链接',
  bannerds    int                        comment 'banner显示顺序',
  isstart     int  default 0             comment '是否启用，1：启用，0：不启用',
  bcontent    text                       comment '设置banner上显示的文本',
  primary key (bannerId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment 'banner表';

/*栏目表*/
create table cols
(
  colsId        bigInt not null AUTO_INCREMENT ,
  columnName    varchar(200) not null       comment '栏目名称',
  colTypeId     bigint not null             comment '栏目类型',

  sortNum      int                         comment '栏目显示顺序',
  columndisplay int                         comment '是否显示',
  openWay      varchar(20)                  comment '连接打开方式',
  columnOutside varchar(1000)               comment '外链地址',
  columnpic     varchar(200)                comment '栏目图片',
  parentId      bigInt       default 0      comment '父栏目ID',
  parentIds     varchar(200)                comment 'treetable排序使用',
  siteId        bigint                      comment '栏目所属站点',
  primary key (colsId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment '栏目表';

/*栏目类型表*/
create table colType
(
  colTypeId bigint not null AUTO_INCREMENT,
  colTypeName varchar(200) not null           comment '类型名称',
  coltpl      varchar(200) not null           comment '栏目模板名称',
  contenttpl  varchar(200)                    comment '内容模板名称',
  colsort     int          not null default 0 comment '栏目排序',
  hasContent  int                             comment '是否有内容页',
  isDisabled  int                             comment '是否可用',
  siteId      bigint                          comment '栏目类型所属站点',
  primary key (colTypeId)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment '栏目类型表';

/*标签表*/

create table label
(
  labelId     bigInt not null AUTO_INCREMENT ,
  labelName     varchar(200)    not null    comment '标签名称',
  alias         varchar(200)                comment '标签别名',
  primary key (labelId)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

alter table cols comment '文章标签表';

/*创建内容表*/
create table content
(
  contentId bigInt not null AUTO_INCREMENT ,
  columnId  bigint                  comment '所属栏目ID',
  cname varchar(500)    not null    comment '内容标题',
  cbody longtext                    comment '发布的内容',
  outside int                       comment '是否是外链，1：是，0：不是',
  outsideURL varchar(100)           comment '外链地址',
  titleColor varchar(10)            comment '标题颜色',
  titleBold  int                    comment '是否加粗',
  titleItalic int                   comment '是否斜体',
  contentKey  varchar(1000)         comment '关键字',
  contentDes  varchar(2000)         comment '摘要',
  lastdt datetime                   comment '最后更新的时间',
  writerId bigint                   comment '提交者ID',
  author  varchar(100)              comment '作者',
  source  varchar(100)              comment '内容来源',
  sourceURL varchar(200)            comment '来源地址',
  stick    int                      comment '是否置顶，1：置顶，2：反之',
  stickNum  int                     comment '置顶序号，只有是置顶状态，才起作用',
  publishDT varchar(10)             comment '原内容发布日期',
  state   int                       comment '是否是草稿，1：发布，0：草稿',
  allowComment int                  comment '是否允许评论，1：运行 0：禁止',
  cpics     varchar(2000)           comment '与文章关联的图片，多个使用逗号分割',
  cattas    varchar(1000)           comment '文章中使用的附件，多个使用丢号分割',
  dispic    varchar(200)            comment '展示图',
  siteId    bigInt                  comment '所属站点',
  primary key (contentId)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

alter table content comment '创建内容表';

/*文章标签表*/
create table content_label
(
  content_labelId   bigInt not null AUTO_INCREMENT ,
  contentId   int,
  labelId     int,
  primary key (content_labelId)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

alter table content_label comment '文章标签中间表';

/*创建评语表*/
create table comments
(
  commentsId      bigInt not null AUTO_INCREMENT,
  contentId       bigInt not null                comment '评语所属内容ID',
  commentAuthor   varchar(100) not null          comment '评论者姓名',
  email           varchar(100) not null          comment '评论者的Email地址',
  commentContent  longtext not null              comment '评语内容',
  reply           longtext                       comment '评论回复',
  siteURL         varchar(500)                   comment '评论者的站点URL',
  commentIP       varchar(200)                   comment '评语者的IP地址',
  commentDate     datetime                       comment '评语时间',
  recommend       int     default 0              comment '是否推荐',
  commentApproved int     default 0              comment '评语是否批准 0:待审批，1:通过审批，2:垃圾评语',
  commentParent   bigInt  default 0              comment '父评语ID',
  primary key (commentsId)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

alter table comments comment '评语表';

/*留言类型*/
create table leave_word_type
(
  id           BIGINT NOT NULL AUTO_INCREMENT,
  name         varchar(200) not null          comment '留言类型名称',
  sortNum      int                            comment '留言类型顺序',
  lwdes        varchar(2000)                  comment '留言类型描述',
  primary key(id)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

/*留言*/
create table leave_word
(
  id           BIGINT NOT NULL AUTO_INCREMENT,
  lwtId        BIGINT                         comment '留言类型ID',
  title        varchar(500) not null          comment '留言标题',
  content      longtext not null              comment '留言内容',
  reply        longtext                       comment '回复内容',
  author       varchar(100)                   comment '留言作者',
  email        varchar(200)                   comment '邮箱',
  phone        varchar(20)                    comment '电话',
  qq           varchar(50)                    comment 'QQ',
  recommend    int     default 0              comment '是否推荐，1：推荐，0：不推荐',
  approved     int     default 0              comment '留言是否批准 0:待审批，1:通过审批，2:垃圾评语',
  lwtime       datetime                       comment '留言时间',
  primary key(id)
)ENGINE=INNODB auto_increment=1000 default charset=utf8;

CREATE TABLE system_res (
  id BIGINT NOT NULL AUTO_INCREMENT,
  pid BIGINT DEFAULT NULL,
  NAME VARCHAR(111) DEFAULT NULL,
   permission VARCHAR(100),
  url VARCHAR(255) DEFAULT NULL,
  sortNum INT(11) DEFAULT '1',		/*排序*/
  icon varchar(100)       comment '菜单图片',
  pids varchar(100)       comment 'TreeTable排序',
  TYPE INT(1) DEFAULT '2' COMMENT '1 菜单 2 按钮',
  available INT DEFAULT 1 COMMENT '1 可用 0 不可用',
  des VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE system_role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(55) DEFAULT NULL,
  sortNum INT(11) DEFAULT '1',
  pid BIGINT DEFAULT '0',
  des VARCHAR(55) DEFAULT NULL,
  available INT DEFAULT 1 COMMENT '1 可用 0 不可用',
  PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE SYSTEM_USER
(
	id           BIGINT NOT NULL AUTO_INCREMENT,
	loginname    VARCHAR(100) NOT NULL,
	PASSWORD     VARCHAR(100) NOT NULL,
	salt VARCHAR(100),
	NAME         VARCHAR(100) NOT NULL,
	email        VARCHAR(100) NOT NULL,
	sex int(1) DEFAULT '1' COMMENT '1:男，0:女',
	mobilephone          VARCHAR(11)							COMMENT '移动电话',
	loginCount          INT					DEFAULT 0		COMMENT '登录次数',
	lastLoginTime        DATETIME								COMMENT '最后登录时间',
	originalPic          VARCHAR(200)							COMMENT '头像',
	available INT(1) DEFAULT '1' COMMENT '#1 不在线 2.封号状态 ',
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;



CREATE TABLE system_user_role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT DEFAULT NULL,
  role_id BIGINT DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_SYSTME_USER_ROLE_USER_ID (user_id),
  KEY FK_SYSTME_USER_ROLE_ROLE_ID (role_id),
  CONSTRAINT FK_SYSTME_USER_ROLE_ROLE_ID FOREIGN KEY (role_id) REFERENCES system_role (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_SYSTME_USER_ROLE_USER_ID FOREIGN KEY (user_id) REFERENCES SYSTEM_USER (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE system_role_res (
  id BIGINT NOT NULL AUTO_INCREMENT,
  res_id BIGINT DEFAULT NULL,
  role_id BIGINT DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_SYSTEM_ROLE_RES_RES_ID (res_id),
  KEY FK_SYSTEM_ROLE_RES_ROLE_ID (role_id),
  CONSTRAINT FK_SYSTEM_ROLE_RES_RES_ID FOREIGN KEY (res_id) REFERENCES system_res (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_SYSTEM_ROLE_RES_ROLE_ID FOREIGN KEY (role_id) REFERENCES system_role (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*用户站点角色表*/
CREATE TABLE user_site_role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT DEFAULT NULL,
  site_id BIGINT DEFAULT NULL,
  role_id BIGINT DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_user_site_role_USER_ID (user_id),
  KEY FK_user_site_role_SITE_ID (site_id),
  KEY FK_user_site_rol_ROLE_ID (role_id),
  CONSTRAINT FK_user_site_role_USER_ID FOREIGN KEY (user_id) REFERENCES SYSTEM_USER (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_user_site_role_SITE_ID FOREIGN KEY (site_id) REFERENCES site (siteId) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_user_site_rol_ROLE_ID FOREIGN KEY (role_id) REFERENCES system_role (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;