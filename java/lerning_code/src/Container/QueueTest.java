package Container;

import java.util.LinkedList;
import java.util.Queue;

/**java中的队列， 接口----Queue
 * 较流行的几个实现类： LinkedList, PriorityQueue, PriorityBlockingQueue
 * 几个方法：offer 和 add, poll 和 remove, peek 和 element, 基本就是抛出异常还是返回 null
 * @author TianRan
 *
 */

public class QueueTest 
{

	public static void main(String[] args) 
	{
		Queue<Integer> myQueue = new LinkedList<Integer>();
//		System.out.println(myQueue.remove());//抛异常
		System.out.println(myQueue.poll()); //输出为null
	
		myQueue.add(1);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.element());
		

	}

}
