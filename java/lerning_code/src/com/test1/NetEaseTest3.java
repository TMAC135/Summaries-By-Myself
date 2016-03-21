package com.test1;

import java.util.*;


public class NetEaseTest3{
    
    //I just assume all the input value is valid
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n,r,avg;
        while(in.hasNext()){
            n = in.nextInt();//total num of courses
            r = in.nextInt();//full credits for the course
            avg = in.nextInt();//average credit
           
            
            //get the credit for the normal performance a[]
            //and study time b[]
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }
            
            int res;
            res = helper(r,avg,a,b);//no overflow happens
            System.out.println(res);
            
        }
        
    }
    
    
    public static int helper(int r, int avg,int[] a, int[] b){
        int length = a.length;
        
        long tmp;
        for(int i=0;i<length;i++){
            tmp += a[i];
        }
        
        long totalCredit = avg*length;
        long needCredit = totalCredit - tmp;
        
        int res=0;
        while(needCredit > 0){
            int []min = findMin(b);
            int index = min[1];
            
            for(int i=a[index]+1;i<=r;i++){
                res += b[index];
                needCredit--;
                if(needCredit == 0) return res;
            }
            
            b[index] = Integer.MAX_VALUE;//set the current min to max value to avoid use it next time
        }
        
        return res;
    }
    
    
    public static int[] findMin(int[] b){
        int []res = new int[2];
        
        int max = 0;
        for(int i=0;i<b.length;i++){
            if(b[i] >= max){
                res[0] = b[i];
                res[1] = i;
                max = res[0];
            } 
        }
        return res;
        
    }
}