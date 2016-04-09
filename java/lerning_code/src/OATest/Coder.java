package OATest;
import java.util.*;


/*
本题难点： 给定一个数组，按照数组元素进行排序，并且对于相同元素的情况，保证原来的相对顺序。
我的解决方法：创建一个新的类实现Comparable接口，属性包括对应的次数和索引。
*/
public class Coder {
    public String[] findCoder(String[] A, int n) {
        // write code here
        if (n <= 0) return null;
        
        //统计每个index中出现'coder'的次数，保存在数组内
        CountString []cs = new CountString[n];
        int count;
        for(int i=0;i<n;i++){
            count = hasString(A[i]);
            cs[i] = new CountString(i,count);
        }
        
        Arrays.sort(cs);
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<n && cs[i].count > 0;i++){
            list.add(A[cs[i].index]);
        }
        
//        int size = list.size();
//        String []res = new String[size];
//        for(int i=0;i<list.size();i++){
//            res[i] = list.get(i);
//        }
        String []res = null;
        return list.toArray(res);
       // return (List<String>)list.toArray();
    }
    
    private class CountString implements Comparable<CountString>{
        public int index;
        public int count;
        
        public CountString(int index,int num){
            this.index = index;
            this.count = num;
        }
        
        public int compareTo(CountString o){
            if(this.count < o.count) return -1;
            else if(this.count > o.count) return 1;
            else{
                if(this.index < o.index) return -1;
                else return 1;
            }
        }
        
    }
    
    //判断一个字符串内包括几个子字符串，注意，一个字母不能被多次利用，而且是不区分大小写的
    public int hasString(String s){
        if(s == null || s.length() == 0) return 0;
        
        int res = 0;
        String tmp;
        for(int i=0;i<s.length()-4;i++){
            if(s.charAt(i) == 'c' || s.charAt(i) == 'C'){
 				tmp = s.substring(i,i+5);//
            	tmp = tmp.toUpperCase();  
                if(tmp.equals("CODER")){
                    res++;
                    i += 5;
                }
            }
        }
        return res;
        
    }
}