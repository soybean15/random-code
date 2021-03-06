import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Board{

    public void printBoard(char[][] board) {

        for(int i=0; i<15; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public void updateBoard(char[][] board, String word, int score){
        reset(board);
        printRandomWord(board, word);
        printScore(board, score);
        printBoard(board);
    }


    char[][] frame1(){
        char[][] board = new char[15][40];

        for(int i=0; i<15; i++){
            for(int j=0; j<40; j++){
                board[i][j] =' ';
                generateFrame1(board);

                if(j==0 || j ==39){
                    board[i][j]='|';
                }
                if(i ==0 || i==14){
                    board[i][j]='-';

                }
            }

        }
        return board;
    }

    void generateFrame1(char[][] board){

        //H
        board[2][2]='o';
        board[2][5]='o';
        board[4][3]='o';
        board[4][4]='o';
        board[3][2]='o';
        board[4][2]='o';
        board[5][2]='o';
        board[3][5]='o';
        board[4][5]='o';
        board[5][5]='o';


        //A
        board[2][8]='o';
        board[3][7]='o';
        board[4][7]='o';
        board[5][7]='o';
        board[4][8]='o';
        board[4][9]='o';
        board[3][9]='o';
        board[5][9]='o';
        //N
        board[5][11]='o';
        board[4][11]='o';
        board[3][11]='o';
        board[2][11]='o';
        board[3][12]='o';
        board[4][13]='o';
        board[5][14]='o';
        board[4][14]='o';
        board[3][14]='o';
        board[2][14]='o';
        //G
        board[5][17]='o';
        board[5][18]='o';
        board[4][16]='o';
        board[3][16]='o';
        board[2][17]='o';
        board[2][18]='o';
        board[4][19]='o';
        board[4][18]='o';
        //M
        board[5][21]='o';
        board[4][21]='o';
        board[3][21]='o';
        board[2][21]='o';
        board[5][23]='o';
        board[4][22]='o';
        board[4][24]='o';
        board[5][25]='o';
        board[4][25]='o';
        board[3][25]='o';
        board[2][25]='o';

        //A
        board[2][28]='o';
        board[3][27]='o';
        board[4][27]='o';
        board[5][27]='o';
        board[4][28]='o';
        board[4][29]='o';
        board[3][29]='o';
        board[5][29]='o';
        //N
        board[5][31]='o';
        board[4][31]='o';
        board[3][31]='o';
        board[2][31]='o';
        board[3][32]='o';
        board[4][33]='o';
        board[5][34]='o';
        board[4][34]='o';
        board[3][34]='o';
        board[2][34]='o';

        printStartExitMEnu(board);


    }

    void printStartExitMEnu(char[][] board){
        String frame1_start = "[1]Start Game";
        String frame1_Exit = "[2]Exit Game";

        for(int i=10, j=0; i<23;i++){
            board[10][i]=frame1_start.charAt(j++);

        }
        for(int i=10, j=0; i<22;i++){
            board[11][i]=frame1_Exit.charAt(j++);

        }
    }


    char[][] frame2(){
        char[][] board = new char[15][40];

        for(int i=0; i<15; i++){
            for(int j=0; j<40; j++){
                board[i][j] = ' ';



                if(j==0 || j ==39 || j==13){
                    board[i][j]='|';
                }
                if(i ==0 || i==14 || i==9){
                    board[i][j]='-';

                }
                if(i>9 && i<14 && j== 13){
                    board[i][j] = ' ';
                }

                generateFrame2(board);

            }

        }

        return board;
    }



    void generateFrame2(char[][] board){

        String scoreStr = "Score";
        String levelStr = "Level";
        String lvl = "001";

        String lowerPanelText = "Guess the word or die!";

        for(int i=4, j=0; j<scoreStr.length();i++){
            board[2][i]=scoreStr.charAt(j++);
        }

        for(int i=4, j=0; j<levelStr.length();i++){
            board[6][i]=levelStr.charAt(j++);
        }

        for(int i=5, j=0; j<lvl.length();i++){
            board[7][i]= lvl.charAt(j++);
        }

        for(int i=8, j=0; j<lowerPanelText.length();i++){
            board[11][i]=lowerPanelText.charAt(j++);
        }

    }

    void printScore(char[][] board, int score){

        String scoreFormatted = String.format("%05d",score);
        for(int i=4, j=0; j<scoreFormatted.length();i++){
            board[3][i]= scoreFormatted.charAt(j++);
        }

    }


    void reset(char[][] board){
        for(int i=1 ;i<39;i++){
            board[12][i]= ' ';
        }
    }

    void printRandomWord(char[][] board, String word){
        int  left= 13 - word.length();
        int left_index= (left/2)+11;

        for(int i=left_index, j=0; j<word.length();i++){
            board[12][i]= word.charAt(j++);
        }


    }

    void updateLevel(char[][] board, int level){
        String scoreFormatted = String.format("%03d",level);
        for(int i=5, j=0; j<scoreFormatted.length();i++){
            board[7][i]= scoreFormatted.charAt(j++);
        }
    }

    void printMessage(char[][] board, String msg){
        for(int i=18, j=0; j<msg.length();i++){
            board[7][i]= msg.charAt(j++);
        }
    }
    void printHangman(char[][] board, int count){
        //sabitan
        board[1][30]='_';
        board[1][31]='_';
        board[1][32]='_';
        board[1][33]='_';
        //poste
        board[4][33]='|';
        board[2][33]='|';
        board[3][33]='|';
        board[1][33]='|';
        board[5][33]='|';
        //platform
        board[5][30]='_';
        board[5][31]='_';
        board[5][32]='_';
        board[5][34]='_';
        board[5][35]='_';


        //prisoner
        if (count==1){
            board[2][30]='O';
        }
        if (count==2){
            board[2][30]='O';
            board[3][30]='|';
        }
        if(count==3){
            board[2][30]='O';
            board[3][30]='|';
            board[3][29]='/';
        }
        if (count==4){
            board[2][30]='O';
            board[3][30]='|';
            board[3][29]='/';
        }
        if (count==5){
            board[2][30]='O';
            board[3][30]='|';
            board[3][29]='/';
            board[3][31]='\\';
        }
        if (count==6){
            board[2][30]='O';
            board[3][30]='|';
            board[3][29]='/';
            board[3][31]='\\';
            board[4][29]='/';
        }
        if (count==7){
            board[2][30]='O';
            board[3][30]='|';
            board[3][29]='/';
            board[3][31]='\\';
            board[4][29]='/';
            board[4][31]='\\';
        }



    }

    void clearHangman(char[][] board){
        board[2][30]=' ';
        board[3][30]=' ';
        board[3][29]=' ';
        board[3][31]=' ';
        board[4][29]=' ';
        board[4][31]=' ';

        for(int i=18; i<32 ;i++){
            board[7][i]= ' ';
        }
    }


}


public class HangMan {
    int score = 0;
    int count = 0;
    int level = 1;
    ArrayList<String> wordList = new ArrayList<>();

    void addWord(){
        wordList.add("umbrella");
        wordList.add("magnet");
        wordList.add("canine");
        wordList.add("fan");
        wordList.add("grape");
        wordList.add("pilot");
        wordList.add("elephant");
    }

    String generateRandomWord(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, wordList.size() );

        return wordList.get(randomNum);
    }

    String prompt(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.next();
    }

    String generateAnswer(String word){

        return "*".repeat(word.length());
    }

    String returnResult(char letter, String hidden, String word){

        char[] ch = hidden.toCharArray();
        for(int i =0; i<word.length(); i++){

            if (letter == word.charAt(i)) {
                ch[i]= letter;
            }
        }
        return new String(ch);
    }

    boolean checkResult(String result){
        return !result.contains("*");
    }

    boolean checkLetter(String result, char letter){
        return  result.contains(String.valueOf(letter));
    }

    void startGame(){

        addWord();
        HangMan hangMan = new HangMan();
        Board board = new Board();
        char[][] frame1 = board.frame1();
        char[][] frame2 = board.frame2();

        board.printBoard(frame1);
        int option=0;
        try {
             option = Integer.parseInt(hangMan.prompt("Enter Option: "));
        }catch (Exception e){
            System.out.println("Invalid input");
        }


        if (option==1){
            String randomWord = generateRandomWord();
            String hidden = generateAnswer(randomWord);//generate masked word("*")
            board.printHangman(frame2, count);
            board.updateBoard(frame2, hidden, 0);
            while(count<7) {
                board.printHangman(frame2, count);

                if(checkResult(hidden)) {
                    String msg="Congrats!";
                    if(count==0){
                        msg="Perfect!";
                    }

                    board.printMessage(frame2, msg);
                    level +=1;
                    board.updateLevel(frame2, level);
                    count = 0;
                    board.updateBoard(frame2, hidden, score);
                    String nothing = hangMan.prompt("Next Level:");

                    board.clearHangman(frame2);
                    randomWord = generateRandomWord();
                    hidden = generateAnswer(randomWord);
                    board.updateBoard(frame2, hidden, score);
                }

                String  letter = hangMan.prompt("Enter a letter: ");
                
                //check if letter already pick or doesn't exist
                if(checkLetter(hidden, letter.charAt(0)) || !checkLetter(randomWord, letter.charAt(0))){
                    count++;
                    board.printHangman(frame2, count);
                }else{
                    score +=10;
                }
                
                //show result
                hidden = returnResult(letter.charAt(0), hidden, randomWord);

                board.updateBoard(frame2, hidden, score);

            }
            board.printMessage(frame2, "Game Over!");
            board.updateBoard(frame2, hidden, score);

        }



    }


    public static void main(String[] args) {

        Board board = new Board();
        HangMan hangMan = new HangMan();
        hangMan.startGame();

    }
}
