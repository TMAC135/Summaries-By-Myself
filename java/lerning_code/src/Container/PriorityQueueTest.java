package Container;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import Container.PriorityQueueTest.Person;

/**
 * PriorityQueue 来实现最大堆，或者最小堆,
 * @author TianRan
 *
 */

public class PriorityQueueTest 
{

	public static void main(String[] args) 
	{
		//define my comparator
		Comparator<Person> myComparator = new Comparator<PriorityQueueTest.Person>() {
			
			public int compare(Person o1, Person o2) 
			{
				return o1.getAge() - o2.getAge(); //by setting the comparing criteria, we can set the priority in the heap
						//o1 - o2 对应的是min heap, 表示如果 o1 > o2, 返回正数
			}
		};
		
		PriorityQueue<Person> heap = new PriorityQueue<Person>(10,myComparator);
		
		for(int i=0;i<20;i++)
		{
			heap.add(new Person(new Random().nextInt(50),"s"));
		}
		
		while(!heap.isEmpty())
		{
			System.out.println(heap.poll());
		}
	}
	
	//inner class, instance of this class is the element of priorityqueue
	static class Person
	{
		private int age;
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		private String name;
		
		public Person(int _age, String _name) 
		{
			age = _age;
			name = _name;
		}
		
		@Override
		public String toString() 
		{
			return ("name: " + name + ";" + "age: " + age);
		}
		
	}

}
