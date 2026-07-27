import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class InvoiceWindow {

	private JFrame frame;
	private JTextField idText;
	JLabel successText = new JLabel("");

	/**
	 * Launch the application.
	 */
	public void invoiceW() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceWindow window = new InvoiceWindow();
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
	public InvoiceWindow() {
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
				WelcomeWindow ww = new WelcomeWindow();
				ww.welcome();
				frame.dispose();
			}
		});
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton btnRemove = new JButton("Get invoice");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetInvoiceWindow giw = new GetInvoiceWindow();
				giw.getInvoiceW();
				frame.dispose();
			}
		});
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(543, 418, 99, 23);
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
		
		successText.setForeground(new Color(0, 255, 64));
		successText.setHorizontalAlignment(SwingConstants.CENTER);
		successText.setBounds(10, 111, 297, 41);
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
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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
				
				int id =Integer.parseInt(idText.getText());
				
				for(Product product : inv) {
					if(product.getProductId()==id) {
						invc.addProduct(product);
						inv.getItem(id);
					}
				}
				try {
					ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
						for(StockableProduct product : inv) {
							objOut.writeObject(product);
						}
					objOut.close();
				} catch (IOException e1) {
				}
				
				try {
					ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(invoiceFile));
						for(Product product : invc) {
							objOut.writeObject(product);
						}
					objOut.close();
				} catch (IOException e1) {
				}
				
				successText.setText("Product added successfully");
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(109, 418, 89, 23);
		frame.getContentPane().add(btnAdd);
		
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
	}

}
