/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import mspractice.SinglyLinkedList.*;
import mspractice.SinglyLinkedList.Entry;

/**
 *
 * @author srabo
 */
public class LinkedlistSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<Integer> ls1 = new SinglyLinkedList<>();
        ls1.add(5); ls1.add(4);
        SinglyLinkedList<Integer> ls2 = new SinglyLinkedList<>();
        ls2.add(5); ls2.add(4);ls2.add(3);
        
        Entry first = ls1.header;
        Entry second = ls2.header;
        
        Entry third = addTwoLists(first, second);
          
    }
    
    public static Entry addTwoLists(Entry first, Entry second){
        int carryover =0;
        Entry third = null;
        Entry t_curr = null;
        //int sum =0;
        while (first != null || second != null){
            int sum = (carryover + (first != null? (int) first.element : 0) + (second != null? (int) second.element : 0))%10;
            
            carryover = ((first != null? (int) first.element : 0) + (second != null? (int) second.element : 0)) /10;
            
            /* something new to learn*/
            SinglyLinkedList s = new SinglyLinkedList();
            SinglyLinkedList.Entry temp = s.new Entry(sum, null);
            
            if (third == null){
              third = temp;  
              t_curr = temp;
            }else{
                t_curr.next = temp;  
            }
            
            if(first.next != null){
                first = first.next;
            }
            if(second.next != null){
                second = second.next;
            }
               
        }
        
        if (carryover > 0){
            if (t_curr != null){
                //t_curr.next = s.new Entry(carryover, null);
                SinglyLinkedList s = new SinglyLinkedList();
                t_curr.next  = s.new Entry(carryover, null);
            }
        }
       
        return third;
    }
    
        
}
