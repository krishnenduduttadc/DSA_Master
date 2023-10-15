package ArraysL2;

import java.util.Arrays;

public class MeetingRoom {
    public static boolean meetingRooms(int arr[][]){
        // write code here
        Arrays.sort(arr,(a, b) -> Integer.compare(a[0],b[0]));
        if(arr.length <= 1){
            return true;
        }
        int ep = arr[0][1];

        for(int j = 1; j <= arr.length - 1; j++){
            if(arr[j][0] < ep){
                return false;
            } else {
                ep = arr[j][1];
            }
        }

        return true;
    }
    public static void main(String args[]){
        int input[][] = {
                {1,3},
                {8,10},
                {7,8},
                {9,15},
                {2,6}
        };
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}
