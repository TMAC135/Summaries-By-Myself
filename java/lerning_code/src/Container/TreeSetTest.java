package Container;

import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) 
	{
		//Comparable接口 － 元素实现
		Collection<Person2> collection = new TreeSet<Person2>();
		
		collection.add(new Person2("jack",20));
		collection.add(new Person2("jack", 21));
		collection.add(new Person2("rose", 20));
		collection.add(new Person2("jack", 20));	
		System.out.println(collection);
		
		System.out.println("----------------------");
		
		//Comparator接口 － 容器实现, 在TreeSet 的构造函数加入一个MyComparator实例
		Collection<Person> collection2 = new TreeSet<Person>(new MyComparator());
		
		collection2.add(new Person("jack",20));
		collection2.add(new Person("rose",20));
		collection2.add(new Person("jack",21));
		collection2.add(new Person("jack",20));
		System.out.println(collection2);
	}

}


/* 1:
 * 通过Comparable接口实现比较，当compareTo返回是0时，认为是相同的元素
 */
class Person2 implements Comparable
{
	@Override
	public String toString() {
		return "(name:"+name+" age:"+age+")";
	}
	
	private String name;
	private int age;
	
	/*constructor
	 * 
	 */
	public Person2(String name, int age)
	{
		this.age = age;
		this.name = name;
	}
	
	/*method
	 * getter and setter for name and age
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * 按照年龄的大小比较，如果年龄相同，按照名字(字符串)的compareTo 方法
	 */
	public int compareTo(Object o) 
	{
		Person2 p = (Person2)o;
		if(age > p.age){return 1;}
		else if(age<p.age){return -1;}
		else{return name.compareTo(p.name);}

	}
}

/*2:
 * 通过实现Comparator接口，实现compare方法 
 */

class MyComparator implements Comparator<Person>
{


	public int compare(Person o1, Person o2) 
	{
		if(o1.getAge() > o2.getAge()){return 1;}
		else if(o1.getAge() < o2.getAge()){return -1;}
		else{return o1.getName().compareTo(o2.getName());}
	}
	
}


