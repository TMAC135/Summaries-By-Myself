package NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferChannelTest {

	public static void main(String[] args) throws Exception {
		FileInputStream fileInStream = new FileInputStream("/Users/TianRan/desktop/test.txt");  
        // 获取读通道  
        FileChannel fcin = fileInStream.getChannel();  
  
        FileOutputStream fileOutStream = new FileOutputStream("/Users/TianRan/desktop/test2.txt");  
        // 获取写通道  
        FileChannel fcout = fileOutStream.getChannel();  
  
        // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(10);  
        output("初始化", buffer);  
  
        // 从通道fcin读取数据到缓冲区  
        fcin.read(buffer);  
        output("调用read()", buffer);  
  
        // 重设buffer，将limit设置为position，然后将position设置为0  
        buffer.flip();  
        output("调用flip()", buffer);  
  
        // 将缓冲区中的数据写入通道fcout  
        fcout.write(buffer);  
        output("调用write()", buffer);  
  
        // 重设buffer，将limit设置为容量capacity，position设置为0  
        buffer.clear();  
        output("调用clear()", buffer);  
  
        fileInStream.close();  
        fileOutStream.close();  
        
 /*初始化 : 
position: 0, limit: 10, capacity: 10

调用read() : 
position: 10, limit: 10, capacity: 10

调用flip() : 
position: 0, limit: 10, capacity: 10

调用write() : 
position: 10, limit: 10, capacity: 10

调用clear() : 
position: 0, limit: 10, capacity: 10
         * 
*/
    }  
  
    public static void output(String step, Buffer buffer) {  
        System.out.println(step + " : ");  
        System.out.print("position: " + buffer.position() + ", ");  
        System.out.print("limit: " + buffer.limit() + ", ");  
        System.out.println("capacity: " + buffer.capacity());  
        System.out.println();  
    }  
}

