package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }
    
    public int[] mirror() {
        int length = array.length;
        int[] mirroredArray = new int[length * 2];

        // Copy tu mang chinh sang mang phu
        for (int i = 0; i < length; i++) {
            mirroredArray[i] = array[i];
        }

        // noi phan tu dao nguoc vao mang
        for (int i = 0; i < length; i++) {
            mirroredArray[length + i] = array[length - 1 - i];
        }

        return mirroredArray;
    }

    public int[] removeDuplicates() {
        List<Integer> uniqueElements = new ArrayList<>();
        
        for (int element : array) {
            if (!uniqueElements.contains(element)) {
                uniqueElements.add(element);
            }
        }

        // chuyen ve mot mang
        int[] resultArray = new int[uniqueElements.size()];
        for (int i = 0; i < uniqueElements.size(); i++) {
            resultArray[i] = uniqueElements.get(i);
        }

        return resultArray;
    }
    
    public int[] getMissingValues() {
        List<Integer> missingValues = new ArrayList<>();
        Arrays.sort(array);

        for (int i = array[0]; i <= array[array.length - 1]; i++) {
            if (Arrays.binarySearch(array, i) < 0) {
                missingValues.add(i);
            }
        }

        // Chuyển đổi danh sách giá trị thiếu thành mảng
        int[] resultArray = new int[missingValues.size()];
        for (int i = 0; i < missingValues.size(); i++) {
            resultArray[i] = missingValues.get(i);
        }

        return resultArray;
    }
    
    public int[] fillMissingValues(int k) {
        int[] filledArray = Arrays.copyOf(array, array.length);
        Arrays.sort(filledArray);

        int currentIndex = 0;
        int nextIndex = 1;
        int currentValue = filledArray[currentIndex];

        while (nextIndex < filledArray.length) {
            int nextValue = filledArray[nextIndex];
            if (nextValue - currentValue > 1) {
                int missingCount = nextValue - currentValue - 1;
                for (int i = 0; i < missingCount && currentIndex < filledArray.length - 1; i++) {
                    currentValue++;
                    filledArray = insertElement(filledArray, currentValue, currentIndex + 1);
                    currentIndex++;
                }
            }
            currentIndex++;
            nextIndex++;
            currentValue = nextValue;
        }

        // Lấy mảng sau khi đã điền đầy giá trị
        return filledArray;
    }
    
    private int[] insertElement(int[] array, int value, int index) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (i == index) {
                newArray[j] = value;
                j++;
            }
            newArray[j] = array[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 1, 3, 7};

        MyArray myArray = new MyArray(inputArray);

        System.out.println("Original Array: " + Arrays.toString(inputArray));

        int[] mirroredArray = myArray.mirror();
        System.out.println("Mirrored Array: " + Arrays.toString(mirroredArray));

        int[] uniqueArray = myArray.removeDuplicates();
        System.out.println("Array with Duplicates Removed: " + Arrays.toString(uniqueArray));
        
//        lab 1.2
        int[] inputArray1 = {10, 11, 12, -1, 14, 10, 17, 19, 20};
        MyArray myArray1 = new MyArray(inputArray1);

        System.out.println("Original Array: " + Arrays.toString(inputArray1));

        int[] missingValues = myArray1.getMissingValues();
        System.out.println("Missing Values: " + Arrays.toString(missingValues));

        int k = 3;
        int[] filledArray = myArray1.fillMissingValues(k);
        System.out.println("Filled Array (k=" + k + "): " + Arrays.toString(filledArray));
    }

}

