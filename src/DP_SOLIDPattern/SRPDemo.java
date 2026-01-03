package DP_SOLIDPattern;


//One class = one responsibility.
//Easier maintenance.
//Reduces coupling.
//Improves readability.


class Report {
    void generate() {
        System.out.println("Report");
    }
}

public class SRPDemo {
    public static void main(String[] args) {
        new Report().generate();
    }
}

