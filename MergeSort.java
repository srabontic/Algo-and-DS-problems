/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopt1;

import java.lang.*;
import java.util.Random;

/**
 *
 * @author srabonti
 */
public class MergeSort<T>{
    
    /**
     * @param args the command line arguments
     */
    /*public int compareTo(Object other){
        return this.compareTo(other);
    }*/
    
    public static<T extends Comparable<? super T>> void MergeSort(T[] A, int p, int r) {
    //public static<T extends Comparable<T>> void MergeSort(T[] A, int p, int r) {
        int q =0;
        if (p< r){
            q = (p+r)/2;
            MergeSort(A, p, q);
            MergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
         
    }
    
    //q = mid
    private static <T extends Comparable<? super T>> void merge(T[] A, int p, int q, int r) {
        int n1 = q - p +1;
        //int n1 = q - p;
        int n2 = r - q;
        
        /*System.out.println("n1 " +n1);
        System.out.println("n2 " +n2);
        for (int i=0; i< A.length; i++){
            System.out.println(A[i]);
        }*/
        
        T[] L = (T[])new Comparable[n1];
        T[] R = (T[])new Comparable[n2];
        
        System.arraycopy(A, p, L, 0, n1);
        //System.arraycopy(A, p, L, 0, n1);
        System.arraycopy(A, q+1, R, 0, n2);
        /*System.out.println("L");
        for (int i=0; i< L.length; i++){
            System.out.println(L[i]);
        }
        System.out.println("R");
        for (int i=0; i< R.length; i++){
            System.out.println(R[i]);
        }*/    /////display
        
        //int i= p;
        //int j = q+1;
        int i=0;
        int j=0;
        int k = p;
        //while(i<= q && j<= r){
        while(i< n1 && j< n2){
            if (L[i].compareTo(R[j]) <= 0){
                A[k] = L[i++];
            }else{
                A[k] = R[j++];
            }
            k++;
        }
        
        /*if(i<= n1 && j> n2){
            while(i<=n1){
                A[k] = L[i++];
                k++;
            }
        }else{
            while(j< n2){
                A[k] = R[j++];
                k++;
            }
        }*/
        while(i<n1){
                A[k] = L[i];
                i++;
                k++;
        }
        while(j<n2){
            A[k] = R[j++];
            k++;
        }
        
        
        /*System.out.println("interim A");
        for (int m=0; m< A.length; m++){
            System.out.println(A[m].toString());
        }  
        System.out.println("end");*/    //// display
            
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*Integer[] a = new Integer[5];
        a[0] = new Integer(2);
        a[1] = new Integer(1);
        a[2] = new Integer(4);
        a[3] = new Integer(3);
	a[4] = new Integer(8);*/
        Timer timer = new Timer();
        timer.start();
        
        Integer[] a = new Integer[1000000];
        Random rand = new Random();
        //double d = Math.random()*50;
        //System.out.println(d);
        //int i = (int) d;
        //System.out.println(i);
        double d;
        int in;
        for(int x = 0; x < 1000000; x++){
            d =   Math.random()*50;
            in = (int) d;
            a[x] = in;
        }
        
        MergeSort(a, 0, a.length-1);
        
        timer.end();
        
        /*for (int i=0; i< a.length; i++){
            System.out.println(a[i].toString());
        }*/
        System.out.println(timer);
        
    }

    
}
