package com.test1;

import java.util.*;

public class NetEaseTest2{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int N;
        int M;
        int K;
        int[][] mat;
        int firstScan[]= new int[3];
        int secondScan[] = new int[3];
        
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            K = in.nextInt();
            
            if(N <3) N =3;
            if(M < 3) M =3;
            //set the mat with input        
            mat = new int[N][M];
            int tmpX;
            int tmpY;
            for(int i=0;i<K;i++){
                tmpX = in.nextInt();
                tmpY = in.nextInt();
                
                //if(tmpX > N || tmpX < 1 || tmpY > M || tmpY < 1) throw RuntimeException("please input valid input!!!");
                mat[tmpX-1][tmpY-1]+=1;
            }
            
            //first scan with the original matrix
            helper(mat,firstScan);
            
            //clean the scanned mushrooms after first scan
            for(int i = firstScan[1];i<firstScan[1]+3;i++){
                for(int j = firstScan[2];j<firstScan[2]+3;j++){
                    if(mat[i][j] >= 1) mat[i][j] -= 1;
                }
            }
            
            //second scan
            helper(mat,secondScan);
            System.out.println(firstScan[0]+secondScan[0]);
            
        }
        
    }
    
    
    //brutal force method for scanning
    public static void helper(int[][] mat, int[] arr){
        int row = mat.length;
        int col = mat[0].length;
        
        for(int i=0;i<row-2;i++){
            
            for(int j=0;j<col-2;j++){
                int tmp=0;
                //get the total number of the mushroom for the given row and col
                for(int ii =i;ii<i+3;ii++){
                    for(int jj=j;jj<j+3;jj++){
                        if(mat[ii][jj] > 0) tmp += 1;
                    }
                }
                //update the max mashroon for every element
                if(tmp > arr[0]){
                    arr[0] = tmp;
                    arr[1] = i;
                    arr[2] = j;
                }
            }
        }
        
    } 
    
}
