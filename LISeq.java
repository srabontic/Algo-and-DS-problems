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
public class LISeq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> sequence = new ArrayList<>();
        sequence.add(16);
        sequence.add(3);
        sequence.add(5);
        sequence.add(19);
        sequence.add(10);
        sequence.add(14);
        sequence.add(12);
        sequence.add(0);
        sequence.add(15);
        List<Integer> result = longest_increasing_subsequence(sequence);
        System.out.println();
                
    }

    private static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
        
        int seqCount[] = new int [sequence.size()];
        for (int k =0; k< sequence.size(); k++){
            seqCount[k] = 1;
        }
        List<Integer> result = new ArrayList<Integer> ();
        int i =1;
        int p[] = new int [sequence.size()]; //holds the index of previous number
        for (int k =0; k< p.length; k++){
            p[k] = -1;
        }
        //int j =0;
        while (i< sequence.size()){
            for (int j=0; j< i ; j++){
                if (sequence.get(i) > sequence.get(j)){ 
                    seqCount[i] = Integer.max(seqCount[i] , seqCount[j] + 1);
                    p[i] = j;
                }
            }
            i++;
        }
        int max =0;
        int pos =0;
        for (int k=0; k< sequence.size(); k++){
            if (max < seqCount[k]){
                max = seqCount[k]; 
                pos = k;
            }
        }
        //System.out.println(max);
        //int best_index = 
        result = getLIS(max,sequence, seqCount, pos);  //pos - 1  is the index
        
        return result;
    }

    private static List<Integer> getLIS(int max, List<Integer> sequence, int []p, int pos) {
        List<Integer> result = new ArrayList<Integer> ();
       
        int curr = max;
        for (int i = p.length - 1; i > 0 ; i--){
            if (p[i] == curr){
                System.out.print(sequence.get(i)+ " ");
                curr --;
            }
        }
        
        return result;
    }
  
}
