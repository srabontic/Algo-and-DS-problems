/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author srabo
 */
public class SimplifyPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "/a/.//b/../../c/";
        String res = simplifyPath(s);
    }

    private static String simplifyPath(String st) {
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        Deque<String> stack = new LinkedList<>();
        String[] s = st.split("/+");
        for (String dir : s){
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir: stack) res = "/"+dir+res;
        if (res.isEmpty()) return "/";
        else return res;
    }
    
}
