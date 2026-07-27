import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addItemWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void addItemW() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addItemWindow window = new addItemWindow();
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
	public addItemWindow() {
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
		
		JLabel lblAddItem = new JLabel("Add Item");
		lblAddItem.setForeground(Color.WHITE);
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblAddItem.setBounds(173, 11, 308, 65);
		panel.add(lblAddItem);
		
		JButton btnGame = new JButton("Game");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGameWindow agw = new AddGameWindow();
				agw.addGameW();
				frame.dispose();
			}
		});
		btnGame.setHorizontalAlignment(SwingConstants.LEFT);
		btnGame.setForeground(Color.BLACK);
		btnGame.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnGame.setBackground(Color.WHITE);
		btnGame.setBounds(10, 141, 233, 43);
		frame.getContentPane().add(btnGame);
		
		JButton btnMusic = new JButton("Music");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMusicWindow amw = new AddMusicWindow();
				amw.addMusicW();
				frame.dispose();
			}
		});
		btnMusic.setHorizontalAlignment(SwingConstants.LEFT);
		btnMusic.setForeground(Color.BLACK);
		btnMusic.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnMusic.setBackground(Color.WHITE);
		btnMusic.setBounds(10, 195, 233, 43);
		frame.getContentPane().add(btnMusic);
		
		JButton btnMovie = new JButton("Movie");
		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMovieWindow amw = new AddMovieWindow();
				amw.addMovieW();
				frame.dispose();
			}
		});
		btnMovie.setHorizontalAlignment(SwingConstants.LEFT);
		btnMovie.setForeground(Color.BLACK);
		btnMovie.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnMovie.setBackground(Color.WHITE);
		btnMovie.setBounds(10, 249, 233, 43);
		frame.getContentPane().add(btnMovie);
		
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
	}

}
