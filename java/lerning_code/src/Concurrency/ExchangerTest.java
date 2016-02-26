package Concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**Exchanger: 同步工具类 －－买家和买家
 * 当有两个线程或多个想交换数据时
 * @author TianRan
 *
 */

public class ExchangerTest {

	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "zxx";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"想交换数据 " + data1);
					Thread.sleep((long)(Math.random()*10000));
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"换回的数据时 " + data2);
				}catch(Exception e){
					
				}
			}	
		});
		service.execute(new Runnable(){
			public void run() {
				try {				

					String data1 = "lhm";
					System.out.println("线程" + Thread.currentThread().getName() + 
					"想交换数据 " + data1);
					Thread.sleep((long)(Math.random()*10000));					
					String data2 = (String)exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + 
					"交换的数据为 " + data2);
				}catch(Exception e){
					
				}				
			}	
		});		

	}

}
