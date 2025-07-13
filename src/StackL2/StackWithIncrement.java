package StackL2;

public class StackWithIncrement {
    public static void main(String[] args) {
        int maxsize = 5; // Stack size
        CustomStack cs = new CustomStack(maxsize);

        // Hardcoded operations
        cs.push(1);
        cs.push(2);
        System.out.println(cs.pop());       // Should print 2
        cs.push(3);
        cs.push(4);
        cs.push(5);
        cs.increment(2, 100);               // Increment bottom 2 elements by 100
        cs.increment(3, 100);               // Increment bottom 3 elements by 100
        System.out.println(cs.pop());       // Should print 5
        System.out.println(cs.pop());       // Should print 4 + 100
        System.out.println(cs.pop());       // Should print 3 + 200
        System.out.println(cs.pop());       // Should print 1 + 200
        System.out.println(cs.pop());       // Should print -1 (stack empty)

        System.out.println("exit");
    }

    public static class CustomStack {
        int[] value;
        int[] increment;
        int index;

        public CustomStack(int maxSize) {
            value = new int[maxSize];
            increment = new int[maxSize];
            index = -1;
        }

        public void push(int x) {
            if (index + 1 == value.length) {
                return;
            }
            index++;
            value[index] = x;
            increment[index] = 0;
        }

        public int pop() {
            if (index == -1) {
                return -1;
            }

            int x = value[index];
            int inc = increment[index];
            index--;
            if (index >= 0) {
                increment[index] += inc;
            }

            return x + inc;
        }

        public void increment(int k, int val) {
            int ind = Math.min(k - 1, index);
            if (index >= 0 && ind >= 0) {
                increment[ind] += val;
            }
        }
    }
}
