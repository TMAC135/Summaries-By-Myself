# coding=utf-8

"""
str()面向用户，目的是可读性，repr()面向解释器，便于开发人员

print a => str()
a => repr()

repr() 可以用eval()还原对象

两者都可以重写__str__() 和__repr__()方法，一般类中都定义__repr__()方法，而后者
可选，若没有__str__()，则调用__repr__()
"""

class A(object):
	def __str__(self):
		return 'show on the print'
	def __repr__(self):
		return 'show on the interpreter'

# show on the interpreter
a=A()
# print a
print a

# recover the object by eval
s=' '
print eval(repr(s)) == s





