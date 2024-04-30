package leetcode.fundamentals;

import java.util.*;

public class lasa {
    public static void main(String[] args) {
        int[] nums = {9,16,4};

        System.out.println(resolveIt(nums));

    }

    private static int resolveIt(int[] num) {

        int product = 1;
        int result = 0;
        for (int i = 1; i < num.length; i++) {
            product = product * num[i];
        }
        
        return product;
    }


}
