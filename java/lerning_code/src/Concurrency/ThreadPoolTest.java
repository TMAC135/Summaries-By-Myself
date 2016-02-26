package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的用法： Executors,ExecutorService 包。
 * @author TianRan
 * 如果服务器的客户端很多，每一个客户端都会不断创建个销毁线程，这将严重影响服务器的性能，，而正确的做法是每来一个
 * 客户端，我们会安排空闲的线程为之服务，这些线程的集合就是线程池。这样在线程池的编程环境下，我们是将任务提交给线程池而不是
 * 某单个线程，线程池拿到线程时，会自动查找有无空闲的线程，安排任务。
 */

public class ThreadPoolTest {

	public static void main(String[] args) {
		//create thread pool,only contains 3 thread.固定的线程池
		ExecutorService threadPoll = Executors.newFixedThreadPool(3);
		//缓存的线程池，可以自动开启线程
		ExecutorService threadPool = Executors.newCachedThreadPool();
		//创建单一线程
		ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i<10;i++){
			final int task=i;
			//往线程池里仍东西
			threadPool.execute(new Runnable() {
				
				public void run() {
					for(int j=0;j<20;j++){
						//休息一段时间
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						
						System.out.println("task" + task+ "is running, " + "for j=" + j);	
					}
				}
			});			
		}
		
		System.out.println("have commited all 10 tasks to the pool");
		threadPool.shutdownNow();//如果我们关闭线程池，由于我们只开启了3个线程，则实现3个线程后我们就不在执行	
							 //其他task了
		
	}

}
