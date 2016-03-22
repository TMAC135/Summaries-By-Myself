package Sort;

/*几个注意点：
 * 1: 三个基本步骤
 * 		1: 从含有孩子节点开始向上依次建立最大堆(max heap)，即将原数组变成堆
 * 		2: 取出堆中最大元素，放在末尾，注意此时堆的大小也改变了饿
 * 		3: 当堆的大小变为1时，代表排序结束
 * 2: 注意要维持一个heapSize的变量，因为heapSize 是我们heaplifyDown（）的主要判定条件
 * 3: 在heaplifyDown()方法内，先判断当前节点是否含有左孩子和右孩子，如果有，需要将三者之中的最大值放在parent 节点上
 * 
 */

public class HeapSort {

	public static void main(String[] args) 
	{
		int[] test = {1,45,0,23,345,87,24,57};
		int[] test1 = {45,45,23,23,23,23,45};
		int[] test2 = {1,1,1,1,1,1,1,1,1,1};
		int[] test3 ={1};
		int[] test4 = {1,2,3,4,5,6,7,8,9};
		int[] test5 ={9,8,7,6,5,4,3,2,1};
		
		heapSort(test5);
//		heaplifyDown(test, 0, 8);
		for(int tmp:test5)
		{
			System.out.print(tmp + " ");
		}
	}
	
	public static void heapSort(int[] arr)
	{
		if(arr == null || arr.length == 0) return;
		
		//build the heap in the array firstly
		for(int i=arr.length/2-1;i>=0;i--)
		{
			heaplifyDown(arr, i,arr.length);	
		}
		
		for(int i=0;i<arr.length;i++)
		{
			swap(arr,0,arr.length-i-1);
			heaplifyDown(arr, 0,arr.length-i-1);
		}
	}
	

	//function to build the max heap for given index in the array
	public static void heaplifyDown(int[] arr,int index,int heapSize)
	{
		//edge case
		if(index >= heapSize-1) return;
		int cur = index;
		int tmp;
		
		/*第一遍写错了，注意heaplify的时候如果左右孩子都存在时候，需要找出最大值再交换
		while(cur*2+1 < heapSize)//this condition will make sure we'll have at least one left child
		{
			tmp = cur*2+1;
			
			if(arr[tmp] > arr[cur])//only valid left child 
			{
				swap(arr, cur, tmp);
				cur = tmp;
				continue;			
			}else if(tmp < heapSize -1) // valid right child
			{
				if(arr[tmp+1] > arr[cur])//right child is larger
				{
					swap(arr, cur, tmp+1);
					cur = tmp+1;
					continue;
				}else//left and right child are both less than the parent, which satisfy the max heap
				{
					break;
				}			
			}else //only have left child and left child is less than parent
			{
				break;
			}			
		}
		*/
		
		
		while(cur*2 + 2 < heapSize) // this condition hold for valid left and right child
		{
			tmp = cur*2+1;
			if(arr[cur] >= arr[tmp] && arr[cur] >= arr[tmp+1]) return; //satisfy the property of max heap
			else //need to rearrange the node
			{
				if(arr[tmp] >= arr[tmp+1])
				{
					swap(arr, cur, tmp);
					cur = tmp;
				}else
				{
					swap(arr, cur, tmp+1);
					cur=tmp+1;
				}
			}			
		}
		
		//need to judge whether it still has left child
		if(cur*2 +1 < heapSize)
		{
			if(arr[cur] < arr[cur*2+1])
			{
				swap(arr, cur, cur*2+1);
			}
		}
		
		
	}
	
	//function to swap the values in the array
	public static void swap(int[] arr,int index1,int index2)
	{
		if(index1 <0 || index1 >= arr.length || index2 <0 || index2 >= arr.length) return;
		
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
