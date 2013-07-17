import java.lang.Character;
import java.util.ArrayList;
public class WordTries{
	private Node root;
	private static int numWords;
	public WordTries(){
		//Create a new Node - root node
		Node newNode = new Node();
		root = newNode;
	}
	private class Node{
		int value;
		Node[] nextLetter = new Node[26];
	}
	// Method to insert words into the trie
	public void insert(String word){
		word = word.toLowerCase();
		char[] wordToInsert = word.toCharArray();
		Node currentNode = root;
		for(int i=0; i<wordToInsert.length;i++){
			char  letterToInsert = Character.toLowerCase(wordToInsert[i]);
			int asciiValue = (int) letterToInsert;
			if (currentNode.nextLetter[asciiValue-97] == null){
				Node createNode = new Node();
				currentNode.nextLetter[asciiValue-97] = createNode;
			}

			currentNode = currentNode.nextLetter[asciiValue-97];

		}
		numWords++;
		currentNode.value = numWords;	//End of word
	}
	public void numberOfWords(){
		System.out.println(numWords);
	}
	// Method that takes in a word prefix and lists words from trie with prefix   
	public ArrayList<String> listMatches(String prefix){
		ArrayList<String> matches = new ArrayList<String>();
		Node current = root;
		for (int i =0;i<prefix.length();i++){
			int asciiValue = (int)prefix.charAt(i);
			asciiValue -=97;
			if (current.nextLetter[asciiValue] != null){
				current = current.nextLetter[asciiValue];
			}
			else return null;
		}
		Queue<Character> wordQ = new Queue<Character>();
		matches = suggestions(current,wordQ,prefix,matches);
		return matches;
	}
	private ArrayList<String> suggestions(Node current,Queue wordQ, String prefix,ArrayList<String> listMatches){
		for (int i =0;i<26;i++){
			if (current.nextLetter[i]!=null){
				wordQ.enqueue((char)(i+97));
				suggestions(current.nextLetter[i], wordQ,prefix,listMatches);
			}
			
		}
		if (current.value > 0){
			String path = makeWord(prefix, wordQ);
			listMatches.add(path);
			}	
		return listMatches;	
	}
	private String makeWord(String prefix, Queue wordQ){
		StringBuffer newWord = new StringBuffer();
		newWord.append(prefix);
		while(!wordQ.isEmpty()){
			newWord.append(wordQ.dequeue());
		}
		return newWord.toString();
	
	}

	public boolean prefixExists(String prefix){
		Node current = root;
		for (int i =0;i<prefix.length();i++){
			int asciiValue = (int)prefix.charAt(i);
			asciiValue -=97;
			if (current.nextLetter[asciiValue] != null){
				current = current.nextLetter[asciiValue];
			}
			else return false;
		}
		return true;
	}
}
