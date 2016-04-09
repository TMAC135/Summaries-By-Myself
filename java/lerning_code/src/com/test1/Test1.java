package com.test1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 
{

	public static void main(String[] args) 
	{
//		System.out.println("你好");
		
//		int []A = {1,2,3,4,5,6,7,8,9,10};
//		print(A +1);//java不支持数组＋这样的操作，因为数组本身是个引用
//		Arrays.copyOfRange(A, 0, 2);
//		int a = 5;
//		a >>= 1;
//		System.out.println(a);
		
//		System.out.println(hasString("CODER coder"));
		
		ArrayList<String> l1 = new ArrayList<>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		String [] test1 = {"String","String","String"};
		test1 = l1.toArray(test1);
		for(String tmp:test1) System.out.print(tmp +  " ");
		
		int a = -11111;
		int j  = a>>31;
		System.out.println((a^j)-j);
		
		System.out.println(Integer.toBinaryString(-11));
		System.out.println(Integer.toBinaryString(-11 >>31));
		
		int [][] test = new int[3][3];
//		int []test = {1,2,3,4};
//		Arrays.fill(test, 2);
		System.out.println(Arrays.toString(test));//只能对一维数组有用！！！！
		
		" ".hashCode();
	}
	
	
	public static void print(int[] arr)
	{
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print(arr[i]);
//		}
		
		
		
	}
	
	
    //判断一个字符串内包括几个子字符串，注意，一个字母不能被多次利用，而且是不区分大小写的
    public static int hasString(String s){
        if(s == null || s.length() == 0) return 0;
        
        int res = 0;
        String tmp;
        for(int i=0;i<s.length()-4;i++){
            if(s.charAt(i) == 'c' || s.charAt(i) == 'C'){
 				tmp = s.substring(i,i+5);//
            	tmp = tmp.toUpperCase();  
                if(tmp.equals("CODER") == true){
                    res++;
                    i += 5;
                }
            }
        }
        return res;
        
    }

}


class Person
{
	private int i;
	
	// get and set attribute i 
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}