package ss16.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    /**
     * Viết một ứng dụng cho phép đọc một file text chứa các số nguyên
     * và tìm giá trị lớn nhất trong các số đó và ghi ra file.
     * Ứng dụng cho phép nhập vào đường dẫn của file
     * và tìm giá trị lớn nhất của các số hiện có trong file và sau đó ghi ra tệp tin có tên là result.txt.
     * Trong file text, mỗi số nguyên được ngăn cách với nhau bởi dấu cách.
     */

    // Tạo phương thức readFile với đối số truyền vào là đường dẫn file
    // mà người dùng nhập vào và trả về một List<Integer>
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return numbers;
    }
    // Tạo phương thức writeFile trong lớp ReadAndWriteFile
    // để ghi giá trị lớn nhất vào trong file
    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: "+ max + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
