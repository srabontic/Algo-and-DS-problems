/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.Stack;

/**
 *
 * @author srabo
 */
public class NumberofIslands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int grid[][] = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
        printGrid(grid);
        int result = numIslands(grid);
        System.out.println(result);
        
    }

    private static void printGrid(int[][] grid) {
        for (int i=0; i< grid.length; i++){
            for (int j =0; j< grid[0].length ; j++){
                System.out.print(grid[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    
    static class point{
        int x;
        int y;
        point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int numIslands(int[][] grid) {
        int islands =0;
        int n = grid[0].length; //cols
        int m = grid.length; //rows
        
        //read each element in the array and if unvisited check the four adjecent elements;
        //Stack<point> stack = new Stack<>();
        for (int i=0; i< m; i++){
            for (int j =0; j< n ; j++){
                if (grid[i][j] == 1){
                    //stack.add(new point(i, j));
                    dfs(i, j, grid);
                    islands++;
                    //boolean land = isInLand(grid,visitedArr, i,j);
                    printGrid(grid);
                }
            }
        }
        return islands;
    }

    private static void dfs(int a, int b, int[][] grid) {
        Stack<point> stack = new Stack<>();
        stack.push(new point(a,b));
        int n = grid[0].length;
        int m = grid.length;
        while (!stack.isEmpty()){
            int i = stack.peek().x;
            int j = stack.peek().y;
            grid[i][j] = 0;
            stack.pop();
            if (i-1 >=0 && j >=0 && i-1 < m && j < n && grid[i-1][j] == 1){
                stack.push(new point(i-1, j));
            }
            if (i >=0 && j+1 >=0 && i < m && j+1 < n && grid[i][j+1] == 1){
                stack.push(new point(i, j+1));   
            }
            //System.out.println(i+"    "+j); //+"  array ele:  "+ grid[i+1][j]);
            if (i+1 >= 0 && j >=0 && i+1 < m && j < n && grid[i+1][j] == 1){
                stack.push(new point(i+1, j));   
            }
            if (i >=0 && j-1 >=0 && i < m && j-1 < n && grid[i][j-1] == 1){
                stack.push(new point(i, j-1));   
            }
        }
    }
    
}
