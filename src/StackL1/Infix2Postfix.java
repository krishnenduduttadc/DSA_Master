package StackL1;

import java.util.Stack;

public class Infix2Postfix {
        // Function to convert an infix expression to a postfix expression.
        public static String infixToPostfix(String exp) {
            Stack<String> operand = new Stack<>();
            Stack<Character> operator = new Stack<>();
            int i = 0;
            while(i<exp.length()){
                char ch = exp.charAt(i);
                if(ch=='(') operator.push(ch);
                else if(ch == ')'){
                    while(operator.peek() != '('){
                        char oper = operator.pop();
                        String val2 = operand.pop();
                        String val1 = operand.pop();
                        String cal = val1 + val2 + oper;
                        operand.push(cal);
                    }
                    operator.pop();
                }
                else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
                    while(operator.size() > 0 && prec(operator.peek()) >= prec(ch)){
                        char oper = operator.pop();
                        String val2 = operand.pop();
                        String val1 = operand.pop();
                        String cal = val1 + val2 + oper;
                        operand.push(cal+"");
                    }
                    operator.push(ch);
                } else{
                    operand.push(ch+"");
                }
                i++;
            }
            while(operator.size() > 0 ){
                char oper = operator.pop();
                String val2 = operand.pop();
                String val1 = operand.pop();
                String cal = val1 + val2 + oper;
                operand.push(cal+"");
            }
            return operand.pop();

        }
        public static int prec(char c){
            if(c == '^') return 2;
            else if(c == '*' || c == '/') return 1;
            return 0;
        }


    public static void main(String[] args) {
        String infix1 = "a+b*c";
        String postfix1 = infixToPostfix(infix1);
        System.out.println("Infix: " + infix1 + " -> Postfix: " + postfix1); // Expected: "abc*+"


    }
}
