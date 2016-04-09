package AlgorithmProject_BloomFilter;

/*This the test class for the bloom filter
 * 
 */
public class Main {

	public static void main(String[] args) 
	{
		//this is the path of the 'basic.txt' file
		String path = "/Users/TianRan/Desktop/basic.txt";
		
		BloomFilter bFilter = new BloomFilter(8148);//M = 8148 to get the 0.01 false positive probability 
		LineReader lineReader = new LineReader(path);

		//add all words to the bloom filter
		int numOfWords = 0;
	    while (lineReader.hasNext())
	    {
	    	numOfWords++;
	    	bFilter.add(lineReader.next());
	    }
	    //then to count the accuracy of the bloom filter
	    lineReader = new LineReader(path);
	    int wrong=0;
	    while(lineReader.hasNext())
	    {
	    	String tmp =lineReader.next();
	    	if(bFilter.isIn(tmp) == false) 
	    	{
	    		wrong++;
	    		System.out.println(tmp);
	    	}
	    }
//	    System.out.println(wrong);
//	    System.out.println(numOfWords);
	    System.out.println(bFilter.accuracy(wrong, numOfWords));
		
		
		//these are the test for the 7 hash functions ,in order to run these, make 7 hashfunctions in the
	    //BloomFilter from private to public
//		System.out.println(bFilter.hashCode1("qweqwe"));
//		System.out.println(bFilter.hashCode2("qweqwe"));
//		System.out.println(bFilter.hashCode3("qweqwe"));
//		System.out.println(bFilter.hashCode4("qweqwe"));
//		System.out.println(bFilter.hashCode5("qweqwe"));
//		System.out.println(bFilter.hashCode6("qweqwe"));
//		System.out.println(bFilter.hashCode7("qweqwe"));
	}

}
