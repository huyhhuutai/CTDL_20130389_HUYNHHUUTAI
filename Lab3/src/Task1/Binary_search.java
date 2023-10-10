package Task1;

public class Binary_search {
	private int[] array;

	public Binary_search(int[] array) {
		this.array = array;
	}

	// Phương thức tìm kiếm nhị phân sử dụng vòng lặp
	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1; // Trả về -1 nếu không tìm thấy
	}

	// Phương thức tìm kiếm nhị phân đệ quy
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelper(target, 0, array.length - 1);
	}

	private int recursiveBinarySearchHelper(int target, int left, int right) {
		if (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				return recursiveBinarySearchHelper(target, mid + 1, right);
			} else {
				return recursiveBinarySearchHelper(target, left, mid - 1);
			}
		}

		return -1; // Trả về -1 nếu không tìm thấy
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };
		int target1 = 7;
		int target2 = 4;

		Binary_search searcher = new Binary_search(array);

		// Tìm kiếm bằng phương thức tìm kiếm nhị phân sử dụng vòng lặp
		int result1 = searcher.iterativeBinarySearch(target1);
		int result2 = searcher.iterativeBinarySearch(target2);

		System.out.println("Iterative Binary Search:");
		System.out.println(target1 + " found at index: " + result1);
		System.out.println(target2 + " found at index: " + result2);

		// Tìm kiếm bằng phương thức tìm kiếm nhị phân đệ quy
		result1 = searcher.recursiveBinarySearch(target1);
		result2 = searcher.recursiveBinarySearch(target2);

		System.out.println("\nRecursive Binary Search:");
		System.out.println(target1 + " found at index: " + result1);
		System.out.println(target2 + " found at index: " + result2);
	}
}
