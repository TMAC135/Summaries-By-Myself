package OATest;
import java.util.*;

public class MushromPath{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int N,M,K;
        boolean[][] arr;
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            arr = new boolean[N][M];
            //get the total path numbers
            int total = path(arr);
            //get the plausible path numbers
            K = in.nextInt();
            int tmp1,tmp2;
            for(int i=0;i<K;i++){
                tmp1 = in.nextInt();
                tmp2 = in.nextInt();
                arr[tmp1-1][tmp2-1] = true;
            }
            int success = path(arr);
            double res = (double)success/(double)total;
            //保留两位有效数字
            java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
            System.out.println(df.format(res));
        }
    }
    
    public static int path(boolean[][] arr){
//    	System.out.println(arr[1][1]);
        int row = arr.length;
        int col = arr[0].length;
        int [][]count = new int[row][col];
//        Arrays.fill(count,0);
        
        //pad 0's or 1's to the first row or first column
        //boolean flag = false;
        for(int i=1;i<col;i++){
            if(arr[0][i] == false) count[0][i] = 1;
            else break;
        }
        for(int i=1;i<row;i++){
            if(arr[i][0] == false) count[i][0] = 1;
            else break;
        }
        
        //DP, starting from (1,1)
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(arr[i][j] == true) count[i][j] = 0;
                else count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[row-1][col-1];
    }
}