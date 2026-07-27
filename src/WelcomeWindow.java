import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void welcome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWindow window = new WelcomeWindow();
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
	public WelcomeWindow() {
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
		panel.setBackground(new Color(11, 11, 11));
		panel.setBounds(10, 11, 632, 102);
		frame.getContentPane().add(panel);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setVerticalAlignment(SwingConstants.TOP);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 80));
		panel.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Inventory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryWindow iw = new InventoryWindow();
				iw.inventoryW();
				frame.dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 152, 234, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceWindow iw = new InvoiceWindow();
				iw.invoiceW();
				frame.dispose();
			}
		});
		btnInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnInvoice.setForeground(Color.BLACK);
		btnInvoice.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnInvoice.setBackground(Color.WHITE);
		btnInvoice.setBounds(10, 217, 234, 54);
		frame.getContentPane().add(btnInvoice);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame LGframe = new JFrame("Log out");
				if(JOptionPane.showConfirmDialog(LGframe, "Do you want to Log Out?", "Log out", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					LoginWindow.main(null);
					frame.dispose();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 418, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
