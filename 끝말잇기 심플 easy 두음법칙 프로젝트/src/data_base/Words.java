package data_base;

public class Words {
	private static String wordFile = "c:/files/wordChain/easy_words_set/words.txt";
	public static final int NUM_OF_WORDS=FileReader.getNumOfWords(wordFile);
	public static final String[] words = new String[NUM_OF_WORDS];		
	
	public static void getWords() {
		FileReader.getWords(wordFile, words);
	}
}
