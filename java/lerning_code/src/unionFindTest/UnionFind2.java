package unionFindTest;

/*并查集的实现2:使用链表
 * 自定义node: 
 * 	1:size, 表示集合内有多少元素
 * 	2: root, 集合的root元素
 * 	3: next, 节点的下一个节点
 */

public class UnionFind2 
{

	public static void main(String[] args) 
	{
		
	}
	
	private class Node
	{
		public int size;
		public int root;
		public int next;
		
		//constructor , 
		public Node(int index)
		{
			size = 1;
			root = index;
		}
	}

}
