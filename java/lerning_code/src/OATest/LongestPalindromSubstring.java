package OATest;

/*
最长回文字符串：
给定一个字符串，可以通过删除其中的一些字符，得到相应的回文字符串，求最长的回文子字符串。
例如：
输入：cabbeaf
输出：4(对应的回文串是：abba)
*/

/*我的基本思路：
1: 使用递归的思路，分两种情况，一种是包括当前字符串第一个字符，另一种不包括
2: 当包含第一个字符，我们需要找到字符串中最后一个与其相同的元素，然后递归剩下的字符
3: 当不包含第一个字符，直接跳过该字符进行递归。
 */

import java.util.*;

public class LongestPalindromSubstring
{
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			String s = in.next();
			if(s == null || s.length() <= 0) continue;
			int res = helper(s,0,s.length()-1,0);
			System.out.println(res);
		}
	}

	//using recursion
	public static int helper(String s, int start, int end, int num)
	{
		//edge case
		if(start > end) return num;
		if(start == end) return num+1;

		//case 1: contain the charater at the start
		//case 2: doesn't contain the charater at the start
		int i = end;
		for(; i >= start; i--)
		{
			if(s.charAt(i) == s.charAt(start)) break;
		}
		if( i<= start) return helper(s,start+1,end,num); //we don't have the palindrom string for this starting letter
		else return Math.max(helper(s,start+1,i-1,num+2),helper(s,start+1,end,num));

	}
}