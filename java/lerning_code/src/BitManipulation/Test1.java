package BitManipulation;

public class Test1 {

	public static void main(String[] args) 
	{
		int t1 = 10;
		int t2 = -10;
		//算数右移>>：低位溢出，符号位不变，用符号位补溢出的高位
		//算数左移<<：符号不变，低位补0(相当于乘以2^k,k位移动位数，负数同样适合)
		System.out.println("before shift >>&<<:");
		System.out.println(Integer.toBinaryString(t1));
		System.out.println(Integer.toBinaryString(t2));
		System.out.println("after shift >>&<<:");
		System.out.println(Integer.toBinaryString(t1 >> 2));
		System.out.println(t2>>2);
		System.out.println(Integer.toBinaryString(t2 >> 2) + "负数>>右移时补1");
		System.out.println(t2 >>>2);//变成正数了
		System.out.println(Integer.toBinaryString(t2 >>> 2) + "负数>>>右移补0");
		System.out.println(Integer.toBinaryString(t1<<2));
		System.out.println(Integer.toBinaryString(t2<< 2));
		
		//统计一个数二进制有多少1
		int a = -100;
		System.out.println("binary:" + Integer.toBinaryString(a));
		System.out.println(numberOfOnes(a));
		System.out.println(numberOfOnes2(a));
		
	}
	
	//统计二进制数有多少个1
	public static int numberOfOnes(int num)
	{
		int res = 0;
		while(num != 0 )
		{
			num = (num-1)&num;
			res++;
		}
		return res;
	}
	
	//简单的方法:统一循环32次
	public static int numberOfOnes2(int num)
	{
		int res = 0;
		int tmp;
		for(int i=0;i<32;i++)
		{
			tmp = 1<<i;
			res = (tmp&num)!=0 ? res+1: res;
		}
		return res;
	}

	

}
