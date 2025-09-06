package CodeChef_java_coding_interview.logicalQuestions;

public class NewYearCandles {
    public static void main(String[] args) {
        int candles = 6;
        int count_needed_to_make_new_candle = 3;
        int went_out_candles_count = 0;
        int hours = 0;

        while (candles > 0) {
            candles--;
            went_out_candles_count++;
            hours++;
            if (went_out_candles_count == count_needed_to_make_new_candle) {
                candles++;
                went_out_candles_count = 0;
            }
        }
        System.out.println(hours);
    }
}
