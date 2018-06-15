/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {


    public static void main(String[] args) {
        // TODO code application logic here
        String[] dict = {"leet", "code"};
        //String[] dict = {"aaaa", "aa"};
        List<String> wordDict = Arrays.asList(dict);
        String s = "leetcode";
        //String s = "aaaaaaa";
        boolean res = wordBreak(s,wordDict); 
        System.out.print(res);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int count =0;
        boolean b[] = new boolean[s.length()+1];
        b[0] = true;
        for (int i=1; i<= s.length(); i++){
            for (int j=0; j< i; j++){
                String tempS = s.substring(j,i);
                if(wordDict.contains(tempS) && b[j]){
                    b[i] = true;
                    break;
                }
            }
        }
        return (b[s.length()]);
    }
    
}
