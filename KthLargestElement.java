/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.PriorityQueue;

/**
 *
 * @author srabo
 */
public class KthLargestElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {3,2,1,5,6,4};
        System.out.print(findKthLargestPQ(arr, 3)); //O(N lg K) running time + O(K) memory
        
        System.out.print(findKthLargestQuick(arr, 3));
        
        
        
    }

    private static int findKthLargestPQ(int[] arr, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);
        for(int el : arr) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }
        return largeK.poll();
    }

    private static int findKthLargestQuick(int[] nums, int k) {
        k = nums.length - k;
        int lo =0;
        int hi = nums.length -1;
        while(lo< hi){
            int j = partition(nums, lo, hi);
            if (j < k){
                lo = j+1;
            }else if (j > k){
                hi = j -1;
            }else{
                break;
            }  
        }
        return nums[k];  
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi, pivot = nums[hi];
        while(i<j){
            i++;
            if (i>pivot){
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        return i-lo+1;
        
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
}
