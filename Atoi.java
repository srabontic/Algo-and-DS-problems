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
public class Atoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String str = "      -123456789";
        String str = "1";
        int res = myAtoi(str);
        System.out.print(res);
    }

    private static int myAtoi(String str) {
        int index =0; int sign = 1, total =0;
        //if emtpy string return 0
        if (str.length() == 0) return 0;
        
        //remove first spaces
        while(str.charAt(index) == ' ' && index < str.length()){
            index++;
        }
        
        //handle sign
        if (str.charAt(index)== '+' || str.charAt(index) == '-'){
            sign = (str.charAt(index) =='+')? +1 : -1;
            index++;
        }
        
        //convert number and avoid overflow 
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            
            //check if total will be overflown after multiplying with 10 times and adding digit
            if (Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/ 10 == total && Integer.MAX_VALUE %10 < digit){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10*total + digit;
            index++;
         
        }
        return total*sign;
    }
    
}
