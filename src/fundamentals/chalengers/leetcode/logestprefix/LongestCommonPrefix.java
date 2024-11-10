package fundamentals.chalengers.leetcode.logestprefix;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
//O(nLogn)
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] casa = {"flower","flow","flight"};

        String s = longestCommonPrefix(casa);

        System.out.println(s);
    }

    private static String longestCommonPrefix(String[] words) {
        Arrays.sort(words);
        String first = words[0];
        String last = words[words.length-1];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)!=last.charAt(i))
                break;
            result.append(first.charAt(i));
        }

        
        
        return result.toString();
    }
}
