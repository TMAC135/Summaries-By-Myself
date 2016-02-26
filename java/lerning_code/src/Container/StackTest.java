package Container;

import java.util.AbstractList;
import java.util.List;
import java.util.Stack;

/**java中stack的使用：继承与Vector, 因此底层也是由array实现的
 * Stack只有一个无参的构造函数
 * 几个重要的方法：peek, pop, push, empty()
 * search(Object o): 返回出现object位置到最上面元素的距离
 * @author TianRan
 *
 */
public class StackTest 
{

	public static void main(String[] args) 
	{
		Stack<Integer> myStack = new Stack<Integer>();
		
		myStack.push(1);
		myStack.push(3);
		myStack.push(3);
		myStack.push(4);
		myStack.push(2);
		
		System.out.println("first position of 2: " + myStack.search(2));//寻找的元素就是最上层的元素，则输出1
		System.out.println("first position of 3: " + myStack.search(3));//寻找最接近最上层元素的距离
		System.out.println("first position of 5: " + myStack.search(5));//如果没找到，则输出为－1
	}

}
