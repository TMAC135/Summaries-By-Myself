package Concurrency;

import java.util.Random;

/**运用ThreadLocal对象来设置共享数据，原理和test1 一样，通过一个map来记录不同
 * 线程的数据，注意每个threadLocal对象只能存储一个数据对象，因此如果要共享多个数据类型，我们可以将数据包装成一个数据对象
 * @author TianRan
 *这里MyThreadData 可以是单例模式，并且可以静态调用 getInstance方法
 */

public class ThreadLocalDataTest2 {
	
	private static ThreadLocal<MyThreadData> myLocalThread = new ThreadLocal<MyThreadData>();

	public static void main(String[] args) {
		
		//three threads
		for(int i=0;i<3;i++){
			new Thread(){
				public void run() {
					MyThreadData data = MyThreadData.getInstance();
					data.setAge(new Random().nextInt(50));
					data.setName("peter");
					System.out.println(Thread.currentThread().getName() + "create data: " + data.getAge());
					myLocalThread.set(data);
					
					A.get();
					B.get();
				};
			}.start();
		}

	}
	
	//inner static class A
	static class A{
		static void get(){
			MyThreadData _data = myLocalThread.get();
			System.out.println("A get data from " + Thread.currentThread().getName() 
					+ " name:" + _data.getName() + " age: "+_data.getAge());
		}
	}
	
	//inner static class B
	static class B{
		static void get(){
			MyThreadData _data = myLocalThread.get();
			System.out.println("B get data from " + Thread.currentThread().getName() 
					+ " name:" + _data.getName() + " age: "+_data.getAge());
		}
	}

}

//the wrapped data class
class MyThreadData{
	private static MyThreadData myData=new MyThreadData();
	
	private MyThreadData(){};
	
	public static MyThreadData getInstance(){
		return myData;
	}
	
	//data we wrapped
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
