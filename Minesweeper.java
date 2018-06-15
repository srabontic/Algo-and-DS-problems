/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author srabo
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},  {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] res = updateBoard(board, click);
    }

    private static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0]; int col = click[1];
        int m = board.length; int n = board[0].length;
        int count = 0;
        //set M to X
        if (board[row][col] == 'M'){
            board[row][col] = 'X';
        }else{
        //check if adj cells are unrevealed mines  
            for (int i=-1; i< 2; i++){
                for (int j=-1; j< 2; j++){
                    if (i==0 && j ==0) continue;
                    int r = row + i;
                    int c = col + j;
                    if (r<0 || r >= m || c <0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;   
                }
            }
        //if count > 0 that means not E
            if (count > 0){
                board[row][col] = (char)count;
            }else{
                for (int i=-1; i< 2; i++){
                    for (int j=-1; j< 2; j++){
                        if (i==0 && j ==0) continue;
                        int r = row + i;
                        int c = col + j;
                        if (r<0 || r >= m || c <0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[]{r,c});
                    }
                }
            }
        }
        return board;
    }
    
}
