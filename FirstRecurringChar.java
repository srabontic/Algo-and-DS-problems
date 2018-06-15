/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.HashMap;

/**
 *
 * @author srabo
 */
public class FirstRecurringChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "ABCA";
        char[] inputChars = input.toCharArray();
        System.out.println("First recurring character: " + findFirstReccurringChar(inputChars));
    }

    private static char findFirstReccurringChar(char[] inputChars) {
        HashMap<Character, Integer> map = new HashMap<>();
        char result;
        for (int i=0; i< inputChars.length; i++){
            if (map.containsKey(inputChars[i])){
                result = inputChars[i];
                return result;
            }else{
                map.put(inputChars[i], 1);
            }
        }
       return '#'; 
    }
    
}
