package Task1;

public class Task1_1 {
	// S(n) = 1 - 2 + 3 - 4 + ... + ((-1)^(n+1)) * n, n > 0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		int sign = (n % 2 == 0) ? -1 : 1;
		return getSn1(n - 1) + sign * n;
		// S(n) = 1 + 12 + 123 + ... + 123...*n, n > 0
	}

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn2(n - 1) + factorial(n);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	// S(n) = 1^2 + 2^2 + 3^2 + ... + n^2, n > 0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn3(n - 1) + n * n;
	}

	// S(n) = 1 + 1/2 + 1/(24) + 1/(246) + ... + 1/(246...*2n), n >= 0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1.0;
		}
		return getSn4(n - 1) + 1.0 / factorial(2 * n);
	}

	public static int factoria1(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int n = 5; // Change n to the desired value
		int result1 = getSn1(n);
		System.out.println("S(" + n + ") = " + result1);
		int result2 = getSn2(n);
		System.out.println("S(" + n + ") = " + result2);
		int result3 = getSn3(n);
		System.out.println("S(" + n + ") = " + result3);
		double result4 = getSn4(n);
		System.out.println("S(" + n + ") = " + result4);
	}
}
