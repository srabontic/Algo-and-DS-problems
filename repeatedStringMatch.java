/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 * @author srabo
 */
public class repeatedStringMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String A = "abcabcabcabc", B = "abac";
        System.out.println(repeatedStringMatch1(A, B));
    }

    private static int repeatedStringMatch1(String A, String B) {
        int i=1;
        StringBuilder s = new StringBuilder();
        while (A.length() < B.length()){
            A = A+A;
            i++;
        }
        if (A.indexOf(B) < 0){
            A= A+A;
            if (A.indexOf(B) >=0) return i+1;
        }else{
            return i;
        }
        return -1;
    }
    
}
