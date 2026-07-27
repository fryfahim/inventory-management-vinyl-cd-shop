import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class RemoveItemWindow {

	private JFrame frame;
	private JTextField idText;
	JTextPane textPane = new JTextPane();
	JLabel successText = new JLabel("");

	/**
	 * Launch the application.
	 */
	public void removeItemW() {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					RemoveItemWindow window = new RemoveItemWindow(); 
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
	public RemoveItemWindow() {
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
		
		JLabel lblRemoveItem = new JLabel("REMOVE ITEM");
		lblRemoveItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveItem.setForeground(Color.WHITE);
		lblRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblRemoveItem.setBounds(10, 11, 612, 65);
		panel.add(lblRemoveItem);
		
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
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
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
				for(StockableProduct product : inv) {
					if(product.getProductId()==id) {
						inv.removeItem(id);
					}
				}
				
				StringBuilder result = new StringBuilder();
			    for(StockableProduct product: inv) {
			    	result.append(product.getInfo()+"\n\n");
			    }
			    textPane.setText(result.toString());
			    successText.setText("Product Removed Successfully");
			    
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
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(553, 418, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 109, 317, 298);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(10, 59, 158, 41);
		panel_2.add(lblNewLabel);
		
		idText = new JTextField();
		idText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idText.setBounds(178, 59, 129, 41);
		panel_2.add(idText);
		idText.setColumns(10);
		successText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		successText.setHorizontalAlignment(SwingConstants.CENTER);
		successText.setForeground(new Color(0, 255, 64));
		successText.setBounds(0, 111, 317, 41);
		panel_2.add(successText);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(325, 109, 317, 298);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 297, 276);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2_1.add(scrollPane);
		
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setEditable(false);
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
