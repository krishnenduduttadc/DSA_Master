package Arrays3;


public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int dist = Integer.MIN_VALUE;
        int i = -1;

        for (int j = 0; j < seats.length; j++) {
            if (seats[j] == 1) {
                if (i == -1) {
                    dist = Math.max(dist, j);
                } else {
                    dist = Math.max(dist, (j - i) / 2);
                }
                i = j;
            }
        }

        dist = Math.max(dist, seats.length - 1 - i);

        return dist;
    }


    public static void main(String[] args) {
        MaximizeDistancetoClosestPerson solution = new MaximizeDistancetoClosestPerson();

        // Test case 1
        int[] seats1 = {1, 0, 0, 0, 1, 0, 1};
        int result1 = solution.maxDistToClosest(seats1);
        System.out.println("Max distance to closest person: " + result1); // Expected output: 2

    }
}
