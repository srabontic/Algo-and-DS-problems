/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import Google.SinglyLinkedList.*;
import Google.SinglyLinkedList.Entry;

/**
 *
 * @author srabo
 */
    
public class ReverseLinkedList { 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Entry result = reverseList(list.header);
        while (result != null){
            System.out.println(result.element);
        }
        //reverseList(node);
    }
    private static Entry reverseList(Entry head) {
        Entry prev = null;
        Entry curr = head;
        Entry temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
    
}
