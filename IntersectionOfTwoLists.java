/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.LinkedList;

/**
 *
 * @author srabo
 */
public class IntersectionOfTwoLists {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a!=b){
            if (a == null){
                a = headB;
            }else{
                a = a.next;
            }
            
            if (b == null){
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }

    /**
     * @param args the command line arguments
     */
    ListNode headA;
    ListNode headB;
    
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<ListNode> list1 = new LinkedList<>();
        LinkedList<ListNode> list2 = new LinkedList<>();
       
        list1.addLast(new ListNode(1));
        list1.addLast(new ListNode(2));
        list1.addLast(new ListNode(3));
        list1.addLast(new ListNode(4));
        list1.addLast(new ListNode(5));
       
        for(ListNode l : list1){
            System.out.println(l.val);
        }
        
        list2.addLast(new ListNode(6));
        list2.addLast(new ListNode(7));
        list2.addLast(new ListNode(8));
        list2.getLast().next = list1.get(2);
        for(ListNode l : list2){
            System.out.println(l.val);
        }
        
        ListNode headA = list1.getFirst();
        ListNode headB = list2.getFirst();
        
        ListNode n = getIntersectionNode( headA,  headB);
        
        System.out.println(n.val);
  
    }
    
    
}
