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
 * @author srabo
 */
public class AllParenthesis {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<String> list = generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public static void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            System.out.println("output: "+str);
            list.add(str);
            return;
        }
        if(open < max){
            backtrack(list, str+"(", open+1, close, max);
            System.out.println("left:  "+str);
        }
        if(close < open){
            backtrack(list, str+")", open, close+1, max);
            System.out.println("right: "+str);
        }
    }
    
}
