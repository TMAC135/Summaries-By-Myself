package IO;

import java.io.*;

public class FileTest 
{

	public static void main(String[] args) 
	{
		//this is relative path, since it don't start with /,but we recommend the absolute path 
		File file = new File("src");
		
//		System.out.println(file.isDirectory());
		System.out.println(file.getAbsolutePath());//very useful when we want absolute path
//		System.out.println(file.isAbsolute());
//		System.out.println(file.isFile());
//		System.out.println(File.separator);
		
//		File []files = file.listFiles();
//		for(int i=0;i<files.length;i++)
//		{
//			System.out.println(files[i].getName());
//		}
//		System.out.println(files[0].isFile());
		
		/**Example: 
		 * List all the sub files and sub directories under the src/
		 */
		String Filename = "src";
		
//		printHierarchyStructure(Filename,0);
		
	}
	
	/*
	 * List and print the hierarchy file and directory for a given directory
	 * 	using recursion
	 */
	public static void printHierarchyStructure(String directoryName,int spaceNum)
	{
		
		String space="";
		for(int i=0;i<spaceNum;i++)
		{
			space += "  ";
		}
		
		File file = new File(directoryName);
		
		//print the string directory first
		System.out.println(space + file.getName());
		
		File []files = file.listFiles();
		for(int i=0;i<files.length;i++)
		{
			File tmp = files[i];
			if(tmp.isFile())
			{
				System.out.println(space + "--" + tmp.getName());
			}
			else
			{
				printHierarchyStructure(directoryName+File.separator+tmp.getName(),spaceNum+1);
			}
		}
		
	}

}
