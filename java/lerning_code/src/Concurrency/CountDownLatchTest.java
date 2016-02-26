package Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**CountDownLatch:同步工具类，倒计时计数器 -- 跑步比赛的例子
 * CountDownLatch 对象的countDown()方法，当计数为0时，所有等待者开始执行
 * @author TianRan
 *实现一个人等待所有人的结果，实现一人通知多人，类似与一个裁判员
 */
public class CountDownLatchTest 
{

	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1); //开始一个计数器
		final CountDownLatch cdAnswer = new CountDownLatch(3);	//结束的计数器	
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable(){
					public void run(){
					try {
						System.out.println("线程" + Thread.currentThread().getName() + 
								"准备接受命令");						
						cdOrder.await();
						System.out.println("线程" + Thread.currentThread().getName() + 
						"已接受命令");								
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("线程" + Thread.currentThread().getName() + 
								"回应命令处理结果");						
						cdAnswer.countDown();						
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
			};
			//在for循环里面，每创建一个线程，加入到线程池中
			service.execute(runnable);
		}	
		//在for循环外面，类似于裁判的功能
		try {
			Thread.sleep((long)(Math.random()*10000));
		
			System.out.println("线程" + Thread.currentThread().getName() + 
					"即将发布命令");						
			cdOrder.countDown();
			System.out.println("线程" + Thread.currentThread().getName() + 
			"已发布命令，正在等待结果");	
			cdAnswer.await();
			System.out.println("线程" + Thread.currentThread().getName() + 
			"已收到所有响应结果");	
		} catch (Exception e) {
			e.printStackTrace();
		}				
		service.shutdown();

	}


}
