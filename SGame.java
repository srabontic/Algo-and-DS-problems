/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srabonti
 */
public class SGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<int[]> food = new ArrayList<>();
        int[] i = {1,1};
        food.add(new int[]{1, 1});
        food.add(new int[]{1, 0});
        food.add(new int[]{2, 1});
        food.add(new int[]{1, 2});
        game(5, 5, food);
    }
    public static void game(int width, int height, List<int[]> food) {
        for (int i=0; i< food.size(); i++){
            
        }
    }

    /**
     * @param direction U = Up, L = Left, R = Right, D = Down
     * @return The game's score after the move. Return -1 if game over.
     */
    public int move(char direction) {
           return 0;
    }
    
}
