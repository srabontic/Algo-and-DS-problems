/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author srabo
 */
public class maxSlidingWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1,3,-1,-3,5,3,6,7};
        //int [] nums = {};
        int k = 3;
        int[] result = maxSlidingWindow2(nums, k);
        for (int i = 0; i< result.length; i++)
            System.out.println(result[i]);
    }

    private static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length ==0) return null;
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int count =0;
        int temp_max =0;
        for (int i=0; i< nums.length; i++){
            if (q.size() == k){
                //result[count] = Collections.max(q);
                if (nums[i] > temp_max){
                    temp_max = nums[i];
                }
                result[count] = temp_max;
                q.poll();
                count++;
            }
            q.add(nums[i]);
            if (nums[i] > temp_max){
                temp_max = nums[i];
            }
        }
        result[count] = Collections.max(q);
        q.poll();
        return result;
    }
    
    public static int[] maxSlidingWindow2(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
    
}
