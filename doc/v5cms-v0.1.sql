create database 'v5cms';

use 'v5cms'

/**创建用户名**/
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
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table manager comment '用户表';

/**创建site表**/
create table site
(
	siteId			BIGINT not null AUTO_INCREMENT,
	siteName		    varchar(100) not null		comment '网站标题',
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
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table site comment '网站信息表';

/**创建广告表**/
create table adv
(
  advId BIGINT not null AUTO_INCREMENT ,
  advName varchar(100) not null     comment '广告名称',
  advCode varchar(3000)             comment '广告代码',
  advState int default 0            comment '广告状态',
  primary key (advId)
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table adv comment '广告表';

/**广告版位**/
CREATE TABLE advPos(
  advPosId BIGINT NOT NULL AUTO_INCREMENT,
  advPosName VARCHAR(100) NOT NULL        COMMENT '版位名称',
  advPosState INT DEFAULT 0               COMMENT '状态0:关闭，1:启用',
  advPosDes VARCHAR(2000)                  COMMENT '描述',
  PRIMARY KEY (advPosId)
)ENGINE=MYISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT '广告版位';

--友情连接表
create table link
(
  linkId    bigInt not null AUTO_INCREMENT ,
  linkName varchar(200) not null        comment '连接名称',
  link     varchar(1000) not null       comment '连接',
  linkPic  varchar(200)                 comment '连接图片',
  openType varchar(50)                  comment '打开方式',
  isstart  int         default 0        comment '是否启用，1：启用，0：不启用',
  primary key (linkId)
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table adv comment '友情连接表';

--banner表
create table banner
(
  bannerId bigInt not null AUTO_INCREMENT ,
  bannerName  varchar(200) not null      comment 'banner名称',
  bannerPic   varchar(1000) not null     comment 'banner图片',
  bannerds    int                        comment 'banner显示顺序',
  isstart     int  default 0             comment '是否启用，1：启用，0：不启用',
  bcontent    text                       comment '设置banner上显示的文本',
  primary key (bannerId)
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table banner comment 'banner表';

--栏目表
create table cols
(
  colsId        bigInt not null AUTO_INCREMENT ,
  columnName    varchar(200) not null       comment '栏目名称',
  columnlht     varchar(200)                comment '栏目列表页头模板',
  columnlbt     varchar(200)                comment '栏目列表主体模板',
  columncht     varchar(200)                comment '内容页头模板',
  columncbt     varchar(200)                comment '内容也主体模板',
  columnds      int                         comment '栏目显示顺序',
  columndisplay int                         comment '是否显示',
  columnot      int                         comment '连接打开方式',
  columnOutside varchar(1000)               comment '外链地址',
  columnpic     varchar(200)                comment '栏目图片',
  parentId      int       default 0         comment '父栏目ID',
  primary key (colsId)
)ENGINE=MyISAM AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

alter table cols comment '栏目表';

--标签表

create table label
(
  labelId     bigInt not null AUTO_INCREMENT ,
  labelName     varchar(200)    not null    comment '标签名称',
  alias         varchar(200)                comment '标签别名',
  primary key (labelId)
)ENGINE=MyISAM auto_increment=10000 default charset=utf8;

alter table cols comment '文章标签表';

--创建内容表
create table content
(
  contentId bigInt not null AUTO_INCREMENT ,
  columnId  int                     comment '所属栏目ID',
  cname varchar(500)    not null    comment '内容标题',
  cbody longtext                    comment '发布的内容',
  lastdt datetime                   comment '最后更新的时间',
  writerId int                      comment '作者ID',
  stick    int                      comment '是否置顶，1：置顶，2：反之',
  stickNum  int                     comment '置顶序号，只有是置顶状态，才起作用',
  isdraft   int                     comment '是否是草稿，1：是，0：否',
  publish   int                     comment '是否发布，1：是，0：否',
  cpics     varchar(2000)           comment '与文章关联的图片，多个使用逗号分割',
  cattas    varchar(1000)           comment '文章中使用的附件，多个使用丢号分割',
  dispic    varchar(200)            comment '展示图',
  primary key (contentId)
)ENGINE=MyISAM auto_increment=10000 default charset=utf8;

alter table content comment '创建内容表';

--文章标签表
create table content_label
(
  content_labelId   bigInt not null AUTO_INCREMENT ,
  contentId   int,
  labelId     int,
  primary key (content_labelId)
)ENGINE=MyISAM auto_increment=10000 default charset=utf8;

alter table content_label comment '文章标签中间表';

--创建评语表
create table comments
(
  commentsId      bigInt not null AUTO_INCREMENT,
  contentId       int not null                   comment '评语所属内容ID',
  commentAuthor   varchar(100) not null          comment '评论者姓名',
  email           varchar(100) not null          comment '评论者的Email地址',
  commentContent  longtext not null              comment '评语内容',
  siteURL         varchar(500)                   comment '评论者的站点URL',
  commentIP       varchar(200)                   comment '评语者的IP地址',
  commentDate     datetime                       comment '评语时间',
  commentApproved int     default 0              comment '评语是否批准 0:待审批，1:通过审批，2:垃圾评语',
  commentParent   int     default 0              comment '父评语ID',
  primary key (commentsId)
)ENGINE=MyISAM auto_increment=10000 default charset=utf8;

alter table comments comment '评语表';