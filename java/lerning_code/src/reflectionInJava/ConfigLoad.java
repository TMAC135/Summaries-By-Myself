package reflectionInJava;

import java.io.*;
import java.util.Collection;
import java.util.Properties;

public class ConfigLoad
{

	public static void main(String[] args) throws Exception
	{
//		String filename1 = "src/reflectionInJava/config.properties";
		String filename2 = "config.properties";//此种路径是相对于class path的路径，因为我们
					//将配置文件放入到了与源java同一个文件，因此自动在class path文件中复制配置文件.
		
		//两种方式加载配置文件
//		InputStream fis = new FileInputStream(filename1);
		
		InputStream fis = ConfigLoad.class.getResourceAsStream(filename2);
		
		//Properties 类类似于HashMap ，自动读取文件中的key-value对
		Properties property = new Properties();
		property.load(fis);
		String myClassName = property.getProperty("className");
//		System.out.println(myClassName);
		
		fis.close();
			
		//有了className 的string类型我们就可以通过反射来得到该类然后创建实例了
		Collection collection =
				(Collection)Class.forName(myClassName).newInstance();
		collection.add(new ReflectedPoints(2, 2));
		collection.add(new ReflectedPoints(3, 3));
		collection.add(new ReflectedPoints(4, 4));
		collection.add(new ReflectedPoints(3, 3));
		
		System.out.println(collection.size());
		
		//equal 和 ==
		System.out.println(new ReflectedPoints(3, 3).equals(new ReflectedPoints(3, 3)));
		System.out.println(new ReflectedPoints(3, 3) == new ReflectedPoints(3, 3));
		
	}

}
