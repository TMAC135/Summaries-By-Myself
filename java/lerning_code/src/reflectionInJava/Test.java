package reflectionInJava;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test 
{

	public static void main(String[] args) throws Exception 
	{
		//Constructor，构造函数反射
//		Constructor<String> constructor1 = String.class.getConstructor(StringBuffer.class);
//		String s1=constructor1.newInstance(new StringBuffer("abc"));
//		System.out.println(s1);
		
		//Field，成员属性反射
			//共有的属性
//		ReflectedPoints rp1 = new ReflectedPoints(2, 3);
//		Field field1 = rp1.getClass().getField("y");
//		System.out.println(field1.get(rp1));
//			//私有的属性
//		Field field2 = rp1.getClass().getDeclaredField("x");
//		field2.setAccessible(true);
//		System.out.println(field2.get(rp1));
//			//返回整个属性数组，当然私有的也不显示
//		Field []field3 = rp1.getClass().getFields();
//		System.out.println(field3.length);	
		
	//将类ReflectedPoints中的属性中是字符属性的"b"字符替换成"a"字符
//		changeStringContent(rp1);
//		System.out.println(rp1);
		
		//Method，成员方法反射
//		String s2 = "abc";
//		Method methodCharAt = String.class.getMethod("charAt", int.class);
//		System.out.println(methodCharAt.invoke(s2, 1));
		
		//数组反射
		Object []o1 = new Object[]{1,"abc",true};
		printObject("only string");
		printObject(o1);
	}
	
//测试数组反射，打印任何object 对象，当对象是数组时，以此打印每一个元素
	private static void printObject(Object o) 
	{
		Class objectClass = o.getClass();
		if (objectClass.isArray())
		{
			int len = Array.getLength(o); //对应的是还有isEnum(),...
			for (int i=0;i<len;i++)
			{
				System.out.println(Array.get(o, i));
			}
		}else {System.out.println(o);}
		
	}

		//测试检查Field
		private static void changeStringContent(ReflectedPoints rp1) throws Exception 
	{
		Field []field = rp1.getClass().getFields();//因为要判断每个field是否是字符串类型，因此没用泛型
		for(Field fd:field)
		{
			if(fd.getType() == String.class)
			{
				String oldString = (String)fd.get(rp1);//需要强制转换，因为field.get(instanceOfClass)返回的是object类型
				String newString = oldString.replace("b", "a");
				fd.set(rp1,newString);
			}
		}
		
	}


}
