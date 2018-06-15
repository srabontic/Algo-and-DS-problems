/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author srabo
 */
public class MergeKSortedLists {

    private ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new ListComparator());
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        //for (ListNode l:lists){
        for (int i=0; i< lists.length; i++){
            ListNode l = lists[i];
            if (l != null){
                System.out.print(l.val+ "  ");
                pq.add(l);
            }
        }
        System.out.println();
        //when all the first elements are in the pq poll the highest priority one 
        //and add the next element
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            
            if (tail.next != null){
                pq.offer(tail.next);
            }
        }
        return dummy.next;
    }
    
    public class ListComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
        }  
    } 

    /**
     * @param args the command line arguments
     */
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode head1 = obj.new ListNode(1);
        head1.next = obj.new ListNode(4);
        head1.next.next = obj.new ListNode(7);
        ListNode head2 = obj.new ListNode(2);
        head2.next = obj.new ListNode(5);
        head2.next.next = obj.new ListNode(8);
        ListNode head3 = obj.new ListNode(3);
        head3.next = obj.new ListNode(6);
        head3.next.next = obj.new ListNode(9);
        ListNode[] lists = {head1.next, head2.next, head3.next};
        ListNode head = obj.new ListNode(-1);
        head = obj.mergeKLists(lists); 
        while(head.next != null){
            System.out.print(head.next.val+ "  ");
        }
    }
    
}
