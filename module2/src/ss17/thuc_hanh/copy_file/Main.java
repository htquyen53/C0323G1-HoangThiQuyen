package ss17.thuc_hanh.copy_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    /**
     * Viết một ứng dụng cho phép copy các file có dung lượng lớn.
     * Ứng dụng cho phép nhập vào đường dẫn của file nguồn, đường dẫn
     * thư mục đích và sao chép file nguồn sang thư mục đích.
     *
     * @throws IOException
     */
    private static void copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
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
        Scanner in = new Scanner(System.in);
        System.out.println("Enter source file: ");
        String sourcePath = in.nextLine();
        System.out.println("Enter destination file: ");
        String destPath = in.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7File(sourceFile, destFile);
//            copyFileUsingStream(sourceFile,destFile);
            System.out.println("Copy completed!");
        } catch (IOException ioe) {
            System.out.println("Can't copy that file!");
            System.out.println(ioe.getMessage());
        }
    }
}
