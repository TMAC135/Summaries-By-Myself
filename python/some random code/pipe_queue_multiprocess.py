

# 	1: Example of the pipe ,we use send to send the object and recv()
# to receivet the object on the other side of the pipe.

"""
output:
('proc2 rec:', 'hello')
('proc1 rec:', 'hello, too')
"""



# 	2: example of Queue, 

# import os
# import multiprocessing
# import time
# #==================
# # input worker
# def inputQ(queue):
#     info = str(os.getpid()) + '(put):' + str(time.time())
#     queue.put(info)

# # output worker
# def outputQ(queue,lock):
#     info = queue.get()
#     lock.acquire()
#     print (str(os.getpid()) + '(get):' + info)
#     lock.release()
# #===================
# # Main
# record1 = []   # store input processes
# record2 = []   # store output processes
# lock  = multiprocessing.Lock()    # To prevent messy print
# queue = multiprocessing.Queue(3)

# # input processes
# for i in range(10):
#     process = multiprocessing.Process(target=inputQ,args=(queue,))
#     process.start()
#     record1.append(process)

# # output processes
# for i in range(10):
#     process = multiprocessing.Process(target=outputQ,args=(queue,lock))
#     process.start()
#     record2.append(process)

# for p in record1:
#     p.join()

# queue.close()  # No more object will come, close the queue

# for p in record2:
#     p.join()



"""
output:
4327(get):4318(put):1445567259.35
4328(get):4317(put):1445567259.35
4329(get):4319(put):1445567259.35
4330(get):4320(put):1445567259.35
4331(get):4321(put):1445567259.35
4332(get):4322(put):1445567259.35
4333(get):4323(put):1445567259.36
4334(get):4324(put):1445567259.36
4335(get):4326(put):1445567259.36
4336(get):4325(put):1445567259.36
"""


import multiprocessing as mul

def f(x):
    return x**2

pool = mul.Pool(5)
rel  = pool.map(f,[1,2,3,4,5,6,7,8,9,10])
print(rel)









