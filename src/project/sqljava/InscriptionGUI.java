package project.sqljava;

// awt imports
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// jdbc sql imports
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

// swing imports
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InscriptionGUI implements ActionListener{
	
	// private int clickCount = 0;

	// private JLabel buttonLabel;
	private JLabel cinLabel;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JLabel emailLabel;
	private JLabel inscriptionLabel;
	
	private JFrame inscriptionFrame;
	
	private JButton button;
	
	private JPanel inscriptionPanel;
	

	private JTextField cinText;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JTextField emailText;
	
	public InscriptionGUI() {
		
		inscriptionFrame = new JFrame();
		
		button = new JButton("Login");
		button.addActionListener(this);
		
		//buttonLabel = new JLabel("Number of clicks: 0");
		
		inscriptionLabel = new JLabel("Inscription");
		inscriptionLabel.setBounds(10,20,80,25);
		inscriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		
		cinLabel = new JLabel("CIN");
		cinLabel.setBounds(10,20,80,25);
		cinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		userLabel = new JLabel("username");
		userLabel.setBounds(10,20,80,25);
		userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		passwordLabel = new JLabel("password");
		passwordLabel.setBounds(10,20,80,25);
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		emailLabel = new JLabel("email");
		emailLabel.setBounds(10,20,80,25);
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		// CIN text input
		cinText = new JTextField(20);
		
		// username text input
		usernameText = new JTextField(20);
		
		// password text input
		passwordText = new JPasswordField(20);
		
		// email text input
		emailText = new JTextField(20);
		
		inscriptionPanel = new JPanel();
		inscriptionPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		inscriptionPanel.setLayout(new GridLayout(0 , 1));
		
		inscriptionPanel.add(inscriptionLabel);
		inscriptionPanel.add(cinLabel);
		inscriptionPanel.add(cinText);
		inscriptionPanel.add(userLabel);
		inscriptionPanel.add(usernameText);
		inscriptionPanel.add(passwordLabel);
		inscriptionPanel.add(passwordText);
		inscriptionPanel.add(emailLabel);
		inscriptionPanel.add(emailText);
		inscriptionPanel.add(button);
		//inscriptionPanel.add(buttonLabel);
		
		inscriptionFrame.setSize(500, 500);
		inscriptionFrame.add(inscriptionPanel, BorderLayout.CENTER);
		inscriptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inscriptionFrame.setTitle("Centre Culturel");
		inscriptionFrame.pack();
		inscriptionFrame.setVisible(true);
		// frame.add(button);
		// button.setSize(10, 10);
		
		
		
	}
	
	public static void main(String[] args) {
		new InscriptionGUI();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//clickCount++;
		//buttonLabel.setText("number of clicks: " + clickCount);
		
		String url = "jdbc:mysql://localhost:3306/centre";
		String username = "root";
		String password = "root123";
		

		String inscriptionCIN = cinText.getText();
		String inscriptionUser = usernameText.getText();
		@SuppressWarnings("deprecation")
		String inscriptionPassword = passwordText.getText();
		String inscriptionEmail = emailText.getText();
		
		System.out.println(inscriptionUser);
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("connected to the database");
			
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, inscriptionCIN);
			statement.setString(2, inscriptionUser);
			statement.setString(3, inscriptionPassword);
			statement.setString(4, inscriptionEmail);
			
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("a row has been inserted");
			}
			
			statement.close();
			connection.close();
			
			new AlertGUI("Votre compte a été créé avec succès");
			inscriptionFrame.dispose();
			
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
		
		
	}

}
