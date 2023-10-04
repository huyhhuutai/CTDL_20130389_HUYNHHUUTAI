package Task1;

public class PascalTriangle {
    // This method is used to display a Pascal triangle based on the parameter n.
    // Where n represents the number of rows
    public static void printPascalTriangle(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(getPascalTriangle(i)[j] + " ");
            }
            System.out.println();
        }
    }

    // Get the nth row of Pascal's triangle
    public static int[] getPascalTriangle(int n) {
        if (n <= 0) {
            int[] firstRow = { 1 };
            return firstRow;
        } else {
            int[] prevRow = getPascalTriangle(n - 1);
            return generateNextRow(prevRow);
        }
    }

    // Generate the next row based on the previous row
    public static int[] generateNextRow(int[] prevRow) {
        int length = prevRow.length;
        int[] nextRow = new int[length + 1];
        nextRow[0] = 1;
        nextRow[length] = 1;
        for (int i = 1; i < length; i++) {
            nextRow[i] = prevRow[i - 1] + prevRow[i];
        }
        return nextRow;
    }

    public static void main(String[] args) {
        int numRows = 5; // Change numRows to the desired number of rows
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        printPascalTriangle(numRows);
    }
}


