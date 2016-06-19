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
			
			"backspace","/","^","root","C",
			"7","8","9","(",")",
			"4","5","6","*","/",
			"1","2","3","+","-",
			"0",".","(-)","Exp","=",			
			
	};
	
	private double result = 0;
	private double secondresult = 0;
	private double getresult = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	private boolean lastOfNumber = false;

	public master(){
		tField = new JTextField(35);
		panel = new JPanel();
		tField.setText("0.0");
		//tField.setEnabled(false);
		
		
		panel.setLayout(new GridLayout(0,5,3,3));
		buttons = new JButton[25];
		int index = 0;
		for (int rows=0 ; rows <5;rows++){
		for (int i = 0 ; i <5;i++){
			buttons[index] = new JButton(labels[index]);
			panel.add(buttons[index]);
			buttons[index].addActionListener(this);
			index++;
			}
		}
		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Command = e.getActionCommand();
		if(Command.charAt(0)=='C'){
			startOfNumber = true;
			result = 0;
			operator = "=";
			tField.setText("0.0");
		}
		else if(Command.charAt(0) >= '0' && Command.charAt(0)<= '9' || Command.equals(".")){
			if (startOfNumber == true){
				tField.setText(Command);
				startOfNumber = false;
			}
			else{
				tField.setText(tField.getText()+Command);
				
				}
			}
		else if(Command.charAt(0)=='='){
			secondresult = Double.parseDouble(tField.getText());
			calculate(secondresult);
			tField.setText(""+result);
		}
		else{
			if(startOfNumber){
					tField.setText("숫자를 먼저 입력해 주세요");
					startOfNumber = true;
					result = 0;
					operator = "=";
			}
			else{
				result = Double.parseDouble(tField.getText());
				operator = Command;
				startOfNumber = true;
				lastOfNumber = true;
			}
	}
}

public void calculate(double n){
	if (operator.equals("+")){
		result += n;
	}
	else if(operator.equals("-")){
		result -=n;
	}
	else if(operator.equals("*")){
		result *=n;
	}
	else if(operator.equals("/")){
		result = result/n+result%n;
	}
	else if(operator.equals("=")){
		result =n;
		tField.setText(" "+result);
	}
	else if(operator.equals("^")){
		getresult = result;
		for(double i = 1 ; i<n;i++){
			result *= getresult;
		}
	}
}

public static void main(String[] args) {

	// TODO Auto-generated method stub
	System.out.println("master");
	master m = new master();

}

}
