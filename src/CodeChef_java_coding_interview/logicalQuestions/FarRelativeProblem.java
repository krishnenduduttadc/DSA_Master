package CodeChef_java_coding_interview.logicalQuestions;

public class FarRelativeProblem {
    public static void main(String[] args) {

        int n = 4;

        String[] input = {"M 151 307", "F 343 352", "F 117 145", "M 24 128"};

        int[] male = new int[366];

        int[] female = new int[366];

        for (int i = 0; i < n; i++) {
            String inputStr = input[i];

            //converting input string into array
            String[] arr = inputStr.split(" ");

            char c = arr[0].charAt(0);

            //when it's a Male friend
            if (c == 'M') {
                int s = Integer.valueOf(arr[1]) - 1;
                int e = Integer.valueOf(arr[2]) - 1;
                for (int j = s; j <= e; j++) {
                    male[j]++;
                }
            } else {  //when it's a Female friend
                int s = Integer.valueOf(arr[1]) - 1;
                int e = Integer.valueOf(arr[2]) - 1;
                for (int j = s; j <= e; j++) {
                    female[j]++;
                }
            }
        }

        int max_friends = 0;

        for (int i = 0; i < male.length; i++) {
            max_friends = Math.max(Math.min(male[i], female[i]), max_friends);
        }

        System.out.println(max_friends * 2);
    }
}
