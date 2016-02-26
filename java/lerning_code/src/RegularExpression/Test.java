package RegularExpression;

//coding=utf-8
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	public static void main(String[] args) {
		//����ʶ������ʽ�ĸ���
		/*
		p("abc".matches("..."));
		p("a8729a".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fgh");
		p(m.matches());
		p("fgha".matches("[a-z]{3}"));
		*/
		
		//������ʶ. * + ?
		
//		p("a".matches("."));
//		p("aa".matches("aa"));
//		p("aaaa".matches("a*"));
//		p("aaaa".matches("a+"));
//		p("".matches("a*"));
//		p("aaaa".matches("a?"));
//		p("".matches("a?"));
//		p("a".matches("a?"));
//		p("214523145234532".matches("\\d{3,100}"));
//		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
//		p("192".matches("[0-2][0-9][0-9]"));
		
		
		//范围，中括号取其中一个字符
//		p("a".matches("[abc]"));
//		p("a".matches("[^abc]"));//除了abc之外的任意一个字符
//		p("A".matches("[a-zA-Z]")); //横线是范围
//		p("A".matches("[a-z]|[A-Z]"));
//		p("A".matches("[a-z[A-Z]]"));
//		p("R".matches("[A-Z&&[RFG]]"));//&&是并且
		
		
		//特殊字符\s \w \d \
		
//		p(" \n\r\t".matches("\\s{4}"));
//		p(" ".matches("\\S"));
//		p("a_8".matches("\\w{3}"));// \\w是构成单词的字符。
//		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
//		p("\\".matches("\\\\"));//在正则表达式中匹配一个\.
		
		
		//POSIX Style
//		p("a".matches("\\p{Lower}"));
		
		//boundary		
//		p("hello sir".matches("^h.*"));//^
//		p("hello sir".matches(".*ir$"));
//		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
//		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		
		//whilte lines,空白行
//		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//开头不是一个换行符但是一个空白符，结尾是换行符。
//				
//		p("aaa 8888c".matches(".*\\d{4}."));
//		p("aaa 8888c".matches(".*\\b\\d{4}."));
//		p("aaa8888c".matches(".*\\d{4}."));
//		p("aaa8888c".matches(".*\\b\\d{4}."));
		
		
		//email
		//p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
		
		//matches find lookingAt 
		/*
		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		p(m.matches());
		m.reset(); //将搜索引擎返回到初始位置
		p(m.find()); //find 找子串
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		p(m.start() + "-" + m.end());
		p(m.find());
		//p(m.start() + "-" + m.end());
		p(m.lookingAt()); //每次都从头开始搜索
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		*/
		
		//replacement，替换字符串。
		/*
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) {
				m.appendReplacement(buf, "java");
			} else {
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);
		p(buf);
		*/
		
		//group ()代表一个组
		/*
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());//p(m.group(1))只打印数字，p(m.group(1))只打印字母。
		}
		*/
		
		//qulifiers
		/*
		Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			p(m.start() + "-" + m.end());
		else 
			p("not match!");
		*/
		
		//non-capturing groups
		/*
		Pattern p = Pattern.compile(".{3}(?=a)");
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}
		*/
		
		//back refenrences
		/*
		Pattern p = Pattern.compile("(\\d(\\d))\\2");
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		*/
		
		//flags�ļ�д
		//Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
//		p("Java".matches("(?i)(java)"));
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}

}
