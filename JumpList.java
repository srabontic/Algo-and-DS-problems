/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import mspractice.SinglyLinkedList.*;
import mspractice.SinglyLinkedList.Entry;

/**
 *
 * @author srabo
 */
public class JumpList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<Integer> input = new SinglyLinkedList<>();
        input.add(3);
        input.add(4);
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(6);
        input.add(9);
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(1);
        System.out.println("Number of jumps:" + jump_over_numbers(input));
        
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(0);
        System.out.println("Number of jumps:" + jump_over_numbers1(l));
        
        long number = 424;
        System.out.println("is palindrome : " + is_numeric_palindrome(number));
        
        
           
    }

    private static int jump_over_numbers(SinglyLinkedList<Integer> input) {
        //code to return number of jumps
        int pos = 1;
        int curr_pos = 1;
        int jumps =0;
        
        Entry curr = input.header;
        pos += (int) curr.next.element; //store number of first node as position
        while(curr.next != null) {
	    
            if (curr_pos == pos){
                System.out.println(curr.element);
                if ((int) curr.element == 0)
                    return -1;
                else{
                    pos += (int) curr.element;
                    jumps += 1;
                }
            }
            curr = curr.next;
            curr_pos ++;
        }
        return jumps;
    }

    private static int jump_over_numbers1(List<Integer> input) {
        
        
        int pos = 0;
        //int curr_pos =0;
        int jumps = 1;
       
        while (pos < input.size()){
            //curr_pos = pos - 1;
            int temp = input.get(pos);
            //curr_pos += temp;
            if (temp == 0) return -1;
            else {
                pos += temp; 
                jumps += 1;
            }
        }
        //if (input.get(input.size() -1) == 0) return -1;
        return jumps;
    }

    private static boolean is_numeric_palindrome(long number) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        long copy = number;
    
        while (copy != 0) {
            int digit = (int)(copy % 10);
            s.push(digit);
            copy /= 10;
        }
    
        int halfWay = s.size() / 2;
        for (int i = 0; i < halfWay; i++) {
            Integer popped = s.pop();
            if (popped != number % 10) return false;
            number /= 10;
        }
        return true;
        
        
        /*
        // Write your code here
        if (number >= 0 && number < 10){
            return true;
        }
        List<Integer> list = new LinkedList<>();
        while (number > 0){
            list.add((int) number % 10);
            number = number / 10;
        }
        //if (list.size() % 2 == 0){
            int i =0;
            int j = list.size() - 1;
            while (i < j){
                if (list.get(i) == list.get (j)){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
        //}
        return true;
        */
    }
        
}
