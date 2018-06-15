/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class MinPathSum {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int path = minPathSum(grid);
        System.out.print(path);
        
    }
    private static int minPathSum(int[][] grid) {
        int [][] temppaths = new int[grid.length][grid[0].length];
        temppaths[0][0] = grid[0][0];
        for (int i=0; i<grid.length; i++ ){
            for (int j =0; j< grid[0].length; j++){
                if (i-1>=0 && j-1 >=0){
                    temppaths[i][j] = Math.min(temppaths[i-1][j] , temppaths[i][j-1]) + grid [i][j];
                }  else if (i-1 < 0 && j-1 >=0){
                    temppaths[i][j] = temppaths[i][j-1] + grid [i][j];
                } else if (i-1 >=0  && j-1 < 0){
                    temppaths[i][j] = temppaths[i-1][j] + grid [i][j];
            }
            }
        }
        for (int i=0; i<grid.length; i++ ){
            for (int j =0; j< grid[0].length; j++){
                System.out.print(temppaths[i][j]+",");
            }
            System.out.println();
        }
       return temppaths[grid.length-1][grid[0].length-1];
    }
    
}
