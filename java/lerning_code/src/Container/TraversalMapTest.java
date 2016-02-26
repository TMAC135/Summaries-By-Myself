package Container;

import java.util.*;
import java.util.Map.Entry;

public class TraversalMapTest 
{
	/* 两种方式遍历Map
	 * 
	 */
	public static void main(String[] args) 
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("jack", 20);
		map.put("rose", 25);
//		System.out.println(map.put("jack", 25));//如果我们重写了
									//原来的key值的value,我们将返回原来的value,即20		
		map.put("peter", 30);
		
		//遍历方法1:通过keySet()
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext())
		{
			String tmp = iter.next();
			System.out.println("key:"+ tmp + " value:"+map.get(tmp));
		}
		System.out.println("-----------------------");
		
		//遍历方法2:通过Map.Entry<> 来得到键值对集合,注意吧Entry<E,T>当成一种数据类型，例如String
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String,Integer>> iter2 = entrySet.iterator();
		while(iter2.hasNext())
		{
			Entry<String,Integer> tmp = iter2.next();
			System.out.println("key:"+ tmp.getKey() + " value:"+ tmp.getValue());
		}
		System.out.println("-----------------------");
		
		//注意上述方法可以实用增强的for 循环,每个元素都是entry范型
		for(Entry<String, Integer> eachEntry:map.entrySet()){
			System.out.println(eachEntry);
		}
		
		for(String mykey: map.keySet()){
			System.out.println(mykey+"="+map.get(mykey));
		}
		
	}

}
