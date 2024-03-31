package leetcode.logestprefix;

import java.util.Arrays;

public class LongestPrefixBetter {
    public static void main(String[] args) {
        String[] casa = {"flower","flow","flight"};

        String s = longestCommonPrefix(casa);

        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
