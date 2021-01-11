package project.sqljava;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePageGUI implements ActionListener{

	private JLabel homeLabel;
	
	private JCheckBox homeUserCheckBox;
	private JCheckBox homeNewCheckBox;
	
	
	private JButton homeButton;
	
	private JPanel homePanel;
	
	private JFrame homeFrame;
	
	
	public HomePageGUI() {
		
		homeLabel = new JLabel("Home");
		homeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		
		homeUserCheckBox = new JCheckBox("Membre");  
        homeUserCheckBox.setBounds(100,100, 50,50);
        
        homeNewCheckBox = new JCheckBox("Nouveau Utilisateur");
        homeNewCheckBox.setBounds(100,100, 50,50);
        
        homeFrame = new JFrame();
        
        homeButton = new JButton("Submit");
        homeButton.addActionListener(this);
        
        homePanel = new JPanel();
        homePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        homePanel.setLayout(new GridLayout(0 , 1));
		
        homePanel.add(homeLabel);
        homePanel.add(homeNewCheckBox);
        homePanel.add(homeUserCheckBox);
        homePanel.add(homeButton);
        
        homeFrame.setSize(500, 500);
        homeFrame.add(homePanel, BorderLayout.CENTER);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setTitle("Centre Culturel");
        homeFrame.pack();
        homeFrame.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new HomePageGUI();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (homeUserCheckBox.isSelected()) {
			new LoginGUI();
			homeFrame.dispose();
		} else if (homeNewCheckBox.isSelected()) {
			new InscriptionGUI();
			homeFrame.dispose();
		}
		
	}
	
}
	

