package com.test1;

import java.util.Arrays;

public class hello {

	/***
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] A = new int[5];
		A[0]=1;
		A[1]=2;
		A[2]=3;
		int[] B = {4,5};
		
		mergeSortedArray(A, 3, B, 2);
		System.out.println(Arrays.toString(A));
		
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
