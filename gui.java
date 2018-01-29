import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092302837728504184L;
	private JPanel contentPane;
	private JTextField anserField;
	private JTextField tryField;

	/**
	 * Create the frame.
	 */
	public gui() {
		
	
		gameRules game = new gameRules();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLayeredPane hiddenWord = new JLayeredPane();
		getContentPane().add(hiddenWord);
		
		JLabel lblHangman = new JLabel("Hangman");
		lblHangman.setBounds(169, 11, 131, 14);
		hiddenWord.add(lblHangman);
		
		
		
		JLabel lblGuessHere = new JLabel("Guess here");
		lblGuessHere.setBounds(310, 50, 86, 14);
		hiddenWord.add(lblGuessHere);
		
		JButton Image = new JButton("");
		Image.setBackground(new Color(0, 0, 128));
		Image.setForeground(Color.WHITE);
		Image.setIcon(new ImageIcon(gui.class.getResource("/images/0.jpg")));
		Image.setBounds(10, 36, 290, 339);
		hiddenWord.add(Image);
		
		JTextField deWord = new JTextField(game.getToString(game.getTheWord()));
		deWord.setEditable(false);
		deWord.setEnabled(false);
		deWord.setBounds(310, 129, 180, 50);
		hiddenWord.add(deWord);
		
		
		JTextField alphabet = new JTextField();
		alphabet.setEditable(false);
		alphabet.setEnabled(true);
		alphabet.setBounds(310, 234, 180, 50);
		hiddenWord.add(alphabet);
		
		Integer i = game.getTries();
		tryField = new JTextField(i.toString());
		tryField.setEditable(false);
		tryField.setBounds(310, 325, 86, 27);
		hiddenWord.add(tryField);
		tryField.setColumns(10);
		
		JButton btnTryAgain = new JButton("Try again");
		btnTryAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				game.restart();
				deWord.setText(game.getToString(game.getTheWord()));
				alphabet.setText(null);
				anserField.setEditable(true);
				Image.setIcon(new ImageIcon(gui.class.getResource("/images/0.jpg")));
				tryField.setText(i.toString());
				btnTryAgain.setEnabled(false);
				game.setWin(false);
			}
		});
		btnTryAgain.setEnabled(false);
		btnTryAgain.setBounds(307, 390, 89, 23);
		hiddenWord.add(btnTryAgain);

		anserField = new JTextField();
		anserField.addActionListener(new ActionListener() {
			
				    public void actionPerformed(ActionEvent e) {
				//sends guess to game
				game.entered(anserField.getText());
				
				//keeps track of guesses
				String sb = alphabet.getText();
				String guess = anserField.getText();
				sb = sb + " " + guess;
				alphabet.setText(sb);
				
				
				deWord.setText(game.getToString(game.getTheWord()));
				Integer d = game.getTries();
				tryField.setText(d.toString());
				anserField.setText(null);
				
				
				//change image as needed
				switch(d) {
				case 10: Image.setIcon(new ImageIcon(gui.class.getResource("/images/0.jpg")));
					break;
				case 9: Image.setIcon(new ImageIcon(gui.class.getResource("/images/1.jpg")));
					break;
				case 8: Image.setIcon(new ImageIcon(gui.class.getResource("/images/2.jpg")));
					break;
				case 7: Image.setIcon(new ImageIcon(gui.class.getResource("/images/3.jpg")));
					break;
				case 6: Image.setIcon(new ImageIcon(gui.class.getResource("/images/4.jpg")));
					break;
				case 5: Image.setIcon(new ImageIcon(gui.class.getResource("/images/5.jpg")));
					break;
				case 4: Image.setIcon(new ImageIcon(gui.class.getResource("/images/6.jpg")));
					break;
				case 3: Image.setIcon(new ImageIcon(gui.class.getResource("/images/7.jpg")));
					break;
				case 2: Image.setIcon(new ImageIcon(gui.class.getResource("/images/8.jpg")));
					break;
				case 1: Image.setIcon(new ImageIcon(gui.class.getResource("/images/9.jpg")));
					break;
				case 0: Image.setIcon(new ImageIcon(gui.class.getResource("/images/e38b2cee0dce880cd0f5bedb1a188df6451be3a8cc97cf6c646fe47d319a89b3.jpg")));
					break;
			}
				//takes care of win or lose situation
				if(game.isWin() == true) {
					 Image.setIcon(new ImageIcon(gui.class.getResource("/images/angry-you-win-this-time!.jpg")));
					 anserField.setEditable(false);
					 btnTryAgain.setEnabled(true);
				}
				if(game.getTries() == 0) {
					
					anserField.setEditable(false);
					deWord.setText(game.getWord());
					btnTryAgain.setEnabled(true);
				}
			}});
		
		
		
		anserField.setBounds(310, 75, 86, 20);
		hiddenWord.add(anserField);
		anserField.setColumns(10);
		
		JLabel lblGuesses = new JLabel("Guesses");
		lblGuesses.setBounds(310, 209, 118, 14);
		hiddenWord.add(lblGuesses);
		
		JLabel lblTheWord = new JLabel("The Word");
		lblTheWord.setBounds(310, 104, 180, 14);
		hiddenWord.add(lblTheWord);
		
		
		
		JLabel lblRemainingTries = new JLabel("Remaining Tries");
		lblRemainingTries.setBounds(310, 300, 86, 14);
		hiddenWord.add(lblRemainingTries);
		
		
		
		
		}
}
