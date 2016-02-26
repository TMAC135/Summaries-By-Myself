package Container;

import java.util.ArrayList;
import java.util.Iterator;

/**关于RandomAccess 接口的说明：为了能快速遍历，通常是O(1)，RandomAccess 并不是任意选取元素
 * 几个重要的实现了该接口的class， ArrayList, Vector, Stack, 这些都是底层实现了数组，因此O(1)时间找到
 * 
 * @author TianRan
 *
 */

public class RandomAccessTest 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		for(int j = 0; j<10000000; j++)
		{
			myList.add(j);
		}
//		myList.add(1);
//		myList.add(2);
//		myList.add(3);
//		myList.add(4);
//		myList.add(5);
		
		int sum=0;
		//使用get方法得到的元素，random access，更快
		long start1 = System.currentTimeMillis();
		for(int i=0;i<myList.size();i++)
		{
			sum += myList.get(i);
//			System.out.println(myList.get(i));
		}
		System.out.println((System.currentTimeMillis() - start1));//time unit is second
		System.out.println("--------------------");
		
		//使用iterator 模式来遍历是有序的,若要用for 来实现iterator，注意iter.next()  返回的是具体的数据类型
		long start2 = System.currentTimeMillis();
		for(Iterator<Integer> iter=myList.iterator();iter.hasNext();)
		{
			int elt = iter.next();
			sum += elt;
//			System.out.println(elt);
		}
		System.out.println((System.currentTimeMillis() - start2));//time unit is second
		System.out.println("--------------------");
		
		//使用增强的for循环来遍历
		long start3 = System.currentTimeMillis();
		for(int i:myList)
		{
//			System.out.println(i);
			sum += i;
		}
		System.out.println((System.currentTimeMillis() - start3));
	}

}
