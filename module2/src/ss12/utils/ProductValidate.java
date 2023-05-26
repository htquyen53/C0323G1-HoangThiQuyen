package ss12.utils;

public class ProductValidate {

    public static boolean checkId(String id) {
        if(id == "%" ) {
            System.out.println();
            return false;
        }
        return true;
    }
}
