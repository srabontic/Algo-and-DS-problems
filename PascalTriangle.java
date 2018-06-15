/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author srabo
 */
public class PascalTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> res = getRow(4);
        for (Integer i: res){
            System.out.println(i);
        }
    }
    public static List<Integer> getRow(int rowIndex) {
      Integer[] result =  new Integer[rowIndex + 1];
      Arrays.fill(result, 0);
      result[0] = 1;
      for(int i = 1; i < rowIndex + 1; i++)
        for(int j = i; j >= 1; j--)
          result[j] += result[j - 1];
      return Arrays.asList(result);
    }
    
}
