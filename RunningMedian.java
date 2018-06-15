/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author srabo
 */
public class RunningMedian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int i=0;
        SortedSet<Integer> set = new TreeSet<>();
        while(i != num){
            set.add(in.nextInt());
            int n = set.size();
            if (n%2 == 0){
                //even
                double mid = (double) ((int) set.toArray()[n/2]+ (int) set.toArray()[(n/2)-1])/2;
                //double avg = set.toArray()[]
                System.out.println(mid);
            }else{
                System.out.println(set.toArray()[n/2]);
            }
            i++;
        }
        
    }
    
}
