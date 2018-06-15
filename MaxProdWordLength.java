/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author srabo
 */
public class MaxProdWordLength {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int res = maxProduct(words);
        System.out.println(res);
    }

    //create an array to save the binary values of the words
    // we consider each words as a 32 bit word and we will take OR of each 2^valueOf(letter) in every word
    //then will compare if those are equal
    private static int maxProduct(String[] words) {
        int[] keep = new int[words.length];
        int max =0;
        for (int i=0; i< words.length; i++){
            int num = 0;
            for(int j =0; j< words[i].length(); j++){
                num |= 1<<(words[i].charAt(j) - 'a');
            }
            keep[i] = num;
        }
        for (int i=0; i< words.length; i++){
            for (int j=i+1; j< words.length; j++){
                if ((keep[i] & keep[j]) == 0){ //that means no common characters // "bde" = "11100" and "abc" = "111"
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    
}
