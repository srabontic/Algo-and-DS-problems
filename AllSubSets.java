/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;

/**
 *
 * @author srabo
 */
public class AllSubSets {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        ArrayList<ArrayList<Integer>> result = getAllSubSets(input, 0);
        for (ArrayList<Integer> subset : result) {
            for (Integer s : subset) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println("------------------");
        getAllSubSetsBitOp(input);
    }

    //when index is zero create empty subset
    // for each subset add 
    private static ArrayList<ArrayList<Integer>> getAllSubSets(ArrayList<Integer> input, int index) {
        ArrayList<ArrayList<Integer>> resultSubSets;
        if (input.size() == index){
            resultSubSets = new ArrayList<ArrayList<Integer>>();
            resultSubSets.add(new ArrayList<Integer>()); // Empty set
        }else{
            resultSubSets = getAllSubSets(input, index + 1);
            int item = input.get(index);
            ArrayList<ArrayList<Integer>> shortResults = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : resultSubSets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                shortResults.add(newsubset);   
            }
            resultSubSets.addAll(shortResults);
        }
        return resultSubSets;
    }
    
    //when index is zero create empty subset
    // for each subset add 
    private static void getAllSubSetsBitOp(ArrayList<Integer> input) {
        int n = input.size();
        for (int i=0; i <(1<<n); i++){
            System.out.print("{");
            for (int j=0; j< n; j++){
                if ((i & (1<<j)) > 0){
                    System.out.print(input.get(j));
                }  
            }
            System.out.println("}");
        }
    }
    
}
