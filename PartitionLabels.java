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

/**
 *
 * @author srabo
 */
public class PartitionLabels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "ababcbacadefegdehijhklij";
        List<Integer> l =  partitionLabels(str);
        for (Integer i: l){
            System.out.print(i+"  ");
        }
    }
    public static List<Integer> partitionLabels(String S) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i< S.length(); i++){
            map.put(S.substring(i, i+1), i);
        }
        int start =0; int end =0;
        for (int i=0; i< S.length(); i++){
           if (map.get(S.substring(i, i+1)) > end) {
               end = map.get(S.substring(i, i+1));
           }
           if (end == i){
               list.add(end - start + 1);
               start = end + 1;
           }
        }
        return list;   
    }
    
}
