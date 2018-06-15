/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author srabo
 */
public class QueueUsingStack {

    Deque<Integer> dq;
    /** Initialize your data structure here. */
    public QueueUsingStack() {
        dq = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        dq.add(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int val = dq.getLast();
        dq.removeLast();
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        return dq.getLast();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        int count =0;
        Iterator it = dq.iterator();
        while(it.hasNext()){
            count++;
        }
        if (count ==0) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        QueueUsingStack obj = new QueueUsingStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
    
}
