package Container;

import java.util.*;

public class HashSetTest 
{
	/*
	 * 	对于hashset,我们判断加入元素是否是重复的依据是hashCode()和equals()
	 * 方法，先判断两个对象的hashCode()返回的hash值是否相同，如果不相同，那么
	 * 可以直接加入元素，但是如果相同，再判断equals返回的值是否相同。
	 * 	类似于领结矩阵，将相同的哈喜值的元素连接到一个list里。
	 */
	
	public static void main(String[] args) 
	{
		Collection<Person> collection = new HashSet<Person>();
		
		collection.add(new Person("jack",20));
		collection.add(new Person("rose",20));
		collection.add(new Person("peter",20));
		collection.add(new Person("jack",20));
		
		System.out.println(collection);

		
	}

}

class Person
{
	@Override
	public String toString() {
		return "(name:"+name+" age:"+age+")";
	}

	@Override
	public int hashCode() 
	{
		return this.name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (obj instanceof Person)
		{
			Person p = (Person)obj;
			return this.name.equals(p.name) && this.age == p.age;
		}else
		{
			return false;
		}
	}

	private String name;
	private int age;
	
	/*constructor
	 * 
	 */
	public Person(String name, int age)
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
	
	
	
	
	
	
}
