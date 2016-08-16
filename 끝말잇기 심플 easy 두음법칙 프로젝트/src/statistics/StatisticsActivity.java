package statistics;

import data_base.Words;

/**
 * Created by user on 2016-08-02.
 */
public class StatisticsActivity {

    public static void showStatistics() {
    	System.out.println("사용된 단어" + "\t\t" + "가중치" + "\t\t" + "사용된 횟수");

        // 사용된 단어 사이즈만큼으로
        // 일단은 급한대로 단어장 전체로 해보자
        try {
            for (int i = 0; i < Words.NUM_OF_WORDS; i++) {
                if (NumbersForWordList.numbersOfUsed.get(i) != 0) {
                    System.out.println(Words.words[i] + "\t\t" 
                    		+ NumbersForWordList.numbersOfWeight.get(i) + "\t\t"
                    		+ NumbersForWordList.numbersOfUsed.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("\n" + "뭔가 심상치 않아 일이생긴거야");
        }
        System.out.println(); System.out.println(); System.out.println();
    }
}
