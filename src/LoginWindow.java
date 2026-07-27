import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.*;

public class LoginWindow {

	private JFrame frame;
	private JTextField usernameText;
	private JPasswordField passwordText;
	JLabel checkLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
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
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T1 Trade");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 0, 612, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Log In");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 38, 622, 53);
		panel.add(lblNewLabel_1);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setVerticalAlignment(SwingConstants.TOP);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		usernameLabel.setBounds(231, 138, 170, 39);
		frame.getContentPane().add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameText.setBounds(231, 183, 170, 39);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setVerticalAlignment(SwingConstants.TOP);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordLabel.setBounds(231, 233, 170, 39);
		frame.getContentPane().add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordText.setBounds(231, 283, 170, 39);
		frame.getContentPane().add(passwordText);
		
		JButton loginButton = new JButton("Log In");
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				FileReader creds;
				boolean matched = false;
				try {
					creds = new FileReader("userCredentials.txt");
					BufferedReader reader = new BufferedReader(creds);
					String str;
					try {
						while((str=reader.readLine())!=null) {
							if(str.equals(usernameText.getText()+"\t"+passwordText.getText())) {
								matched = true;
								break;
							}
						}
						creds.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(matched) {
					WelcomeWindow ww = new WelcomeWindow();
					ww.welcome();
					frame.dispose();
				}
				else {
					checkLabel.setText("Wrong Username or Password");
				}
			}
		});
		loginButton.setBounds(271, 344, 89, 23);
		frame.getContentPane().add(loginButton);
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupWindow sw = new SignupWindow();
				sw.signUp();
				frame.dispose();
			}
		});
		signUpButton.setForeground(new Color(0, 0, 0));
		signUpButton.setBackground(new Color(255, 255, 255));
		signUpButton.setBounds(271, 418, 89, 23);
		frame.getContentPane().add(signUpButton);
		checkLabel.setForeground(new Color(255, 0, 0));
		checkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkLabel.setBackground(new Color(255, 255, 255));
		checkLabel.setBounds(205, 124, 221, 14);
		frame.getContentPane().add(checkLabel);
	}
}
