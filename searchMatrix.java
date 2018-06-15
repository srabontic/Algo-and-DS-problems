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
public class searchMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matrix = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(7/2 +1);
        int target = 9;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        //shroten the array
        /*int rows_start =0, rows_end =0, cols_start =0, cols_end = 0;
        while(rows_end >= 1 && cols_end >= 1){
            int mid_rows = matrix.length/2 ;
            if (matrix[mid_rows][0] < target){      //3<5
                rows_start = mid_rows+1;
            }else if (matrix[mid_rows][0] > target){      //3<5
                rows_end = mid_rows;
            }else{
                return true;
            }
            int mid_cols = matrix[0].length/2 ;
            if (matrix[rows_start][mid_cols] < target){
                cols_start = mid_cols+1;
            }else if (matrix[rows_start][mid_cols] > target){
                cols_end = mid_cols;
            }else{
                return true;
            }
        }*/
        if (matrix.length <= 0 || matrix[0].length <=0) return false;
        //both of the part of code works
        /*int rows = 0;
        int cols = matrix[0].length -1;
        while(cols >=0 && rows <= matrix.length){
            if (target == matrix[rows][cols]){
                return true;
            }else if (target < matrix[rows][cols]){
                cols--;
            }else if (target > matrix[rows][cols]){
                rows++;
            }
        }*/
        
        int rows = matrix.length -1;
        int cols = 0;
        while(rows >=0 && cols <= matrix[0].length-1){
            if (target == matrix[rows][cols]){
                return true;
            }else if (target < matrix[rows][cols]){
                rows--;
            }else if (target > matrix[rows][cols]){
                cols++;
            }
        }
        System.out.println(7/2);
        return false;
    }
    
}
