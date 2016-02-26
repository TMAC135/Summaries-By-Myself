package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 因为是一个字节一个字节读的，中文字体就会乱码
 */

public class ByteStreamTest {

	public static void main(String[] args) throws Exception
	{
		String fileName = "src/IO/InputStreamTest.java";
		File file = new File(fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		//read the contends byte by byte,有乱码
//		int byteUnit;
//		while((byteUnit = fis.read()) != -1)
//		{
//			System.out.print((char)byteUnit);
//		}
//		fis.close();
		
		//read the contends using a buffer - bytes array
//		byte []bytes = new byte[512];
//		int length;
//		while((length = fis.read(bytes)) != -1)
//		{
//			//print 
//
//			//用string 的新构造方法String(bytes,0,length)，竟然没有乱码
//			System.out.print(new String(bytes,0,length));
//		}
		
		/*
		 * OutputStream 类似的方法
		 */
		File outputFile = new File("/Users/TianRan/Desktop/output.java");
		
		FileOutputStream fos = new FileOutputStream(outputFile,true);//代表接者原文件写

		//write by every byte
//		fos.write('b');
//		fos.write('c');
//		fos.write(97);
//		
//		fos.close();
		
		
		//using buffer byte array		
//		byte []buffer = "123456".getBytes();
//		fos.write(buffer);
//		fos.close();
		
		/* copy big files like image or music type
		 * 
		 */
		String srcPath = "/Users/TianRan/Desktop/GF.jpg";
		String desPath1 = "/Users/TianRan/Desktop/copy1.jpg";
		String desPath2 = "/Users/TianRan/Desktop/copy2.jpg";
		String desPath3 = "/Users/TianRan/Desktop/copy3.jpg";
		//我们写的带缓冲的流
//		copy1(srcPath,desPath1);
//		copy2(srcPath,desPath2);
		
		/* BufferedInputStream and BufferedOutputStream
		 * 类似于上面我们自己写的带缓冲区的字节数组，系统默认的缓冲长度是8192
		 */
		copy3(srcPath,desPath3);
		
	}
	
	/* method:
	 * copy byte by byte,very slow
	 */
	public static void copy1(String srcPath, String desPath) throws IOException
	{
		File inputFile = new File(srcPath);
		File outputFile = new File(desPath);
		
		FileInputStream fis = new FileInputStream(inputFile);
		FileOutputStream fos = new FileOutputStream(outputFile);
		
		int length;
		while((length=fis.read()) != -1)
		{
			fos.write(length);
		}
		fis.close();
		fos.close();
	}
	
	/* method:
	 * copy using buffer,much faster
	 */
	public static void copy2(String srcPath, String desPath) throws IOException
	{
		File inputFile = new File(srcPath);
		File outputFile = new File(desPath);
		
		FileInputStream fis = new FileInputStream(inputFile);
		FileOutputStream fos = new FileOutputStream(outputFile);
		
		//不能保证最后一次写入正确信息
//		byte []buffer = new byte[512];
//		while((fis.read(buffer)) != -1)
//		{
//			fos.write(buffer);
//		}
//		
//		fis.close();
//		fos.close();
		
		//由于最后一次很有可能没有装满，用write的另外一个方法
//		int length;
//		byte []buffer = new byte[1024];
//		
//		while ( (length=fis.read(buffer)) != -1 )
//		{
//			fos.write(buffer, 0, length);
//		}
//		fis.close();
//		fos.close();
		
	}

	/* method:
	 * copy using BufferedInputStream and BufferedOutputStream
	 * Also: keep in mind that we get used to wrap the stream in try...
	 * catch...finally... block so that we can close the stream safely
	 * 一定要养成这个习惯
	 */
	public static void copy3(String srcPath, String desPath) 
	{
		File inputFile = new File(srcPath);
		File outputFile = new File(desPath);
		
		//定义要放在try ... catch ... finally 外面
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int length;
			while((length=bis.read()) != -1)
			{
				bos.write(length);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(bis != null)
			{
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(bos != null)
					{
						try {
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		

	}
}
