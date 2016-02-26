


# class suibian(object):
# 	def __init__(self,value):
# 		self.value=value

# 	def __call__(self,arg1,arg2):
# 		return arg1-arg2


# class Sample:
#     def __enter__(self):
#         return self
 
#     def __exit__(self, type,
#  value, trace):
#         print ("type:", type)
#         print ("value:",value)
#         print ("trace:",trace)
 
#     def do_something(self):
#         bar = 1/0
#         return bar + 10


# if __name__=='__main__':

# 	with Sample() as sample:
# 	    sample.do_something()


# def line_conf(a,b):
# 	# v={}#use dict to store 
# 	# v['0']=a*b
# 	v=[0]
# 	v[0]=a*b
# 	def line(x):
# 		# nonlocal i #only can be used in python 3 which means this variable is not in this local function
# 		# v['0']=v['0']+x
# 		v[0]=v[0]+x
# 		return v[0]*x+b
# 	return line

# if __name__=='__main__':
# 	l1=line_conf(4,5)
# 	# l2=line_conf(10,4)
# 	print(l1(5))
# 	# print(l2(3))

# Example for the recursion:
# Recursion in the generator, 
# def rerc_generator(l):
# 	for s in l:
# 		if isinstance(s,list):
# 			# yield rerc(s)   # this doen't work,since every time yield will generate a new object
# 			for item in rerc(s):
# 				yield item
# 		else:
# 			yield s

# # if we recurse by the value instead of generator:
# def rerc(l):
# 	for s in l:
# 		if isinstance(s,list):
# 			rerc(s)
# 			# yield rerc(s)   # this doen't work,since every time yield will generate a new object
# 			# for item in rerc(s):
# 			# 	yield item
# 		else:
# 			print s

# def facto(n):
# 	if n>=1:
# 		return n * facto(n-1)
# 	else:
# 		return 1


# #Pickle module
# import pickle
# class Bird(object):
# 	def __init__(self,n):
# 		self.n=n


# if __name__=='__main__':
# 	a=Bird(3)
# 	# b=pickle.dumps(a)
# 	fn='a.pkl'
# 	with open(fn,'w') as f:
# 		pickle.dumps(a,f)

# 	with open('test.data','r') as f:
# 		b=pickle.load(f)
# 	print b.n



# Experiment about the attribute in class 

# class Circle(object):
# 	def __init__(self,name):
# 		self.name=name
# 	def __getattr__(self,name):
# 		if name=='area':
# 			return 4
# 		elif name=='length':
# 			return 8
# 		else:
# 			object.__getattr__(self,name)
# 	def __setattr__(self,name,value):
# 		if name in ['area','length']:
# 			raise TypeError('not acceptable')
# 		object.__setattr__(self,name,value)


# Overload __repr__(self) and __str__(self)

# class complex(object):
# 	def __init__(self,real,img):
# 		self.real=real
# 		self.img=img

# 	def __repr__(self):
# 		return 'Complex(%s,%sjjj)' % (self.real,self.img)

# 	def __str__(self):
# 		return '(%g+%gjjjjj)' % (self.real,self.img)

# 	def __add__(self,other):
# 		return complex(self.real+other.real,self.img+other.img)

# if __name__=='__main__':
# 	a=complex(2,3)
# 	a+complex(2,3) #the result will go into the __repr__(self) and show in the interactive screnn
# 	print a+complex(2,3) # __str__ methos is simple way, often show in the print commend,if we 
# 						# don't define __str__(self) , we will print (__repr__(self))


# __call__ method in the class:

# class A(object):
# 	def __init__(self,value):
# 		self.value = value

# 	def __call__(self,value):
# 		return self.value * value



"""
__getattr__ and __setattr__
the attribute in the instance is stored in dictionary self.__dict__.
notice that the key of this dictionary must be string.
"""

# class A(object):
# 	def __getattr__(self,value):
# 		if value=='name':
# 			return 40

# 		else:
# 			raise AttributeError, name
# 	def __setattr__(self,key,value):
# 		if key == 'age':
# 			self.__dict__[key]=value
# 		else:
# 			raise AttributeError,key

# if __name__=='__main__':
# 	a=A()
# 	print a.name
# 	# print a.age
# 	# a.name=1
# 	a.age=12

"""
a example of decorator 


"""
# from functools import wraps


def mu(x):
	# @wraps(x)
	def _mu(*args,**kwargs):
		a,b=args
		print "in decorator"
		return a*a
	return _mu
@mu
def test(x,y):
	print (x,y)

		
if __name__=='__main__':
	print test(2,3)





















































