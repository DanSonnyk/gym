package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        final int[] response = twoSum(nums, 9);
        System.out.println("Result: " + Arrays.toString(response));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tree = new HashMap<>();
        final int length = nums.length;

        for (int i = 0; i < length; i++) {
            tree.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            final int dif = target - nums[i];
            if(tree.containsKey(dif) && tree.get(dif) != i ){
                return new int[]{tree.get(dif), i};
            }
            tree.put(nums[i], i);
        }
        return new int[]{};
    }
}
