package OATest;


import java.awt.print.Printable;

/*
输出蛇形矩阵：给定方矩阵的宽度N,输出相应的蛇形矩阵
如：N=3
1 2 3
8 9 4
7 6 5
输出矩阵结果

*/

/*
edge case:

1 2  ==> N/2 = 1
4 3

1 2 3 
8 9 4  ==> N/2 = 1
7 6 5
*/


import java.util.*;

public class SpiralMatrix
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			int N = in.nextInt();
			if(N <= 0 ) continue;

			int [][]res = new int[N][N];
			int layer = 0;//record the number layer by layer
			//0:left->right  1:top->down  2:right->left  3:bot -> up
			int dir = 0;
			int row = 0;
			int col = 0;
			int num = 1;

			while(layer < N/2)
			{
				switch(dir)
				{
					case 0:	
						while(col < N-1-layer) res[row][col++] = num++;
						dir = 1;
						break;
					case 1:
						while(row < N-1-layer) res[row++][col] = num++;
						dir = 2;
						break;
					case 2:
						while(col > layer) res[row][col--] = num++;
						dir = 3;
						break;
					case 3:
						while(row > layer) res[row--][col] = num++;
						//prepare for the next layer
						layer++;
						dir = 0;
						
						//特别注意，这个bug我找了10分钟！！，注意要将设置下一次遍历的起始点
						row++;
						col++;
						break;	
				}

			}
			//the center number based on the even or odd of N
			if(N%2 != 0) res[row][col] = num;
			printArray(res);

//			System.out.println(Arrays.toString(res));//不适合二维数组
		}
	}
	
	//print the given array row by row
	public static void printArray(int[][] res)
	{
		int row = res.length;
		int col = res[0].length;
		for(int i=0; i < row; i++)
		{
			for(int j = 0; j < col ; j++)
			{
				
			System.out.print(res[i][j]);
			System.out.print(" ");
			}
			System.out.println();
		}
	}
}