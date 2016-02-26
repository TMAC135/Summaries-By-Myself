package hahcode;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * this is the test of the hashcoder from apache commons
 * @author TianRan
 *
 */

public class ApacheHashCodeTest {

	public static void main(String[] args) {
		int[] s = new int[]{1,2,3,4};
		int[] s1 = new int[]{11,2,3,4};
		int[] s2 = new int[]{1,22,3,4};
		int[] s3 = new int[]{1,2,33,4};
		System.out.println(hashCode(s));
		System.out.println(hashCode(s1));
		System.out.println(hashCode(s2));
		System.out.println(hashCode(s3));
		

	}

	
	/*
	 * This method is used to compute hashCode for a object, using apache commons util
	 */
	public static int hashCode(int[] _s) {
		HashCodeBuilder builder = new HashCodeBuilder();
		return builder.append(_s).toHashCode();
	}
}
