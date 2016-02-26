package NIO;

import java.nio.IntBuffer;

/**Buffer类：
 * capacity:the number of elements it contains。
 * 指示Buffer最多能够存储的数据。实际上，它指示了底层array的容量，或者至少是底层array允许使用的空间数量。Limit永远不会大于capacity
 * 
 * limit: index of the first element that should not be read or written
 * 在从Channel中读取数据到Buffer中时，limit变量指示了还剩多少空间可供存放数据，在从Buffer向Channel写数据时，limit变量指示了还剩多少数据可以写入。position正常情况下小于或者等于limit。
 * 
 * position:  index of the next element to be read or written
 * 指定了下一个将要被写入或者读取的元素索引。在从Channel读取数据到Buffer时，position变量用来跟踪截止目前为止从Channel中读出了多少数据，在从Buffer中向Channel写数据时，position变量用来跟踪截止目前为止向Channel写入了多少数据。
 * @author TianRan
 *
 */

/**flip(): 
 * 1. 把limit设置为当前的position值
   2. 把position设置为0
 * 
 *clear():
 *1. 把limit设置为capacity值
  2. 把position设置为0
 */

public class BufferTest {

	public static void main(String[] args) {
		IntBuffer buffer =IntBuffer.allocate(8);
		
		 for (int i = 0; i < buffer.capacity(); ++i) {  
	            int j = 2 * (i + 1);  
	            // 将给定整数写入buffer的当前位置  
	            buffer.put(j);  
	        }  
	  
	        // 重设buffer，将limit设置为position，position设置为0  
	        buffer.flip();  
	  
	        // 查看在position和limit之间是否有元素  
	        while (buffer.hasRemaining()) {  
	            // 读取buffer当前位置的整数  
	            int j = buffer.get();  
	            System.out.println(j + " ");  
	        }
		
		
	}

}
