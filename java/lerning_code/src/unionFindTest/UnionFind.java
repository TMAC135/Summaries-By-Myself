package unionFindTest;

/*并查集的实现1: 数组
 * 1:给定了集合的总个数，
 * 2:将整个几个分成几个不相交的字集
 * 3:提供find,union的操作
 */

/*
size 是总的集合的个数，包括 num+1个元素，因此几个里的元素从1开始，0代表元素不存在于原集合中
采用压缩路径的做法，但我们第一次find时候，我么将集合的子元素的parent都设置成该集合的root,这样
下次find 的时候就是 O(1)时间了。 
 
 */
public class UnionFind {

	public static void main(String[] args) 
	{
		UnionFind ufs = new UnionFind(10);
		ufs.union(1, 2);
		ufs.union(2, 3);
		ufs.union(1, 10);
		ufs.find(2);
		for(int tmp:ufs.parent)
		{
			System.out.print(tmp+" ");
		}
	}
	
	private int size;//size include num+1 elements
	private int[] parent;//store the previous node for the current index
	
	public UnionFind(int num)
	{
		size = num+1;
		parent = new int[size];
		
		//initialize the parent with itself
		for(int i=1;i<size;i++)
		{
			parent[i] = i;
		}
	}
	
	//find the root the current set 
	//compress the path when we find the root the set, which means we 
	public int find(int index)
	{
		if(index >= size) return 0;// return 0 if the index is out of bound
		
		int root = index;
		while(root != parent[root])
		{
			root = parent[root];
		}
		
		int tmp;
		while(index != parent[index])
		{
			tmp = parent[index];
			parent[index] = root;
			index = tmp;
		}
		
		return root;
	}
	
	//union the two sets
	public void union(int index1, int index2)
	{
		if(index1 >= size || index2 >= size) return;
		
		int root1 = find(index1) ;
		int root2 = find(index2);
		if(root1 == root2) return;
		else
		{
			parent[root1] = root2; 
		}		
	}
	

}
