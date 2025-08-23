package GreedyL2;

//Find the starting gas station index from which a car can complete the circuit.
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int totalGas = 0, totalCost = 0;
        for (int g : gas) totalGas += g;
        for (int c : cost) totalCost += c;

        if (totalGas < totalCost) {
            System.out.println("No solution exists");
            return;
        }

        int start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        System.out.println("Start index = " + start);
    }
}

