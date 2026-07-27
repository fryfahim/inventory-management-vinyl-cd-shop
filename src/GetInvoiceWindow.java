import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GetInvoiceWindow {

	private JFrame frame;
	JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public void getInvoiceW() {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					GetInvoiceWindow window = new GetInvoiceWindow();
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
	public GetInvoiceWindow() {
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
		
		JLabel lblRemoveItem = new JLabel("INVOICE");
		lblRemoveItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveItem.setForeground(Color.WHITE);
		lblRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblRemoveItem.setBounds(10, 11, 612, 65);
		panel.add(lblRemoveItem);
		
		JButton backButton = new JButton("Back\r\n");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Invoice.txt");
				file.delete();
				InvoiceWindow iw = new InvoiceWindow();
				iw.invoiceW();
				frame.dispose();
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton btnCheckStock = new JButton("Check Stock");
		btnCheckStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice invc = new Invoice(); 
				Inventory inv = new Inventory();
				File file = new File("Inventory.txt");
				File invoiceFile = new File("Invoice.txt");
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					invoiceFile.createNewFile();
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
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(invoiceFile));
					while(true) {
						try {
							invc.addProduct((Product)input.readObject());
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
				result.append("Available Stocks of Sold Products in Inventory:\n");
				
				for(Product product : invc) {
					for(StockableProduct Sproduct : inv) {
						if(product.getProductId()==Sproduct.getProductId()) {
							result.append("Name: " + Sproduct.getName() + ", Category: " + Sproduct.getClass().getSimpleName() + ", Items Available: " + Sproduct.getNumberOfItemStocked() + "\n");
						}
					}
				}
				
				textPane.setText(result.toString());
			}
		});
		btnCheckStock.setForeground(Color.BLACK);
		btnCheckStock.setBackground(Color.WHITE);
		btnCheckStock.setBounds(109, 418, 107, 23);
		frame.getContentPane().add(btnCheckStock);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice invc = new Invoice();
				File file = new File("Invoice.txt");
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
					while(true) {
						try {
							invc.addProduct((Product)input.readObject());
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
			    
			    result.append(invc.getInvoice());
			    
			    textPane.setText(result.toString());
			}
		});
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(553, 418, 89, 23);
		frame.getContentPane().add(btnPrint);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 109, 632, 298);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 632, 298);
		panel_1.add(scrollPane);
		
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		Invoice invc = new Invoice();
		File file = new File("Invoice.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				try {
					invc.addProduct((Product)input.readObject());
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
	    
	    result.append(invc.getInvoice());
	    
	    textPane.setText(result.toString());
	}
}
