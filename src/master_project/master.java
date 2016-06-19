package master_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class master extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;
	private String[] labels = {
			
			"backspace","a/b","a^b","b root a","CL",
			"7","8","9","(",")",
			"4","5","6","*","/",
			"1","2","3","+","-",
			"0",".","(-)","Exp","=",
			
			
	};

	public master(){
		tField = new JTextField(35);
		panel = new JPanel();
		tField.setText("");
		tField.setEnabled(false);
		
		
		panel.setLayout(new GridLayout(0,5,3,3));
		buttons = new JButton[25];
		int index = 0;
		for (int rows=0 ; rows <5;rows++){
		for (int i = 0 ; i <5;i++){
			buttons[index] = new JButton(labels[index]);
			buttons[index].addActionListener(this);
			panel.add(buttons[index]);
			index++;
			}
		}
		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("master");
		master m = new master();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if(actionCommand == "CL"){
			
		}
	}
}
