package EnumTest;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/*
1: Season.values() 返回的是类型的内的实例数组
2:java.util.EnumSet 和 java.util.EnumMap。
EnumSet保证集合中的元素不重复；EnumMap中的key是enum类型，而value则可以是任意类型。 
 */

public enum Season 
{
	Spring(1),Summer(2),Fall(3),Winter(4);
	
	private int index;
	
	private Season(int index)
	{
		this.index = index;
	}
	
	//override
	public String toString() {
		return "index is: " + Integer.toString(index);
	};
	
	//main方法
	public static void main(String[] args) {
		//普通检测enum类型
//		Season a = Season.Spring;
//		System.out.println(a);
		
		//检测 .values() 返回的数组
		System.out.println(get(5));
		
		//检测EnumSet, EnumMap类
		EnumSet<Season> set = EnumSet.of(Season.Spring, Season.Summer, Season.Fall);
		
		EnumMap<Season, Integer> map = new EnumMap<>(Season.class);
		map.put(Spring, 1);
		map.put(Summer, 2);
		
		System.out.println(map.containsKey(Summer));
		System.out.println(map.get(Summer));
		System.out.println(map.containsKey(Fall));//false
		
		Set<Season> keySet = map.keySet();
		for(Season s : keySet)
		{
			System.out.println(map.get(s));
		}
		
	}
	// 普通static 方法,Season.values()返回的是具体实例的数组
	public static String get(int index)
	{
		for(Season s:Season.values())
		{
			if(s.index == index) return s.toString();
		}
		return null;
	}
	
}
