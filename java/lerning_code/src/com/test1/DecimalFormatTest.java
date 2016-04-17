package com.test1;

import java.text.DecimalFormat;
import java.util.Random;

/*如果需要特定的输出形式，例如小数点后保留两位有效数字
 * 
 */
public class DecimalFormatTest {

	public static void main(String[] args) {
		int test1 = 10;
		long test2 = 7;
		float test3 = 15.4f;
		double test4 = 100.1234;
		
		DecimalFormat formatTest = new DecimalFormat("#.00");
		System.out.println(formatTest.format(test1));
		System.out.println(formatTest.format(test2));
		System.out.println(formatTest.format(test3));
		System.out.println(formatTest.format(test4));
		
		//Random class
		Random random = new Random();
		System.out.println(random.nextInt(10));
	}

}
