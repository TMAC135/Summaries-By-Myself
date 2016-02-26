package Concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**CyclicBarrier: 同步工具类 －－集合等待的例子
 * 类似于排队集合的生活例子，当我们希望在哪里集合所有线程的时候，调用await()方法
 * @author TianRan
 *
 */

public class CyclicBarrierTest 
{

	public static void main(String[] args) 
	{
		//thread pool
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		//CyclicBarrier,规定三个到齐后在继续执行
		final CyclicBarrier barrier = new CyclicBarrier(3);

		for(int i=0;i<3;i++)
		{
			Runnable runnable = new Runnable() 
			{
				
				public void run() 
				{
					//sleep different time for different threads for stage 1
					try {
						Thread.sleep(new Random().nextInt(2000));
						System.out.println(Thread.currentThread().getName() + " has finished statge 1 -- "
										+ barrier.getNumberWaiting() + " threads waited");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						barrier.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (BrokenBarrierException e1) {
						e1.printStackTrace();
					}
					
					//sleep different time for different threads for stage 2
					try {
						Thread.sleep(new Random().nextInt(3000));
						System.out.println(Thread.currentThread().getName() + " has finished statge 2 -- " 
										+ barrier.getNumberWaiting() + " threads waited");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
									
				}
			};
			threadPool.execute(runnable);
		}
		threadPool.shutdown();
	}

}
