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
public class LetterCombinationPhoneNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String digits = "23";
        List<String> res = letterCombinations(digits) ;
    }

    private static List<String> letterCombinations(String digits) {
        
        String[] buttons = {"#", "#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        result.add("");
        
        for (int i=0; i< digits.length(); i++){
            int index = (int)digits.charAt(i) - '0';
            result = combine(buttons[index], result);
        }
        return result;
    }

    private static List<String> combine(String button, List<String> l) {
        List<String> result = new ArrayList<String>();
            
            for (int i=0; i<button.length(); i++) 
                for (String x : l) 
                    result.add(x+button.charAt(i));
    
            return result;
    }
    
}
