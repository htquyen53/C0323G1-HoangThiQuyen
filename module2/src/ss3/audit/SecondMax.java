package ss3.audit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondMax {
    public static void main(String[] args) {
        System.out.println(findSecondMax(Arrays.asList(1,2,5,2,7,1,3,9)));
    }
    public static String findSecondMax (List <Integer> integerList) {
        if (integerList.size()==0)  return "The is no second max in this list.";
        Integer secondMax = null;
        Collections.sort(integerList);
        secondMax = integerList.get(integerList.size()-2)  ;
        return "The second max number is " + secondMax;

    }

}
