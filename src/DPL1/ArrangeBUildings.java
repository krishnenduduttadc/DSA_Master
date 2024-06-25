package DPL1;

public class ArrangeBUildings {
    public static void main(String[] args) {
        long n = 5;

        long ob = 1;
        long os = 1;

        for(long i = 2; i <= n;i++){
            long nb = os;
            long ns = os + ob;

            os = ns;
            ob = nb;
        }

        long total= os + ob;
        total = total * total;

        System.out.println(total);
    }
}
