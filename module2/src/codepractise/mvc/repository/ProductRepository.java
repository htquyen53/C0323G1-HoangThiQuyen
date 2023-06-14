package codepractise.mvc.repository;

import codepractise.mvc.common.ReadAndWrite;
import codepractise.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    private static final String PRODUCTS_PATH = "module2/src/codepractise/mvc/data";


    @Override
    public List<Product> getAll() {
        List<String> strings = ReadAndWrite.readFile(PRODUCTS_PATH);
        productList.clear();
        String[] info;
        for (String str: strings) {
            info = str.split(",");
            productList.add(new Product(info[0], info[1], info[2], Float.parseFloat(info[3]), Integer.parseInt(info[4])));
        }
        return productList;
    }

    @Override
    public void editProduct(Product product) {
        productList = getAll();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCode().equals(product.getCode())) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public void addProduct(Product product) {
        List<String> productInfo = new ArrayList<>();
        productInfo.add(getInfoToCSV(product));
        ReadAndWrite.writeFile(PRODUCTS_PATH, productInfo, true);

    }

    @Override
    public Product getProductByID(String code) {
        productList = getAll();
        for (Product product: productList) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void removeProduct(Product product) {
        productList = getAll();
        productList.remove(product);
        List<String> strings = new ArrayList<>();
        for (Product p: productList) {
            strings.add(getInfoToCSV(p));
        }
        ReadAndWrite.writeFile(PRODUCTS_PATH, strings, false);
    }
    public static String getInfoToCSV(Product product) {
        return product.getCode() + "," + product.getName() + "," + product.getDescription() + "," + product.getPrice() + "," + product.getQuantity();
    }
}
