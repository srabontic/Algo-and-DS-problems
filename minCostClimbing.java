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
public class minCostClimbing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] cost = {0,1,1,0};
        int result = minCostClimbingStairs(cost);
        System.out.print(result);
    }

    private static int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        if (cost[0]>cost[1]){
         first = cost[1];
        }
        int result = first;
        int a = cost[0];
        int b = cost[1];
        for (int i=2; i<= cost.length;i++){
            if (i==cost.length) result = Math.min(a,b);
            else{
                result = Math.min(a,b)+cost[i];
                a=b;
                b=result;
            }
        }
        return result;
    }
    private static int minCostClimbingStairs1(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        int result = Math.min(a, b);

        for (int i = 2; i <= cost.length; i++) {
            int c = i == cost.length? 0: cost[i];
            result = Math.min(a + c, b + c);
            a = b;
            b = result;
        }

        return result;
    }
}
