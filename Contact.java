/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author srabo
 */
public class Contact {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(); int i=0;int count =0;
        Map<String, Integer> map = new HashMap<>();
	while(i != num+1) {
            count =0;
            String[] st = in.nextLine().split(" ");
            if (st[0].equals("add")){
                for (int j=0; j< st[1].length(); j++){
                    if (map.containsKey(st[1].substring(0, j))){
                        map.put(st[1].substring(0, j), map.get(st[1].substring(0, j))+1);
                    }else{
                        map.putIfAbsent(st[1].substring(0, j), 1);
                    }
                }
            }
            if (st[0].equals("find")){
                for (String s: map.keySet()){
                    if (s.equals(st[1])){
                        System.out.println(map.get(s));
                        break;
                    }
                    System.out.println(0);
                }
            }
            
            i++;
        }
    }
    
}
