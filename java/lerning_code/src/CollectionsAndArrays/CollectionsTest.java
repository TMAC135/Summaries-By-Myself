package CollectionsAndArrays;

import java.util.ArrayList;
import java.util.Collections;


public class CollectionsTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(45);
		arrayList.add(23);
		arrayList.add(12);
		Collections.sort(arrayList);
		System.out.println(arrayList);
		Collections.reverse(arrayList);
		System.out.println(arrayList);
		
//		ArrayList<Integer> copy = new ArrayList<Integer>();
//		Collections.copy(copy, arrayList);
//		System.out.println(copy);
	}
	

}
