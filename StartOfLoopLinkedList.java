/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

/**
 *
 * @author srabo
 */
public class StartOfLoopLinkedList {

    private static Node detectCycle(StartOfLoopLinkedList lst) {
        
        Node slow = lst.head;
        Node fast = lst.head;
        
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //get first element
                slow = lst.head;
                while (slow != null && fast != null){
                    slow = slow.next;
                    fast = fast.next;
                    if (slow == fast){
                        return slow;
                    }
                }
                
            }
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    Node head, tail;
    
    class Node{
        int element;
        Node next;
        
        Node(int a){
            this.element = a;
            this.next = null;
        }
    }
    
    public void add(int data){
        if (head == null){
            Node new_node = new Node(data);
            head.next = new_node;
            tail = head;
        }else{
            tail.next = new Node(data);
            tail = tail.next;     
        }
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        StartOfLoopLinkedList lst = new StartOfLoopLinkedList();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.head.next.next.next.next.next = lst.head.next.next.next;
       // SinglyLinkedList.Entry result = detectCycle(head);
 
    }
    
}
