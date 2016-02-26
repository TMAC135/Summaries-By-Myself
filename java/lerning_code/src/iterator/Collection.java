package iterator;

public interface Collection {
	void add(Object o);
	int size();
	Iterator iterator();//这个方法返回一个实现了Iterator接口的对象
}
