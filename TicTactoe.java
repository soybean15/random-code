import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player{
    int number;
    char piece;
    public Player(int number, char piece){
        this.number=number;
        this.piece= piece;
    }


    int generateMove(int[] arr){
        Random rand = new Random();

        int index = rand.nextInt(arr.length);
        return arr[index];
    }



}


class Board{
    char[][] board = new char[3][9];
    int[] availableMove = {1,2,3,4,5,6,7,8,9};


    public Board(){
        createBoard();

    }

    void updateBoard(int row, int col, char piece){
        board[row][col] = piece;
    }

    void createBoard(){
        char[] box ={'[',' ',']'};
        int index = 0;
        for(int i =0; i<3; i++){
            index=0;

            for(int j =0; j<9; j++){

                if(j==3 ||j ==6 ){
                    index=0;
                }
                board[i][j] = box[index];
                index++;

            }
        }
    }




    void printBoard(){
        for(int i =0; i<3; i++){
            for(int j =0; j<9; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }


    int checkElement(int n){
        int count = 0;
        for(int i : availableMove){
            if (n==i){
                return count;
            }
            count++;
        }
        return -1;
    }

    int[] updateAvailableMove(int n){
        int target = checkElement(n);
        int[] newArr= new int[availableMove.length-1];
        if(target <0){
            return availableMove;
        }
        else{

            for(int i = 0; i <target; i++){
                newArr[i] =availableMove[i];
            }

            for(int i=target; i<newArr.length;i++){
                newArr[i] = availableMove[i+1];
            }
        }


        return newArr;
    }
}

 class TicTactoe{
    int[][] winningMove ={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

    int[] row = {0,0,0,1,1,1,2,2,2};
    int[] col = {1,4,7,1,4,7,1,4,7};
    Scanner sc = new Scanner(System.in);
    Board board = new Board();
    boolean draw = true;
    Player[] player = new Player[2];



    boolean checkWinner(List<Integer> arr){
        for(int i=0; i<8; i++){
            int count =0;
            for(int j = 0; j<3; j++){
                for(int k :arr){
                    if(winningMove[i][j] ==k){
                        count++;
                    }
                }
                if (count==3){
                    return true;
                }
            }
        }

        return false;

    }
    boolean checkMove(int[] arr, int n){
        for(int i :arr){
            if(i==n){
                return true;
            }
        }
        return false;
    }


    void start(){

        player[0] =  new Player(1,'x');
        player[1] =  new Player(2,'o');
        List<Integer> p1move = new ArrayList<>();
        List<Integer> p2move = new ArrayList<>();


        int index =0;
        board.printBoard();
        while(board.availableMove.length>0){


            int move = 0;
            if(player[index].number == 2){
                move = player[index].generateMove(board.availableMove);
                p1move.add(move);
            }else{


                while(!checkMove(board.availableMove, move)){
                    System.out.println("Select Move:");
                    move = sc.nextInt();
                }


                p2move.add(move);
            }

            System.out.println("Player :"+(index+1));

            board.updateBoard(row[move-1], col[move-1], player[index].piece);
            board.printBoard();
            board.availableMove = board.updateAvailableMove(move);




            if(checkWinner(p2move) || checkWinner(p1move) ){
                System.out.println("Winner: Player"+player[index].number);
                draw= false;
                break;
            }


            index++;
            if(index == 2){
                index=0;
            }


        }
        if(draw){
            System.out.println("Draw");
        }



    }
    public static void main(String[] args){

        TicTactoe tictactoe = new TicTactoe();

        tictactoe.start();
       
    }
}
