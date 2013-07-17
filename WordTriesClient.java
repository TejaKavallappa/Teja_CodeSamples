import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
public class WordTriesClient{
	public static void main(String[] args) throws IOException{
		//Read in file
		try{	
			File textFile = new File("words.txt");	
			Scanner readFile = new Scanner(textFile);
			WordTries wordTree = new WordTries();
			//Call WordTries to build a trie with words in the file
			while(readFile.hasNext()){
				String newWord = readFile.nextLine();
				wordTree.insert(newWord);
			}
			ArrayList<String> completions = new ArrayList<String>();
			completions = wordTree.listMatches("ab");
		       	int i = completions.size();
			System.out.println(i + " suggestions");
			for (String s: completions){
				System.out.println(s);
				i++;
			}	
		}
		catch (FileNotFoundException e)
			{System.out.println("File not found.");}
	}
}
