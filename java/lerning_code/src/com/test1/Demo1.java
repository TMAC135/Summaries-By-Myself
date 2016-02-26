
/**
 * borderLayout ,不要输出中文字符，不然容易混幺。
 */


package com.test1;
import java.awt.*;
import javax.swing.*;

public class Demo1 extends JFrame {
	//定义组建	
	JButton jb1,jb2,jb3,jb4,jb5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 p1 = new Demo1();
		

	}
	
	public Demo1(){
		jb1 = new JButton("mid");
		jb2 = new JButton("north");
		jb3 = new JButton("east");
		jb4 = new JButton("south");
		jb5 = new JButton("west");
		
		//添加组建
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5,BorderLayout.WEST);
		
		//设置窗体属性
		this.setTitle("边界布局");
		this.setSize(200,200);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//显示窗体
		this.setVisible(true);

	}
	

}
