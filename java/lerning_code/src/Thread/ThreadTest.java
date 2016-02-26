package Thread;

public class ThreadTest 
{
	private static int count = 100;

	public static void main(String[] args) {
		// 用继承Thread类的方式启动一个线程
		new Thread() {
			public void run() {
				synchronized (ThreadTest.class) {
					while (count > 0) {
						count--;
						System.out.println(Thread.currentThread() + "卖了一张票，还剩" + count);
					}
				}
			}
		}.start();

		// 用实现Runnable接口的方式启动一个线程
		new Thread(new Runnable() {
			public void run() {
				synchronized (ThreadTest.class) {
					while (count > 0) {
						count--;
						System.out.println(Thread.currentThread() + "卖了一张票，还剩" + count);
					}
				}
			}
		}).start();
	}

}
