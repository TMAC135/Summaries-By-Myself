package AlgorithmProject_BloomFilter;


/*BloomFilter class:
 * Implement to realize the bloomfilter
 */

public class BloomFilter 
{
	private BitArray bitArray;
	private int length;
	
	/*
	 *Constructor 
	 */
	public BloomFilter(int M)
	{
		//invalid argument
		if(M <= 0) throw new IllegalArgumentException();
		
		length = M;
		bitArray = new BitArray(M);
	}

	/*
	 * hash functions 
	 * Suppose the false positive probability is 0.01, then the optimize M = -Nln(p)/(ln(2)^2) =8148
	 * the number of hash function is 6.7, choose 7 hash functions
	 */
	private int hashCode1(String w)
	{
		return Math.abs(w.hashCode())%length;
	}
	private int hashCode2(String w)
	{
		long hash = 5;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;
	}	
	private int hashCode3(String w)
	{
		long hash = 7;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;
		
	}
	private int hashCode4(String w)
	{
		long hash = 13;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;
		
	}
	private int hashCode5(String w)
	{
		long hash = 17;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;
		
	}
	private int hashCode6(String w)
	{
		long hash = 23;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;
		
	}
	private int hashCode7(String w)
	{
		long hash = 1;
		for(int i=0;i<w.length();i++)
		{
			hash = hash*31 + (int)w.charAt(i);
		}
		return Math.abs((int)hash)%length;		
	}

	/*
	 * add the word into the bit array
	 */
	public void add(String w) 
	{
		//copute the 7 hash numbers individually,set it to bit array
		if(w == null || w.length() == 0) return;
		bitArray.set(hashCode1(w));
		bitArray.set(hashCode2(w));
		bitArray.set(hashCode3(w));
		bitArray.set(hashCode4(w));
		bitArray.set(hashCode5(w));
		bitArray.set(hashCode6(w));
		bitArray.set(hashCode7(w));		
	}
	
	/*
	 * determine whether the new word is in the set
	 */
	public boolean isIn(String w)
	{
		if(w == null || w.length() == 0) return false;
		
		boolean f1 = bitArray.get(hashCode1(w));
		boolean f2 = bitArray.get(hashCode2(w));
		boolean f3 = bitArray.get(hashCode3(w));
		boolean f4 = bitArray.get(hashCode4(w));
		boolean f5 = bitArray.get(hashCode5(w));
		boolean f6 = bitArray.get(hashCode6(w));
		boolean f7 = bitArray.get(hashCode7(w));
		
		if(f1 == false || f2 == false || f3 == false 
			|| f4 == false || f5 == false || f6 == false || f7 == false)
		{
			return false;
		}else{
			return true;
		}
	}
	
	/*
	 * calculate the accuracy of method isIn will report a word is in the set, when it is not 
	 */
	public double accuracy(int wrong, int total)
	{
		double res = 0;
		res = (double)(total-wrong)/total;
		return res;
	}
}
