package Concurrency;

import java.util.concurrent.locks.ReentrantLock;

/** 问题： 设计一个程序，主线程运行100次，子线程运行10次，周而复始，总共运行50次
 * -- 生产者消费者的例子的演化，注意wait(),notify(),的使用
 * @author TianRan
 *1:可以直接锁定TraditionalThreadExample.class对象，因为他是唯一的，但是这样在代码逻辑里面写线程的程序
 *显得代码维护性和拓展性差，推荐第二种方法
 *2:将线程的所有逻辑都封装成一个类（ThreadHandle）中，这样所有关于线程代码的业务逻辑都在该类中，可以大大简化代码复杂度
 */

/*也可以用condition来替代wait,notify，效果与其等效
 * Condition 创建对象是要附属于lock对象的，如：Lock myLock = new ReentrantLock(); Condition myCondition = myLock.Condition();
 * Condition对象等待和唤醒分别对应与await(),signal(),signalAll(); 效果和wait(),notify(),notifyAll()等效。
 * 
 */

/*方法:2
但是当多个线程（大于2）轮流交替运行时，运用wait()和notify()就不能达到效果，但是
可以运用condition来解决问题，condition充分体现了面向对象的思想。
*/

/*方法3:运用blocking queue对象来制造阻塞
 * 
 */

public class TraditionalThreadExample {

	public static void main(String[] args) {
		final ThreadHandler myHandler = new ThreadHandler();
		
		//子线程的程序逻辑
		new Thread(new Runnable() {
			
			public void run() {
				for(int i=0;i<50;i++){
					myHandler.subThread(i);
				}
			}
		}).start();
		
		//主线程的逻辑
		for(int i=0;i<50;i++){
			myHandler.mainThread(i);
		}
	}

}

/*处理多线程的类，便于对象的锁定，更利于
 * 业务逻辑的拓展
 */
class ThreadHandler{
	// true->mainThread, false->subThread
	private boolean flag=true;
	
	/*主线程
	 * 运行100次
	 */
	public synchronized void mainThread(int _i){
		//判断flag
		while(!flag){ //也可以用if,while更加保险
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j=0;j<100;j++){
			System.out.println("main thread is running "+j+"-->cicle"+_i);
		}
		
		//设置flag,通知子线程
		flag=false;
		notify();	
	}
	
	
	/*子线程
	 * 运行10次
	 */
	public synchronized void subThread(int _i){
		//判断flag
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(int j=0;j<10;j++){
			System.out.println("sub thread is running "+j+"-->cicle"+_i);
		}

		//设置flag,通知主线程
		flag=true;
		notify();
	}
}