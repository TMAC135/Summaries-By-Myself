package Properties;

import java.io.InputStream;
import java.util.Properties;

public class PathTest {

	public static void main(String[] args) throws Exception 
	{
		Class clazz = new PathTest().getClass();
		//这里没有/，表示在当前class所在的包中查找
		InputStream in1 = clazz.getResourceAsStream("config.properties");
		//这里的/表示classpath 的根目录，即bin 目录；
		InputStream in2 = clazz.getResourceAsStream("/Properties/config.properties");
		
		Properties properties = new Properties();
		properties.load(in2);
		in2.close();
		
		System.out.println(properties);
		
		
		int index = 0 ;
		System.out.println(index++);//0
		System.out.println(index);//1	
		System.out.println(++index);//2
	}

}
