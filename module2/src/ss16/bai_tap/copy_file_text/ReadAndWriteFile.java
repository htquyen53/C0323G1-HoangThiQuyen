package ss16.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public List<Character> readFile(String filePath) {
        List<Character> characters = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    characters.add(line.charAt(i));
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        } catch (Exception e) {
            e.getStackTrace();
        }
        return characters;
    }

    public void writeFile(List<Character> characters, String filePath) {
        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File(filePath);
            FileWriter fileWriter;
            if (file.exists()) {
                do {
                    System.out.println("Tập tin đích đã tồn tại! Bạn muốn ghi đè hay ghi nối???\n" +
                            "1. Ghi đè \n" +
                            "2. Ghi nối");
                    int choose;
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1) {
                        fileWriter = new FileWriter(file, false);
                        break;
                    } else if (choose == 2) {
                        fileWriter = new FileWriter(file, true);
                        break;
                    } else {
                        System.out.println("Bạn đã nhập sai chức năng, mời nhập lại!!");
                    }
                } while (true);
            } else {
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Character character : characters) {
                bufferedWriter.write(character);
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File không tồn tại!");
        }
    }
}
