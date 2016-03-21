package iterator;

/*
 * check the remove method in the iterator,
 * check the effects of == and equals(),  
 */

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorRemoveTest {

	public static void main(String[] args) 
	{
		ArrayList<Integer> res =  new ArrayList<Integer>();
//		ArrayList<Integer> cur = new ArrayList<Integer>();
		res.add(1);
		res.add(2);
		res.add(3);
		res.add(4);
		
		//use self-defined object to check the == and equals() method;
		// ==: check the reference of the object
		// equals: check the value of object
		ArrayList<TestObject> res1 =  new ArrayList<TestObject>();
		res1.add(new TestObject(1));
		res1.add(new TestObject(2));
		res1.add(new TestObject(3));
		res1.add(new TestObject(4));
		
		Iterator<TestObject> iter = res1.iterator();
		TestObject tmp;
		TestObject removeObject = new TestObject(2);
		
		while(iter.hasNext())
		{
			tmp = iter.next();
//			if(tmp == removeObject) iter.remove();
			if(tmp.equals(removeObject)) iter.remove();
		}
		System.out.println(res1);
		
		

	}
}


class TestObject
{
	int value;
	public TestObject(int value)
	{
		this.value = value;
	}
	
	public boolean equals(Object o) 
	{
		if (o instanceof TestObject)
		{
			TestObject tmp = (TestObject)o;
			return tmp.value == value;
			
		}else
		{
			return false;
		}

	}
	
	public String toString()
	{
		String res = "";
		return res + value+" ";
	}
}
