# coding=utf-8

"""
finally 里不推荐使用return 或者break 语句，因为在实际开发中finally语句总是
会被执行，如果直接return 或者break了则有可能漏掉可能的异常，出现严重的错误。
"""

def finalTest(n):
	try:
		if n<0:
			raise NameError('no negtive number')
	except IndexError,e:
		print 'index is not right'
	else:
		print 'everything is correct'
	finally:
		print 'finally'
		return -1

# 此时nameerror 没有被捕获，但是也没有被抛给上层，因为finally语句直接返回了。 
finalTest(-1)






