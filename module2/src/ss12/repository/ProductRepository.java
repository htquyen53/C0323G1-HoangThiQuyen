package ss12.repository;

import ss12.model.Product;

import java.util.*;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    //Product(String id, String productName, String productOrigin, int quantity, String description, float price)
    static {
        productList.add(new Product("01KCN", "Kem chống nắng ANESSA", "Anesa Nhật Bản", 100, "Kem chống nắng cho da nhạy cảm", 350000));
        productList.add(new Product("02KCN", "Kem chống nắng ANESSA hồng", "Anesa Nhật Bản", 150, "Kem chống nắng cho em bé", 360000));
        productList.add(new Product("01SRM", "Sữa rửa mặt HATOMUGI", "Hatomugi Nhật Bản", 100, "Sữa rửa mặt dịu nhẹ", 180000));
        productList.add(new Product("02SRM", "Sữa rửa mặt Ý DĨ", "Hatomugi Nhật Bản", 120, "Sữa rửa mặt tẩy da chết nhẹ", 200000));
        productList.add(new Product("01KBD", "Kem body HATOMUGI", "Hatomugi Nhật Bản", 100, "Kem dưỡng body", 170000));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getProductById(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByName(String productName) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(productName)) {
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
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product);
    }

    @Override
    public void productSortUp() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }

    @Override
    public void productSortDown() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
    }
}
