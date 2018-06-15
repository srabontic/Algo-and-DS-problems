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
public class findNthDigit {
    /**
     * @param args the command line arguments
     */
    public static int findNthDigit1(int n) {

        int digits = 1;int start = 1; long count =9;
        //if (n <= 9) return n;
        while (n > digits * count){
            n -= digits * count;
            digits++;
            start *= 10;
            count *= 10;
        }
        
        //digit gives which digit number is it
        //start gives 10* start of that digits
        //n = remaining from start to the actual number
        start = start + (n-1)/digits;       // 10+(2-1)/2 = 10 + 0 = 10
        
        //this gives the digit in the number
        int num = (n-1)%digits;     // (2-1)%2 = 1st;
        System.out.println(num);
        System.out.println(String.valueOf(start).charAt(num));
        return Character.getNumericValue(Integer.toString(start).charAt(num));
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(findNthDigit1(20));
    }
    
}
