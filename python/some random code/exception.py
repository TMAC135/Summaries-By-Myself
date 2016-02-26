# exception examples:

# here if we have a=func(2),
#		the output is 'run the else part',and a= 7
# 		the process is : x=2 -> raise IndexError: x=func(3),
# 			func(3): no exception, then we run the 'else' part, print 'run the else part'
			# and we also run the finally x=5, return 5
# 		x=func(3)=5,then we run the finally part x=5+2=7,thus a=7
# if we have the return x in the try part, still a=func(2)
# 		there is no string output, and a = 5,since x=func(3)=3 (haven't run the 
	# 	finally part and else part since we don't have exception 
	# 	in the try and we have return value in the try) and finally, eturn 3+2=5
# 		similarly, a=func(3) -> a=3
class Breakit(Exception):
	pass

def func(x):
	# try:
	# 	if x==2: raise IndexError
	# 	return x
	# except IndexError:
	# 	x=func(x+1)
	# else:
	# 	print 'run the else part'
	# finally:
	# 	x=x+2
	# return x
	try:
		for i in range(10):
			for j in range(10):
				for z in range(10):
					if (i*j*z) > 20:
						re=(i,j,z)
						raise Breakit
	except Breakit:
		return re