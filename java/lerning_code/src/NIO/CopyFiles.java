package NIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * 运用NIO 拷贝文件
 */

public class CopyFiles {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fileInStream = new FileInputStream("/Users/TianRan/desktop/test.txt");
		FileOutputStream fileOutStream = new FileOutputStream("/Users/TianRan/desktop/test2.txt");
		
		//get the channel
		FileChannel inChannel = fileInStream.getChannel();
		FileChannel outChannel = fileOutStream.getChannel();
		
		//copy
		outChannel.transferFrom(inChannel, 0, inChannel.size());
		
		
		//close the stream 
		inChannel.close();
		outChannel.close();

	}

}
