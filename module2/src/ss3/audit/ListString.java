package ss3.audit;

import java.util.ArrayList;
import java.util.List;

public class ListString {
    public static void main(String[] args) {
        List<String> listStringA = new ArrayList<>();
        List<String> listStringB = new ArrayList<>();
        List<String> listStringC = new ArrayList<>();
        listStringA.add("GG");
        listStringA.add("FB");
        listStringA.add("TT");
        listStringA.add("ZLP");
        listStringA.add("FB");
        for (int i = 0; i < listStringA.size(); i++) {
            if(listStringA.get(i).equals("FB")) {
                listStringB.add(listStringA.get(i));
            }
        }
        System.out.println(listStringB);
    }
}
