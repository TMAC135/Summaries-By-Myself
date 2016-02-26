 

import os
import threading
import multiprocessing

# worker function
def worker(sign, lock):
    lock.acquire()
    print(sign, os.getpid())
    lock.release()

# Main
print('Main:',os.getpid())

# Multi-thread. they all print the same PID: process ID
record = []
lock  = threading.Lock()
for i in range(5):
    thread = threading.Thread(target=worker,args=('thread',lock))
    thread.start()
    record.append(thread)

for thread in record:
    thread.join()



# Multi-process
record = []
lock = multiprocessing.Lock()
for i in range(5):
    process = multiprocessing.Process(target=worker,args=('process',lock))
    process.start()
    record.append(process)

for process in record:
    process.join()


"""
the output is :
('Main:', 4281)
('thread', 4281)
('thread', 4281)
('thread', 4281)
('thread', 4281)
('thread', 4281)
('process', 4282)
('process', 4283)
('process', 4284)
('process', 4285)
('process', 4286)
As we can see, all the threads are sharing the same PID as the Main,
however, the processes have different PID



"""