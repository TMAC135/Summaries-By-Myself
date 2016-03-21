package com.test1;

import java.util.ArrayList;

public class GenerateParentheses {

	public static void main(String[] args) 
	{
		System.out.println(generateParenthesis(3));
		

	}
	
    //use dfs 
    public static ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        
        dfs(n-1,n,"(",res);
        return res;
    }
    
    //dfs function, left and right means how many 
    public static void dfs(int left,int right,String tmp,ArrayList<String> res)
    {
        //boundary case
        if(left == 0 && right == 0)
        {
        	res.add(tmp);
        	return;
        }
        if(right < 0 || right <left ) return;
        
        int i=0;
        i++;
        
        if(left == 0)
        {
            dfs(0,right-1,tmp + ")",res);
        }else
        {
            dfs(left-1,right,tmp+"(",res);
            dfs(left,right-1,tmp+")",res);
        }
//        return;
        
    }

}
