package LeetCodePatterns.Stacks;

import java.util.Stack;

public class MinStack {

    public Stack<Integer> a, b;

    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int val) {
        a.push(val);
        if (b.empty() || val <= b.peek()) {
            b.push(val);
        }
    }

    public void pop() {
        if (!a.empty()) {
            if (a.peek().intValue() == b.peek().intValue()) {
                b.pop();
            }
            a.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }

    public class Main {
        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            System.out.println(minStack.getMin()); // -3
            minStack.pop();
            System.out.println(minStack.top());    // 0
            System.out.println(minStack.getMin()); // -2
        }
    }
}
