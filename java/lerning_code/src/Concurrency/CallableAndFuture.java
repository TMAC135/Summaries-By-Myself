package Concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 可以调用线程的返回结果
 * @author TianRan
 *
 */
public class CallableAndFuture {

	public static void main(String[] args)  {
		
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		//通过submmit 来提交，future 来接受。
		Future<String> future = threadPool.submit(new Callable<String>(){
			public String call() throws Exception {
				Thread.sleep(1000);
				return "hello";
			}
		});
		
		//通过future 对象取到callable 返回的结果
		try {
			System.out.println("调用完，future 是：" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//future 对象可以在指定时间内接受对象，如果超过时间，则抛异常
//		future.get(2, TimeUnit.SECONDS);
		
		
		/*运用线程池处理多个任务，然后再调取每个任务的结果
		 * 通过CompletionService 对象来实现
		 */
		ExecutorService threadpool2 = Executors.newFixedThreadPool(10);
		CompletionService< Integer> myservice = new ExecutorCompletionService<Integer>(threadpool2);
		
			//提交10个任务的结果
			for(int i =0;i<10;i++){
				final int sequence = i;
				myservice.submit(new Callable<Integer>() {
					//overide call method
					public Integer call() throws Exception {
						Thread.sleep(new Random().nextInt(2000));
						return sequence;
					}
			
				});		
		}
			//提取结果
			for(int i=0;i<10;i++){
				try {
					System.out.println(myservice.take().get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		
		
	}

}
