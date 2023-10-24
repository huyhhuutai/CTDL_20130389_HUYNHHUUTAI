/**
 * 
 */
package Task1;

/**
 * @author ADMIN
 *
 */
public class MatrixOperations {
	public static int[][] add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("Matrices must have the same dimensions");
		}

		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}

		return result;
	}

	public static int[][] subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			throw new IllegalArgumentException("Matrices must have the same dimensions");
		}

		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}

		return result;
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			throw new IllegalArgumentException(
					"Number of columns in the first matrix must be equal to the number of rows in the second matrix");
		}

		int rowsA = a.length;
		int colsA = a[0].length;
		int colsB = b[0].length;
		int[][] result = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				for (int k = 0; k < colsA; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	public static int[][] transpose(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = a[i][j];
			}
		}

		return result;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrixA = { { 1, 2 }, { 3, 4 } };
		int[][] matrixB = { { 5, 6 }, { 7, 8 } };

		System.out.println("Matrix A:");
		printMatrix(matrixA);

		System.out.println("Matrix B:");
		printMatrix(matrixB);

		int[][] sum = add(matrixA, matrixB);
		System.out.println("Sum of A and B:");
		printMatrix(sum);

		int[][] difference = subtract(matrixA, matrixB);
		System.out.println("Difference of A and B:");
		printMatrix(difference);

		int[][] product = multiply(matrixA, matrixB);
		System.out.println("Product of A and B:");
		printMatrix(product);

		int[][] transposeA = transpose(matrixA);
		System.out.println("Transpose of A:");
		printMatrix(transposeA);
	}
}
