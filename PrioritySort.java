/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopt1;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author srabonti
 */
public class PrioritySort {

    /**
     * @param args the command line arguments
     */
    private static <T extends Comparable<? super T>> void priorityqSort(T[] A) {
        PriorityQueue<T> pq1 = new PriorityQueue<T>();
        for (T x : A) {
            pq1.add(x);
	}
        
        while (!pq1.isEmpty()) {
            Integer i = (Integer) pq1.poll();
            System.out.println(i);
        }
        System.out.println("pq1: " + pq1);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Timer timer = new Timer();
        timer.start();
        
        /*Integer[] a = new Integer[1000000];
        Random rand = new Random();
        double d;
        int in;
        for(int x = 0; x < 1000000; x++){
            d =   Math.random()*50;
            in = (int) d;
            a[x] = in;
        }*/
        
        Integer[] a = new Integer[5];
        a[0] = new Integer(2);
        a[1] = new Integer(1);
        a[2] = new Integer(4);
        a[3] = new Integer(3);
	a[4] = new Integer(8);
        priorityqSort(a);
        /*Queue<Integer> pq1 = new PriorityQueue<Integer>();
        for (Integer x: a){
            pq1.add(x);
        }
        System.out.println("pq1: " + pq1);*/
        
        /*Queue<String> pq2 = new PriorityQueue<>();
        pq2.add("4");
        pq2.add("9");
        pq2.add("2");
        pq2.add("1");
        pq2.add("5");
        pq2.add("0");
        System.out.println("pq: " + pq2);*/
        
        timer.end();
        System.out.println(timer);
    }
    
}
