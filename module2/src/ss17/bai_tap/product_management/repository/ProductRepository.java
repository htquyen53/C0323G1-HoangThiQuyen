package ss17.bai_tap.product_management.repository;

import ss17.bai_tap.product_management.common.ReadAndWriteFileDAT;
import ss17.bai_tap.product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String PRODUCTLIST_PATH = "module2/src/ss17/bai_tap/product_management/data/products.dat";
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("01A", "Kem chống nắng Innisfree", 180000, "Innisfree Hàn Quốc", "Kem chống nắng vật lý"));
        productList.add(new Product("01b", "Sữa dưỡng thể Olay ban đêm", 165000, "Olay Hàn Quốc", "Sữa dưỡng thể cấp ẩm"));
        productList.add(new Product("03A", "Sữa dưỡng thể Olay ban ngày", 185000, "Olay Hàn Quốc", "Sữa dưỡng thể trắng da, chống nắng"));
        productList.add(new Product("06D", "Lotion Innisfree", 160000, "Innisfree Hàn Quốc", "Lotion cấp ẩm tốt"));
    }

    @Override
    public void addProduct(Product product) {
        productList = ReadAndWriteFileDAT.readProductListFromFile(PRODUCTLIST_PATH);
        productList.add(product);
    }

    @Override
    public Product getProductById(String id) {
        productList = ReadAndWriteFileDAT.readProductListFromFile(PRODUCTLIST_PATH);
        for (Product product : productList) {
            if (product.getProductID().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByName(String name) {
        productList = ReadAndWriteFileDAT.readProductListFromFile(PRODUCTLIST_PATH);
        List<Product> resultList = new ArrayList<>();
        for (Product product : productList) {
            if ((product.getProductName().toLowerCase()).contains(name)) {
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
        ReadAndWriteFileDAT.writeProductListListToFile(productList,PRODUCTLIST_PATH);
        return productList;
    }
}
