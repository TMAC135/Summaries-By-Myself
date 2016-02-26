/**
 * 
 */

package com.test1;


import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame{
	//把需要的组建定义在这
	JButton jb1 = null;
	
	public static void main(String[] args){
		Gui p1 = new Gui();

	}

	public Gui(){
		// JFrame jf = new JFrame();//JFrame 是顶层窗口

		jb1 = new JButton("button1");//按钮

		// set title
		this.setTitle("hello world!");

		// set size, width*height
		this.setSize(400,400);

		// set initial location when pop out the window
		this.setLocation(100,200);

		// 添加JButton组建
		this.add(jb1);

		// 关闭窗口的时候保证 jvm 也关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// display
		this.setVisible(true);	
		
	}

}