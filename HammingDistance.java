/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

/**
 *
 * @author srabo
 */
public class HammingDistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 4;
        int y = 1;
        int distance = hammingDistance(x, y) ;
        System.out.println(distance);
    }

    private static int hammingDistance(int x, int y) {
        int[] s1 = binaryValue(x);
        int[] s2 = binaryValue(y);
       
        
        int distance =0;
        for (int i=0; i< s1.length; i++){
            if (s1[i] != s2[i])
                distance ++;
        }
        return distance;
    }

    private static int[] binaryValue(int x) {
        int index =0;
        int [] binary = new int[31];
        while(x >0){
            binary[index++] = x%2;
            x = x/2;
        }
        return binary;
    }
    
}
