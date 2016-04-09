package com.test1;

import java.util.Arrays;

/*荷兰国旗（0，1，2）排序问题，只能用swap来排序：
 * 利用快排的思想，通过设置区间来遍历整个数组
 * 	[0,i-1] ~ 0
 *  [i,k-1] ~ 1
 *  [k,j-1] ~ 待排序的区域
 *  [j,n-1] ~ 2
 *  
 *  注意要检验初试的赋值条件
 */

/*总结：
 * 这个问题是快速排序的扩展，当要对多个区域（n）进行partition的话，需要n+1个变量来划分
 * 区域，例如上述的4个区域，当然有一个区域是带探测的区域。
 * 思路要非常清晰！！！！！
 */

public class QuickSortPartition {

	
	public static void main(String[] args) 
	{
		int []test = new int[10];
//		int []test = {0,2,1,1,1,0,2,1,2};
//		int []test = {0,0,0,0,0,0};
		Arrays.fill(test, 2);
		
		
		partition(test, 3);
		for(int tmp:test)
		{
			System.out.print(tmp + " ");
		}

	}
	
	//给定数组和元素种类，将数组排序
	public static void partition(int[] arr, int num)
	{
		int i=0,j=arr.length;
		
		for(int k=0;k<j;k++)
		{
			if(arr[k] == 0)
			{
				swap(arr,i++,k);
				
			}else if(arr[k] == 2)
			{
				swap(arr,--j,k);
				k--;
			}

		}
		
	}
	
	public static void swap(int[] arr, int index1 , int index2)
	{
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

}
