package Sort;

/*几个注意点：
 * 1: 可以写成两个函数或者三个函数，以下就是两个函数的版本
 * 2: mergeSort()中的 left和right都是inclusive的，
 * 3:mergePart()里需要创建tmp数组来临时保存合并的结果，因此归并排序空间复杂度是O(n)的
 */

public class MergeSort {

	public static void main(String[] args) 
	{
		int[] test = {1,45,0,23,345,87,24,57};
		int[] test1 = {45,45,23,23,23,23,45,45};
		int[] test2 = {1,1,1,1,1,1,1,1};
		int[] test3 ={1};
		int[] test4 = {1,2,3,4,5,6,7,8,9};
		int[] test5 ={9,8,7,6,5,4,3,2,1};
		
		mergeSort(test5, 0, 4);
		
		for(int tmp:test5)
		{
			System.out.print(tmp + " ");
		}
		
	}
	
	public static void mergeSort(int[] arr,int left, int right)
	{
		if(arr == null || arr.length == 0 || arr.length == 1) return;
		if(left >= right) return;
		
		int mid = (right+left)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr, mid+1, right);
		mergePart(arr,left,mid+1,right);
	}
	
	public static void mergePart(int[] arr,int left,int mid,int right)
	{
		if(left >= right) return;
		//if(mid > right || mid < left) return;
		
		int size = right - left +1;
		int[] tmp = new int[size];
		
		//use two pointers
		int l = left;
		int r = mid;
		int i=0;
		
		while(l < mid && r <= right)
		{
			if(arr[l] <= arr[r])
			{
				tmp[i++] = arr[l++];
			}else
			{
				tmp[i++] = arr[r++];
			}
		}
		
		
		if(l<mid)
		{
			while(l<mid)
			{
				tmp[i++] = arr[l++];
			}
		}else
		{
			while(r <= right)
			{
				tmp[i++] = arr[r++];
			}
		}
		
		//assign tmp back to arr 
		for(int j=left;j <= right;j++)
		{
			arr[j] = tmp[j-left];
		}
		
	}

}
