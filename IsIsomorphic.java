/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author srabo
 */
public class IsIsomorphic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));
        //boolean b = isIsomorphic(s,t);    
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        //Map<Character, Integer> mapS  = new HashMap<>();
        //Map<Character, Integer> mapT  = new HashMap<>();
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for(int i=0; i< s.length(); i++){
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) return false;
            mapS[s.charAt(i)] = i+1;
            mapT[t.charAt(i)] = i+1;
           
        }
        
       return true; 
    }
    
}
