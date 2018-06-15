/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mspractice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srabo
 */
public class lexographicNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 100;
        List<String> result = new ArrayList<>();
        sort_the_files(n, result);
        for (String s: result){
            System.out.println(s);
        }
    }

    private static void sort_the_files(int n, List<String> result) {
        addFile(n, result, "",1);   
    }

    private static void addFile(int n, List<String> result, String prefix, int firstDigit) {
        for (int i = firstDigit; i<= 9; i++){
            String current = prefix + i;
            if (result.size() == 1000 || Integer.parseInt(current) > n) return;
            result.add("IMG" + current + ".jpg");
            addFile(n, result, current, 0);
            
        }
    }
    
}
