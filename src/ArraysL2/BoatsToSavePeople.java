package ArraysL2;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        // write your code here
        int c = 0;

        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        while(l <= r){
            int sum = people[l] + people[r];
            if(sum <= limit){
                c++;
                l++;
                r--;
            } else {
                c++;
                r--;
            }
        }

        return c;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit = 3;
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
    }
}
