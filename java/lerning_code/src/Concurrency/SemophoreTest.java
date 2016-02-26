package Concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** Semophore 信号灯的测试
 * 
 * @author TianRan
 *问题： 我们可以控制一个runnable 对象最多被几个线程同时访问，互斥锁就类似于一个Semophore对象
 */

public class SemophoreTest 
{
	
	public static void main(String[] args) 
	{
		//创建线程池
		ExecutorService myThreadPool = Executors.newCachedThreadPool();
		
		//创建信号灯,只允许三个信号灯
		final Semaphore sp = new Semaphore(3);
		
		//10个可运行的线程
		for(int i=0;i<10;i++)
		{
			Runnable runnable =new Runnable() 
			{

				public void run() 
				{
					//获得信号灯，类似于上锁
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + " has entered; " + 
										(3 - sp.availablePermits()) + " concurency ");
					
					//sleep 一段时间
					try {
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + " will left;");
					
					// 释放信号灯，类似于解锁
					sp.release();
					
					System.out.println(Thread.currentThread().getName() + " has left; "
								+ (3 - sp.availablePermits()) + " concurrency");

				}
			};
			myThreadPool.execute(runnable);
		}
			

	}

}
