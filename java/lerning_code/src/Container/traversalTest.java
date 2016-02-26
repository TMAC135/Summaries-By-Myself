package Container;

import java.util.*;
import java.util.Map.Entry;

/*3 ways to traversal the container
 * 1，	使用迭代器Iterator的方式。
   2，	使用增强for循环的方式。
   3，	如果有下标，则可以使用下标的方式。
 */

public class traversalTest 
{
	public static void main(String[] args) 
	{
		/*遍历List
		 * 
		 */
		List<String> myList = new ArrayList<String>();
		
		myList.add("a");
		myList.add("b");
		myList.add("c");
		
//System.out.println(myList);
		
		//1:增强for循环
//		for(String ele:myList)
//		{
//			System.out.println(ele);
//		}
		
//		//2:下标
//		for(int i=0;i<myList.size();i++)
//		{
//			System.out.println(myList.get(i));
//		}
//		
//		//3:迭代器
//		for(Iterator<String> iter = myList.iterator();iter.hasNext();)
//		{
//			String elt = iter.next();
//			System.out.println(elt);
//		}
//		
//		System.out.println("-----------------------");
//		/*遍历set
//		 * 
//		 */
//		Set<String> mySet = new HashSet<String>();
//		
//		mySet.add("a");
//		mySet.add("b");
//		mySet.add("a");
//		
//		//1:增强for循环
//		for(String elt:mySet)
//		{
//			System.out.println(elt);
//		}
//		
//		//2:迭代器
//		for(Iterator<String> iter = mySet.iterator();iter.hasNext();)
//		{
//			String elt = iter.next();
//			System.out.println(elt);
//		}
//		
//		System.out.println("-----------------------");
//		
//		/*遍历map
//		 * 
//		 */
//		Map<String,String> myMap = new HashMap<String,String>();
//		myMap.put("key1", "value1");
//		myMap.put("key2", "value2");
//		myMap.put("key3", "value3");
//		
//		//得到每一组entry
//		for(Entry<String,String> entry:myMap.entrySet())
//		{
//			System.out.println(entry);
//		}
//		
//		//得到key set
//		for(String key:myMap.keySet())
//		{
//			System.out.println(key);
//		}
//		
//		//得到value set
//		for(String value:myMap.values())
//		{
//			System.out.println(value);
//		}
//		//判断是否是一个实例，用instanceof 来判断
//		System.out.println(myMap instanceof Map<?,?>);
//		
		
	}

}
