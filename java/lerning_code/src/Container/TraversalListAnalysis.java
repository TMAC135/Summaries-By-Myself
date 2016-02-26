package Container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

/**
 * 比较不同List对象的最佳遍历方法
 * @author TianRan
 *通过计算80万大小数组的平均值
 */

public class TraversalListAnalysis {

	public static void main(String[] args) {
		int studentNum = 800000;
//		List<Integer> myList = new LinkedList<Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		
		//加入每个学生成绩
		for(int i=0;i<studentNum;i++){
			myList.add(new Random().nextInt(100));
		}
		
		long start = System.currentTimeMillis();
		System.out.println(average(myList));
		System.out.println(System.currentTimeMillis() - start);
		
	}
	
	public static int average(List<Integer> _list){
		int result = 0;
		
		if(_list instanceof RandomAccess){  //如果实现了RandomAccess接口，则通过get方法
			for(int i=0;i<_list.size();i++){
				result += _list.get(i);
			}
		}else{
			for(int tmp:_list){
				result += tmp;
			}
		}
				
		return result/800000;
	}

}
