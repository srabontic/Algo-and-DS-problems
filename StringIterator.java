/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class StringIterator {
    /**
     * @param args the command line arguments
     */
    Queue<Character> list = new LinkedList<>();
    
    public StringIterator(String compressedString) {
        char[] charArray = compressedString.toCharArray();
        int times=0;
        for (int i=0; i< charArray.length; i=times){
            if (i+1 < charArray.length){
                times=i+1; 
                while (times < charArray.length && charArray[times] >= '0' && charArray[times] <= '9'){
                    times++;
                }
                String s = compressedString.substring(i+1, times);
                int t = Integer.parseInt(s);
                int j=0;
                
                while(j < t){
                    list.add(charArray[i]);j++;
                }
            }
        }
    }
    
    public char next() {
     
        if (!list.isEmpty()){
            return list.poll();
        }
        return ' ';
    }
    
    public boolean hasNext() {
        if (!list.isEmpty( )){
            return true;
        }else
            return false;    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
    
}
