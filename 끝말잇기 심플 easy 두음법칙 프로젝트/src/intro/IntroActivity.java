package intro;


import java.util.Scanner;

import data_base.*;
import main.GamePlayingActivity;
import static_variables.GameSetting;
import statistics.StatisticsActivity;
import statistics.WriteTextFile;

/**
 * Created by user on 2016-07-31.
 */
public class IntroActivity {
    private static Scanner scanner = new Scanner(System.in);
    public static int whatToDo;
    private static boolean gameDone;
    private static long startTime, endTime;
    private static float timeSpent;
    
    // 차례로 - AI, 쉬운 단어장, 킬러, 안전, 노말, 없는 단어 뺌, 마지막단어로 시작
    public static boolean easyAuto[] = { true, true, false, false, false, false, true };		// easyWord Activate
    
    public static void main(String args[]) {
    	// 건드리지 않을 단어장 생성
        Words.getWords();
        Weight.getWeights1();
        Weight.getWeights2();
        Weight.getWeights3();
        WordVectors.getWordVecteors1();
        WordVectors.getWordVecteors2();
        WordVectors.getWordVecteors3();
        Maps.getWeightMap1();
        Maps.getWeightMap2();
        Maps.getWeightMap3();
        Classified.classifyWords();
        Classified.classifyWeights(WordVectors.wordVectors1, Classified.trainedWords1);
        Classified.classifyWeights(WordVectors.wordVectors2, Classified.trainedWords2);
        Classified.classifyWeights(WordVectors.wordVectors3, Classified.trainedWords3);
        

        // 통계량을 보기위한 세팅들
        GameSetting.killerWordsPeriod = 5;          // 킬러단어 주기
        GameSetting.resignLimitNumber = 0;          // 항복 선언하는 단어 한계

        // autoPlay만 남김   
        while (!gameDone) {
        	System.out.println("무엇을 하시겠습니까?");
            System.out.println("---------------------------------------------------");
            System.out.println("1. 기존vs기존	2. 학습vs기존	3. 학습vs학습	");
            System.out.println("4. 트리탐색vs기존	5. 통계 보기	6. 파일 출력	");
            System.out.println("7. 세팅 바꾸기	8. 끝내기		");
            System.out.println("---------------------------------------------------");
            whatToDo = scanner.nextInt();
            startTime = System.nanoTime();
            
            if(whatToDo==1) {
            	printTitle("기존 vs 기존");
 
            	selectNumOfGames();
            	startGame();
            }
            if(whatToDo==2) {
            	printTitle("학습 vs 기존");

	       	   	System.out.println("사용할 데이터 번호를 입력해주세요.");
	       	   	GameSetting.leftDataNum = scanner.nextInt();			    	    
	       	   	scanner.nextLine();
                
            	selectNumOfGames();
            	startGame();
            }
            if(whatToDo==3) {
            	printTitle("학습 vs 학습");
            	
	       	   	System.out.println("왼쪽에서 쓸 데이터 번호를 입력해주세요.");
	       	   	GameSetting.leftDataNum = scanner.nextInt();	scanner.nextLine();
	       	   	System.out.println("오른쪽에서 쓸 데이터 번호를 입력해주세요.");
	       	   	GameSetting.rightDataNum = scanner.nextInt();	scanner.nextLine();		
	       	   	
            	selectNumOfGames();
            	startGame();
            }
            if(whatToDo==4) {
            	printTitle("트리탐색vs기존");
                
            	selectNumOfGames();
            	startGame();
            }
            
            if(whatToDo==5) {
            	printTitle("통계량");
            	
            	StatisticsActivity.showStatistics();
            }
            if(whatToDo==6) {
            	printTitle("파일출력");
            	
            	try { WriteTextFile.writeText(); } 
            	catch (Exception e) { System.out.println("파일쓰기 실패 ㅜㅜ"); }
            }
            if(whatToDo==7) {
            	printTitle("세팅 바꾸기");
                
                System.out.println("어떤 것의 세팅을 바꾸실 건가요?");
	            System.out.println("1. 승패방향  	2.시작단어");
                int selectSetting = scanner.nextInt();	scanner.nextLine();	System.out.println();
                
            switch(selectSetting) {
	            case 1:
	              	System.out.println("어느쪽의 입장으로 바꾸실 건가요?");
	                System.out.println("1. 왼쪽	2. 오른쪽	");
	    	        int whichSide = scanner.nextInt();	scanner.nextLine();	System.out.println();
	    	   	    
	    	   	    if(whichSide==1) { 
	    	   	    	GameSetting.sideExchangerOn = false;
	    	    	    System.out.println("승패방향을 왼쪽을 선택하셨습니다. \n");
	   	    	    }
	   	    	    if(whichSide==2) { 
	   	    	    	GameSetting.sideExchangerOn = true; 
	   	    	    	System.out.println("승패방향을 오른쪽을 선택하셨습니다. \n");
	   	    	    }	
	   	    	    break;
               case 2: 
	                System.out.println("시작단어를 어떻게 바꾸실 건가요?");
	    	        System.out.println("1. 가나다순	2. 랜덤	");
	    	   	    int startingWord = scanner.nextInt();	scanner.nextLine();	System.out.println();

	    	   	    if(startingWord==1) { 
	   	    	    	GameSetting.startWithRandomWords = false;
	    	    	    System.out.println("가나다순을 선택하셨습니다. \n");
	   	    	    }
	   	    	    if(startingWord==2) { 
	   	    	    	GameSetting.startWithRandomWords = true; 
    	    	    	System.out.println("랜덤을 선택하셨습니다. \n");	    	    	    }
                	}
            }
            if(whatToDo==8) {
            	gameDone=true;
            }
        	System.out.println("\n");
        	
        	endTime = System.nanoTime();
        	timeSpent = (float) (endTime - startTime) / (float) 1000000000;
        	System.out.println("걸린시간 : " + timeSpent + "초");
        }
    }

    // 각 메뉴 타이틀을 프린트
    private static void printTitle(String title) {
        System.out.println("-----------------------------------------");
        System.out.println("                    " + title);
        System.out.println("-----------------------------------------"); 
    }
    
    // 지우고 더하지 않아 단어번호가 일정한, 검색용 단어장 형성

    // 게임 판수를 선택
    private static void selectNumOfGames() {
    	if (!GameSetting.startWithRandomWords)
    		{ System.out.println("단어 하나당 게임을 몇판 돌리실 생각이신가요?"); }
    	else if (GameSetting.startWithRandomWords)
    		{ System.out.println("게임을 몇판 돌리실 생각이신가요?"); }
    	
	     GamePlayingActivity.numOfGamesToPlay = scanner.nextInt();
	     System.out.println(GamePlayingActivity.numOfGamesToPlay + "판을 선택하셨습니다.");
	     scanner.nextLine();
    }
    
    // 게임세팅값을 넣어서 GamePlayingActivity의 startGame메소드를 실행
    private static void startGame() {
        GamePlayingActivity autoPlay = new GamePlayingActivity();
        autoPlay.startGame(easyAuto);
    }
}
