package Sort;

import java.util.Random;


/*Implement the randomized quick sort algorithm
 * 几个注意点：
 * 1: 需要三个函数： 
 * quickSort() -> 调用函数，接受排序的数组，返回可以时空，也可以时一个数组
 * sortHelper(int[] arr,int left,int right) -> 排序调用时的递归函数，三个参数，包括左索引和右索引
 * partition(int[] arr,int left,int right) -> 将一个范围分成两部分，注意要返回分完的index,因此返回类型是int
 */

public class QuickSort {

	public static void main(String[] args) 
	{
		int[] test = {2,5,67,23,1,0,456,234};
		
//		int []res = quickSort(test);
		quickSort(test);
		for(int tmp:test)
		{
			System.out.print(tmp + " ");
		}

		//test for generate random value
//		for(int i=0;i<20;i++){
//		System.out.println(generateRandom(10, 30));}
		
		//test the partition function
//		int []test1 = {4,5,1,23,14,256,0,34}s;
		
//		partition(test1, 0, 7,5);
//		for(int tmp:test1)
//		{
//			System.out.println(tmp + " ");
//		}
	}
	
	public static void quickSort(int[] arr)
	{
		if(arr == null || arr.length == 0) return;
		
		sortHelper(arr,0,arr.length-1);
//		return arr;
	}

	public static void sortHelper(int[] arr,int left,int right)
	{
		if(left >= right) return;
		
//		int pivotIndex = generateRandom(left,right);
		int pivotIndex= partition(arr,left,right);
		
		//sort the left and right side of the pivot index
		sortHelper(arr, left, pivotIndex-1);
		sortHelper(arr, pivotIndex+1,right);
		
	}
	
	// generate the random int value for the given bound
	public static int generateRandom(int left,int right)
	{
		Random random = new Random();
		int gap = right -left + 1;
		return random.nextInt(Integer.MAX_VALUE)%gap + left;
	}
	
	//partition the array for the given pivot
	public static int partition(int[] arr, int left,int right)
	{
//		int pivot = arr[pivotIndex];
		int random = generateRandom(left, right);
		int pivot = arr[random];
		swap(arr,left,random);
	
		int tmp=left;//tmp is the index to partition the array for the given pivot
		for(int i=left+1;i<=right;i++)
		{
			if(arr[i] <= pivot) 
			{
				tmp++;
				swap(arr,tmp,i);
			}
				
		}
		swap(arr, left, tmp);
		return tmp;
			
	}
	
	//swap the element for the given two indices in the array
	public static void swap(int[] arr,int index1,int index2)
	{
		if(arr == null || arr.length == 0) return;
		if(index1 < 0 || index2 < 0 || index1 >= arr.length || index2 >= arr.length) return;
		
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		
	}
	
}
