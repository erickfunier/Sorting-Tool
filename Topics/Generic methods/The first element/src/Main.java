// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T getFirst(T[] t) {
        if (t.length > 0)
            return t[0];
        else
            return null;
    }
}