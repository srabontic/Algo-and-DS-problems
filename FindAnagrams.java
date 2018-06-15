/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class FindAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s,p);
        for (Integer i : result){
            System.out.print(i + "  ");
        }
    }

     private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        //keep p in a hashmap with count of chars
        Map<Character, Integer> p_map = new HashMap<> ();
        for (char c: p.toCharArray()){
            p_map.putIfAbsent(c, 1);
            if (p_map.containsKey(c)){
                p_map.put(c, p_map.get(c)+1);
            }
        }
        //copy counts of each chars in an array
        int[] p_count = new int[256];
        int i_count =0;
        for (char ch : p.toCharArray()){
            p_count[ch] ++;
        }
        //slide window in s and count for chars in an window
        int left = 0;
        int right =0;
        int pCount1 [] = new int[p_count.length];
        for (int i=0; i< p_count.length; i++){
            pCount1 [i] = p_count[i];
        }
        for (Character c: s.toCharArray()){
            //System.out.println(s.toCharArray()[left]+ " "+ s.toCharArray()[left+1]+ "  "+ s.toCharArray()[left+2]);
            /*
            if (!p_map.containsKey(c)){      //if there is c in p_map 
                left++;
                right = 0;
                pCount1 = p_count;
            }
            else{
                if (right < p.length()-1){
                    if (pCount1[c] > 0)
                        pCount1[c]--;
                    else{
                         //resetCount
                         pCount1 = p_count;
                         left++;
                         //right = 0;
                    }
                    right++;
                }else if (right == p.length()-1){
                    if (pCount1[c] > 0){
                        pCount1[c]--;
                    }
                        //check if anagram and reset
                        right=0; //reset right
                        //check if value of p_count is zero, if zero return left
                        if (checkCount(pCount1)){ 
                            result.add(left);
                            System.out.println(s.toCharArray()[left]+ " "+ s.toCharArray()[left+1]+ " "+ s.toCharArray()[left+2]);
                            pCount1 = p_count;
                        }
                        left++;
                }
                //right++;
            }
            */
            //new code
            if (right < p.length()-1){
                if (pCount1[c] > 0){
                    pCount1[c]--;
                }
                right++;
            }else if (right == p.length()-1){     //cab
                if (pCount1[c] > 0) {
                    pCount1[c]--;
                }
                if (checkCount(pCount1)){ 
                    result.add(left);
                    System.out.println(s.toCharArray()[left]+ " "+ s.toCharArray()[left+1]+ " "+ s.toCharArray()[left+2]);
                    for (int i=0; i< p_count.length; i++){
                        pCount1 [i] = p_count[i];
                    }
                }
                //pCount1 = p_count;
                //right --;
                if (p_map.containsKey(s.toCharArray()[left]))
                    pCount1[s.toCharArray()[left]] = p_count[s.toCharArray()[left]];
                left++;            
            }
        }
        return result; 
    }
     
     
    private static boolean checkCount(int[] countArray) {
        for (int i: countArray){
            if (i != 0)
                return false;
        }
        return true;
    }
    /*
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<> ();
        int pLength = p.length();
        int matchCount =0;
        int s_count =0;
        //keep p in map
        Map<Character, Integer> p_map = new HashMap<> ();
        for (char c: p.toCharArray()){
            p_map.putIfAbsent(c, 1);
            if (p_map.containsKey(c)){
                p_map.put(c, p_map.get(c)+1);
            }
        }
        Map<Character, Integer> s_map = null; // = new HashMap<> ();
        for (char c: s.toCharArray()){
            //keep pLength characters in map
            if (matchCount == pLength - 1 || matchCount ==0){
                matchCount =0;
                if (matchCount > 0){
                    if (checkCount(s_map, p_map)){
                        result.add(s_count);
                    }
                }
                s_map = new HashMap<> ();
            }
            s_map.putIfAbsent(c, 1);
            if (s_map.containsKey(c)){
                s_map.put(c, s_map.get(c)+1);
            }
            matchCount ++;
            s_count++;
            
        }
        return result;
    }

    private static boolean checkCount(Map<Character, Integer> s_map, Map<Character, Integer> p_map) {
        for (Character c: p_map.keySet()){
            if (p_map.get(c) != s_map.get(c)){
                return false;
            }
        }
        return true;
    }
    */   

}