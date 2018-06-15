/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopt1;

/**
 *
 * @author srabonti
 */
public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {

    /**
     * @param args the command line arguments
     */
    public void merge(SortableList<T> list) {
        
        this.printList();
        list.printList();
        SortableList<T>.Entry<T> head;
        
        
        System.out.println("this header: "+ this.header.next.element);
        System.out.println("list header: "+ list.header.next.element);
        if (this.header.next.element.compareTo(list.header.next.element) < 0){
            head = this.header.next;
        }
        else{
            head = list.header.next;
            //list = this;
            list.header.next = this.header.next;
            this.header.next = head;
        }
       this.printList();
       list.printList();
        
        SortableList<T>.Entry<T> leftCurr = this.header.next;
        SortableList<T>.Entry<T> rightCurr = list.header.next;
        
        System.out.println("leftCurr: "+ leftCurr.element);
        System.out.println("rightCurr: "+ rightCurr.element);
        head = leftCurr;
        System.out.println("Head1: "+ head.element);
        if (head.next != null)
        System.out.println("Head2: "+ head.next.element);
        //if (head.next.next != null)
        //System.out.println("Head3: "+ head.next.next.element);
        //while()
        //while(leftCurr.next != null){
        while(leftCurr != null){
            //if (leftCurr.next.element.compareTo(rightCurr.element) > 0){
            if (leftCurr.element.compareTo(rightCurr.element) > 0){
                /*SortableList<T>.Entry<T> temp = leftCurr.next;
                leftCurr.next = rightCurr;
                rightCurr = temp;*/
                SortableList<T>.Entry<T> temp = leftCurr;
                leftCurr = rightCurr;
                rightCurr = temp;        
            }
            leftCurr = leftCurr.next;
        }
        System.out.println("Head1: "+ head.element);
        if (head.next != null)
        System.out.println("Head2: "+ head.next.element);
        
        //if (leftCurr.next == null){
        if (leftCurr == null){
            //leftCurr.next = rightCurr;
            leftCurr = rightCurr;
        }
        
        this.header = head;     
    }
    void mergeSort() {
        mergeSort(this);
        System.out.println("after divide");
        
    }
    
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> lst) {
        
        if (lst.header == null || lst.header.next == null){
            return;
        }
        int countElements = 0;
        SortableList<T>.Entry<T> temp = lst.header;
        while( temp.next != null){
            countElements++;
            temp = temp.next;
        }
        //System.out.println("--"+countElements);
        
        if (countElements == 1){
            return;
        }
        int mid = countElements/2;
        
        SortableList<T>.Entry<T> currNode = lst.header;
        SortableList<T>.Entry<T> left = lst.header.next;
        SortableList<T>.Entry<T> right = null;
        SortableList<T>.Entry<T> next = null;
        
        int itr =0;
        
        //add left header to left list
        SortableList<T> leftLst = new SortableList<>();
        SortableList<T> rightLst = new SortableList<>();
        
        while(itr < mid){
            leftLst.add(left.element);
            next = left.next;
            left = next;
            itr++;
        }
       
        right = left;
        while(right != null){
           rightLst.add(right.element);
           next = right.next;
           right = next;
        }
        /*System.out.println("left list");
        leftLst.printList();
        
        System.out.println("right list");
        rightLst.printList();*/
        
        mergeSort(leftLst);
        mergeSort(rightLst);
        
        leftLst.merge(rightLst);
        
        System.out.println("sorted list");
        leftLst.printList();
        
         
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SortableList<Integer> lst = new SortableList<>();
        lst.add(2);
        lst.add(1);
        lst.add(4);
        lst.add(3);
        lst.add(8);
        
        /*for(int i=1; i<=10; i++) {
            lst.add(new Integer(i));
        }*/
        //lst.printList();
        lst.mergeSort();
    }
    
}
