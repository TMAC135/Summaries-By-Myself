package ArrayTest;

import java.util.Arrays;
import java.util.HashMap;

public class Test1 {

	public static void main(String[] args) 
	{
		//复制数组
		int []arr = {1,2,3,4};
		int []copy1 = Arrays.copyOf(arr, 5);
		System.out.println(Arrays.toString(copy1));//[1, 2]
		int []copy2 = Arrays.copyOfRange(arr, 0, 5);
		copy2[0]=100;
		System.out.println(Arrays.toString(copy2));//自动补0，如果长度大于原来的长度的话
		System.out.println(Arrays.toString(arr));
		
		//当hashmap中有数组的时候
		HashMap<Integer,int []> dict = new HashMap<>();
		int t1[] ={1,2,3};
		int t2[] = {4,5};
		dict.put(1, t1);
		dict.put(2, t2);
		System.out.println(Arrays.toString(dict.get(1)));
		HashMap<char [] , Integer> dict2 = new HashMap<>();
		char c1[] = {'a','b'};
		dict2.put(c1, 2);
		System.out.println(dict2.get(c1));
		
		//fill
		int []test1 = new int[10];
		Arrays.fill(test1, 5);
		System.out.println(Arrays.toString(test1));

	}

}
