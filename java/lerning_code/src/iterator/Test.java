package iterator;

import iterator.ArrayList;
import iterator.LinkedList;

public class Test {
	public static void main(String[] args) {
		//ArrayList al = new ArrayList();
		//LinkedList al = new LinkedList();
		
		//面向接口的编程，统一了一个接口之后，其他容器类要实现这个接口
		//利用多态的思想，我们可以直接利用父类的引用指向子类的对象
		Collection c = new LinkedList();
		
		for(int i=0; i<15; i++) {
			c.add(new Cat(i));
		}
		System.out.println(c.size());
		
		//遍历不同的容器，只需要拥有Iterator对象(next()和hasNext())，
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.print(o + " ");
		}
		
	}
}


