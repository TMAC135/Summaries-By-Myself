package Concurrency;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*阻塞队列的演示 －－生产者和消费者的BlockingQueue的实现
 * 
 */

public class BlockingQueueTest {

	public static void main(String[] args) {

		final BlockingQueue queue = new ArrayBlockingQueue(3);
		for(int i=0;i<2;i++){
			new Thread(){
				public void run(){
					while(true){
						try {
							Thread.sleep((long)(Math.random()*1000));
							System.out.println(Thread.currentThread().getName() + "准备放数据");							
							queue.put(1);
							System.out.println(Thread.currentThread().getName() + "已经放了数据" + 							
										"队列里还有" + queue.size() + "个数据");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
				
			}.start();
		}
		
		new Thread(){
			public void run(){
				while(true){
					try {
						//修改睡眠时间，观看生产者和消费者的情况
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + "准备取数据");
						queue.take();
						System.out.println(Thread.currentThread().getName() + "已经取了数据" + 							
								"队列里还有" + queue.size() + "个数据");					
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}.start();
	}

}
