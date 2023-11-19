package ss3.audit;

import java.util.ArrayList;
import java.util.List;

public class SymmetricalArray {
    // Find Symmetrical Array
    public static void main(String[] args) {
        Integer[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> outputArray = new ArrayList<>();
            for (int i = inputArray.length - 1; i >=0; i--) {
            outputArray.add(inputArray[i]);
        }
            ArrayList<Integer> result = new ArrayList<>(outputArray);
        System.out.println(result);
    }
}
