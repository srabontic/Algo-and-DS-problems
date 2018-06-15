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
public class maxSubArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] A) {
        /*int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        for(int i = 0; i < n; i++){
            System.out.print(dp[i]+ "  ");
        }
        return max;
        */
        int n = A.length;
        int max = A[0]; int sum = A[0];
        for (int i=1; i< n; i++){
            sum = A[i] + (sum > 0 ? sum : 0) ;
            max = Math.max(max, sum);
        }
        return max;
    }
}
