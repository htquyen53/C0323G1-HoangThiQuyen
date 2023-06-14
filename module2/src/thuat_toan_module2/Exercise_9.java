package thuat_toan_module2;

public class Exercise_9 {
    public static boolean checkCircleNumber(int number) {
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            if (numberStr.charAt(0) != numberStr.charAt(numberStr.length() - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int countCircleNumber(int left, int endNumber) {
        int count = 0;
            for (int i = left; i <= endNumber; i++) {
                if (checkCircleNumber(i)) {
                    count++;
                }
            }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("circlemnum(L,R) = "+ countCircleNumber(9,13));
        System.out.println("circlemnum(L,R) = "+ countCircleNumber(10,100));
        System.out.println("circlemnum(L,R) = "+ countCircleNumber(10,30));
    }
}
