package Task1;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        // Test adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // Test getting elements
        System.out.println("Element at index 2: " + list.get(2)); // Expected output: Cherry

        // Test setting elements
        String replacedElement = list.set(1, "Grape");
        System.out.println("Replaced element: " + replacedElement); // Expected output: Banana

        // Test removing elements
        String removedElement = list.remove(0);
        System.out.println("Removed element: " + removedElement); // Expected output: Apple

        // Test size and isEmpty
        System.out.println("Size of the list: " + list.size()); // Expected output: 3
        System.out.println("Is the list empty? " + list.isEmpty()); // Expected output: false

        // Test toArray
        Object[] array = list.toArray();
        System.out.print("List as an array: ");
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Test clear
        list.clear();
        System.out.println("Is the list empty after clearing? " + list.isEmpty()); // Expected output: true

        // Test sorting
        list.add("Grape");
        list.add("Cherry");
        list.add("Banana");
        list.sort(String::compareTo);
        System.out.print("Sorted list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

