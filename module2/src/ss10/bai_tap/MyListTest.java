package ss10.bai_tap;

import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList(10);
        System.out.println(myList);
        myList.add(6);
        myList.add(5);
        myList.add(1);
        myList.add(null);
        System.out.println(myList);
        myList.add(2, 5);
        myList.add(3, 5);
        System.out.println("element 1: " + myList.get(0));
        System.out.println("element 3: " + myList.get(3));
    }
}
