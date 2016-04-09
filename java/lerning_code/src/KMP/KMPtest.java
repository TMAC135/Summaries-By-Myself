package KMP;

/** 还没有完全吃透，虽然程序检验了几个测试案例，需要再多多体会！！！
 * 方法1: KMP
 * 方法2:暴力法
 * @author TianRan
 *使用KMP算法得到匹配字符串的首个索引，要查找的字符串－s, 模版字串 - p;
 *1: 利用GetNextArray得到模式串的next数组
 *2: 依次遍历s － i， 与模版串里的索引字符串进行比较 －j,当j遍历完后，则说明匹配到。
 */

/* 个人的对KMP一些理解:
 * 1: 理解next数组的含义，以及怎样在原字符串里进行匹配
 * 2: 怎样移动模版字符串，怎样遍历原字符串，当s[i] == s[j]时候，我们继续遍历，不相同时候，我们固定当前的i,
 * 将j=next[j],并且递归的继续判断。注意当j==-1时候，这是边界条件。
 */

public class KMPtest {

	public static void main(String[] args) 
	{
		String s = "BBC ABCDAB ABCDABCDABDE";
		String p = "ABCDABD";
//		s = "abcab";
//		p = "ca";
		int[] next = GetNextArray.next(p);
		System.out.println(find(s, p, next));
		System.out.println(find2(s, p));
 
	}
	
	
	public static int find(String s, String p, int[] next)
	{
		if(s == null || s.length() == 0 || p == null ||
				p.length() == 0 || s.length() < p.length()) return -1;
		
		int j = 0;
		for(int i=0;i<s.length();i++)
		{
			
			if(j == -1) j = 0;
			while(j <= p.length()-1 && i <= s.length()-1 && s.charAt(i) == p.charAt(j)) 
			{
				i++;
				j++;
			}
			if(j == p.length()) return i - p.length();
			else j = next[j];
		}
		return -1;
	}
	
	//这是暴力发解决，时间复杂度O(n*m),n是原串的长度，m是模版串的长度
	public static int find2(String s, String p)
	{
		if(s == null || s.length() == 0 || p == null ||
				p.length() == 0 || s.length() < p.length()) return -1;
		
		int j=0;
		
		for(int i=0;i<s.length();i++)
		{
			//每次没有匹配的时候，都将i回溯到原来的位置
			while(i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j))
			{
				i++;
				j++;
			}
			if(j == p.length()) return i-j;
			else
			{
				i -= j;
				j=0;
			}
		}
		return -1;
		
	}

}
