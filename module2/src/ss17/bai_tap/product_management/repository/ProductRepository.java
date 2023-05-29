package ss17.bai_tap.product_management.repository;

import ss17.bai_tap.product_management.common.ReadAndWriteFileCSV;
import ss17.bai_tap.product_management.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductRepository implements IProductRepository {
    private static final String STUDENTLIST_PATH = "module2/src/ss17/bai_tap/product_management/data/student.dat";
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("01A", "Kem chống nắng Innisfree", 180000, "Innisfree Hàn Quốc", "Kem chống nắng vật lý"));
        productList.add(new Product("01b", "Sữa dưỡng thể Olay ban đêm", 165000, "Olay Hàn Quốc", "Sữa dưỡng thể cấp ẩm"));
        productList.add(new Product("03A", "Sữa dưỡng thể Olay ban ngày", 185000, "Olay Hàn Quốc", "Sữa dưỡng thể trắng da, chống nắng"));
        productList.add(new Product("06D", "Lotion Innisfree", 160000, "Innisfree Hàn Quốc", "Lotion cấp ẩm tốt"));
    }

    @Override
    public void addProduct(Product product) {
        productList = (List<Product>)ReadAndWriteFileCSV.readFile();
        productList.add(product);
    }

    @Override
    public Product getProductById(String id) {
        for (Product product : productList) {
            if (product.getProductID().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(name)) {
                resultList.add(product);
            }
        }
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAll() {
        ReadAndWriteFileCSV.writeFile(productList);
        return productList;
    }

    @Override
    public boolean checkIdFormat(String id) {
        String patternId = "^T\\d{3}$";
        Pattern regex = Pattern.compile(patternId);
        Matcher matcher = regex.matcher(id);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) >= 32 && (int) input.charAt(i) <= 47 ||
                    (int) input.charAt(i) >= 58 && (int) input.charAt(i) <= 64) {
                return false;
            }
        }
        return true;
    }
}
