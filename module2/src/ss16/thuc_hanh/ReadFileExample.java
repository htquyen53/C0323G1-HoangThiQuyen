package ss16.thuc_hanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    /**
     * [Thực hành] Tính tổng các số trong file text.
     * Viết một ứng dụng cho phép đọc một file text chứa các số nguyên và tính tổng của giá trị của các số đó.
     * Ứng dụng cho phép nhập vào đường dẫn của file và hiển thị tổng các số chứa trong file đó. Nếu có ngoại lệ xảy ra (file không tồn tại, file chứa các giá trị không phải là số) thì hiển thị thông báo lỗi.
     * Trong file text, mỗi số nguyên được lưu trên một dòng.
     * Ví dụ, numbers.txt:
     * 5
     * 3
     * 6
     * 1
     * 8
     */
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            //Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {

                throw new FileNotFoundException();
            }
            // Đọc từng dòng file và tiến hành tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            // Hiển thị ra màn hình tổng các số nguyên trong file.
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            //TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.out.println("File không tồn tại hoặc nội dung file có lỗi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
