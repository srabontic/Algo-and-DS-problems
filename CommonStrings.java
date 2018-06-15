/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author srabo
 */
public class CommonStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "Hello,I am a software engineer";
        String t = "I am mechanical engineer but I love software";
        boolean res = getCommon(s, t, "software engineer");
        System.out.println(res);
    }

    private static boolean getCommon(String s, String t, String se) {
        Map<String,HashSet<Integer>> map = new HashMap<>();
        for (String st: s.split("\\s|,")){
            HashSet<Integer> sh = new HashSet<>();
            sh.add(1);
            map.putIfAbsent(st, sh);
        }
        for (String st: t.split("\\s|,")){
            if (map.containsKey(st)){
                HashSet<Integer> sh = map.get(st);
                sh.add(2);
                map.put(st, sh);
            }else{
                HashSet<Integer> sh = new HashSet<>();
                sh.add(2);
                map.put(st, sh);
            }
        }
        for (String st: se.split("\\s|,")){
            if (map.containsKey(st)){
                HashSet<Integer> h = map.get(st);
                int count =0;
                for (Integer i: h){
                    count++;
                }
                if (count != 2){
                    return false;
                }
            }
        }
        return true;
    }
    
}
