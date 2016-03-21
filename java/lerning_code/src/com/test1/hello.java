package com.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hello {

	/***
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		int[] A = new int[5];
//		A[0]=1;
//		A[1]=2;
//		A[2]=3;
//		int[] B = {4,5};
//		
//		mergeSortedArray(A, 3, B, 2);
//		System.out.println(Arrays.toString(A));
		
		
		//we can add the null to the list
//		ArrayList<Integer> cur = new ArrayList<Integer>();
//		cur.add(null);
//		cur.add(null);
//		System.out.println(cur.size());//2
//		System.out.println(cur);
//		
//		//we can override the existing key-value for put method in HashMap
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(1, 1);
//		map.put(1, 2);//we override the 1
//		System.out.println(map.get(1));//2
		
		//List<Object> list=new ArrayList<String>() 和 List<String> list=new ArrayList<Object>(),两种都不行
//		List<Object> list=new ArrayList<String>();//wrong,can't convert ArrayList<String> to List<Object>
//		List<String> list2=new ArrayList<Object>();
		
		
		// 数组类包括ArrayList, 不好用，建议用List<ArrayList<>>
		ArrayList<Integer>[] res = new ArrayList[5];
//		Object[] res = new Object[5];
		for(int i=0;i<res.length;i++)
		{
			res[i] = new ArrayList<Integer>();
		}
		res[1].add(2);
		res[1].add(3);
		res[2].add(10);
		System.out.println(res[1]);
		System.out.println(res[2]);
		
		List<ArrayList<Integer>> res2 = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<5;i++)
		{
			res2.add(new ArrayList<Integer>());
		}
		res2.get(1).add(10);
		res2.get(1).add(3);
		System.out.println(res2.get(1));
		
		Map<Integer, ArrayList<Integer>> myMap = new HashMap<>();
		for(int i=0;i<5;i++)
		{
			myMap.put(i, new ArrayList<Integer>());
		}
		myMap.get(2).add(2);
		myMap.get(2).add(4);
		System.out.println(myMap.get(2));

		ArrayList<Integer> cur = new ArrayList<>(2);
		System.out.println(cur.size());
//		cur.get(2);
		cur.add(2);
		cur.add(3);
		cur.add(4);
//		System.out.println(cur.get(2));
		
		
	}
	
	
	public static void mergeSortedArray(int[] A, int m, int[] B, int n) 
    {
      //boundary cases
      if(n == 0) return;
      
      //two pointers for the two array from the end of the arrays
      int indexB = n - 1;
      int indexA = m - 1;
      
      int merge = n + m -1;
      while(merge < 0)
      {
        //determine whether the index of A and B are valid
        if(indexA < 0)
        {
          while(indexB <0)
          {
            A[merge--] = B[indexB--];
          }
          return;            
        }
        if(indexB < 0)
        {
          return;
        }
        
        if(A[indexA] >= B[indexB])
        {
          A[merge] = A[indexA--];
        }else
        {
          A[merge] = B[indexB--];
        }
        merge--;        
      }
    }

}
