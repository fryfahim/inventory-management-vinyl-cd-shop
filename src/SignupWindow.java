import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;

public class SignupWindow {

	private JFrame frame;
	private JTextField UsernameText;
	private JTextField emailText;
	private JPasswordField passwordText;

	/**
	 * Launch the application.
	 */
	public void signUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupWindow window = new SignupWindow();
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
	public SignupWindow() {
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
		
		JLabel SignupLabel = new JLabel("SIGN UP");
		SignupLabel.setVerticalAlignment(SwingConstants.TOP);
		SignupLabel.setForeground(Color.WHITE);
		SignupLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		panel.add(SignupLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		usernameLabel.setBounds(81, 176, 161, 43);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordLabel.setBounds(81, 230, 161, 43);
		frame.getContentPane().add(passwordLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		emailLabel.setBounds(81, 284, 161, 43);
		frame.getContentPane().add(emailLabel);
		
		UsernameText = new JTextField();
		UsernameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernameText.setBounds(252, 176, 274, 43);
		frame.getContentPane().add(UsernameText);
		UsernameText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailText.setColumns(10);
		emailText.setBounds(252, 284, 274, 43);
		frame.getContentPane().add(emailText);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordText.setBounds(252, 230, 274, 43);
		frame.getContentPane().add(passwordText);
		
		JButton signupButton = new JButton("Sign Up");
		signupButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter emails = new FileWriter("userEmails.txt", true);
					FileWriter creds = new FileWriter("userCredentials.txt", true);
					creds.write(UsernameText.getText()+"\t"+passwordText.getText());
					creds.write("\n");
					emails.write(UsernameText.getText()+"\t"+emailText.getText());
					emails.write("\n");
					creds.close(); 
					emails.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				LoginWindow.main(null);
				frame.dispose();
			}
		});
		signupButton.setForeground(new Color(0, 0, 0));
		signupButton.setBackground(new Color(255, 255, 255));
		signupButton.setBounds(272, 352, 89, 23);
		frame.getContentPane().add(signupButton);
	}

}
