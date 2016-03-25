package BigInteger;

import java.util.ArrayList;


/*实现大数据的乘法
 * 
 * 
 */

public class Multiplication 
{

	public static void main(String[] args) 
	{
//		int[] res = mul("11", "11");
//		for(int tmp:res)
//		{
//			System.out.println(tmp + " ");
//		}
		
		System.out.println(mul("12345634234324234", "123312321443434"));
	}
	
	 public static String mul(String s1, String s2)
	{
		 if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return "";
		 
		 int length1 = s1.length();
		 int length2 = s2.length();
		 int resultLength = length1 + length2;
		 
		 //initialization for the array for the number
		 int []arr1 = new int[length1];
		 int []arr2 = new int[length2];
		 int []res = new int[resultLength];		 
		 //here i deal with the input number is valid
		 for(int i=length1-1;i>=0;i--)
		 {
			 //if the digit is not valid 
			 if(s1.charAt(i) - '0' < 0 || s1.charAt(i)-'0' > 10) continue;			 
			 arr1[i] = s1.charAt(i)-'0';
		 }
		 
		 for(int i=length2-1;i>=0;i--)
		 {
			 //if the digit is not valid 
			 if(s2.charAt(i) - '0' < 0 || s2.charAt(i)-'0' > 10) continue;			 
			 arr2[i] = s2.charAt(i)-'0';
		 }
		 
		 for(int i=resultLength-1;i>=0;i--)
		 {	 
			 res[i] = 0;
		 }
		 
		 //then we will do the multiplication bit by bit,notice that we need to pay attention to 
		 //the overflow
		 int tmp;
		 for(int mul1=length1-1; mul1 >=0; mul1--)
		 {
			 
			 for(int mul2=length2-1; mul2 >= 0; mul2--)
			 {
				 tmp = arr1[mul1] * arr2[mul2] + res[mul1+mul2+1] ;
				 res[mul1+mul2+1] = tmp%10;
				 res[mul1+mul2] += tmp/10;
			 }
		 }
		 
//		 return res;
		 //convert int array to char array and trim the padding zero in the front
//		 ArrayList<Character> characters = new ArrayList<>();
		 StringBuilder sb = new StringBuilder();
		 boolean flag = false;//flag to indicate the front zeros
		 char ch;
		 for(int i=0;i<resultLength;i++)
		 {
			 ch =(char)((int)'0' + res[i]);
			 if(flag == true)
			 {
				 sb.append(ch);				 
			 }else{
				 if(ch == '0') continue;
				 else
				 {
					flag = true;
					sb.append(ch);
				 }
				 
			 }
			 
		 }
		 return sb.toString();
		 
		 
		
	}

}
