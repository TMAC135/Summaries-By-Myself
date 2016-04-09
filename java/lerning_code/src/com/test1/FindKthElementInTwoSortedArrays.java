package com.test1;

/*给定两个排好序的数组，返回他们之间第k大的元素
 * 1: 利用归并排序的思想，找到第k大的元素
 * 
 */

public class FindKthElementInTwoSortedArrays {

	public static void main(String[] args) 
	{
		int []arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10};
		System.out.println(find(arr1, arr2, 5));

	}
	
	public static int find(int[] arr1,int[] arr2,int k)
	{
		//special case
		if(k > arr1.length + arr2.length) return Integer.MIN_VALUE;
		
		int i=0,j=0;
		while(i < arr1.length && j < arr2.length)
		{
			k--;
			if(k == 0)
			{
				if(arr1[i] < arr2[j]) return arr1[i];
				else return arr2[j];
			}else
			{
				if(arr1[i] < arr2[j]) i++;
				else j++;
			}
		}
		return (i == arr1.length)?arr2[j+k-1]:arr1[i+k-1];
	}

}
