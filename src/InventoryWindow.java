import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InventoryWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void inventoryW() {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					InventoryWindow window = new InventoryWindow();
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
	public InventoryWindow() {
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
		panel.setBounds(10, 11, 632, 87);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel.setBounds(10, 11, 612, 65);
		panel.add(lblNewLabel);
		
		JButton backButton = new JButton("Back\r\n");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeWindow ww = new WelcomeWindow();
				ww.welcome();
				frame.dispose();
			}
		});
		backButton.setForeground(new Color(0, 0, 0));
		backButton.setBackground(new Color(255, 255, 255));
		backButton.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton removeItem = new JButton("Remove Item");
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveItemWindow riw = new RemoveItemWindow();
				riw.removeItemW();
				frame.dispose();
			}
		});
		removeItem.setHorizontalAlignment(SwingConstants.LEFT);
		removeItem.setForeground(Color.BLACK);
		removeItem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		removeItem.setBackground(Color.WHITE);
		removeItem.setBounds(10, 183, 233, 43);
		frame.getContentPane().add(removeItem);
		
		JButton addItem = new JButton("Add Item");
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemWindow aiw = new addItemWindow();
				aiw.addItemW();
				frame.dispose();
			}
		});
		addItem.setHorizontalAlignment(SwingConstants.LEFT);
		addItem.setForeground(Color.BLACK);
		addItem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		addItem.setBackground(Color.WHITE);
		addItem.setBounds(10, 129, 233, 43);
		frame.getContentPane().add(addItem);
		
		JButton addStock = new JButton("Add Stock");
		addStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStockWindow asw = new AddStockWindow();
				asw.addStockW();
				frame.dispose();
			}
		});
		addStock.setHorizontalAlignment(SwingConstants.LEFT);
		addStock.setForeground(Color.BLACK);
		addStock.setFont(new Font("Tahoma", Font.PLAIN, 28));
		addStock.setBackground(Color.WHITE);
		addStock.setBounds(10, 237, 233, 43);
		frame.getContentPane().add(addStock);
		
		JButton showItem = new JButton("Show Items");
		showItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowItemsWindow siw = new ShowItemsWindow();
				siw.showItem();
				frame.dispose();
			}
		});
		showItem.setHorizontalAlignment(SwingConstants.LEFT);
		showItem.setForeground(Color.BLACK);
		showItem.setFont(new Font("Tahoma", Font.PLAIN, 28));
		showItem.setBackground(Color.WHITE);
		showItem.setBounds(10, 291, 233, 43);
		frame.getContentPane().add(showItem);
	}

}
