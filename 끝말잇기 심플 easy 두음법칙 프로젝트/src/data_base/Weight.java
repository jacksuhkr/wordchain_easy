package data_base;

public class Weight {
	private static String weightFile1 = "c:/files/wordChain/easy_words_set/weight1.txt";
	private static String weightFile2 = "c:/files/wordChain/easy_words_set/weight2.txt";
	private static String weightFile3 = "c:/files/wordChain/easy_words_set/weight3.txt";
	
	public static final float[] weights1 = new float[Words.NUM_OF_WORDS]; 
	public static final float[] weights2 = new float[Words.NUM_OF_WORDS]; 
	public static final float[] weights3 = new float[Words.NUM_OF_WORDS]; 
	
	public static void getWeights1() {
		FileReader.getWeights(weightFile1, weights1);
	}
	
	public static void getWeights2() {
		FileReader.getWeights(weightFile2, weights2);
	}

	public static void getWeights3() {
		FileReader.getWeights(weightFile3, weights3);
	}
}
