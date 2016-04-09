package OATest;

import java.util.*;
import java.util.Arrays;


public class HuaWeiTest{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
//        int n;
//        int[] arr;
//        while(in.hasNext()){
//            n = in.nextInt();
//            if(n<=0) return;//unvalid length of the array
//            arr = new int[n];
//            for(int i=0;i<n;i++){
//                arr[i] = in.nextInt();
//            }
//            break;
//        }
        int n = in.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n;i++){
        	arr[i] = in.nextInt();
        }
        
        //sort the array firstly
        Arrays.sort(arr);
        //remove the duplicated elements from the sorted array and print it
        int prev = arr[0]-1;//initial previous value, not the same as arr[0]
        for(int i=0;i<arr.length;i++){
            if(arr[i] != prev){
                System.out.println(arr[i]);
                prev = arr[i];
            }
        }
               
        
    }
}