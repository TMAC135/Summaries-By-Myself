package ExceptionTest;


public class RuntimeExceptionTest {

	public static void main(String[] args) 
	{
		helper(2, 2);
		helper(1,2);

	}
	
	public static void helper(int m,int n)
	{
		if(m == 1) throw new RuntimeException("run time exception happened in helper");
	}

}
