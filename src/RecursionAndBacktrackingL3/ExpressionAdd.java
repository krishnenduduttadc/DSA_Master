package RecursionAndBacktrackingL3;

public class ExpressionAdd {


    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        backtrack(num, target, 0, 0, 0, "");
    }

    public static void backtrack(String num, int target, int index,
                                 long currentValue, long prevValue,
                                 String expression) {

        if (index == num.length()) {
            if (currentValue == target)
                System.out.println(expression);
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0')
                break;

            long number = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                backtrack(num, target, i + 1, number, number, "" + number);
            } else {

                backtrack(num, target, i + 1,
                        currentValue + number,
                        number,
                        expression + "+" + number);

                backtrack(num, target, i + 1,
                        currentValue - number,
                        -number,
                        expression + "-" + number);

                backtrack(num, target, i + 1,
                        currentValue - prevValue + prevValue * number,
                        prevValue * number,
                        expression + "*" + number);
            }
        }
    }

}
