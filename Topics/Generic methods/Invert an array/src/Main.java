// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T[] invert(T[] t) {
        int i, k;
        T temp;
        int size = t.length;
        for (i = 0; i < size / 2; i++) {
            temp = t[i];
            t[i] = t[size - i - 1];
            t[size - i - 1] = temp;
        }
        return t;
    }
}