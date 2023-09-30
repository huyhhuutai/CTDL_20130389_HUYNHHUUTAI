package Task2;

import java.io.*;
import java.util.Scanner;

public class MyCaesar {
    public static final char[] ALPHABET = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private int n; // Số bước dịch (dịch sang phải)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    // Mã hóa một ký tự theo số bước dịch đã cho
    // Mã hóa: En(x) = (x + n) mod 26. Trong đó, x là chỉ số của c trong mảng ALPHABET
    public char encryptChar(char c) {
        if (Character.isUpperCase(c)) {
            int index = (c - 'A' + n) % 26;
            if (index < 0) {
                index += 26;
            }
            return ALPHABET[index];
        } else if (Character.isLowerCase(c)) {
            int index = (c - 'a' + n) % 26;
            if (index < 0) {
                index += 26;
            }
            return Character.toLowerCase(ALPHABET[index]);
        } else {
            return c; // Giữ nguyên ký tự không phải chữ cái
        }
    }

    // Mã hóa một chuỗi sử dụng hàm mã hóa ký tự ở trên
    public String encrypt(String input) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            encryptedText.append(encryptChar(c));
        }
        return encryptedText.toString();
    }

    // Giải mã một ký tự theo số bước dịch đã cho
    // Giải mã: Dn(x) = (x - n) mod 26. Trong đó, x là chỉ số của c trong mảng ALPHABET
    public char decryptChar(char c) {
        if (Character.isUpperCase(c)) {
            int index = (c - 'A' - n) % 26;
            if (index < 0) {
                index += 26;
            }
            return ALPHABET[index];
        } else if (Character.isLowerCase(c)) {
            int index = (c - 'a' - n) % 26;
            if (index < 0) {
                index += 26;
            }
            return Character.toLowerCase(ALPHABET[index]);
        } else {
            return c; // Giữ nguyên ký tự không phải chữ cái
        }
    }

    // Giải mã một chuỗi sử dụng hàm giải mã ký tự ở trên
    public String decrypt(String input) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            decryptedText.append(decryptChar(c));
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
        // Ví dụ sử dụng lớp MyCaesar
        MyCaesar caesar = new MyCaesar(3); // Số bước dịch là 3

        // Mã hóa một chuỗi
        String plainText = "HELLO WORLD";
        String encryptedText = caesar.encrypt(plainText);
        System.out.println("Encrypted Text: " + encryptedText);

        // Giải mã chuỗi đã mã hóa
        String decryptedText = caesar.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}



