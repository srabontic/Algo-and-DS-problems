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
public class LongestPalSubString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "bb";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    private static String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        if (s.length() < 2) return s;
        for (int i=0; i<s.length(); i++){
            //go towards left to search for a pali
            //then go to right the same distance 
            int j =0,k=0;
            //start for even pali
            j =i; k=i+1;
            while(j>=0 && k<s.length() && s.charAt(j)== s.charAt(k)){
                j--;
                k++;   
            }
            if(k-j-1 > max){
                max = k-j-1;
                start = j+1;
            }
            //System.out.println("1  "+max);
            //start for odd pali
            j=i;k=i;
            while(j>=0 && k<s.length() && s.charAt(j)== s.charAt(k)){
                j--;
                k++;   
            }
            if(k-j-1 > max){
                max = k-j-1;
                start = j+1;
            }
            //System.out.println("2  "+max);
             
        }
        return s.substring(start, start+max);
    }
    
    
    
}
