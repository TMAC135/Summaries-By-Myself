# coding=utf-8
# show the function of OrderedDict in the package collections

from collections import OrderedDict


print 'Regular dictionary:'  
d={}  
d['a']='A'  
d['b']='B'  
d['c']='C'  
for k,v in d.items():  
    print k,v  
  
print '\nOrderedDict:'
# ordered dict 是可以记录字典中加入的顺序的 
d=OrderedDict()  
d['a']='A'  
d['b']='B'  
d['c']='C'  
for k,v in d.items():  
    print k,v

print "--------------------------------"


print 'Regular dictionary:'  
d1={}  
d1['a']='A'  
d1['b']='B'  
d1['c']='C'  
  
d2={}  
d2['c']='C'  
d2['a']='A'  
d2['b']='B'  
  
print d1==d2 #普通的字典是相同的，跟字典无关
  
print '\nOrderedDict:'  
d1=OrderedDict()  
d1['a']='A'  
d1['b']='B'  
d1['c']='C'  
  
d2=OrderedDict()  
d2['c']='C'  
d2['a']='A'  
d2['b']='B'  
  
print  d1==d2 #不相同，因为跟插入的顺序有关

print "--------------------------------"

# 可以用ordered dict来排序
d = {'banana': 3, 'apple':4, 'pear': 1, 'orange': 2}

print OrderedDict(sorted(d.items(), key=lambda t: t[0])) #按照key来排序,在产生一个OrderedDict
print OrderedDict(sorted(d.items(), key=lambda t: t[1])) #按照value来排序,在产生一个OrderedDict
print OrderedDict(sorted(d.items(), key=lambda t: len(t[0]))) #按照字符长度来分,返回一个OrderedDict





















































