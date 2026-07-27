import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class SearchWindow {

	private JFrame frame;
	private JTextField searchText;
	JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public void searchW() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow window = new SearchWindow();
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
	public SearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 668, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 632, 87);
		frame.getContentPane().add(panel);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblSearch.setBounds(173, 11, 308, 65);
		panel.add(lblSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 109, 317, 298);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Enter text: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 11, 158, 41);
		panel_2.add(lblNewLabel);
		
		searchText = new JTextField();
		searchText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchText.setColumns(10);
		searchText.setBounds(10, 59, 297, 41);
		panel_2.add(searchText);
		
		JButton backButton = new JButton("Back\r\n");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowItemsWindow siw = new ShowItemsWindow();
				siw.showItem();
				frame.dispose();
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton backButton_1 = new JButton("Search");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory inv = new Inventory();
				File file = new File("Inventory.txt");
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
					while(true) {
						try {
							inv.addItem((StockableProduct)input.readObject());
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
				
				String text = searchText.getText(); 
				for(StockableProduct product : inv) {
					if((product.getInfo().contains(text))==true) {
						textPane.setText(product.getInfo());
						break;
					}
				}
			}
		});
		backButton_1.setForeground(Color.BLACK);
		backButton_1.setBackground(Color.WHITE);
		backButton_1.setBounds(553, 418, 89, 23);
		frame.getContentPane().add(backButton_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(325, 109, 317, 298);
		frame.getContentPane().add(panel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 297, 276);
		panel_2_1.add(scrollPane);
		
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(textPane);
	}
}
