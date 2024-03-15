package leetcode;

import java.util.Arrays;

public class twosum {
//leetcode challenge 01. Two Sum
//    https://leetcode.com/problems/two-sum/description/
//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//    You can return the answer in any order.

    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        final int[] response = twoSumBruteForce(nums, 6);
        System.out.println("Result: " + Arrays.toString(response));
    }

    public static int[] twoSumBruteForce( int[] nums, int target){
        final int length = nums.length;
        for (int i = 0; i < length -1; i++ ){
            int n1 = nums[i];
            for (int f = i + 1; f < length; f++) {
                int n2 = nums[f];
                if (n1 + n2 == target) {
                    return new int[]{i, f};
                }
            }
        }
        return new int[0];
    }
}
