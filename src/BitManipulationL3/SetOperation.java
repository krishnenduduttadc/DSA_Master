package BitManipulationL3;

public class SetOperation {
    public static void main(String[] args) {

        int x = (1 << 1) | (1 << 3) | (1 << 4) | (1 << 8); //[1,3,4,8]

        int y = (1 << 3) | (1 << 6) | (1 << 8) | (1 << 9); //[3,6,8,9]

        System.out.println("\nUnion------------");
        int union = x | y;
        System.out.println(union);
        set(union);

        System.out.println("\nIntersection------------");

        int intersection = x & y;
        System.out.println(intersection);
        set(intersection);

        System.out.println("\nDifference------------");

        int difference = x & (~y);
        System.out.println(difference);
        set(difference);

        System.out.println("\nComplement------------");

        int complement = ~x;
        System.out.println(complement);
        set(complement);
    }

    static void set(int x) {
        for (int i = 0; i < 32; i++) {
            if ((x & (1 << i)) != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
