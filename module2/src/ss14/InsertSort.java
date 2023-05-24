package ss14;

public class InsertSort {
    static int[] list = {2, 4, 5, -5, 7, 9, 14, 21};
    // Viết phương thức insertSort(int[] list) để sắp xếp các phần tử theo thứ tự tăng dần
    public static void insertSort(int[] list) {
        int pos;
        int elementX;
        for (int i = 1; i < list.length; i++) {
            elementX = list[i];
            pos = i;
            while (pos > 0 && elementX < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = elementX;
        }
    }
    // Hàm main để hiển thị kết quả thuật toán
    public static void main(String[] args) {
        System.out.println("You input list: ");
        for (int x : list) {
            System.out.print(x + "\t");
        }
        insertSort(list);
        System.out.println("\nYour output list: ");
        for (int x : list) {
            System.out.print(x + "\t");
        }
        insertSort(list);
    }
}
