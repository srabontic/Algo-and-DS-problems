/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

/**
 *
 * @author srabo
 */
public class KMPAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        
        findFrequency(str.toCharArray(), subString.toCharArray());
        
    }

    //this method searchs for the number of occurrence of a pattern in a text
    //this is kmp algo
    private static void findFrequency(char[] text, char[] pattern) {
        //get lps array
        int[] lps = getLpsArray(pattern);
        int i=0; //points text
        int j=0; //points pattern
        while (i < text.length){
            if (text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if (j!=0)
                    j = lps[j-1];
                else{
                    i++;
                }
            }
            if (j == pattern.length){
                System.out.println("pattern at index : " + (i-j));
            }
        }
        
    }

    //this method processes LPS array
    private static int[] getLpsArray(char[] pattern) {
        int j=0;
        int [] lps = new int [pattern.length];
        for (int i=0; i< pattern.length; i++){
            lps[i]=0;
        }
        for (int i=1; i< pattern.length;){
            if (pattern[i] == pattern[j]){
                lps [i] = j + 1;
                i++;
                j++;
            }
            else{
                if (j!=0)
                    j = lps[j-1];
                else{
                    lps [i] = 0;
                    i++;
                }  
            }
        }
        for (int i=0; i< pattern.length; i++ ){
            System.out.print(lps[i]+ "  ");
        }
        return lps;
    }
    
}
