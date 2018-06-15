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
public class DeepCopyList {

    /**
     * @param args the command line arguments
     */
    static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RandomListNode node = new RandomListNode(1);
        RandomListNode head = node;
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.random = node.next.next;
        node.next.random = node.next.next;
        RandomListNode result = copyRandomList(head);
        while(result.next != null){
            System.out.print(result.label+"   ");
        }
    }
    
    private static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode itr = head;
        RandomListNode next_itr = head;
        
        //change the next pointer of itr
        while(itr != null){
            next_itr = itr.next;
            RandomListNode new_node = new RandomListNode(itr.label);
            itr.next = new_node;
            new_node.next = itr.next;
            itr = next_itr;
        }
        System.out.println(500);
        //assign random of new list
        itr = head;
        while(itr != null){
            if (itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        System.out.println(600);
        //restore the old list and take out new list
        itr = head;
        RandomListNode pHead = new RandomListNode(0);
        RandomListNode copy, copyItr = pHead;
        
        while (itr != null){
            next_itr = itr.next.next;
            
            //extract copy
            copy = itr.next;
            copyItr.next = copy;
            copyItr = copy;
            
            itr.next = next_itr;
            itr = next_itr;
              
        }
        System.out.println(700);
        return pHead.next;
    }
     
}
