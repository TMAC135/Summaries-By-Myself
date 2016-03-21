package LeetcodeTest;
import java.util.*;import javax.swing.table.TableColumnModel;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
测试样例：
1->2->2->1
返回：true
*/

//问题：可以改变原来的链表结构吗？
public class PalindromeList 
{
	public static void main(String[] args) 
	{
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(2);
		ListNode fouth = new ListNode(1);
		
		first.next = second;
		second.next = third;
		third.next = fouth;
		
		ListNode tmp;
		tmp = findMid(first);
//		System.out.println(tmp.val);
//		tmp = reverse(first);
//		System.out.println(tmp.val);
//		
//		while(tmp != null)
//		{
//			
//			System.out.println(tmp.val);
//			tmp = tmp.next;
//		}
		
		System.out.println(chkPalindrome(first));
		
	}
	
    public static boolean chkPalindrome(ListNode A) 
    {
        if(A == null) return true;
        
        ListNode midNode = findMid(A);
    	ListNode A2 = midNode.next;
        midNode.next = null;
        A2 = reverse(A2);
        
        while(A2 != null)
        {
            if(A.val != A2.val) return false;
            else
            {
                A = A.next;
                A2 = A2.next;
            }
        }
        return true;
        
    }
    
    //1 2 3 4 case 1
    //1 2 3 4 5 case 2
    public static ListNode findMid(ListNode head)
    {
        ListNode slow;
        ListNode fast;
        slow = head;
        fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    
    // 1->2->3
    // 1<-2  3
    public static ListNode reverse(ListNode head)
    {
        ListNode prev;
        ListNode cur;
        ListNode tmp;
        
        cur = head;
//        next = head.next;
        prev = null;
        
        while(cur != null)
        {
          tmp = cur.next;
          cur.next = prev;
          prev = cur;
          cur = tmp;
        }
        return prev;
    }
}