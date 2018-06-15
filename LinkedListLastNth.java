/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author srabo
 */
public class LinkedListLastNth {

    
    static class Node{
        int data;
        Node next;
        Node(int x){
            data =x;
            next = null;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Node head = new Node(Integer.MIN_VALUE);
        head.next = new Node(5);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(4);
        Node result = deleteLastNth(head, 4);
        System.out.println(result.data);
        
    }
    
    private static Node deleteLastNth(Node head, int N) {
        //p2 travels to n th position, p1 stays in the beginning
        //if p2.next is null retun p1 else increment p2 by one and p1 and repeat
        Node p1 = head;
        Node p2 = head;
        int n = 1;
        while (n!=N){
            p2 = p2.next;
            n++;
        }
        while(p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
       
    }

    
}
