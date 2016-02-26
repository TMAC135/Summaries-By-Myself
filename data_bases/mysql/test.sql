# 注释内容
-- 注释内容
-- 创建maizi数据库
CREATE DATABASE IF NOT EXISTS `maizi` DEFAULT CHARACTER SET 'UTF8';

USE `maizi`; #反引号防止与sql语句冲突

-- 创建学员表(user)
-- 编号 id
-- 用户名 username
-- 年龄 age
-- 性别 sex
-- 邮箱 email
-- 地址 addr
-- 生日 birth
-- 薪水 salary
-- 电话 tel
-- 是否结婚 married
-- 注意：当需要输入中文的时候，需要临时转换客户端的编码方式
-- SET NAMES GBK;
-- 字段注释 通过COMMENT 注释内容 给字段添加注释
CREATE TABLE IF NOT EXISTS `user`(
id SMALLINT,
username VARCHAR(20),
age TINYINT,
sex ENUM('男','女','保密'),
email VARCHAR(50),
addr VARCHAR(200),
birth YEAR,
salary FLOAT(8,2),
tel INT,
married TINYINT(1) COMMENT '0代表未结婚，非0代表已婚'
)ENGINE=INNODB CHARSET=UTF8;

-- 创建课程表 course
-- 编号 cid
-- 课程名称courseName
-- 课程描述courseDesc
CREATE TABLE IF NOT EXISTS course(
cid TINYINT,
courseName VARCHAR(50),
courseDesc VARCHAR(200)
);


-- 创建新闻分类表cms_cate
-- 编号、分类名称、分类描述
CREATE TABLE IF NOT EXISTS cms_cate(
id TINYINT,
cateName VARCHAR(50),
cateDesc VARCHAR(200)
)ENGINE=MyISAM CHARSET=UTF8;


-- 创建新闻表 cms_news
-- 编号、新闻标题、新闻内容、新闻发布时间、点击量、是否置顶
CREATE TABLE IF NOT EXISTS cms_news(
id INT,
title VARCHAR(50),
content TEXT,
pubTime INT,
clickNum INT,
isTop TINYINT(1) COMMENT '0代表不置顶，1代表置顶'
);

-- 查看cms_news表的表结构
DESC cms_news;
DESCRIBE cms_news;
SHOW COLUMNS FROM cms_news;


###########################################################
-- 测试整型
CREATE TABLE test1(
num1 TINYINT,
num2 SMALLINT,
num3 MEDIUMINT,
num4 INT,
num5 BIGINT
);
-- 向表中插入记录INSERT tbl_name VALUE|VALUES(值,...);
INSERT test1 VALUES(-128,-32768,-8388608,-2147483648,-9223372036854775808);

INSERT test1 VALUES(-129,-32768,-8388608,-2147483648,-9223372036854775808);#错误的插入，没有成功

-- 查询表中所有记录SELECT * FROM tbl_name;
SELECT * FROM test1;

-- 无符号UNSIGNED

CREATE TABLE test2(
num1 TINYINT UNSIGNED,
num2 TINYINT 
);

INSERT test2 VALUES(0,-12);

-- 零填充ZEROFILL,显示长度

CREATE TABLE test3(
num1 TINYINT ZEROFILL,
num2 SMALLINT ZEROFILL,
num3 MEDIUMINT ZEROFILL,
num4 INT ZEROFILL,
num5 BIGINT ZEROFILL
);

INSERT test3 VALUES(1,1,1,1,1);

INSERT test3 VALUES(123,1,1,1,1);

-- 测试浮点类型

CREATE TABLE test4(
#四舍五入
num1 FLOAT(6,2),
num2 DOUBLE(6,2),
num3 DECIMAL(6,2)  #以字符串形式保存,保存精度较高，因此定点数适应与高精度保存
);
INSERT test4 VALUES(3.1415,3.1415,3.1415);

INSERT test4 VALUES(3.1495,3.1495,3.1495);

#####################################################
-- 测试CHAR和VARCHAR
CREATE TABLE IF NOT EXISTS test5(
str1 CHAR(5),
str2 VARCHAR(5)
);
INSERT test5 VALUES('1','1');

INSERT test5 VALUES('12345','12345');

INSERT test5 VALUES('123456','123456');


INSERT test5 VALUES('','');#ok

INSERT test5 VALUES('1  ','1  ');#char 把末尾空格都删除，而varchar保存.

INSERT test5 VALUES('  a','  a');# 开始都空格都不能去掉

INSERT test5 VALUES('啊啊啊啊啊','麦子学院好'); #中文在utf8中占用三个字节来表示一个字符，因此CHAR(5)可以保存五个中文字.

CREATE TABLE test6(
str1 TEXT  #text不能有默认值,能不用就尽量不用
);

INSERT test6 VALUES('skdfjlksdfjlksjdflkj塑料口袋精灵是看见对方离开首都基辅绿卡时间的联发科技');

######################################################
-- 测试枚举类型
CREATE TABLE IF NOT EXISTS test7(
sex ENUM('男','女','保密    ')#自动删除后面的空格
);
INSERT test7 VALUES('男     ');

INSERT test7 VALUES('女     ');

INSERT test7 VALUES('保密');

INSERT test7 VALUES('保密1');

INSERT test7 VALUES(2);#序号是从1开始的，2代表为女

INSERT test7 VALUES(0);#0不可以

INSERT test7 VALUES(NULL);#ok

INSERT test7 VALUES('');#not ok


#############################################
-- 测试集合类型

#集合类型可以选择多个类型
CREATE TABLE IF NOT EXISTS test8(
fav SET('A','B','C','D')
);

INSERT test8 VALUES('A,C,D');#多个选项以逗号间隔

INSERT test8 VALUES('D,B,A');

INSERT test8 VALUES(3); #表示前两个爱好，1+2

INSERT test8 VALUES(15);#表示前4个爱好，1+2+4+8

###############################################
-- 测试日期时间
CREATE TABLE IF NOT EXISTS test9(
birth YEAR #1901~2155
);

INSERT test9 VALUES(1901);
INSERT test9 VALUES('1988'); #ok
INSERT test9 VALUES(2155);
INSERT test9 VALUES(2156);

INSERT test9 VALUES(0); #0000
INSERT test9 VALUES('0'); #2000

INSERT test9 VALUES(79);#1979

CREATE TABLE IF NOT EXISTS test10(
test TIME
);
INSERT test10 VALUES('1 12:12:12'); #24+12 : 12 : 12

INSERT test10 VALUES('11:11'); #11: 11: 00

CREATE TABLE IF NOT EXISTS test11(
test DATE
);
INSERT test11 VALUES('12-6-7');
INSERT test11 VALUES('12/6/7');









