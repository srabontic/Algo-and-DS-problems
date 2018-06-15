/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author srabo
 */
class Tree<T extends Comparable<? super T>>{

    Tree left;
    Tree right;
    String code;
    Double element;
    public Tree(double x){
        left = null;
        right = null;
        code = "";
        element = x;
    }
}
class comparator<T extends Comparable<? super T>> implements Comparator<Tree>{

	@Override
	public int compare(Tree arg0, Tree arg1) {
		// TODO Auto-generated method stub
		return arg0.element.compareTo(arg1.element);
	}
	
}
public class HuffmanCoding {
    
    public static void main(String[] args) {
        //enter each element as tree in a priority queue
        Double [] x={0.05,0.05,0.2,0.35,0.05,0.3};
        PriorityQueue<Tree> pq = new PriorityQueue<>(10,new comparator());
        //enter all probabilities to the pq
        for(double k:x)
        {
            Tree t = new Tree(k);
            pq.add(t);
        }
        //create the final tree 
        Tree t=null;
        for (int i=0; i< x.length-1; i++){
            t=new Tree(0.0);
            Tree left = pq.remove();
            Tree right = pq.remove();
            double sum = left.element +right.element;
            t.element = sum;
            t.left = left;
            t.right = right;
            pq.add(t);
        }
        //read the final tree in an tree element
        //Tree tree = pq.remove();
        preorder(t);
        
    }

    private static void preorder(Tree root) {
        if(root!=null)
        {
            if(root.left!=null)
            {
                root.left.code=root.left.code.concat(root.code).concat("0");
            }
            if(root.right!=null)
            {
                root.right.code=root.right.code.concat(root.code).concat("1");
            }
            preorder(root.left);
            preorder(root.right);	
            //System.out.println("infinte ");
        }
    }
    
}
