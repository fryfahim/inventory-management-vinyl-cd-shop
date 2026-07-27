
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;

public class AddGameWindow {

	private JFrame frame;
	private JTextField nameText;
	private JTextField productIdText;
	private JTextField priceText;
	private JTextField genreText;
	private JTextField yearText;
	private JTextField stockText;
	private JTextField developerText;
	private JTextField discountText;
	JLabel successText = new JLabel(""); 

	/**
	 * Launch the application.
	 */
	public void addGameW() {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					AddGameWindow window = new AddGameWindow();
					window.frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddGameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 912, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 876, 87);
		frame.getContentPane().add(panel);
		
		JLabel lblAddGame = new JLabel("Add Game");
		lblAddGame.setBounds(285, 11, 328, 65);
		panel.add(lblAddGame);
		lblAddGame.setForeground(Color.WHITE);
		lblAddGame.setFont(new Font("Tahoma", Font.PLAIN, 70));
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameLabel.setForeground(new Color(0, 0, 0));
		nameLabel.setBackground(new Color(255, 255, 255));
		nameLabel.setBounds(0, 127, 189, 30);
		frame.getContentPane().add(nameLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameText.setBounds(199, 127, 239, 30);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JLabel productIdLabel = new JLabel("Product ID:");
		productIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		productIdLabel.setForeground(Color.BLACK);
		productIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		productIdLabel.setBackground(Color.WHITE);
		productIdLabel.setBounds(0, 168, 189, 30);
		frame.getContentPane().add(productIdLabel);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setBounds(0, 209, 189, 30);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setForeground(Color.BLACK);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGenre.setBackground(Color.WHITE);
		lblGenre.setBounds(0, 250, 189, 30);
		frame.getContentPane().add(lblGenre);
		
		JLabel lblYear = new JLabel("Year Published:");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setForeground(Color.BLACK);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblYear.setBackground(Color.WHITE);
		lblYear.setBounds(442, 168, 179, 30);
		frame.getContentPane().add(lblYear);
		
		productIdText = new JTextField();
		productIdText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productIdText.setColumns(10);
		productIdText.setBounds(199, 168, 239, 30); 
		frame.getContentPane().add(productIdText);
		
		priceText = new JTextField();
		priceText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceText.setColumns(10);
		priceText.setBounds(199, 209, 239, 30);
		frame.getContentPane().add(priceText);
		
		genreText = new JTextField();
		genreText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genreText.setColumns(10);
		genreText.setBounds(199, 250, 239, 30);
		frame.getContentPane().add(genreText);
		
		yearText = new JTextField();
		yearText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearText.setColumns(10);
		yearText.setBounds(631, 168, 239, 30);
		frame.getContentPane().add(yearText);
		
		JLabel lblNewLabel_4_1 = new JLabel("Total Stock:");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(469, 209, 152, 30);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Developer:");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4_2.setBackground(Color.WHITE);
		lblNewLabel_4_2.setBounds(469, 250, 152, 30);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		stockText = new JTextField();
		stockText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stockText.setColumns(10);
		stockText.setBounds(631, 209, 239, 30);
		frame.getContentPane().add(stockText);
		
		developerText = new JTextField();
		developerText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		developerText.setColumns(10);
		developerText.setBounds(631, 250, 239, 30);
		frame.getContentPane().add(developerText);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemWindow aiw = new addItemWindow();
				aiw.addItemW();
				frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 427, 89, 23);
		frame.getContentPane().add(btnNewButton); 
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt(productIdText.getText());
				double gPrice = Double.parseDouble(priceText.getText());
				int year = Integer.parseInt(yearText.getText());
				double gDiscount = Double.parseDouble(discountText.getText());
				int gStock = Integer.parseInt(stockText.getText()); 
				Game g = new Game(nameText.getText(), id, gPrice, genreText.getText(), year, gDiscount, gStock, developerText.getText());
				File file = new File("Inventory.txt");
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Inventory temp = new Inventory();
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
					while(true) {
						try {
							temp.addItem((StockableProduct)input.readObject());
						}catch(java.io.EOFException eofe) {
							break;
						}
					}  
					input.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				temp.addItem(g);
				try {
					ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
						for(StockableProduct product : temp) {
							objOut.writeObject(product);
						}
					objOut.close();
				} catch (IOException e1) {
				}
				
				nameText.setText("");
				productIdText.setText("");
				priceText.setText("");
				genreText.setText("");
				yearText.setText("");
				discountText.setText("");
				stockText.setText("");
				developerText.setText("");
				successText.setText("Game Added Successfully");
			}
		});
		btnNewButton_1.setBounds(797, 427, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Discount:");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4_2_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1.setBounds(469, 127, 152, 30);
		frame.getContentPane().add(lblNewLabel_4_2_1);
		
		discountText = new JTextField();
		discountText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		discountText.setColumns(10);
		discountText.setBounds(631, 127, 239, 30);
		frame.getContentPane().add(discountText);
		
		successText.setForeground(new Color(0, 255, 64));
		successText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		successText.setHorizontalAlignment(SwingConstants.CENTER);
		successText.setBounds(10, 291, 876, 23);
		frame.getContentPane().add(successText);
	}
}
