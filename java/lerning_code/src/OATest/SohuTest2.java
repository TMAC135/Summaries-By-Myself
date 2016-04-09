package OATest;

import java.util.*;

/*题目：
	 狐进行了一次黑客马拉松大赛，全公司一共分为了N个组，每组一个房间排成一排开始比赛，比赛结束后没有公布成绩，
	 但是每个组能够看到自己相邻的两个组里比自己成绩低的组的成绩，比赛结束之后要发奖金，以1w为单位，每个组都至少会发1w的奖金，
	 另外，如果一个组发现自己的奖金没有高于比自己成绩低的组发的奖金，就会不满意，作为比赛的组织方，
	 根据成绩计算出至少需要发多少奖金才能让所有的组满意。
	
 */

/*解析：
 1: 读懂题目，理解不满意的条件，
 2: 考虑问题全面，此题顺着扫一遍是不够的，因为没有处理连续递减的情况，，例如43,23,11,
 按照顺着扫的结论，得到的结果是1,1,1;显然不符合要求，
 3: Arrays类中fill(arr,num),将原数组fill成num的元素
 */


//别人的解法，
public class SohuTest2 
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int num = scan.nextInt();
            int[] arr = new int[num];
            for(int i=0; i<num; ++i) arr[i] = scan.nextInt();
              
            int[] money = new int[num];
            Arrays.fill(money,1);
            for(int j=1; j<num; ++j){
                if(arr[j]>arr[j-1]) money[j] = money[j-1] + 1;
            }
            for(int k=num-2; k>=0; --k){
               if(arr[k]>arr[k+1]) money[k] = Math.max(money[k],money[k+1]+1);
            }
              
            int total = 0;
            for(int m : money) total += m;
            System.out.println(total);
        }
}

 //我的解法，没有考虑周全，连续递减的情况没考虑
class Main1
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		int num;
		int []arr;
		while(in.hasNext())
		{
			num = in.nextInt();
			//jump the unvalid number
			if(num <= 0) continue;
			arr = new int[num];
			for(int i=0;i<num;i++)
			{
				arr[i] = in.nextInt();
			}

			//starting from the begining,pass through the array
            int res=0;
			int prev = arr[0] +1;//make sure the first prev is greater than arr[0];
			int money=1;
			for(int i=0;i<num;i++)
			{
				if(arr[i] < prev){
					money=1;
					res += money;

				}else if(arr[i] > prev){
					money++;
					res += money;
				}else{
					res += money;
				}
				prev = arr[i];
			}
			System.out.println(res);

		}
	}
}