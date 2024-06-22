package StackL1;

import java.util.Stack;

public class MinStack {
    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push(0L);
        } else {
            long diff = val - min;
            st.push(diff);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        long rem = st.pop();
        if (rem < 0) {
            min = min - rem;
        }
    }

    public int top() {
        long rem = st.peek();
        if (rem < 0) {
            return (int) min;
        } else {
            return (int) (min + rem);
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println("Minimum value: " + minStack.getMin()); // Should print 0
        minStack.pop();
        System.out.println("Minimum value: " + minStack.getMin()); // Should print 0
        minStack.pop();
        System.out.println("Minimum value: " + minStack.getMin()); // Should print 0
        minStack.pop();
        System.out.println("Minimum value: " + minStack.getMin()); // Should print 2
    }
}
