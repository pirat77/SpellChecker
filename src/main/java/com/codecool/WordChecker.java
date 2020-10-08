import java.util.ArrayList;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called WordList that I haven't provided the source
 * code for.  WordList has only one method that you'll ever need to call:
 *
 *     public boolean lookup(String word)
 *
 * which returns true if the given word is in the WordList and false if not.
 */

public class WordChecker
{
	WordList wordList;

	/**
	 * Constructor that initializes a new WordChecker with a given WordList.
	 *
	 * @param wordList Initial word list to check against.
	 * @see WordList
	 */
	public WordChecker(WordList wordList)
	{
		this.wordList = wordList;
	}


	/**
	 * Returns true if the given word is in the WordList passed to the
	 * constructor, false otherwise.
	 *
	 * @param word Word to chack against the internal word list
	 * @return bollean indicating if the word was found or not.
	 */
	public boolean wordExists(String word)
	{
		return wordList.lookup(word);
	}


	/**
	 * Returns an ArrayList of Strings containing the suggestions for the
	 * given word.  If there are no suggestions for the given word, an empty
	 * ArrayList of Strings (not null!) should be returned.
	 *
	 * @param word String to check against
	 * @return A list of plausible matches
	 */
	public ArrayList getSuggestions(String word) {
		ArrayList<String> outputList = new ArrayList<>();
		outputList.addAll(checkSwaps(word));
		outputList.addAll(checkForMisspell(word));
		outputList.addAll(checkMissingLetters(word));
		outputList.addAll(checkingForMissingSpace(word));
		outputList.addAll(checkingForBonusLetters(word));
		return outputList;
	}

	private ArrayList checkSwaps(String word){
		ArrayList<String> outputList = new ArrayList<>();
		for (int i =1; i<word.length(); i++){
			char[] chars = word.toCharArray();
			char buffer = chars[i-1];
			chars[i-1] = chars[i];
			chars[i] = buffer;
			String sideWord = String.valueOf(chars);
			if (wordList.lookup(sideWord)){
				outputList.add(sideWord);
			};
		}
		return outputList;
	}

	private ArrayList checkMissingLetters(String word){
		ArrayList<String> outputList = new ArrayList<>();
		for (int i = 0; i<=word.length(); i++){
			for (char c = 'A'; c <= 'Z'; c+=2){
				String sideWord = word.substring(0, i) + c + word.substring(i);
				if (wordList.lookup(sideWord)){
					outputList.add(sideWord);
				};
			}
		}
		return outputList;
	}

	private ArrayList checkingForBonusLetters(String word){
		ArrayList<String> outputList = new ArrayList<>();
		for (int i = 1; i<word.length(); i++){
			String sideWord = word.substring(0, i) + word.substring(i+1);
			if (wordList.lookup(sideWord)){
				outputList.add(sideWord);
			};
		}
		return outputList;
	}

	private ArrayList checkForMisspell(String word){
		ArrayList<String> outputList = new ArrayList<>();
		for (int i = 0; i<word.length(); i++){
			for (char c = 'A'; c <= 'Z'; c+=2){
				String sideWord = word.substring(0, i) + c + word.substring(i+1);
				if (wordList.lookup(sideWord)){
					outputList.add(sideWord);
				};
			}
		}
		return outputList;
	}

	private ArrayList checkingForMissingSpace(String word){
		ArrayList<String> outputList = new ArrayList<>();
		for (int i = 0; i<=word.length(); i++){
			String sideWord = word.substring(0, i);
			String sideWord2 = word.substring(i);
			if (wordList.lookup(sideWord) && wordList.lookup(sideWord2)){
				outputList.add(sideWord);
				outputList.add(sideWord2);
			};
		}
		return outputList;
	}
}
