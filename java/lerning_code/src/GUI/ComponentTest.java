package GUI;

import javax.swing.JOptionPane;

public class ComponentTest 
{

	public static void main(String[] args) 
	{
		
		//显示对话框
		JOptionPane.showMessageDialog(null, "message", "dialog", JOptionPane.CANCEL_OPTION);
		JOptionPane.showConfirmDialog(null, "你高兴吗", "确认对话框", JOptionPane.YES_NO_OPTION);
	}

}
