package project.sqljava;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener{

	
	
	private JLabel loginLabel;
	private JFrame loginFrame;
	
	private JLabel loginUserLabel;
	private JLabel loginPasswordLabel;
	
	private JButton loginButton;
	
	private JTextField loginUsernameText;
	private JPasswordField loginPasswordText;
	
	private JPanel loginPanel;
	
	public LoginGUI() {
		
	loginLabel = new JLabel("Login");
	loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
	
	loginUserLabel = new JLabel("Username");
	loginUserLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
	loginPasswordLabel = new JLabel("Password");
	loginPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
	
	loginUsernameText = new JTextField();
	loginPasswordText =  new JPasswordField();
	
	loginButton = new JButton("Login");
	loginButton.addActionListener(this);
	
	loginFrame = new JFrame();
	
	loginPanel = new JPanel();
	loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    loginPanel.setLayout(new GridLayout(0 , 1));
    
    loginPanel.add(loginLabel);
    loginPanel.add(loginUserLabel);
    loginPanel.add(loginUsernameText);
    loginPanel.add(loginPasswordLabel);
    loginPanel.add(loginPasswordText);
    loginPanel.add(loginButton);
		
	loginFrame.setSize(500, 500);
	loginFrame.add(loginPanel, BorderLayout.CENTER);
	loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	loginFrame.setTitle("Centre Culturel");
	loginFrame.pack();
	loginFrame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new LoginGUI();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String url = "jdbc:mysql://localhost:3306/centre";
		String username = "root";
		String password = "root123";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("connected to the database");
			
			String sql = "SELECT CIN FROM users where (username = ? and password = ?)";
			
			String loginUsername = loginUsernameText.getText();
			@SuppressWarnings("deprecation")
			String loginPassword = loginPasswordText.getText();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginUsername);	
			statement.setString(2, loginPassword);
			
			ResultSet rows = statement.executeQuery();
			if (rows.next()) {
				System.out.println("a row has been selected");
				// String CIN = rows;
				String cin = (rows.getString(1));
				new ReservationGUI(cin);
				// move on to the reservation page
			}
			
			statement.close();
			connection.close();
			loginFrame.getDefaultCloseOperation();
			
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		new alertGUI("vous vous êtes connecté avec succès");
		loginFrame.dispose();
		
	}
	

}
