-- 测试主键
CREATE TABLE IF NOT EXISTS user1(
id INT PRIMARY KEY,
username VARCHAR(20)
);
-- 查看创建表的标的定义
SHOW CREATE TABLE user1;

INSERT user1 VALUES(1,'king');
INSERT user1 VALUES(13,'QUEEN');

SELECT * FROM user1 WHERE id=1;#查看主键id是1的用户

CREATE TABLE IF NOT EXISTS user2(
id INT,
username VARCHAR(20),
card CHAR(18),
PRIMARY KEY(id,card) #多字段主键
);

INSERT user2 VALUES(1,'king','111');

INSERT user2 VALUES(1,'queen','112');

CREATE TABLE IF NOT EXISTS user3(
id INT KEY, #可以省略primary
username VARCHAR(20)
);

#字符串当主键
CREATE TABLE IF NOT EXISTS user4(
id INT,
username VARCHAR(20) KEY
);

###################################################
-- 测试AUTO_INCREMENT
CREATE TABLE IF NOT EXISTS user5(
id SMALLINT KEY AUTO_INCREMENT, #配合主键使用,只对整数列有效果
username VARCHAR(20)
);

INSERT user5 VALUES(1,'KING');
INSERT user5(username) VALUES('queen1');#只给usename赋值

INSERT user5 VALUES(111,'KING1');

#两种自增长形式
INSERT user5 VALUES(NULL,'AAAA');
INSERT user5 VALUES(DEFAULT,'AAAA'); 

#指定AUTO_INCREMENT的初始值
CREATE TABLE IF NOT EXISTS user6(
id SMALLINT KEY AUTO_INCREMENT,
username VARCHAR(20)
)AUTO_INCREMENT=100;

INSERT user6(username) VALUES('queen1');
-- 修改自增长的值
ALTER TABLE user6 AUTO_INCREMENT =500;

##########################################################
-- 测试NOT NULL
CREATE TABLE IF NOT EXISTS user7(
id INT UNSIGNED KEY AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
password CHAR(32) NOT NULL,
age TINYINT UNSIGNED
);

INSERT user7(username,password) VALUES('KING','KING');

INSERT user7(username,password,age) VALUES('KING1','KING1',12);

INSERT user7(username,password) VALUES(NULL,NULL);

########################################################
-- 测试DEFAULT

CREATE TABLE IF NOT EXISTS user8(
id INT UNSIGNED KEY AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
password CHAR(32) NOT NULL,
age TINYINT UNSIGNED DEFAULT 18,
addr VARCHAR(50) NOT NULL DEFAULT '北京', #NOT NULL 配合 DEFAULT 使用
sex ENUM('男','女','保密') NOT NULL DEFAULT '男'
);

INSERT user8(username,password) VALUES('KING','KING');

INSERT user8 VALUES(2,'QUEEN','QUEEN',29,'上海','保密');

INSERT user8 VALUES(3,'QUEEN','QUEEN',DEFAULT,DEFAULT,'保密');

################################################################
-- 测试UNIQUE KEY

CREATE TABLE IF NOT EXISTS user9(
id TINYINT UNSIGNED KEY AUTO_INCREMENT,
username VARCHAR(20) NOT NULL UNIQUE,
card CHAR(18) UNIQUE
);

INSERT user9(username) VALUES('A');
INSERT user9(username,card) VALUES('B','111');

INSERT user9(username,card) VALUES('B1',NULL);

INSERT user9(username,card) VALUES('B2',NULL);


--CREATE TABLE [IF NOT EXISTS] tbl_name(
--字段名称 字段类型 [UNSIGNED|ZEROFILL] [NOT NULL] [DEFAULT 默认值] [[PRIMARY] KEY| UNIQUE [KEY]] [AUTO_INCREMENT]
--)ENGINE=INNODB CHARSET=UTF8 AUTO_INCREMENT=100;

-- 创建用户表
CREATE TABLE IF NOT EXISTS user10(
id SMALLINT UNSIGNED KEY AUTO_INCREMENT, #以后创建表一般是固定的
username VARCHAR(20) NOT NULL UNIQUE,
password CHAR(32) NOT NULL,
email VARCHAR(50) NOT NULL DEFAULT '382771946@qq.com',
age TINYINT UNSIGNED DEFAULT 18,
sex ENUM('男','女','保密') DEFAULT '保密',
addr VARCHAR(200) NOT NULL DEFAULT '北京',
salary FLOAT(6,2),
regTime INT UNSIGNED,
face CHAR(100) NOT NULL DEFAULT 'default.jpg'
);

-- 将user10重命名成user11 ---两种形式
ALTER TABLE user10 RENAME TO user11;

ALTER TABLE user11 RENAME AS user10;

ALTER TABLE user10 RENAME user11; #alter三种方法

RENAME TABLE user11 TO user10; # 这里面的to 不能使用

##############################################################
-- 添加card 字段 CHAR(18)  ----- ADD 语句 , 默认添加到已有字段末尾
ALTER TABLE user10 ADD card CHAR(18);

ALTER TABLE user10 ADD test1 VARCHAR(100) NOT NULL UNIQUE;

ALTER TABLE user10 ADD test2 VARCHAR(20) NOT NULL FIRST;

ALTER TABLE user10 ADD test3 INT NOT NULL DEFAULT 100 AFTER username;#指定添加的位置

-- 选中一次表，完成多个操作
ALTER TABLE user10 

ADD test4 INT NOT NULL DEFAULT 123 AFTER password,

ADD test5 FLOAT(6,2) FIRST,

ADD test6 SET('A','B','C');

-- 删除test6字段 ----DROP

ALTER TABLE user10 DROP test6;

-- 一次删除test2,test3,test4,test5
ALTER TABLE user10 

DROP test2,

DROP test3,

DROP test4,

DROP test5;

-- 添加test字段删除addr字段
ALTER TABLE user10 

ADD test INT UNSIGNED NOT NULL DEFAULT 10 AFTER sex,

DROP addr;

##############################################	
-- 修改字段
-- 将email VARCHAR(200) 

ALTER TABLE user10 MODIFY email VARCHAR(200);


ALTER TABLE user10 MODIFY email VARCHAR(50) NOT NULL DEFAULT '382771946@qq.com';

-- 将card字段移动到test字段之后
ALTER TABLE user10 MODIFY card CHAR(18) AFTER test;

-- 将test字段修改为CHAR(32) NOT NULL DEFAULT '123' 移动到第一个位置
ALTER TABLE user10 MODIFY test CHAR(32) NOT NULL DEFAULT '123' FIRST;

-- 将test字段改为test1
ALTER TABLE user10 CHANGE test test1 CHAR(32) NOT NULL DEFAULT '123';

ALTER TABLE user10 CHANGE test1 test VARCHAR(200) NOT NULL AFTER username;

ALTER TABLE user10 CHANGE test test INT;

CREATE TABLE IF NOT EXISTS user11(
id TINYINT UNSIGNED KEY AUTO_INCREMENT ,
username VARCHAR(20) NOT NULL UNIQUE,
age TINYINT UNSIGNED
);
ALTER TABLE user11 ALTER age SET DEFAULT 18;

ALTER TABLE user11 ADD email VARCHAR(50) ;


-- 删除默认值
ALTER TABLE user11 ALTER age DROP DEFAULT;

ALTER TABLE user11 ALTER email DROP DEFAULT;

-- 添加主键
CREATE TABLE IF NOT EXISTS test12(
id INT
);

ALTER TABLE test12 ADD PRIMARY KEY(id);

CREATE TABLE IF NOT EXISTS test13(
id INT,
card CHAR(18),
username VARCHAR(20) NOT NULL
);

ALTER TABLE test13 ADD PRIMARY KEY(id,card);

-- 删除test12表的主键
ALTER TABLE test12 DROP PRIMARY KEY;

ALTER TABLE test13 DROP PRIMARY KEY;

ALTER TABLE test12 ADD CONSTRAINT symbol PRIMARY KEY index_type(id);


CREATE TABLE IF NOT EXISTS test14(
id INT UNSIGNED KEY AUTO_INCREMENT
);

ALTER TABLE test14 MODIFY id INT UNSIGNED;
ALTER TABLE test14 DROP PRIMARY KEY ;

-- 测试添加唯一索引
CREATE TABLE IF NOT EXISTS user12(
id TINYINT UNSIGNED KEY AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
card CHAR(18) NOT NULL,
test VARCHAR(20) NOT NULL,
test1 CHAR(32) NOT NULL
);
ALTER TABLE user12 ADD UNIQUE(username);

ALTER TABLE user12 ADD CONSTRAINT symbol  UNIQUE KEY uni_card(card);

ALTER TABLE user12 ADD CONSTRAINT symbol UNIQUE INDEX mulUni_test_test1(test,test1);

--删除唯一索引
ALTER TABLE user12 DROP INDEX username;

ALTER TABLE user12 DROP KEY uni_card;

ALTER TABLE user12 DROP KEY mulUni_test_test1;

-- 修改表的存储引擎为MyISAM
ALTER TABLE user12 ENGINE=MyISAM;

-- 修改自增长值

ALTER TABLE user12 AUTO_INCREMENT=100;

-- 删除数据表
DROP TABLE user12;

DROP TABLE IF EXISTS user12;

DROP TABLE IF EXISTS user11,user10,user9;


DROP TABLE IF EXISTS user123,user8,user7,user6;




