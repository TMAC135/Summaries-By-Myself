package Concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**SynchronousQueueTest: 同步队列，只有当一个队列take时候，才能put元素
 * 
 * @author TianRan
 * 要求10个线程排队一次取出10个元素，然后在输出响应的数字
 */

public class SynchronousQueueTest {

	public static void main(String[] args) {
		//保证一次只能一个线程输出
		final Semaphore semaphore = new Semaphore(1); //使用信号灯来解决每个线程依次输出
//		final Lock lock = new ReentrantLock();//使用lock也能解决问题
		
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){
				
				public void run() {	
					try {
						semaphore.acquire();
//						lock.lock();
						String input = queue.take();
						String output = TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+ ":" + output);
						semaphore.release();
//						lock.unlock();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}).start();
		}
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<10;i++){  //此行不能改
			String input = i+"";  //此行不能改
			try {
				queue.put(input);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


//此类不能改
class TestDo {
	public static String doSome(String input){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}