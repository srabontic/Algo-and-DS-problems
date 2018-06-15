/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author srabo
 */
public class LengthOfLongestSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int max_index =0;
        for (int i=0; i< s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                max_index = Math.max(max_index, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-max_index+1);
        }
        return maxLength;
    }
    
}
