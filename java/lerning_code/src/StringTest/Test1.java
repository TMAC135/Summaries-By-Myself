package StringTest;

import java.lang.reflect.Field;

/**
 * String Constant Pool
 * Reference: http://www.importnew.com/17034.html
 * @author TianRan
 *字符串常量池，用来再栈中存储字符串对象，字符串内部是用char array来构成的
 */

public class Test1 {

	public static void main(String[] args) throws Exception{
		
		//注意四种构造方法的区别，都共享这字符数组
		String m = "hello,world";//会分配一个11长度的char数组，并在常量池分配一个由这个char数组组成的字符串，然后由m去引用这个字符串
		String n = "hello,world";//用n去引用常量池里边的字符串，所以和n引用的是同一个对象。
		String u = new String(m);// 生成一个新的字符串，但内部的字符数组引用着m内部的字符数组。
		String v = new String("hello,world");//同样会生成一个新的字符串，但内部的字符数组引用常量池里边的字符串内部的字符数组，意思是和u是同样的字符数组。
		//利用反射来改变字符数组的值
		Field f = m.getClass().getDeclaredField("value"); //String 内部的字符数组名字是value
		f.setAccessible(true);
		char[] cs = (char[]) f.get(m);
		cs[0] = 'H';
		//再来查看是否映射到上面四个字符串上
		String p = "Hello,world";
		System.out.println(p.equals(m));//true
		System.out.println(p.equals(n));//true
		System.out.println(p.equals(u));//true
		System.out.println(p.equals(v));//true
		
		//一些情况下，例如replace,concat,+等操作，可能需要修改原来的字符串数组内容或者原数组没法容纳的时候，就会使用另外一个新的数组
		String mm = "hello,";
		String uu = mm.concat("world"); //这时候 mm,uu 使用的不是一套字符数组，
		String vv = new String(mm.substring(0,2)); 
		
		//如何再字符串运行的时候将字符串放到常量池里，调用intern方法
		String mmm = "hello,world";
		String uuu = mmm.substring(0,2);
		String vvvv = uuu.intern(); //如果再常量池没有"he"字符串，则创建一个
	}

}
