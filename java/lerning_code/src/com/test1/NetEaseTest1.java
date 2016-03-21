package com.test1;

import java.util.*;

public class NetEaseTest1{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
       	int R = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        
        int res = 0;
        long maxDis = R * R;
        
        if(getDistance(x1,y1,x0,y0) <= maxDis) res++;
        if(getDistance(x2,y2,x0,y0) <= maxDis) res++;
        if(getDistance(x3,y3,x0,y0) <= maxDis) res++;
        
        System.out.println(res+"x");
        }
        
    }
    
    //
    public static long getDistance(int x1,int y1,int x0,int y0){
        
        long res;
        res = (x1-x0)*(x1-x0) + (y1-y0)*(y1-y0);
        return res;
    }
   
}
