/**
 * gridlayout
 */

package com.test1;
import java.awt.*;
import javax.swing.*;

public class Demo3 extends JFrame {
	JButton jbs[] = new JButton[9];
	int size=9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo3 p1 = new Demo3(); 
//		System.out.println(String.valueOf(2));
	}
	
	public Demo3(){
		//create widgets
		for (int i = 0; i < size; i++) {
			jbs[i] = new JButton(String.valueOf(i));			
		}
		
		//set layout manager
		this.setLayout(new GridLayout(3,3,10,10));//(3,3) rows and columns
		
		//add the widgets
		for (int i = 0; i < size; i++) {
			this.add(jbs[i]);
			
		}
		
		//set the properties of window
		this.setTitle("grid layout");
		this.setSize(300, 300);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//show the window
		this.setVisible(true);		
	}

}
