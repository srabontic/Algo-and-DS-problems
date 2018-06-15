/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author srabo
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.print(result[0]+ "   "+ result[1]);
        
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i< arr.length; i++){
            if (map.containsKey(target - arr[i])){
                return new int[] {i, map.get(target - arr[i])};
            }else{
                map.put(arr[i], i);
            }
        }
        return null;
    }
    
}
