/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class CutOffTrees {

    /**
     * @param args the command line arguments //[[1,2,3], [0,0,4], [7,6,5]];
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<List<Integer>>  forest = new ArrayList<List<Integer>> ();  
        List<Integer> l = new ArrayList<Integer>(); l.add(1); l.add(2); l.add(3);
        forest.add(l);   
        List<Integer> l1 = new ArrayList<Integer>(); l1.add(0); l1.add(0); l1.add(4);
        forest.add(l1);   
        List<Integer> l2 = new ArrayList<Integer>(); l2.add(7); l2.add(6); l2.add(5);
        forest.add(l2);
        int result = cutOffTree(forest);
        System.out.println(result);
        
    }
    
    static class point{
        int x;
        int y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int cutOffTree(List<List<Integer>> forest) {
        Map<Integer,point> map = new HashMap<>();
        int numList =0;
        int numInteger =0;
        int steps =0;
        //keep non zero and non one values in sorted order in which they must be accessed
        for(List<Integer> l : forest){
            numInteger =0;
            for (Integer i : l){
                if (i>1){
                    map.put(i, new point(numList, numInteger));
                }
                numInteger++;
            }
            numList++;
        }
        //count the steps from start to nodes in map and increment steps
        point start = new point(0, 0); //initial start position
        for (Integer m : map.keySet()){
            steps += getMinPath(start, m, map.get(m), forest);
            //System.out.println("next start location: "+ start.x +"  " +start.y);
            //System.out.println("path length each time:  "+steps);
        }
        return steps;
    }
    
    //get min path from start to point>1
    private static int getMinPath(point start, Integer m, point m_location, List<List<Integer>> forest) {
        int path_length =0;
        int cols = forest.size();
        int rows = forest.get(0).size();
        Queue<point> q = new LinkedList<>();
        boolean[][] visited = new boolean [forest.size()][forest.get(0).size()];
        q.add(start);
        while(!q.isEmpty()){
            point node = q.poll();
            path_length++;
            visited[node.x][node.y] = true;
            //if (node.x < )
            if (m_location.x == node.x && m_location.y == node.y+1) { 
                //start = new point(node.x,node.y+1 ); 
                start.x = node.x; start.y = node.y +1;
                return path_length;
            }
            else if (m_location.x == node.x+1 && m_location.y == node.y) {
                //start = new point(node.x+1,node.y); 
                start.x = node.x+1; start.y = node.y;
                return path_length;
            }
            if (node.y + 1 < cols && visited[node.x][node.y+1] != true){
                q.add(new point(node.x, node.y+1));
            }
            if (node.x + 1 < rows && visited[node.x+1][node.y] != true){
                q.add(new point(node.x+1, node.y));
            }
            
        }
        
        return path_length;
    }
    
}
