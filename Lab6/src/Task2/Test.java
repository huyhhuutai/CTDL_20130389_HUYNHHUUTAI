package Task2;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        // Test addFirst and addLast
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addLast(3);

        // Test size
        System.out.println("Size of the list: " + myList.size()); // Expected output: 3

        // Test isEmpty
        System.out.println("Is the list empty? " + myList.isEmpty()); // Expected output: false

        // Test first and last
        System.out.println("First element: " + myList.first()); // Expected output: 2
        System.out.println("Last element: " + myList.last()); // Expected output: 3

        // Test removeFirst and removeLast
        int removedFirst = myList.removeFirst();
        int removedLast = myList.removeLast();

        System.out.println("Removed first element: " + removedFirst); // Expected output: 2
        System.out.println("Removed last element: " + removedLast); // Expected output: 3

        System.out.println("Size of the list after removals: " + myList.size()); // Expected output: 1

        // Test isEmpty after removals
        System.out.println("Is the list empty after removals? " + myList.isEmpty()); // Expected output: false
    }
}
