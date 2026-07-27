import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*
;
import javax.swing.JTextPane;public class ShowItemsWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void showItem() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowItemsWindow window = new ShowItemsWindow();
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
	public ShowItemsWindow() { 
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
		panel.setLayout(null); 
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Inventory\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel.setBounds(173, 11, 308, 65);
		panel.add(lblNewLabel);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 109, 632, 298);
		frame.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	    
	    JButton btnSortByPrice = new JButton("Sort by price");
	    btnSortByPrice.addActionListener(new ActionListener() {
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
				
				inv.sortByPrice();
				StringBuilder result = new StringBuilder();
			    for(StockableProduct product: inv) {
			    	result.append(product.getInfo()+"\n\n");
			    }
			    textPane.setText(result.toString());
			    
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
	    btnSortByPrice.setForeground(Color.BLACK);
	    btnSortByPrice.setBackground(Color.WHITE);
	    btnSortByPrice.setBounds(109, 418, 209, 23);
	    frame.getContentPane().add(btnSortByPrice);
	    
	    JButton btnSortByAvailability = new JButton("Sort by availability");
	    btnSortByAvailability.addActionListener(new ActionListener() {
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
				
				inv.sortByAvailableStock();
				StringBuilder result = new StringBuilder();
			    for(StockableProduct product: inv) {
			    	result.append(product.getInfo()+"\n\n");
			    }
			    textPane.setText(result.toString());
			    
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
	    btnSortByAvailability.setForeground(Color.BLACK);
	    btnSortByAvailability.setBackground(Color.WHITE);
	    btnSortByAvailability.setBounds(334, 418, 209, 23);
	    frame.getContentPane().add(btnSortByAvailability);
	    
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
		
		StringBuilder result = new StringBuilder();
	    for(StockableProduct product: inv) {
	    	result.append(product.getInfo()+"\n\n");
	    }
	    textPane.setText(result.toString());
	    
	    JButton btnSearch = new JButton("Search");
	    btnSearch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SearchWindow sw = new SearchWindow();
	    		sw.searchW();
	    		frame.dispose();
	    	}
	    });
	    btnSearch.setForeground(Color.BLACK);
	    btnSearch.setBackground(Color.WHITE);
	    btnSearch.setBounds(553, 418, 89, 23);
	    frame.getContentPane().add(btnSearch);
	}
}
