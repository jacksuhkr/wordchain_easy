package data_base;

import java.util.HashMap;
import java.util.Map;

public class Maps {
	// 단어 -> 단어번호
	
	public static final Map<String, Float> weightMap1 = new HashMap<String, Float>();
	public static final Map<String, Float> weightMap2 = new HashMap<String, Float>();
	public static final Map<String, Float> weightMap3 = new HashMap<String, Float>();
	
	public static void getWeightMap1() {
		for(int i=0; i<Words.NUM_OF_WORDS; i++) {
			weightMap1.put(Words.words[i], Weight.weights1[i]);
		}
	}
	
	public static void getWeightMap2() {
		for(int i=0; i<Words.NUM_OF_WORDS; i++) {
			weightMap2.put(Words.words[i], Weight.weights2[i]);
		}
	}
	
	public static void getWeightMap3() {
		for(int i=0; i<Words.NUM_OF_WORDS; i++) {
			weightMap3.put(Words.words[i], Weight.weights3[i]);
		}
	}
}
