/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class BTConnNodes {

    class Node{
        int element;
        Node left;
        Node right;
        Node nextRight;
        
        Node(int x){
            element =x;
            left = null;
            right = null;
            nextRight = null;
        }
        Node (int x, Node n1, Node n2){
            element =x;
            left = n1;
            right = n2;
            nextRight = null;
        }
    }
    
    Node root;
    int size =0; 
    
    private void add(int data){
        if (size ==0)
            root = new Node(data);
        else{
            Node curr = find(root, data);
            if (curr.element != data){
                Node n = new Node(data);
                if (data < curr.element){
                    curr.left = n;
                }else{
                    curr.right = n;
                }
            }
        }
        size++;
    } 
    private Node find(Node t, int x){
        Node pre = t;
        while(t!=null){
            pre = t;
            if (x == t.element){
                return t;
            }
            else if (x < t.element){
                t = t.left;
            }
            else{
            t = t.right;
            }
        }
        return pre;
    }
    
    private void connectLevelNodes(Node root){
        Queue curr = new LinkedList<Node> ();
        Queue next = new LinkedList<Node> ();
        curr.add(root);
        if (root == null){
            return;
        }
        else{
            while(!curr.isEmpty()){
                Node n =(Node) curr.peek();
                if (n.left != null){
                    n.left.nextRight = (n.right != null) ? n.right : null;
                    next.add(n.left);
                }else if (n.right != null){
                    n.right.nextRight = (n.nextRight != null) ? n.nextRight.left : null;
                    next.add(n.right);
                }
                
                if (curr.isEmpty()){
                    curr = next;
                    next = new LinkedList<Node> ();
                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
