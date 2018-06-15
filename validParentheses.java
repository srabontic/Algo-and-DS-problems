/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author srabo
 */
public class validParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "()[]{}";
        boolean r = isValid(s);
        System.out.print(r);
        System.out.println();
    }

    private static boolean isValid(String s) {
        //Set<Character> start = new HashSet<>(Arrays.asList('(', '{', '['));
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] c_input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c: c_input ){
           if (map.keySet().contains(c)) {
               stack.push(c);
           }else if (map.values().contains(c)){
               if (!stack.isEmpty()){
                   char temp = stack.pop();
                    if (map.get(temp) != c){
                        return false;
                    }
               }else{
                   return false;
               }
               
           }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    
}
