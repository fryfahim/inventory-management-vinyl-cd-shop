import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class AddStockWindow {

	private JFrame frame;
	private JTextField idText;
	private JTextField stockText;
	JTextPane textPane = new JTextPane();
	JLabel successText = new JLabel("");

	/**
	 * Launch the application.
	 */
	public void addStockW() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStockWindow window = new AddStockWindow();
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
	public AddStockWindow() {
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
		
		JLabel lblAddStock = new JLabel("ADD STOCK");
		lblAddStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStock.setForeground(Color.WHITE);
		lblAddStock.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblAddStock.setBounds(10, 11, 612, 65);
		panel.add(lblAddStock);
		
		JButton backButton = new JButton("Back\r\n");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryWindow iw = new InventoryWindow();
				iw.inventoryW();
				frame.dispose();
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory inv = new Inventory();
				File file = new File("Inventory.txt");
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
				int id =Integer.parseInt(idText.getText());
				int gStock = Integer.parseInt(stockText.getText());
				
				for(StockableProduct product : inv) {
					if(product.getProductId()==id) {
						inv.getItem(id).addStock(gStock+1);
					}
				}
				StringBuilder result = new StringBuilder();
			    for(StockableProduct product: inv) {
			    	result.append(product.getInfo()+"\n\n");
			    }
			    textPane.setText(result.toString());
			    successText.setText("Stock Added Successfully");
			    
			    try {
					ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
						for(StockableProduct product : inv) {
							objOut.writeObject(product);
						}
					objOut.close();
				} catch (IOException e1) {
				}
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(553, 418, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 109, 317, 298);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 59, 158, 41);
		panel_2.add(lblNewLabel);
		
		idText = new JTextField();
		idText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idText.setColumns(10);
		idText.setBounds(178, 59, 129, 41);
		panel_2.add(idText);
		
		JLabel lblAddStock_1 = new JLabel("Add Stock:");
		lblAddStock_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddStock_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAddStock_1.setBounds(10, 111, 158, 41);
		panel_2.add(lblAddStock_1);
		
		stockText = new JTextField();
		stockText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stockText.setColumns(10);
		stockText.setBounds(178, 111, 129, 41);
		panel_2.add(stockText);
		successText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		successText.setHorizontalAlignment(SwingConstants.CENTER);
		successText.setForeground(new Color(0, 255, 64));
		successText.setBounds(10, 163, 307, 41);
		panel_2.add(successText);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(325, 109, 317, 298);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 297, 276);
		panel_2_1.add(scrollPane);
		
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(textPane);
		
		 Inventory inv = new Inventory();
			File file = new File("Inventory.txt");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
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
			
			StringBuilder result = new StringBuilder();
		    for(StockableProduct product: inv) {
		    	result.append(product.getInfo()+"\n\n");
		    }
		    textPane.setText(result.toString());
	}

}
