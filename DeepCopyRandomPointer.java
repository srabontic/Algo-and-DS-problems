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
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
}

public class DeepCopyRandomPointer {

    public static void main(String[] args) {
        // TODO code application logic here
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next = new RandomListNode(3);
        head.next = new RandomListNode(4);
        RandomListNode res = copyRandomList(head);
    }

    private static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode storehead = head;
        RandomListNode curr = head;
        //make 1->2->3 to 1->1'->2->2'->3->3'
        while(curr.next != null){
            RandomListNode temp = new RandomListNode(head.label);
            temp.next = head.next;
            head.next = temp;
            curr = curr.next;
        }
        curr = storehead;
        //make the random pointers point for new nodes
        while(curr != null && curr.next.next != null){
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        //extract the original list and get the new list
        curr = storehead;
        RandomListNode copyHead = new RandomListNode(0);
        RandomListNode copy , copyCurr = copyHead;
        RandomListNode next;
        while(curr != null){
            //take out original list
            next = curr.next.next;
            //before you write the next two lines remove the new nodes from the nmiddle of curr and curr next
            //curr.next = next;
            //curr = next;
            
            //take out new list
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;
            
            //the move the original list pointers forward
            curr.next = next;
            curr = next;
        }
        return  copyHead.next; 
    }
    
}
