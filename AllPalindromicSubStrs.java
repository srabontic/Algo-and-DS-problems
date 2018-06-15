/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

/**
 *
 * @author srabo
 */
public class AllPalindromicSubStrs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        countSubstrings("abaaa");
    }
    
    
    public static int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                System.out.println(left + "  " + right);
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
    
}
