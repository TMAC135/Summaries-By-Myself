package LeetcodeTest;

/*Implement the function converting the string to integer
 * like the functionality of atoi in the C
 * 
 */

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(1<<31);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println("123123123123123");
		System.out.println("      -245".trim());
		System.out.println(atoi2("      -245"));
//		System.out.println(atoi("123.4"));
		
//		long res =Integer.MAX_VALUE;
//		res *= 10;
//		System.out.println(res);
		
		
//		System.out.println("    123   ".trim());
	}

	
    public static int atoi(String str) {
        // write your code here
        // int res = 0;
        
        if(str == null || str.length() == 0 ) return 0;
        
        long cur = 0;
        // char tmpChar;
        int tmpValue;
        long factor = 1;
        boolean neg = false;
        for(int i=str.length()-1;i >= 0; i--)
        {
            tmpValue = str.charAt(i) - '0';
            if(tmpValue >= 0 && tmpValue <= 9) 
            {
                cur += factor*tmpValue;//even with long type,still be easy to overflow
                factor *= 10;
                // continue;
            }
            else if(str.charAt(i) == '.')
            {
                cur = 0;
                factor = 1;
                // continue;
            }
            else if(str.charAt(i) == '-')
            {
                neg = true;
            }else return 0;
        }
//        System.out.println(((Object)cur).getClass().getName());
        if(neg == true) cur = -cur;
        if(cur > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(cur < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int) cur;
    }
    
    
    //从头往后扫描整个字符串，更加，简便，并且考虑到了空格的问题
    public static int atoi2(String str) {
        // write your code here
        // int res = 0;
        
        if(str == null || str.length() == 0 ) return 0;
        
        //trim the string firstly
        str = str.trim();
//        System.out.println(str.length());
               
        long cur = 0;
        int tmpValue;
        boolean neg = false;
        for(int i=0;i < str.length(); i++)
        {
            tmpValue = str.charAt(i) - '0';
            if(tmpValue >= 0 && tmpValue <= 9) 
            {
            	cur = cur*10 + tmpValue;
            }
            else if(str.charAt(i) == '.')
            {
            	break;
            }
            else if(str.charAt(i) == '-')
            {
                neg = true;
            }else return 0;//invalid character
        }
//        System.out.println(((Object)cur).getClass().getName());
        if(neg == true) cur = -cur;
        if(cur > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(cur < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int) cur;
    }
    
}
