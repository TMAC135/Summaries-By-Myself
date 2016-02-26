package IO;

import java.io.*;

public class CharacterStreamTest 
{
	public static void main(String[] args) throws Exception
	{
		
		
		/* copy file
		 * 	using BufferedReader and BufferedWriter
		 * 有flush()刷新功能
		 */
		String srcPath = "/Users/TianRan/Desktop/test.txt";
		String desPath1 = "/Users/TianRan/Desktop/copy1.txt";
		
		copy1(srcPath,desPath1);
	}
	
	/*
	 * 类似于stream, 字符流也是可以缓冲处理的
	 */
	private static void copy1(String srcPath, String desPath) throws Exception {
		File inputFile = new File(srcPath);
		File outputFile = new File(desPath);
		
		FileReader fr = new FileReader(inputFile);
		FileWriter fw = new FileWriter(outputFile);
		
		BufferedReader bfr = new BufferedReader(fr);
		BufferedWriter bfw = new BufferedWriter(fw);
		
		String line;
		while((line=bfr.readLine()) != null)
		{
			//一次写出一行
			bfw.write(line);
			//刷新缓冲
			bfw.flush();
			//readline()没有默认的换行，需要手动的换行
			bfw.newLine();
		}
		
		bfw.close();
		bfw.close();
		
		
	}
	
	
}
