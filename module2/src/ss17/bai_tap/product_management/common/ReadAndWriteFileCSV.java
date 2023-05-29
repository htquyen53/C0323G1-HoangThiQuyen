package ss17.bai_tap.product_management.common;

import bailamthem.codegym_management_system.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSV {
    private static final String PRODUCT_LIST_PATH = "module2/src/ss17/bai_tap/product_management/data/product.csv";
    public static void writeFile(List<Student> productList) {
        File file = new File(PRODUCT_LIST_PATH);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < productList.size(); i++) {
                bufferedWriter.write(productList.get(i).getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> readFile() {
        List<Student> productList = new ArrayList<>();
        File file = new File(PRODUCT_LIST_PATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] products = line.split(",");
                Student product = new Student(products[0], products[1], products[2],
                        Boolean.getBoolean(products[3]), products[4], Double.parseDouble(products[5]));
                productList.add(product);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return productList;
    }
}
