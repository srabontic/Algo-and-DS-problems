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
public class MinStackLinkedList {

    /**
     * @param args the command line arguments
     */
    int min = Integer.MAX_VALUE;
    LinkedList<Integer> list;
    public MinStackLinkedList() {
        //LinkedList<Integer> list = new LinkedList<>();
        list = new LinkedList<>();
    }
    //LinkedList<Integer> list = new LinkedList<>();
    
    public void push(int x){
       list.add(x);
       if (x < min){
           min = x;
       }
    }
    public int top(){
        return list.getLast();
    }
    public int pop(){
        int result = list.getLast();
        list.removeLast();
        if (result == min){
            min = Integer.MAX_VALUE;
            for (int x: list){
                if (x < min){
                    min = x;
                }
            }
        }
        return result;
    }
    public int getMin(){
        return this.min;
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        MinStackLinkedList minStack = new MinStackLinkedList();
        /*
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin()); //0
        minStack.pop();
        System.out.println(minStack.getMin()); //0
        minStack.pop();
        System.out.println(minStack.getMin()); //0
        System.out.println("popped" +minStack.pop());
        //System.out.println("popped" +minStack.pop());
        System.out.println(minStack.getMin());  //2
        
    }
    
}
