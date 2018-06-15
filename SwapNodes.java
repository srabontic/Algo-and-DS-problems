/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author srabo
 */
public class SwapNodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int nodesNum = in.nextInt();
        Node root = new Node(1);
        root.depth = 0;
        int nodesNum1 = nodesNum-1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (nodesNum1 > 0){ //when number of nodes input > 0 and 
            //the first node in q is > -1
            Node n = q.poll();
            if (n.element != -1){
                int l = in.nextInt();
                int r = in.nextInt();
                if (l != -1) nodesNum1--;
                if (r != -1) nodesNum1--;
                Node leftNode = new Node(l);
                leftNode.depth = n.depth+1;
                Node rightNode = new Node(r);
                rightNode.depth = n.depth+1;
                n.left = leftNode;
                n.right = rightNode;
                q.add(leftNode);
                q.add(rightNode);
            }
            //System.out.print(nodesNum1);
        }
        //List<Integer> list = new ArrayList<>();
        //int swapTimes=0;
        while(in.nextInt() == -1){
            int data = in.nextInt();
        }
        int swapTimes = in.nextInt();
        System.out.println("swapTimes:  "+ swapTimes);
        int[] swaps = new int[swapTimes];
        Queue<Integer> s = new LinkedList<>();
        int i=0;
        while (i!=swapTimes-1){
           swaps[i] = in.nextInt();
           s.add(in.nextInt());
           i++;
        }
        Node newRoot = getSwapped(q, root, swaps, s);
        printInOrder(root);
    }
    //this function swaps the nodes
    private static Node getSwapped(Queue<Node> q, Node root, int[] swaps, Queue<Integer> s) {
        //print the tree by DFS
        printInOrder(root);
        //level order traverse the tree and if node.depth == swaps
        //For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree.
        int n = 0;
        Node node = root;
        Queue<Node> qq = new LinkedList<>();
        qq.add(node);
        while(node != null){
            //get nodes in swaps[i] depth
            Node nd = qq.poll();
            if (nd.depth > s.peek()){
                s.poll();
            }
            if (nd.depth == s.peek()){
               int temp = nd.left.element;
               nd.left.element = nd.right.element;
               nd.right.element = temp;
            }
            
            qq.add(nd.left);
            qq.add(nd.right);     
        }
        return root;
    }

    private static void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        if (node.element > -1) System.out.print(node.element + " ");
        printInOrder(node.right);
    }

    
    static class Node{
        int element;
        Node left;
        Node right;
        int depth;
        Node(int x){
            element = x;
        }
    }
    
}
