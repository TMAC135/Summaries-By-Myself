package reflectionInJava;
/*
 * 为了测试Field 反射成员变量的机制创建的类
 */

public class ReflectedPoints 
{
	private int x;
	private int y;
	public String z = "i love basketball";
	
	public ReflectedPoints(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	//getters and setters for x and y
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//为了测试判定我们的Field 的成员变量
	@Override
	public String toString() 
	{
		return z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReflectedPoints other = (ReflectedPoints) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
