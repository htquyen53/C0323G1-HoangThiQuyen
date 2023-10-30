package ss3.audit;

public class al5 {
    // Cho một mảng số nguyên và một số nguyên N bất kỳ,
    // output : vị trí của 2 số bất kỳ trong mảng có tổng bằng N.

    public static void main(String[] args) {
        int[] arrayInteger = {1, 2, 3, 4, 5, 6, 7};
        int number = 8;

        for (int i = 0; i < arrayInteger.length; i++) {
            for (int j = 0; j < arrayInteger.length; j++) {
                if (arrayInteger[i] + arrayInteger[j] == number) {
                    System.out.println("Vị trí 2  số bất kỳ có tổng = " + number + " l+ à: " + i + " và " + j);
                    break;
                }
            }
        }
    }
}
