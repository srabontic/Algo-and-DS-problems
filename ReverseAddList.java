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
public class ReverseAddList {

    
    /**
     * @param args the command line arguments
     */
    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    
    private static Node getSum(Node head1, Node head2) {
        int rem =0;
        Node head = head1;
        if (head1 == null && head2 == null) return null;
        while (head1.next != null){
            if (head2.next != null){
                int temp = head1.next.data + head2.next.data + rem;
                head1.next.data = temp % 10;
                if (temp >= 10) rem =1;
                else rem =0;
                head1 = head1.next;
                head2 = head2.next;
            }else{
                int n = head1.next.data + rem;
                head1.next.data = n % 10;
                if (n > 10) rem =1;
                else rem =0;
                head1 = head1.next;
            }
        }
        while (head2.next != null){
            int n = head2.next.data + rem;
            head1.next = new Node(n % 10);
            if (n > 10) rem =1;
            else rem =0;
            head1 = head1.next;
        }
        //reverse list head
        Node next = null;
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        
        return head;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Node head1 = new Node(Integer.MIN_VALUE);
        head1.next = new Node(3);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(5);
        Node head2 = new Node(Integer.MIN_VALUE);
        head2.next = new Node(5);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(2);
        Node head = getSum(head1, head2);
        while(head.next != null){
            System.out.print(head.next.data+" ");
            head = head.next;
        }
    }
    
}
