# coding=utf-8

"""
list comprehension  [expr for iter_item in iterable if condition]
支持多重嵌套，而且表达式expr也可以是函数。
"""

a=[i for i in range(10) if i%2==0]
print a

# 多重嵌套
words=['apple','orange','banana']
aa=[[inner.upper() for inner in outer] for outer in words]
print aa

# 多重迭代
b = [(i,j) for i in range(5) for j in range(5,10) if i+j!=9]
print b

# 表达式是函数
def foo(v):
	if v%2 == 0:
		return v/2
	else:
		return v
c=[foo(i) for i in xrange(10)]
print c

"""
generator (),与list comprehension 类似，只是生成了一个generator
"""


"""
set comprehension: {}
生成了一个集合，无序不重复
"""

d={i for i in xrange(10) if i%2 != 0}
print d


"""
dictionary comprehension: {expr1:expr2 for iter_item in iterable if condition}
"""

e={i:i+1 for i in xrange(5)}
print e



