package ss12.utils;

public class ProductValidate {

    public static boolean checkId(Integer id) {
        if(id <0 ) {
            System.out.println();
            return false;
        }
        return true;
    }
}
