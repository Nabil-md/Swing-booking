package project.sqljava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertGUI implements ActionListener{
	
	
	private JLabel alertLabel;
	
	private JButton alertButton;
	
	private JPanel alertPanel;
	
	private JFrame alertFrame;
	
	
	
	
	public AlertGUI(String message) {
		
		
		alertLabel = new JLabel(message);
		
		alertButton = new JButton("Okay");
		alertButton.addActionListener(this);
		
		alertPanel = new JPanel();
		alertPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		alertPanel.setLayout(new GridLayout(0 , 1));
		
		alertPanel.add(alertLabel);
		alertPanel.add(alertButton);
		
		
		alertFrame = new JFrame();
		
		alertFrame.setSize(500, 500);
		alertFrame.add(alertPanel, BorderLayout.CENTER);
		alertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alertFrame.setTitle("Centre Culturel");
		alertFrame.pack();
		alertFrame.setVisible(true);		
		
	}
	
	

	public static void main(String[] args) {
		new AlertGUI("hi");

	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		alertFrame.dispose();
	}

}
