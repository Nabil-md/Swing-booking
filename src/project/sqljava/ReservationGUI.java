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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ReservationGUI implements ListSelectionListener, ActionListener{
	
	private JFrame reservationFrame;
	
	private JPanel reservationPanel;
	
	private JLabel reservationLabel;
	private JLabel reservationListLabel;
	
	private JList<String> reservationList;
	
	private JButton reservationButton;

	static String cinReserve;
	
	public ReservationGUI(String cin) {
		
		cinReserve = cin;
		
		System.out.println(cin + " this the inscription page");
		reservationFrame = new JFrame();
		
		reservationLabel = new JLabel("Page de réservation");
		reservationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		
		reservationListLabel = new JLabel("Veuillez sélectionner une réservation");
		reservationListLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		
		String url = "jdbc:mysql://localhost:3306/centre";
		String username = "root";
		String password = "root123";
		
		DefaultListModel<String> reservations = new DefaultListModel<String>(); 
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "SELECT reservation_name FROM reservation";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rows = statement.executeQuery();
			
			while (rows.next()) {
				
				String listRes = rows.getString(1);
				
				reservations.addElement(listRes);
				
			}
			
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		reservationList = new JList<String>(reservations);
		reservationList.addListSelectionListener(this);
		
		
		reservationButton = new JButton("Réserver");
		reservationButton.addActionListener(this);
		
		reservationPanel = new JPanel();
		reservationPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		reservationPanel.setLayout(new GridLayout(0 , 1));
		
		
		reservationPanel.add(reservationLabel);
		reservationPanel.add(reservationListLabel);
		reservationPanel.add(reservationList);
		reservationPanel.add(reservationButton);
		
		
		reservationFrame.setSize(500, 500);
		reservationFrame.add(reservationPanel, BorderLayout.CENTER);
		reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reservationFrame.setTitle("Centre Culturel");
		reservationFrame.pack();
		reservationFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new ReservationGUI("test");
	}

	String chosenReservation;
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		chosenReservation = (String) reservationList.getSelectedValue();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(chosenReservation);
		System.out.println(cinReserve);
		
		String url = "jdbc:mysql://localhost:3306/centre";
		String username = "root";
		String password = "root123";
		
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			String sql = "INSERT INTO user_reservation (user_cin, reservation_name) VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cinReserve);
			statement.setString(2, chosenReservation);
			
			int rows = statement.executeUpdate();
			
			if (rows > 0) {
				System.out.println("a row has been inserted");
			}
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		new alertGUI("Votre réservation a été effectuée");
		reservationFrame.dispose();
	}

}
