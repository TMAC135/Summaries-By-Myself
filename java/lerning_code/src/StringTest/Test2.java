package StringTest;

/**
 * 字符串在编译前和编译后是否是同一个对象的实现
 * @author TianRan
 *
 */

public class Test2 
{

	public static void main(String[] args) 
	{
		//由于isboolean1 需要运行时才能返回，因此每次返回的字符串是不同的对象
		String s1 = isBoolean1("a", "");
		String s2 = isBoolean1("s", "");
		System.out.println(s1 == s2); //false
		
		//在编译阶段就判断，事实上在编译成二进制编码时就为："a" + "" = "",
		System.out.println(isBoolean2()); //true

	}
	
	static String isBoolean1(String _s1,String _s2)
	{
		String _s3 = _s1 + _s2;
		return _s3;
	}
	
	static boolean isBoolean2()
	{
		String _s1 = "a" + "";
		String _s2 = "a" + "";
		return _s1 == _s2;
	}

}
