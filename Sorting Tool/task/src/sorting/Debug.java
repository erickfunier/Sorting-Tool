package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Debug {
    public static void main(String[] args) {
        int number1 = 38;
        int number2 = 54;

        number1 = number1 << 2;
        number2 = number2 >> 1;
        int result = number2 ^ number1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.removeAll(Collections.singleton(1));

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
    }
}
