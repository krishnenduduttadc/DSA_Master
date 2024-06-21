package BitManipulation1;

public class CheckDivisibilityBy3 {
    public static void main(String[] args) {
        String str ="333";
        int odd = 0;
        int even = 0;

        for(int i = 0; i < str.length(); i++){
            int bit = str.charAt(i) - '0';

            if(i % 2 == 0){
                even = even + bit;
            } else {
                odd = odd + bit;
            }
        }

        int d = even - odd;

        if(d % 11 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
