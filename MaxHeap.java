/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author srabo
 */
public class MaxHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
 
        MaxHeap ob = new MaxHeap();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        for (int j =0; j< n; j++){
           System.out.print(arr[j]+"  "); 
        }
    }

    private void sort(int[] arr) {
        //1. build a max heap
        //2. remove max from heap
        //3. call max heapify on the remaining heap
        int n = arr.length;
        for (int i = (n/2)-1 ; i > 0; i--){
            maxHeapify(arr, i);
        }
        //remove max element and print
        for (int j =n-1; j>=0; j--){
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            
            maxHeapify(arr, j);
            //System.out.print(arr[j]+"  ");
        }
        System.out.println();
    }

    private void maxHeapify(int[] arr, int i) {
        //i has 2 children 2i and 2i+1
        //i i has parent at floor (i/2)
        //compare i with left child and ecide largest
        //compare largest with right, update largest
        //swap the larest to root and move i to largest and recurse
        int n = arr.length;
        int l = 2*i;
        int r = 2*i +1;
        int largest = i;
        if (l<n && arr[i] < arr[l]){
            largest =l;
        }else{
                largest =i;
        }
        if (r<n && arr[largest] < arr[r]){
            largest =r;
        }
        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest);
        }  
    }
}
