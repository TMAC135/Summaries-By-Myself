package ClassLoader;

public class Test 
{

	public static void main(String[] args) 
	{
		//输出Test类的类加载器名字,appClassLoader
		System.out.println(Test.class.getClassLoader().getClass().getName());
		//输出System类的类加载器，是null,说明加载器是bootstrap类加载器
		System.out.println(System.class.getClassLoader());
		
		//依次打印各个classLoader的名字,appclassloader->extclassloader->bootstrapclassloader;
		ClassLoader loader = Test.class.getClassLoader();
		while(loader != null)
		{
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		
		
	}

}
