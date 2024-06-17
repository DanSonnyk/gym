package fundamentals.chalengers.leetcode.twosum;

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
        final int length = nums.length;

        HashMap<Integer, Integer> n1 = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int sub = target - nums[i];
            if (n1.containsKey(sub)) {
                return new int[]{i, n1.get(sub)};
            }
            n1.put(nums[i], i);
        }
    return new int[]{};
    }
}
