/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 *
 * @author srabo
 */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
public class ListPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode head = new ListNode(1);
        head.next   = new ListNode(2);
        head.next   = new ListNode(3);
        head.next   = new ListNode(2);
        head.next   = new ListNode(1);
        boolean b = isPalindrome(head);
        
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow = reverse(slow); //reverse the list from slow to null
        
        //iterate reversed slow and match with each node from fast
        while(slow != null && head != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
       return true; 
    }
    
    private static ListNode reverse(ListNode head) {
        //reverse a list
        ListNode prev = null;
        while(head != null){
            ListNode temp  =  head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
}
