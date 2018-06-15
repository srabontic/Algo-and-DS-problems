/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = updateMatrix(input);
        for(int i=0; i< input.length; i++){
            for (int j=0; j< input[0].length; j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] updateMatrix(int[][] input) {
        Queue<int[]> q = new LinkedList<>();
        int n = input.length;
        int m = input[0].length;
        //int[][] res = new int[input.length][input[0].length];
        for (int i=0; i< input.length; i++){
            for (int j=0; j< input[0].length; j++){
                if (input[i][j] == 0){
                    q.add(new int[] {i,j});
                    //int val = BSF(q, input, input.length, input[0].length);
                }else
                if (input[i][j] == 1){
                    input[i][j] = Integer.MAX_VALUE;
                }else{
                    return null;
                }
            }
        }
        //calculate the value for each MAX node from 0 nodes
        int[][] disp = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int [] zeroCell = q.poll();
            //check four adj nodes
            for (int[] d: disp){
                int r = zeroCell[0] + d[0];
                int c = zeroCell[1] + d[1];
                if ( r < 0 || r >= n || c < 0 || c >= n || input[r][c] <= input[zeroCell[0]][zeroCell[1]]+1) continue;
                q.add(new int[]{r,c});
                input[r][c] = input[zeroCell[0]][zeroCell[1]] +1;
            }          
        }
        return input;
    }    
}
