import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class DictionaryMain {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		//READ FILE AND THROW EXCEPTIONS IF INVALID FILE
		try {
			File readObj = new File("C:\\Users\\wilds\\Desktop\\School\\4. Fourth year\\Software Engineering\\HW4_words.txt");

			Scanner input = new Scanner(readObj); // reads the file
			String str = "";

			while (input.hasNext()) { // while loop to go through the whole file
				str += input.next() + " "; // stores all words into a string
			}
			input.close();

			//put the string of words into an array
			String[] words = str.split(" ");
			System.out.println(Arrays.toString(words));
			
			for(int i = 0; i < words.length; i++) {
				dictionary.insertWordNode(words[i]);
			}
			
			System.out.println("Spell check: " + dictionary.checkWord("Here"));
			
			/*
			dictionary.insertWordNode("light");
			dictionary.insertWordNode("window");
			dictionary.insertWordNode("water bottle");
			dictionary.insertWordNode("shoes");
			dictionary.insertWordNode("chair");
			dictionary.insertWordNode("desk");
			
			dictionary.deleteWordNode("chair");

			
			System.out.println("Spell Check: " + dictionary.checkWord("light"));*/
			
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
	}
	
}