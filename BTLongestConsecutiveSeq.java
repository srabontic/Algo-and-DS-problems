/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.LinkedList;
import java.util.Queue;
import mspractice.BTConnNodes;

/**
 *
 * @author srabo
 */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    class Node{
        TreeNode t;
        int length;
        Node(TreeNode t, int l){
            this.t = t;
            this.length = l;
        }
    }
public class BTLongestConsecutiveSeq {

    private static int getLongestCosecutiveSeq(TreeNode root) {
        Queue<Node> q =  new LinkedList<>();
        q.add(new Node(root, 1));
        int max = 1;
        while(!q.isEmpty()){
            Node nd = q.poll();
            TreeNode tn = nd.t;
            int size = nd.length;
            if (tn.left != null){
                int left = size;
                if (tn.left.val == tn.val+1){
                    left++;
                    max = Math.max(max, left);   
                }else{
                    left = 1;
                }
                q.add(new Node(tn.left, left));
            }
            if (tn.right != null){
               int right = size;
                if (tn.right.val == tn.val+1){
                    right++;
                    max = Math.max(max, right);   
                }else{
                    right = 1;
                }
                q.add(new Node(tn.right, right));
            }
        }
        return max;
    }

    
    TreeNode root;
    public static void main(String[] args) {
        // TODO code application logic here
        BTLongestConsecutiveSeq bT = new BTLongestConsecutiveSeq();
        bT.root = new TreeNode(1);
        bT.root.left = new TreeNode(2);
        bT.root.right = new TreeNode(4);
        bT.root.left.left = new TreeNode(3);
        bT.root.right.left = new TreeNode(5);
        bT.root.right.right = new TreeNode(6);
        bT.root.right.right.left = new TreeNode(7);
        int res = bT.getLongestCosecutiveSeq(bT.root);
        System.out.println(res);
        
    }
    
}
