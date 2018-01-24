import java.io.File;
import java.util.Random;
import java.util.Scanner;


public class gameRules {

	private int tries = 10; //how many wrong guesses you have left
	private String word = null; //the word you are trying to guess
	private char[] wordArray; // an array to help check guesses
	private char[] theWord;
	private boolean win = false;

	
	public gameRules() {
		super();
		Random rand = new Random();
		Scanner wordFile = null;
		//checks for the file
		try {
			wordFile = new Scanner(new File("C:\\Users\\Jon\\eclipse-workspace\\Hanman\\src\\Words"));
		}
		catch(Exception e) {
			e.getCause();
		}
		
		//get random word
		int n = 0;
		String b = null;
		while(wordFile.hasNext()) {
			++n;
	        String line = wordFile.nextLine();
	        if(rand.nextInt(n) == 0)
	           b = line;
		}
		this.setWord(b);
		wordFile.close();
		
		//set up everything
		this.setWordArray(this.getWord().toCharArray()); // an array to help check guesses
		this.setTheWord(new char[this.getWordArray().length]);
		char [] de = new char [this.getWord().length()];
		for(int i = 0; i < this.getTheWord().length; i++) {
			de[i] = '_';
		}
		this.setTheWord(de);
	}
	
	
	
	public void entered(String c) {
	
		boolean exists = false;
		char [] copy = this.getWordArray();
		for(int i = 0; i < this.getWordArray().length && c.length() == 1; i++) {
			Character b = copy[i];
			
			if( b.equals(c.charAt(0))) {
				theWord[i] = c.charAt(0);
				exists = true;
			}
		
			}
		if(c.length() > 1) {
			for(int i = 0; i < c.length(); i++) {
				Character b = copy[i];
				
				if( b.equals(c.charAt(i))) {
					theWord[i] = c.charAt(i);
					exists = true;
				}
		}
		}
			if(exists == true) {
				exists = false;
			
			}else{
		
			this.setTries(this.getTries()-1);
			
		}
		if(this.getString(this.getTheWord()).equals(this.getWord())) {
			this.setWin(true);
		}
		
	}
	
	public void restart() {
		
		Random rand = new Random();
		Scanner wordFile = null;
		//checks for the file
		try {
			wordFile = new Scanner(new File("C:\\Users\\Jon\\eclipse-workspace\\Hanman\\src\\Words"));
		}
		catch(Exception e) {
			e.getCause();
		}
		
		//get random word
		int n = 0;
		String b = null;
		while(wordFile.hasNext()) {
			++n;
	        String line = wordFile.nextLine();
	        if(rand.nextInt(n) == 0)
	           b = line;
		}
		this.setWord(b);
		wordFile.close();
		
		//set up everything
		this.setWordArray(this.getWord().toCharArray()); // an array to help check guesses
		this.setTheWord(new char[this.getWordArray().length]);
		char [] de = new char [this.getWord().length()];
		for(int i = 0; i < this.getTheWord().length; i++) {
			de[i] = '_';
		}
		this.setTheWord(de);
		this.setTries(10);
	}
	
	public int getTries() {
		return tries;
	}

	public String getWord() {
		return word;
	}

	public char[] getWordArray() {
		return wordArray;
	}
	
	public String getToString(char [] c) {
		String sb = "";
		char [] clone = c;
		for(int i = 0; i < clone.length; i++) {
			Character b = clone[i];
			sb = sb + " " +b.toString();
		}
		return sb;
	}
	
	public String getString(char [] c) {
		String sb = "";
		char [] clone = c;
		for(int i = 0; i < clone.length; i++) {
			Character b = clone[i];
			sb = sb +b.toString();
		}
		return sb;
	}

	public void setWordArray(char[] wordArray) {
		this.wordArray = wordArray;
	}

	public char [] getTheWord() {
		return theWord;
	}

	public void setTheWord(char[] theWord) {
		this.theWord = theWord;
	}

	

	public void setTries(int tries) {
		this.tries = tries;
	}

	public void setWord(String word) {
		this.word = word;
	}

	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
}
