package OATest;

/**
 * @author TianRan
 * 翻转前k个元素并输出翻转后的链表头节点
 */

public class ReverseKElementsInLinkedList {

	public static void main(String[] args) 
	{
		Node L1 = new Node(0);
		Node L2 = new Node(1);
		Node L3 = new Node(2);
		Node L4 = new Node(3);
		Node L5 = new Node(4);
		Node L6 = new Node(5);
		Node L7 = new Node(6);
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
		L4.next = L5;
		L5.next = L6;
		L6.next = L7;
		
		Node head = reverse(L1, 1);
		while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}

	}
	
	//reverse 
	public static Node reverse(Node head,int num)
	{
		if(head == null) return null;
		if(num <= 0) return head;
		
		Node dummy = new Node(0);
		dummy.next = head;
		
		Node cur = head;
		Node next = cur.next;
		int count =1;
		Node tmp;
		while(next != null && count < num)
		{
			tmp = next.next;
			next.next = cur;
			cur = next;
			next = tmp;
			count++;
		}
		
		if(next == null)//this is the case where K is greater than the length of list
		{
			dummy.next.next = null;
			dummy.next = null;
			return cur;
		}else // K is greater than the length of list
		{
			dummy.next.next = next;
			return cur;
		}
	}
}


//definition for node
class Node
{
	public int val;
	public Node next;
	
	public Node(int val)
	{
		this.val = val;
		next = null;
	}
}