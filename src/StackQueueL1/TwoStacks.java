package StackQueueL1;

public class TwoStacks {

    public static void main(String[] args) throws Exception {
        int n = 5;
        TwoStack st = new TwoStack(n);

        String[] commands = {
                "push1 10",
                "push1 20",
                "push2 30",
                "push2 40",
                "push2 50",
                "push1 60",
                "top1",
                "pop1",
                "top1",
                "pop1",
                "top2",
                "pop2",
                "top2",
                "pop2",
                "top1",
                "pop1",
                "top2",
                "pop2",
                "quit"
        };

        for (String str : commands) {
            if (str.equals("quit")) {
                break;
            }

            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) System.out.println(val);
            } else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) System.out.println(val);
            } else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) System.out.println(val);
            } else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) System.out.println(val);
            } else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
        }
    }

    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        int pop1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--;
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos1];
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos2];
            }
        }
    }
}
