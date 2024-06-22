package StackL1;

import java.util.HashMap;
import java.util.Stack;

public class MaxFrequencyStack {

        HashMap<Integer ,Stack<Integer>> st;
        HashMap<Integer,Integer> fmap;
        int maxfreq;
        public MaxFrequencyStack() {
            st = new HashMap<>();
            fmap = new HashMap<>();
            maxfreq = 0;
        }

        public void push(int val) {
            int f = fmap.getOrDefault(val,0);
            f++;
            fmap.put(val,f);
            if(st.containsKey(f)==false){
                st.put(f,new Stack<>());
                maxfreq = Math.max(maxfreq,f);
            }
            st.get(f).push(val);

        }

        public int pop() {
            int ans = st.get(maxfreq).pop();
            int f = fmap.get(ans);
            f--;
            fmap.put(ans,f);
            if(st.get(maxfreq).size()==0){
                st.remove(maxfreq);
                maxfreq--;
            }
            return ans;
        }


    public static void main(String[] args) {
        MaxFrequencyStack freqStack = new MaxFrequencyStack();

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop()); // Should print 5
        System.out.println(freqStack.pop()); // Should print 7
        System.out.println(freqStack.pop()); // Should print 5
        System.out.println(freqStack.pop()); // Should print 4
    }

    }



