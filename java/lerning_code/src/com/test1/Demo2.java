/**
 * flowlayout
 */
package com.test1;
import java.awt.*;
import javax.swing.*;

public class Demo2 extends JFrame{
	JButton jb1,jb2,jb3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2 p1=new Demo2();

	}
	
	public Demo2(){
		//create widget
		jb1=new JButton("1");
		jb2=new JButton("2");
		jb3=new JButton("3");
		
		//add widgets
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		
		//set the layout management!!!!
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		//设置窗体属性
		this.setTitle("边界布局");
		this.setSize(400,400);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//prohibit user changing the size of the window
		this.setResizable(false);
	
		//显示窗体
		this.setVisible(true);
		
	}

}
