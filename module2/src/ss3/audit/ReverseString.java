package ss3.audit;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello, How are you?";
        StringBuilder reverseStr = reverseString (s);
        System.out.println(reverseStr);
    }
    public static StringBuilder reverseString (String s ) {
        StringBuilder newStr = new StringBuilder(s);
        newStr.reverse();
        return newStr;
    }
}
