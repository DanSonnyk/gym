package leetcode.various;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>(List.of(2, -4, -4, -2, -1, -2, -4));

        System.out.println(integers.stream().reduce(0, (sub, ele) -> sub+ele));

        System.out.println(integers);
        System.out.println(isValid(integers));
    }

    public static List<Integer> isValid(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            a.add(a.size() -i, a.getFirst());
            a.removeFirst();
        }

        return a;
    }
}
