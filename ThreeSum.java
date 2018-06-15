/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author srabo
 */
public class ThreeSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list: res){
            for(Integer I: list){
                System.out.print(I+ "  ");
            }
            System.out.println();
        }
        
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i=0,k=nums.length-2;
        int sum = 0;
        for (int r=nums.length-1; r>=0; r--){
            i=0;k=r-1;
            while(i<k){
                sum = nums[r]+nums[k]+nums[i];
                if (sum < 0){
                    i++;
                }else if (sum >0){
                    k--;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[r]); list.add(nums[k]); list.add(nums[i]);
                    res.add(list);
                    k--; i++;
                    //r--;
                    //continue;
                }
            }
        }
        return res;
    }
    
}
