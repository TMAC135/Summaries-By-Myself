package reflectionInJava;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntroSpectorTest 
{

	public static void main(String[] args) throws Exception 
	{
		ReflectedPoints rp1 = new ReflectedPoints(3, 4);
		
		String propertyName = "x";
		//getters method for attributer x,通过JavaBean来访问getter --> Object getX() 
		PropertyDescriptor pd1 = new PropertyDescriptor(propertyName, rp1.getClass());
		Method method1 = pd1.getReadMethod(); //getReadMethod()是getters 方法
		System.out.println(method1.invoke(rp1));

		//setters method for attributer x,通过JavaBean来访问setter --> void setX()
		PropertyDescriptor pd2 = new PropertyDescriptor(propertyName, rp1.getClass());
		Method method2 = pd2.getWriteMethod(); //getWriteMethod()是setters 方法
		method2.invoke(rp1,5);//调用方法
		System.out.println(rp1.getX());

		//另外一种内省的方式,通过Introspector类和BeanInfo 类得到所有的bean 方法,然后再逐一判断
		BeanInfo beaninfo = Introspector.getBeanInfo(rp1.getClass());
		PropertyDescriptor []pds = beaninfo.getPropertyDescriptors();
		for(PropertyDescriptor pd:pds)
		{
//			System.out.println(pd.getName());
			if (pd.getName().equals(propertyName))
			{
				Method method3 = pd.getReadMethod();
				System.out.println(method3.invoke(rp1));;
				break;
			}
		}
		
		
	}

}
