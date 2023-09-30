package Task3;

import java.io.*;
import java.util.Scanner;

public class ExpandingMyCaesar {
	private int n; // Số bước dịch (dịch sang phải)

	public ExpandingMyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Mã hóa/giải mã một ký tự theo số bước dịch đã cho
	public char caesar(char c) {
		// Kiểm tra xem ký tự c có phải là ký tự chữ cái hoặc số không
		if (Character.isLetterOrDigit(c)) {
			int asciiValue = c + n;
			if (Character.isUpperCase(c)) {
				if (asciiValue > 'Z') {
					asciiValue -= 26;
				} else if (asciiValue < 'A') {
					asciiValue += 26;
				}
			} else if (Character.isLowerCase(c)) {
				if (asciiValue > 'z') {
					asciiValue -= 26;
				} else if (asciiValue < 'a') {
					asciiValue += 26;
				}
			}
			return (char) asciiValue;
		} else {
			return c; // Giữ nguyên ký tự không phải chữ cái hoặc số
		}
	}

	// Mã hóa một chuỗi sử dụng hàm mã hóa ký tự ở trên
	public String encrypt(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (char c : input.toCharArray()) {
			encryptedText.append(caesar(c));
		}
		return encryptedText.toString();
	}

	// Giải mã một chuỗi sử dụng hàm giải mã ký tự ở trên
	public String decrypt(String input) {
		StringBuilder decryptedText = new StringBuilder();
		for (char c : input.toCharArray()) {
			decryptedText.append(caesar(c));
		}
		return decryptedText.toString();
	}

	// Mã hóa nội dung văn bản trong srcFile và lưu vào desFile
	public void encryptFile(String srcFile, String desFile) throws IOException {
		try (Scanner scanner = new Scanner(new File(srcFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(desFile))) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String encryptedLine = encrypt(line);
				writer.write(encryptedLine);
				writer.newLine();
			}
		}
	}

	// Giải mã nội dung văn bản trong srcFile và lưu vào desFile
	public void decryptFile(String srcFile, String desFile) throws IOException {
		try (Scanner scanner = new Scanner(new File(srcFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(desFile))) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String decryptedLine = decrypt(line);
				writer.write(decryptedLine);
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) {
		ExpandingMyCaesar caesar = new ExpandingMyCaesar(3); // Số bước dịch là 3

		// Mã hóa một chuỗi bao gồm số và ký tự
		String plainText = "Hello, 123!"; // Văn bản gốc
		String encryptedText = caesar.encrypt(plainText);
		System.out.println("Encrypted Text: " + encryptedText);

		// Giải mã chuỗi đã mã hóa
		String decryptedText = caesar.decrypt(encryptedText);
		System.out.println("Decrypted Text: " + decryptedText);
	}
}
