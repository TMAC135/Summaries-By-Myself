package KMP;

import java.util.Arrays;

/**
 * @author TianRan
 * 怎样求一个字串的next数组：
 * 1: 可以先求出字串的中每个字符串位置时候的最长前缀串和后缀串的最长公共字串，然后将字串整体向后移动一位，并且赋next[0]=-1
 * 2: 利用递归方法，k代表上一位的最长前缀的最后一位，j代表我们要处理的元素，如果相等(p[k] == p[j-1] ),代表我们只需要
 * 在原来的长度上加1，若不想等，k=next[k],再递归判断
 *
 *注意：下面两个是定义的
 *1:next[0]是-1,并不是0，因为next数组代表的是除去该字符以前的最长的公共前缀字串和后缀字串，
 *2:next[1]是0,因为只剩下一个字符，不能是整个字符串的长度，因此只能是0。
 *3:为什么next数组要除去这个字符串的最长公共子字符串，因为我们需要next数组的时候都是 s[i] != p[j]的时候，需要重新定位。
 *检验字符串：
 * A  B  C  D  A  B  D
 *-1  0  0  0  0  1  2 
 */

public class GetNextArray {

	public static void main(String[] args) 
	{
		String test = "ABCDABD";
		test = "AB";
		test = "ABCABCD";
		System.out.println(Arrays.toString(next(test)));
	}
	
	//使用方法2， 利用关系式进行回溯
	public static int[] next(String p)
	{
		if(p == null || p.length() == 0) return null;
		
		int j=0;
		int k=-1;
		int []next = new int[p.length()];
		next[0] = -1;
		while(j < p.length()-1)
		{
			if(k == -1  || p.charAt(k) == p.charAt(j))
			{
				k++;
				j++;
				next[j] = k;
			}else
			{
				k = next[k];
			}
		}
		return next;
	}

}
