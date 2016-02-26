package NIO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*Channel:
 * Channel模拟了老IO包中的流的概念。所有去任何地方（或者来自任何地方）的数据都必须通过Channel对象。可以从Channel中读取数据，也可以从Channel中写入数据。NIO与老IO相比而言，Channel就如同Stream。 
所有被NIO处理的数据都必须通过Buffer对象。不能直接将任何字节写入Channel，而是必须先将数据写入Buffer。同样的，也不能直接从Channel中读取任何字节，必须先通过Channel将数据读入Buffer，然后再从Buffer中获取数据
 * Channel与Stream的区别在于：Channel是双向的，而Stream只能是单向的（Stream必须是InputStream或者OutputStream的一个子类，即要么是输入流，要么是输出流，不能即输入又输出）
 */

/*运用NIO 读取文件的基本步骤：
 *  1. 从FileInputStream中获取Channel
	2. 创建Buffer
	3. 从Channel中把数据读入Buffer
 */

public class ChannelTest {

	public static void main(String[] args) throws Exception{
		
//		File myFile = new File("src/play.html");//相对于现在工程的路径
		File myFile = new File("/Users/TianRan/desktop/test.txt");//绝对路径
		FileInputStream fileInputStream = new FileInputStream(myFile);  
        // 获取通道  
        FileChannel fileChannel = fileInputStream.getChannel();  
  
        // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(1024);  
  
        // 读取数据到缓冲区  
        fileChannel.read(buffer);  
  
        // 重设buffer，将limit设置为position，position设置为0  
        buffer.flip();  
  
        // 查看在position和limit之间是否有元素  
        while (buffer.hasRemaining()) {  
            // 读取buffer当前位置的整数  
            byte b = buffer.get();  
            System.out.print((char) b);  
        }  
  
        //中文有乱码
        fileInputStream.close();
	}

}
