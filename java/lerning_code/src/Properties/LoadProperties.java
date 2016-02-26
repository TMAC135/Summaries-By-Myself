package Properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
/*
 * 1:Properties类对应.properties文件。文件内容是键值对，
 * 键值对之间使用"="或空格隔开。开头是"#"的表示注释
 * 2:使用Properties类中的load(InputStream) 方法可以加载配置文件，
 * 使用其中的store(OutputStream) 方法可以保存配置到指定文件。
 */
	public static void main(String[] args) throws Exception
	{
		Properties properties = new Properties();
		
		InputStream in = new FileInputStream("src/Properties/config.properties");
		
		properties.load(in);
		in.close();
		
		System.out.println(properties);
	}

}
