package ss17.bai_tap.product_management.common;

import ss17.bai_tap.copy_binary_file.Student;
import ss17.bai_tap.product_management.model.Product;

import java.io.*;
import java.util.List;

public class ReadAndWriteFileDAT {
    public static void writeProductListListToFile(List<Product> productList, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Product> readProductListFromFile(String path) {
        List<Product> productList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
