/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author srabo
 */
public class FirstUniqueChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "loveleetcode";
        int res = firstUniqChar(s);
        System.out.println(res);
    }

    private static int firstUniqChar(String s) {
        int[] keep = new int[26];
        int index =Integer.MAX_VALUE;
        for (int i=0; i< s.length(); i++){
            keep[s.charAt(i)-'a'] ++; 
        }
        for (int k=0; k< s.length(); k++){
            if (keep[s.charAt(k)-'a'] == 1){
                return k;
            }
        }
        return -1;       
    }
    
}
