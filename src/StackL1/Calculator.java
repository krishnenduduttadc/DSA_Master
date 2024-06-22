package StackL1;

import RecursionAndBacktrackingL1.Solution;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){
                int num = 0;
                while(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                operand.push(num);
                i--;
            } else if(ch=='+' || ch == '-' ||ch == '*' || ch == '/') {
                while(operator.size() > 0 && prec(operator.peek()) >= prec(ch)){
                    char oper = operator.pop();
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    int cal = calc(val1 , val2 , oper);
                    operand.push(cal);
                }
                operator.push(ch);
            }
            i++;
        }
        while(operator.size() > 0){
            char oper = operator.pop();
            int val2 = operand.pop();
            int val1 = operand.pop();
            int cal = calc(val1 , val2 , oper);
            operand.push(cal);
        }
        return operand.pop();

    }
    public int calc(int a , int b , char c){
        if(c=='+') return a+b;
        else if(c == '-') return a-b;
        else if(c == '*') return a * b;
        return a/b;
    }
    public int prec(char c){
        if(c=='*' || c == '/') return 1;
        else return 0;
    }


    public static void main(String[] args) {
        Calculator sol = new Calculator();

        String expression1 = "3+2*2";
        System.out.println("Result of '" + expression1 + "' = " + sol.calculate(expression1)); // Expected: 7

        String expression2 = " 3/2 ";
        System.out.println("Result of '" + expression2 + "' = " + sol.calculate(expression2)); // Expected: 1

        String expression3 = " 3+5 / 2 ";
        System.out.println("Result of '" + expression3 + "' = " + sol.calculate(expression3)); // Expected: 5

        // Add more test cases as needed
    }
}
