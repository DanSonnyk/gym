package fundamentals.chalengers.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopCrazy {
    public static void main(String[] args) {
        List<Integer> quantity = new ArrayList<>(List.of(10,10,8,9,1));
        System.out.println(getMaximumAmout(quantity, 6));
    }

    private static Long getMaximumAmout(List<Integer> quantity, int m) {
        List<Integer> localList = new ArrayList<>(quantity);
        int result = 0;
        for (int i = 0; i < m; i++) {
            Collections.sort(localList);
            Collections.reverse(localList);
            result =result+localList.getFirst();
            localList.set(0, localList.getFirst() - 1);
        }
        return Integer.toUnsignedLong(result);
    }
}
