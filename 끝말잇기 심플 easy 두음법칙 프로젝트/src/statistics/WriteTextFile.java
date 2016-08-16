package statistics;

import java.io.*;

import data_base.Words;
import main.GamePlayingActivity;

public class WriteTextFile {
	private static String outputDirectory = "data_files/output/statistics.txt";
	
	public static void writeText() throws IOException { 			
		try {
			BufferedWriter out = new BufferedWriter
					(new FileWriter(outputDirectory));
			// 라벨 출력
			out.write("사용단어" + "\t" + "가중치" + "\t"+ "사용횟수" + "\t" + "단어승률"); 
			out.newLine();
			
			// 단어 통계량 출력
			for (int i=0; i<Words.NUM_OF_WORDS; i++) {
				// 승률 계산
				float winningRate = ((float) GamePlayingActivity.numOfGamesWon[i])/
						((float) GamePlayingActivity.numOfGamesToPlay);
				// 사용단어, 승리횟수, 사용횟수, 승률 차례로 출력
				out.write(Words.words[i] + "\t" 
                		+ GamePlayingActivity.numOfGamesWon[i] + "\t"
                		+ GamePlayingActivity.numOfGamesToPlay + "\t"
                		+ winningRate); 
				out.newLine();
				}
			out.close();
		} catch (IOException e) { }
		
		System.out.println("텍스트 파일이 무사히 출력되었습니다 \n\n\n");
	}
}
