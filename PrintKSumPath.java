/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srabo
 */
public class PrintKSumPath {

    private static void printKPath(Node root, int k) {
        List<Node> path = new ArrayList<>();
        printKPathUtils(root,k, path);
    }

    private static void printKPathUtils(Node root, int k, List<Node> path) {
        if (root == null) return;
        
        path.add(root);
        printKPathUtils(root.left, k, path);
        printKPathUtils(root.right, k, path);
        
        int temp_length =0;
        for (int i = path.size()-1; i > -1; i--){
            temp_length += path.get(i).data;
            if (k == temp_length){
                printPath(path, i);
            }
        }
        
        path.remove(path.size()-1);
    }

    private static void printPath(List<Node> path, int i) {
        //print path in list path from i to path size
        for (int j=i; j< path.size(); j++){
            System.out.print(path.get(j).data+ "  ");
        }
        System.out.println();
    }

    //path of sum k from root
    private static void printKPathRoot(Node root, int n) {
        List<Node> pathRoot = new ArrayList<>();
        int sum_so_far =0;
        printKPathRootUtils(root,n, pathRoot, sum_so_far);
    }

    private static void printKPathRootUtils(Node root, int n, List<Node> pathRoot, int sum_so_far) {
        if (root == null){
            return;
        }
        pathRoot.add(root);
        sum_so_far += root.data;
        if (sum_so_far == n){
            //print path
            for (int i=0; i< pathRoot.size(); i++){
                System.out.print(pathRoot.get(i).data+ "  ");
            }
            System.out.println();
        }
        printKPathRootUtils(root.left, n, pathRoot, sum_so_far);
        printKPathRootUtils(root.right, n, pathRoot, sum_so_far);
        
        pathRoot.remove(pathRoot.size()-1);
    }

    /**
     * @param args the command line arguments
     */
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int x){
            data =x;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        int k = 5;
        //print path from any nodes
        //printKPath(root, k);
        //print paths from root node
        printKPathRoot(root, 6);
    }
    
}
