# coding=utf-8

"""
python 中，None 是一个空值对象，注意它既不是0，空list，也不是空string
None 对象是唯一的，也就是说所有被赋予了None的对象都是同一个对象，并且None对象
和非None对象比较都是False.

"""

# 一般判断一个对象是否为空，不要与None判断，而是用 
"""
if a:
	print 'i am not empty'
else:
	print 'i am empty'
"""

# 上述if a 调用了类A 的特殊方法__nonzero__(),此方法如果实例对象为空，就返回false
# 如果没有定义该方法，则将__len__（）返回值进行判断：如果返回0则表示为空对象。如果两个特殊方法
# 都没有定义，则 if a 语句一直认为是true.

class A(object):
	def __nonzero__(self):
		return True

	def __len__(self):
		return 1

a=A()
if a:
	print 'i am not empty'
	# print "i am {0},{1},{2}".format('s2',2,[123])#examples of .format printout
else:
	print 'i am empty'




