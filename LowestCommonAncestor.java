/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.LinkedList;
import java.util.List;

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

public class LowestCommonAncestor {

    /**
     * @param args the command line arguments
     */
    TreeNode root;
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return findLCA(root, p, q);
    }
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> listp = new LinkedList<>();
        List<TreeNode> listq = new LinkedList<>();
        
        if (findPath(root, q, listq) || findPath(root, p, listp)){ 
            System.out.println(listp.size());
            for (int i=0; i< listp.size() && i < listq.size(); i++){
                if (listp.get(i) != listq.get(i)){
                    return listp.get(i);
                }
            }
        }
        return null;       
    }
    
    public static boolean findPath(TreeNode node, TreeNode n, List<TreeNode> l){
        //System.out.println(root.val);
        if (node == null) return false;
        l.add(node);
        if (node.val == n.val) return true;
        if (node.left != null && findPath(node.left, n, l)) return true;
        if (node.right != null && findPath(node.right, n, l)) return true;
        return false;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        LowestCommonAncestor bT = new LowestCommonAncestor();
        bT.root = new TreeNode(3);
        bT.root.left = new TreeNode(5);
        bT.root.right = new TreeNode(1);
        bT.root.left.left = new TreeNode(6);
        bT.root.left.right = new TreeNode(2);
        bT.root.left.right.left = new TreeNode(7);
        bT.root.left.right.right = new TreeNode(4);
        bT.root.right.left = new TreeNode(0);
        bT.root.right.right = new TreeNode(8);
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(6);
        //System.out.println(bT.root.val);
        TreeNode t = lowestCommonAncestor(bT.root,p, q);
        System.out.print(t.val);
    } 
}
