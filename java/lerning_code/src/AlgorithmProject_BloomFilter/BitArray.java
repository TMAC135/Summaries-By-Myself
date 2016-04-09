package AlgorithmProject_BloomFilter;


/*BitArray:
 * Implementing the bit array for the bloom filter
 * 
 */

public class BitArray 
{
	private int[] array;//int array
	private int length;//true length of the bit
	
	/*
	 * Constructor
	 */
	public BitArray(int M)
	{
		//unvalid number
		if(M <= 0) throw new IllegalArgumentException();
		//num is the length of the array
		int num = M/32 + 1;
		array = new int[num];//initial values for the array are all 0
		
		this.length = M;
		
	}
	
	/*
	 * Setter and getter for private field
	 */
	public int[] getArray() 
	{
		return array;
	}

	public void setArray(int[] array) 
	{
		this.array = array;
	}
	
	/*
	 * determine whether the index n is in the our bit array
	 */
	public boolean get(int n)
	{
		//unvalid number
		if(n <= 0 || n >= length) throw new IndexOutOfBoundsException();
		
		int tmp1 = n/32;
		int tmp2 = n%32;
		int mask = 1<<tmp2;
		
		if((array[tmp1] & mask) == 0)
		{
			return false;
		}else
		{
			return true;
		}
			
	}
	
	/*
	 * set the bit array at index n to 1 
	 */
	public void set(int n)
	{
		//unvalid number
		if(n <= 0 || n >= length) throw new IndexOutOfBoundsException();	
		
		int tmp1 = n/32;
		int tmp2 = n%32;
		int mask = 1<<tmp2;
		//Bit or with the mask
		array[tmp1] |= mask;
	}
	
}
