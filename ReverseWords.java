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
public class ReverseWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "the sky is blue";
        char [] str = s.toCharArray();
        reverseWords(str);
        /*for(char c: str){
            System.out.print(c+ "  ");
        }*/
    }

    private static void reverseWords(char[] str) {
        for(int i=0; i< str.length / 2; i++){
            char c1 = str[i];
            char c2 = str[str.length - 1 - i];
            char temp = str[str.length - 1 - i];
            str[str.length - 1 - i] = str[i];
            str[i] = temp; 
        }
        
        //reverse each words
        int start = 0;
        for(int i=0; i< str.length; i++){ 
            if (str[i] == ' ' || i+1 == str.length){
                if (i+1 == str.length) i++;
                //reverse from prev_start to i-1
                for (int j=start; j< (i+start)/2; j++){
                    char temp = str[i-1-j+start];
                    str[i-1-j+start] = str[j];
                    str[j] = temp; 
                }
                start = i+1;
            }
        }
        
    }
   
}
