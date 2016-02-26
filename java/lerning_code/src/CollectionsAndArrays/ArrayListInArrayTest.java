package CollectionsAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Arrays 的内部类：ArrayList 
 * @author TianRan
 * 此ArrayList 与util包内的不一样，只有五个方法，不支持增删操作，换句话说，用Arrays.asList(array)
 * 产生的ArrayList 都是定长的，不可调整
 */
public class ArrayListInArrayTest {

	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		List<int[]> myList = Arrays.asList(array);//注意此时数组是以个类型，因此范型内参数是int[]
		
		String[] str = {"a","b","c"};
		List<String> strList = Arrays.asList(str);
//		strList.add("d");// 注意此时有unsupportedOperationException, 因为Arrays 内部累的Arraylist

	}

}
