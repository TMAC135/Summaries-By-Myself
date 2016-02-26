package Concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**模仿ThreadLocal 来处理线程内部数据共享
 * 
 * @author TianRan
 *运用hashmap 来存储线程数据
 */

public class ThreadLocalDataTest1 {
	
//	private int data;
	private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
	
	public static void main(String[] args) {
		
		//启动多个线程
		for(int i=0;i<3;i++){
			new Thread(){
				
				public void run() {
					int data = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName() + " has create data: "+ data);
					//sleep 0.5 second
//					try {
//						Thread.sleep(50);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					// put the local thread data
					threadData.put(Thread.currentThread(),data);
					//调用方法看是否使用的一个数据
					getA();
					getB();
				};				
				
			}.start();
	}
}
	
	static void getA(){
		int _data = threadData.get(Thread.currentThread());
		System.out.println("A method is getting data:" + _data + " from " + Thread.currentThread());
		
	}
	
	static void getB(){
		int _data = threadData.get(Thread.currentThread());
		System.out.println("B method is getting data:" + _data + " from " + Thread.currentThread());
		
	}

}
