package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*Lock 对象： 与synchronized 关键字实现的功能很类似
 * 
 */

public class LockTest 
{

	public static void main(String[] args) 
	{
		//thread 1
		new Thread()
		{
			public void run() 
			{
				while(true)
				{
				Outputer.output("JACK");
				}
			};
		}.start();
		//thread 2
		new Thread()
		{
			public void run() 
			{
				while(true)
				{
				Outputer.output("Rose");
				}
			};
		}.start();

		
	}
	
	//打印的内部类
	static class Outputer
	{
		static Lock myLock = new ReentrantLock(); // myLock是同一把锁
		
		public static void output(String name)
		{
			//将上锁和解锁统一成一个try...finally规范，防止在上完锁后发生异常，没有解锁
//			try {
//				myLock.lock();
				for(int i=0;i<name.length();i++)
				{
					System.out.print(name.charAt(i));
				}
				System.out.println("");
				
//			} catch (Exception e) {
//				System.out.println("something wrong");
//			}finally{
//				myLock.unlock();
//			}
			
					
		}
	}
	

}
