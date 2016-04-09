package OATest;
import java.util.*;

//zigzag print the matrix
public class MeiTuanTest {
	
	public static void main(String[] args) {
		MeiTuanTest p1 = new MeiTuanTest();
		int [][]test = new int[5][5];
		int index =1;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				test[i][j] = index++;
			}
		}
		
		int []res = p1.arrayPrint(test, 5);
		for(int tmp:res){
			System.out.print(tmp+" ");
		}
	
	}
	
	
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int []res = new int[n*n];
        
        int index =0;
        int col = n-1;
        
        while(col >0){
            int m = 0;
            int q = col;
            while(m <= n-1 && q <= n-1){
                res[index++] = arr[m++][q++];
            }
            col--;
        }
        
        int row = 0;
        while(row < n){
            int m=row;
            int q=0;
            while(m <= n-1 && q <= n-1){
                res[index++] = arr[m++][q++];
            }
            row++;
        }
        return res;
        
		
    }
}
