# coding=utf-8

"""
python 未遇到闭合的括号时自动将多行代码拼接成一行
"""
a=('select * '
	'from table'
	'where field="vallue"')
print a

"""
判断是否是字符，应该用isinstance(s,basestring)
"""
b=u'你好'
print isinstance(b,basestring)
print isinstance(b,str)
print isinstance(b,unicode)

"""
一些有用的字符串用法：
istitle():判断字符串是否每个单词都有且只有第一个字母大写
"""
b="Hello World"
print b.istitle()
c="HEllo Wo"
print c.istitle()

"""
字符的查找 for substring：count(),find(),index(),rfind(),rindex()
"""

str_all = 'Test string if string contains some special substrings'
startIndex=11
endIndex=-1
print str_all.count('string',startIndex,endIndex)
print str_all.find('sssss') #若没有找到子字符串，则返回 -1
# print str_all.index('ssss') #若没有则抛出ValueError 异常

# 判断字符串里是否包含某子字符串，用 in 和 not in
print 'str' in str_all

"""
字符的替换：replace(old,new,count),若没有指出count次数，则替换所有。
"""
str_replace=str_all.replace('string','hahaha',2)
print str_replace

"""
字符分割:partition(),split()
"""
seq = 'str'
print str_all.partition(seq)#返回3个字符元素，中间是要分割的字符串
print str_all.split(seq)
# split(seq,[maxsplit]),maxsplit 表示分切的次数
print str_all.split(seq,3)
print str_all.split()#分隔符是' '

"""
一些转换大小写：lower(),upper(),title()...
"""
#将首字母大写，并且将多个字符转换成一个空格字符，
print str_all.title()




