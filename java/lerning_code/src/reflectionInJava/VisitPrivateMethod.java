package reflectionInJava;

import java.lang.reflect.Method;


public class VisitPrivateMethod 
{

	/*暴力访问类的私有方法.
	 *  使用反射的setAccessible
	 */
	public static void main(String[] args) throws Exception
	{
		Class clazz = Test1.class;
		
		Method m = clazz.getDeclaredMethod("print", String.class);		
//		System.out.println(new Test1().print("hello"));//not accessible for us
		m.setAccessible(true);
		m.invoke(new Test1(), "hello");
	}

}

class Test1
{
	private void print(String s1)
	{
		System.out.println(s1);
	}
}
