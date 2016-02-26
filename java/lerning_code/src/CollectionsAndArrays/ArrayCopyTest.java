package CollectionsAndArrays;

import java.util.Arrays;

public class ArrayCopyTest 
{

	public static void main(String[] args) 
	{
		int[] original = {1,2,3,4,5};
		
		//copyOf
		int[] copy1 = Arrays.copyOf(original, 7);		
		System.out.println(Arrays.toString(copy1));
		
		//copyOfRange
		int[] copy2 = Arrays.copyOfRange(original, 1, 3);//start is inclusive, end is exclusive
		System.out.println(Arrays.toString(copy2));

	}

}
