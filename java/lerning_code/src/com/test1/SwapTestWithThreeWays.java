package com.test1;

/*Use three ways to swap values 
 * 1: use external memory
 * 2: +,-
 * 3: XOR
 */

public class SwapTestWithThreeWays {

	public static void main(String[] args) 
	{
		int[] res = {1,2,3,4};
		
		//对于不是同一块memory,三种方法都适用
//		swap1(res, 1, 2);
//		System.out.println(res[1] +""+ res[2]);
		
//		swap2(res, 1, 2);
//		System.out.println(res[1] +""+ res[2]);
//		
//		swap3(res, 1, 2);
//		System.out.println(res[1] +""+ res[2]);
		
		//但是如果对于同一块内存，第二种和第三种就不适合了
//		swap1(res,1,1);
//		System.out.println(res[1]);
////		
//		swap2(res,2,2);
//		System.out.println(res[2]);//输出是0
//		
		swap3(res,3,3);
		System.out.println(res[3]);//输出是0

	}

	//method3
	private static void swap3(int[] res, int i, int j) 
	{
		res[i] = res[i]^res[j];
		res[j] = res[i]^res[j];
		res[i] = res[i]^res[j];
		
	}

	//method 2
	private static void swap2(int[] res, int i, int j) 
	{
		res[i] = res[i] + res[j];
		res[j] = res[i] - res[j];
		res[i] = res[i] - res[j];
		
	}

	//method 1
	private static void swap1(int[] res, int i, int j) 
	{
		int tmp;
		tmp = res[i];
		res[i] = res[j];
		res[j] = tmp;
	}

}
