package Properties;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class WriteConfig 
{

	public static void main(String[] args) throws Exception
	{
		//准备配置信息
		Properties properties = new Properties();
		properties.setProperty("mykey1", "myvalue1");
		properties.setProperty("mykey2", "myvalue2");
		properties.setProperty("mykey3", "myvalue3");
		//准备输出流(输出文件)以及有关的注释
		OutputStream out = new FileOutputStream("src/Properties/WriteConfig.properties");
		String comment = "this config is written by WriteConfig.java";
		//写出文件
		properties.store(out, comment);
		out.close();
	}

}
