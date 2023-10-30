package ss3.audit;

public class demo7 {
    public static void main(String[] args) {
        int numberInput = 100000;
        StringBuilder res = new StringBuilder("");
        while(numberInput>0) {
            int a = numberInput%8;
            res.append(a);
            numberInput = numberInput/8;
        }
        System.out.println(res.reverse());
    }
}
