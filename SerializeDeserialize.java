/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class SerializeDeserialize {

    
    
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            sb.append(node.val).append(",");
            if (node.left!=null) q.add(node.left);
            if (node.right!=null) q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //recursively devide from mid
        if (data == null) return null;
        if (data.length() == 0) return null;
        String[] c = data.split(",");
        int start = 0;
        int end = c.length -1;
        TreeNode r = makeBST(c, start, end);
        return r;
    }
    
    private static TreeNode makeBST(String[] c, int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(Integer.parseInt(c[mid]));
        node.left = makeBST(c, start, mid -1);
        node.right = makeBST(c, mid+1, end);
        return node;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RightSideView r = new RightSideView();
        TreeNode root;
        root = new TreeNode(2);
        root.left = new TreeNode (1);
        root.right = new TreeNode (3);
        
        String s = serialize( root);
        System.out.println(s);
        TreeNode node = deserialize(s);
        System.out.println(node.val);
        
        
  
    }
}
