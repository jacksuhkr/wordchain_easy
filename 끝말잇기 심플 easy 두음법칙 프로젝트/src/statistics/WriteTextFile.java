package statistics;

import java.io.*;

import data_base.Words;
import main.GamePlayingActivity;

public class WriteTextFile {
	public static void writeText() throws IOException { 			
		try {
			BufferedWriter out = new BufferedWriter
					(new FileWriter("C:/files/wordChain/easy_words_set/output/statistics.txt"));
			// �� ���
			out.write("���ܾ�" + "\t" + "����ġ" + "\t"+ "���Ƚ��" + "\t" + "�ܾ�·�"); 
			out.newLine();
			
			// �ܾ� ��跮 ���
			for (int i=0; i<Words.NUM_OF_WORDS; i++) {
				// �·� ���
				float winningRate = ((float) GamePlayingActivity.numOfGamesWon[i])/
						((float) GamePlayingActivity.numOfGamesToPlay);
				// ���ܾ�, �¸�Ƚ��, ���Ƚ��, �·� ���ʷ� ���
				out.write(Words.words[i] + "\t" 
                		+ GamePlayingActivity.numOfGamesWon[i] + "\t"
                		+ GamePlayingActivity.numOfGamesToPlay + "\t"
                		+ winningRate); 
				out.newLine();
				}
			out.close();
		} catch (IOException e) { }
		
		System.out.println("�ؽ�Ʈ ������ ������ ��µǾ����ϴ� \n\n\n");
	}
}
