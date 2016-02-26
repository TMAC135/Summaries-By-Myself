package iterator;

import iterator.Collection;

public class LinkedList implements Collection {
	//三个成员变量，head,tail和size
	Node head = null;
	Node tail = null;
	int size = 0;
	
	public void add(Object o) {
		Node n = new Node(o, null);
		if(head == null) {
			head = n;
			tail = n;
		}
		tail.setNext(n);
		tail = n;
		size ++;
	}
	
	public int size() {
		return size;
	}

//	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}
	
	//内部类,可以直接使用上述类中的属性
	private class LinkedListIterator implements Iterator
	{
		private Node currentNode = new Node(null,head);//初始化时dummy node
		public Object next() 
		{
				currentNode = currentNode.getNext();
			return currentNode.getData();

		}

		public boolean hasNext() 
		{
			if(currentNode.getNext() != null)
				{return true;}
			else
				{return false;}
		}
		
	}
}
