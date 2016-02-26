# coding=utf-8


"""
当前循环‘自然’终结时(循环条件为假时)，else 语句会执行一次，当循环由 break
语句中断时，else 语句就不会执行。

相应的类似的循环体有 for, while....
"""

# without else,we need to use a flag to indicate break out of the loop

def prime(n):
	for i in xrange(2,n+1):
		flag=True
		for j in xrange(2,i):
			if i % j == 0:
				flag = False
				break
		if flag:
			print "%d is a prime number"%i

# use else
def primeElse(n):
	for i in xrange(2,n):
		for j in xrange(2,i):
			if i % j == 0:
				break
		else:
			print "%d is a prime numbebr"%i

# prime(20)

primeElse(20)


"""
类似于在异常处理中，try...except...else...finally...
没有异常，执行else,finally
有异常，执行except...finally
"""





