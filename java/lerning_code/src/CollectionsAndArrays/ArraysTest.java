package CollectionsAndArrays;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int[] array = {1,45,23,65,78};
		
		Arrays.sort(array);
		for(int i:array){
		System.out.println(i);
		}
		
		int[] array2={45,1,23,65,78};
		int[] array3={45,1,65,78,23};
		
		/*
		 * hashCode in jdk is based on: result=31*result + element;
		 */
		System.out.println(Arrays.hashCode(array));
		System.out.println(Arrays.hashCode(array2));
		System.out.println(Arrays.hashCode(array3));
	}
}
