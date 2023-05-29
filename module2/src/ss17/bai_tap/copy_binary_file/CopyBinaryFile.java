package ss17.bai_tap.copy_binary_file;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    private static void copyFile(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourcePath;
        String destPath;
        File sourceFile;
        File destFile;
        do {
            System.out.println("Nhập đường dẫn file nguồn: ");
            try {
                sourcePath = scanner.nextLine();
                sourceFile = new File(sourcePath);
                if (!sourceFile.exists()) {
                    throw new NullPointerException("Đường dẫn file không tồn tại! Mời nhập lại!");
                }
                break;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        System.out.println("Nhập đường dẫn file đích: ");
        try {
            destPath = scanner.nextLine();
            destFile = new File(destPath);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
        try {
            copyFile(sourceFile, destFile);
            System.out.println("Đã sao chép thành công!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Không thể sao chép file!");
            System.out.println(e.getMessage());
        }
    }
}

