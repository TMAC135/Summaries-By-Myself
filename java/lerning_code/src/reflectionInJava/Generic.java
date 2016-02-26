package reflectionInJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/*
 * some deep understandings of the generic in java. generic is 
 * with respect to javac,which in other words, it only works during the 
 * compiling time. Thus, if we skip the process the static compiling but use 
 * dynamic way to invoke method --> reflection, something fun happens!
 */
public class Generic 
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		//3个整数元素
		a1.add(1);
		a1.add(2);
		a1.add(3);
		
		//反射,加入一个字符串元素
		a1.getClass().getMethod("add", Object.class).invoke(a1, "abc");//注意加入的元素类型是Object.class,不是string.class.
		System.out.println(a1.get(3));
		
		//数组作为元素时不能使用泛型初始化
//		ArrayList<Integer> a2[] = new ArrayList<Integer>();//报错
		
		//问号通配符 -> ?
		printCollection1(a1);
		
		//自定义泛型:返回类型时两者的交集
		int a = add(3,4); //这里3 和 4打包过后成为integer对象
		Number b = add(3,3.56);
		Object o = add(1,"sb");//int 和string的交集只有object
		
		String []s1 = new String[]{"a","b","c"};
		swap(s1,1,2);//另外一个自定义泛型函数
		
		int []s2 = new int[]{1,2,3};
//		swap(s2,1,2);//这个不能使用泛型模版，因为int是基础类型.
	}
	

	//另外一个自定义泛型的例子，交换泛型数组里面两个元素，注意数组元素不能是primitive数据类型，因为这样整个数组也将会是个类型
	private static <T> void swap(T[] s1, int i, int j) 
	{
		T tmp = s1[i];
		s1[i] = s1[j];
		s1[j]=tmp;
		
	}
	//自定义泛型，表面上类似于c++的模版，但是没有其功能强大。这里我们无法实现对任意数据的相加。
	private static <T> T add(T i, T j) 
	{
//		return i+j;//不能这样直接输出，因为对于任意的类型T,可能不支持加法操作.		
		return i; 
	}

	
	//通配符 -> ？
	private static void printCollection1(Collection<?> a1) 
	{
		System.out.print("size "+a1.size()+" "+"\n");
		for(Object object:a1) //可以用增强for循环来来遍历一个collection
		{
			System.out.print(object + " ");
		}
		System.out.println("\n");
	}
	

}
