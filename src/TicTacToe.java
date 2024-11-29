import java.util.Scanner;

public class TicTacToe{
    public static char[][] board = new char[3][3];
    public static char currentPlayer ='X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initializeBoard( );

        while (true) {
            printBoard( );
            playerMove(sc);
            if (checkWinner( )) {
                printBoard( );
                System.out.println("player" + currentPlayer + "wins!");
                break;
            }
            if (isBoardFull( )) {
                printBoard( );
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer( );
        }
        System.out.println("Do you want to play again? (yes/no): ");
        String playAgain = sc.nextLine( ).toLowerCase( );
        if (playAgain.equals("yes")) {
            main(args);
        } else {
            System.out.println("Thank you for playing!");
        }
        sc.close( );
    }

    private static void initializeBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard(){
        System.out.println("Currnt board:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]);
                if(j<2) System.out.print(" | ");
            }
            System.out.println(  );
            if(i<2) System.out.println("---------");
        }
    }
    public static void playerMove(Scanner sc){
        int row, col;
        while(true){
            System.out.println("player "+currentPlayer + ", enter row (1-3) and column (1-3) to place your mark:");
            row = sc.nextInt() -1;
            col = sc.nextInt() -1;
            sc.nextLine();

            if(row >=0 && row<3 && col>=0 &&col<3 && board[row][col] == ' '){
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move! The position is either out of bounds or already taken.");
            }
        }
    }

    public static void switchPlayer(){
        currentPlayer = (currentPlayer == 'X' ) ? 'O' : 'X';
    }
    public static boolean isBoardFull(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWinner(){
        for(int i=0;i<3;i++){
            if((board[i][0] == currentPlayer && board[i][1]==currentPlayer && board[i][2]== currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer)){
                return true;
            }
        }
        if((board[0][0] == currentPlayer && board[1][1]==currentPlayer && board[2][2] == currentPlayer)||
                (board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]== currentPlayer)){
            return true;
        }
        return false;
    }


}