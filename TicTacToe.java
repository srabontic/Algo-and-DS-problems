/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

/**
 *
 * @author srabo
 */
public class TicTacToe {

    
    /**
     * @param args the command line arguments
     */
    /** Initialize your data structure here. */
    int box_size;
    boolean win = false;
    char box[][];
    char[] player_sign;
    public TicTacToe(int n) {
        box = new char[n][n];
        /*    for(int i=0; i< n; i++){
                for(int j=0; j< n; j++){
                    System.out.print(box[i][j]);
                }
                System.out.println();
            }*/
        box_size = n;   
        player_sign = new char[2];
        player_sign[0] = 'X';
        player_sign[1] = 'O';
    }
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
            
        if (row > box_size-1 && col > box_size-1 && row < 0 && col < 0 && !win){
            return 0;
        }
        if (box[row][col] == '\u0000'){
            box[row][col] = player_sign[player-1];
            return winorloss(row, col, player_sign[player-1]);
        }
        return 0;   
    }
    public static void main(String[] args) {
        // TODO code application logic here
        /**
        * Your TicTacToe object will be instantiated and called as such:
        * TicTacToe obj = new TicTacToe(n);
        * int param_1 = obj.move(row,col,player);
        */
        TicTacToe toe = new TicTacToe(2);
        /*
        System.out.println(toe.move(0, 0, 1));
        toe.printbox();
        System.out.println(toe.move(0, 2, 2));
        toe.printbox();
        System.out.println(toe.move(2, 2, 1));
        toe.printbox();
        System.out.println(toe.move(1, 1, 2));
        toe.printbox();
        System.out.println(toe.move(2, 0, 1));
        toe.printbox();
        System.out.println(toe.move(1, 0, 2));
        toe.printbox();
        System.out.println(toe.move(2, 1, 1));
        toe.printbox();*/
        System.out.println(toe.move(0, 0, 2));
        toe.printbox();
        System.out.println(toe.move(1, 1, 1));
        toe.printbox();
        System.out.println(toe.move(0, 1, 2));
        toe.printbox();
        
    }

    private int winorloss(int row, int col, char player) {
        boolean match = true;
        int result = 2;
        if (player == 'X') result = 1;
        else if(player == 'O') result = 2;
        
        // check if rows is filled
        for (int i=0; i< box_size; i++){
            if (box[i][col] != player){
                match = false;
            }
        }
        if (match) return result;match = true;
        //check if cols is filled
        for (int i=0; i< box_size; i++){
            if (box[row][i] != player){
                match = false;
            }
        }
        if (match) return result;match = true;
        for(int i=0; i< box_size; i++){
            if (box[i][i] != player)
                match = false;
        }
        if (match) return result;match = true;
        for(int i=0; i< box_size; i++){
            if (box[i][box_size-1-i] != player)
                match = false;
        }
        if (match) return result;
        return 0;
    }
    
    private void printbox() {
        System.out.println("=================");
        for(int i=0; i< box_size; i++){
            for(int j=0; j< box_size; j++){
                System.out.print(box[i][j]);
            }
        System.out.println();
        }
        System.out.println("=================");
    }

    
}
