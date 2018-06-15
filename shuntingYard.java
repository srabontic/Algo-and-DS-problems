/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopt1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author srabo
 */
public class shuntingYard {

    /**
     * @param args the command line arguments
     */
    static public String shuntingYardAlgo(String stringIn){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        String operators = "-+/*^";
        
        for (String str: stringIn.split("\\s")){
            char c = str.charAt(0);
            int opIdx = operators.indexOf(c);   //get the indix of the operator if the input char is an operator
            
            
            if (opIdx != -1) {
                if (s.isEmpty())
                    s.push(opIdx);
                else{  //if stack is not empty 
                    while(!s.isEmpty()){
                        int precision1 = s.peek()/2;
                        int precision2 = opIdx/2;
                        //calculate precedences
                        //operators.get(s.peek()).precedence;
                        //operators.charAt(s.peek()).precedence;
                        if(precision2 > precision1 || (precision2 == precision1 && c != '^')){
                            //int pos = s.pop();
                            sb.append(operators.charAt(s.pop())).append(' ');
                        }
                        else
                            break;
                         
                        }
                    s.push(opIdx);
                }
                        
            }
            else if(c == '('){
                s.push(6);
                }
            else if (c == ')'){
                while(s.peek() != 6){
                    sb.append(operators.charAt(s.pop())).append(' ');
                }
                s.pop();
            }
            else
            {
                sb.append(str).append(' ');
            }
        }
        
        while(!s.empty()){
            sb.append(operators.charAt(s.pop())).append(' ');
        }
            return sb.toString();  
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String infix = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        System.out.println(shuntingYardAlgo(infix));
    }
    
}
