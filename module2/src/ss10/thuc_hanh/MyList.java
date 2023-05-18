package ss10.thuc_hanh;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    /**
     * size: số phần tử trong danh sách mặc định gán = 0;
     * DEFAULT_CAPACITY: số phần tử tối đa trong danh sách mặc định = 10;
     * Mảng đối tượng elements chứa các phần tử trong danh sách;
     * Các phương thức:
     * - Phương thức khởi tạo không tham số;
     * - Phương thức thêm một phần tử mới vào danh sách: add();
     * - Phương thức thay đổi số phần tử tối đa trong danh sách: ensureCapa();
     * - Phương thức truy cập một phần tử trong danh sách: get();
     */
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + " , Size " + i);
        }
        return (E) elements[i];
    }
}
