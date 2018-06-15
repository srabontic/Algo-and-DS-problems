/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author srabo
 */
public class AmazonTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //List<String> str = subStringsLessKDist("awaglk", 4);
        //List<String> str = subStringsLessKDist("democracy", 5);
        List<String> str = subStringsLessKDistEasy("democracy", 5);
        for (String s1:str)
            System.out.println(s1);
    }
    


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<String> subStringsLessKDist(String inputString, int num)
	{
        // WRITE YOUR CODE HERE
        List<String> list = new ArrayList<>();
        int[] keep = new int[256];
        int start =0;
        int end =0;
        for (int i=0; i< inputString.length(); i++){
            keep[inputString.charAt(i)] ++;
            end++;
            if (keep[inputString.charAt(i)] == 2){
                String newString = inputString.substring(start, end);
                while(end<= num && end < inputString.length()) {
                    //if new char comes once add to subString
                    //else if new char comes > 1 times adjust start
                    if (keep[inputString.charAt(end)] < 2){
                        newString += inputString.charAt(end);
                        end++;
                    }else{
                        start++;
                        break;
                    }
                   
                }
                //when substring ==num
                list.add(newString);
                start ++;
            }
        }
        return list;
    }
    // METHOD SIGNATURE ENDS

    private static List<String> subStringsLessKDistMy(String input, int k) {
        List<String> list = new ArrayList<>();
        int[] keep = new int[256];
        int start =0;
        int end =0;
        for (int i=0; i< input.length(); i++){
            keep[input.charAt(i)] ++;
            end++;
            if(keep[input.charAt(i)]==2){
                //if end-start == k, output substring
                while(end - start +1 < k && end < input.length()){
                    
                }
            }
            if(end-start+1 == k){
                keep[input.charAt(start)] --;
                start ++;
            }
        }
        return list;
    }
    
    private static List<String> subStringsLessKDistEasy(String input, int k) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int start =0; int end =0;
        for (int i=0; i< input.length(); i++){
            end++;
            if (map.containsKey(input.charAt(i)))
                map.put(input.charAt(i), map.get(input.charAt(i))+1);
            else{
                map.put(input.charAt(i), 1);
            }
            
            if(end-start+1 == k){
                int dupCount=0;
                int uniqueCount=0;
                for (Map.Entry<Character, Integer> entry: map.entrySet()){
                    if (entry.getValue()>2){
                        break;
                    }
                    if (entry.getValue()==2){
                        dupCount++;
                    }
                    if (entry.getValue()==2){
                        uniqueCount++;
                    }  
                }
                if (dupCount==1 && uniqueCount == k-1){
                    list.add(input.substring(start, end));
                }
                map = new HashMap<>();
                start ++;
            }
        }
        return list;
    }
}