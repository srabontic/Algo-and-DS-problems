/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srabo
 */
public class RightSideView {

    /**
     * @param args the command line arguments
     */
    static TreeNode root;

    
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        // TODO code application logic here
        RightSideView r = new RightSideView();
        root = new TreeNode(1);
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        root.left.right = new TreeNode (5);
        root.right.right = new TreeNode (4);
        List<Integer> result = rightSideView(root);
        for (Integer i: result)
            System.out.print(i);
  
    }
    
    private static List<Integer> rightSideView(TreeNode root) {
        TreeNode node = root;
        List<Integer> l = new ArrayList<Integer> ();
        rec(root, 0, l);
        return l;
    }
    private static void rec(TreeNode root, int level, List<Integer> l) {
        if (root == null) return;
        if (level == l.size()) l.add(root.val);
        rec(root.right, level+1, l);
        rec(root.left,level+1, l);
    }

    
    
}
