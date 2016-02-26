package Concurrency;

/**
 * 原始方法解决多线程锁的问题：通过synchronized 来锁定同一个对象，如果是静态的方法，则锁定class对象
 * @author TianRan
 *
 */

public class TraditionalThreadTest {

	public static void main(String[] args) {
		new TraditionalThreadTest().init();
	}
	
	//内部类实例话一定要有外部类的实例化对象，因此我们需要先创建外部类对象
	private void init(){
		final Printer printer = new Printer();

		new Thread(){
			public void run() {
				while(true){
					printer.print1("aaaaaaa");
				}
			};}.start();
		new Thread(){
			public void run() {
				while(true){
					printer.print2("bbbbbbb");
				}
			};
		}.start();			
	}
		
	
	//一个基本内部类，来演示互斥对象
	class Printer{
		
		//方法1:synchronized 锁定方法就等效与的是锁定this 对象
		synchronized void print1(String _s){
			for(int i=0;i<_s.length();i++){
				System.out.print(_s.charAt(i));	
			}
			System.out.println("");
		}
		//方法2：在内部锁定this 对象，因此和方法1是等效的
		void print2(String _s){
			synchronized (this) {
				for(int i=0;i<_s.length();i++){
					System.out.print(_s.charAt(i));	
				}
				System.out.println("");
			}
		}		
	}
	
	//一个静态内部类
	static class Output{
		//方法1:静态方法这时候需要锁定class 对象
		static void print1(String _s){
			synchronized (Output.class) {
				for(int i=0;i<_s.length();i++){
					System.out.print(_s.charAt(i));	
				}
				System.out.println("");
			}
		}
		//方法2:与方法1等效
		static synchronized void print2(String _s){
//			synchronized (this) {
				for(int i=0;i<_s.length();i++){
					System.out.print(_s.charAt(i));	
				}
				System.out.println("");
			}
//		}
	}
}
