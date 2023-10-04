package Task1;

public class TowersOfHanoi {
    public static void towersOfHanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
        } else {
            towersOfHanoi(n - 1, source, target, auxiliary);
            System.out.println("Move disk " + n + " from " + source + " to " + target);
            towersOfHanoi(n - 1, auxiliary, source, target);
        }
    }

    public static void main(String[] args) {
        int numDisks = 3; // Change numDisks to the desired number of disks
        char source = 'A';
        char auxiliary = 'B';
        char target = 'C';

        System.out.println("Steps to solve Towers of Hanoi with " + numDisks + " disks:");
        towersOfHanoi(numDisks, source, auxiliary, target);
    }
}


