package Task1;

public class Linear_search {
    private int[] array;

    public Linear_search(int[] array) {
        this.array = array;
    }

    // Phương thức tìm kiếm tuyến tính sử dụng vòng lặp
    public int iterativeLinearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    // Phương thức tìm kiếm tuyến tính đệ quy
    public int recursiveLinearSearch(int target) {
        return recursiveLinearSearchHelper(target, 0);
    }

    private int recursiveLinearSearchHelper(int target, int index) {
        if (index >= array.length) {
            return -1; // Trả về -1 nếu không tìm thấy
        }
        
        if (array[index] == target) {
            return index;
        }
        
        return recursiveLinearSearchHelper(target, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
        int target1 = 45;
        int target2 = 15;

        Linear_search searcher = new Linear_search(array);

        // Tìm kiếm bằng phương thức tìm kiếm tuyến tính sử dụng vòng lặp
        int result1 = searcher.iterativeLinearSearch(target1);
        int result2 = searcher.iterativeLinearSearch(target2);

        System.out.println("Iterative Linear Search:");
        System.out.println(target1 + " found at index: " + result1);
        System.out.println(target2 + " found at index: " + result2);

        // Tìm kiếm bằng phương thức tìm kiếm tuyến tính đệ quy
        result1 = searcher.recursiveLinearSearch(target1);
        result2 = searcher.recursiveLinearSearch(target2);

        System.out.println("\nRecursive Linear Search:");
        System.out.println(target1 + " found at index: " + result1);
        System.out.println(target2 + " found at index: " + result2);
    }
}
