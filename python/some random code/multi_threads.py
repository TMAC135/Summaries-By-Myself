# example of multi threads

# A program to simulate selling tickets in multi-thread way
# Written by Vamei

# 1: the method is similar to C, using Process_Orianted method


"""
import threading
import time
import os

# This function could be any function to do other chores.
def doChore():
    time.sleep(0.5)

# Function for each thread
def booth(tid):
    global i
    global lock
    while True:
        lock.acquire()                # Lock; or wait if other thread is holding the lock
        if i != 0:
            i = i - 1                 # Sell tickets
            print(tid,':now left:',i) # Tickets left
            doChore()                 # Other critical operations
        else:
            print("Thread_id",tid," No more tickets")
            os._exit(0)              # Exit the whole process immediately
        lock.release()               # Unblock
        doChore()                    # Non-critical operations

# Start of the main function
i    = 10                           # Available ticket number 
lock = threading.Lock()              # Lock (i.e., mutex)

# Start 10 threads
for k in range(10):
    new_thread = threading.Thread(target=booth,args=(k,))   # Set up thread; target: the callable (function) to be run, args: the argument for the callable 
    new_thread.start()                                      # run the thread

"""

# 	The OOP method: we inherit the threading.Thread class and merge the 
# run function into the class.

# OOP的话，通过修改Thread类的run()方法来定义线程所要执行的命令。

import threading
import time
import os

# This function could be any function to do other chores.
def doChore():
    time.sleep(0.5)

# Function for each thread
class BoothThread(threading.Thread):
    def __init__(self, tid, monitor):
        self.tid          = tid
        self.monitor = monitor
        threading.Thread.__init__(self)
    def run(self):
        while True:
            monitor['lock'].acquire()                          # Lock; or wait if other thread is holding the lock
            if monitor['tick'] != 0:
                monitor['tick'] = monitor['tick'] - 1          # Sell tickets
                print(self.tid,':now left:',monitor['tick'])   # Tickets left
                doChore()                                      # Other critical operations
            else:
                print("Thread_id",self.tid," No more tickets")
                os._exit(0)                                    # Exit the whole process immediately
            monitor['lock'].release()                          # Unblock
            doChore()                                          # Non-critical operations

# Start of the main function
monitor = {'tick':10, 'lock':threading.Lock()}

# Start 10 threads
for k in range(10):
    new_thread = BoothThread(k, monitor)
    new_thread.start()