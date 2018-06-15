/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class WordLadder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("cog");
        
        String beginWord = "hit";
        String endWord = "cog";
        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println();
        System.out.println(res);
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int distance =1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int q_size = q.size();
            for (int k =0; k< q_size; k++){
                String curr = q.poll();
                System.out.print(curr+  "   ");
                //check if cuurent word is in list, remove
                if(wordList.contains(curr)) wordList.remove(curr);
                //search for the word with one letter difference
                if(curr.equals(endWord)) return distance;
                for (String s: wordList){
                    boolean differenceOne = checkDiff(s, curr);
                    if (differenceOne) {
                        q.add(s);
                    }
                }
            }
            distance++;
        }
        return 0;
    }

    private static boolean checkDiff(String s, String curr) {
        char[] a = s.toCharArray();
        char[] b = curr.toCharArray();
        int count =0;
        for(int i=0; i< a.length; i++){
            if (a[i] != b[i]){
                count++;
            }
            if(count > 1) return false;
        }
        if (count <=1) return true;
        return true;
    }
    
}
