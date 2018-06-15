/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author srabo
 */
public class relatedWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);;
        String inputText = in.nextLine();
        String word = in.nextLine();
        int n = in.nextInt();
        
        inputText = inputText.replaceAll("[^a-zA-Z0-9]", "");
        String[] inputWords = inputText.split("\\s");
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i< inputWords.length; i++){
            if (inputWords[i].equals(word)){
                //yet to be done
            }
        }
        
        String maxFreqWord = null;
        int maxFreq =0;
        for (Map.Entry<String, Integer> m : map.entrySet()){
            if (m.getValue() > maxFreq){
                maxFreq = m.getValue();
                maxFreqWord = m.getKey();
            }
        }
        
        System.out.println(maxFreqWord);
        
    }
    
}
