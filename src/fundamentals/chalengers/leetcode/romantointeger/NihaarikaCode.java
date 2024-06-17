package fundamentals.chalengers.leetcode.romantointeger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NihaarikaCode {

    public static void main(String[] args) {
        String[] romanNumerals = {"MCDLXXVI","XL", "V", "X", "L", "C", "D", "M", "IV", "IX", "XC", "CM", "MCMXCIV"};
        Arrays.stream(romanNumerals).forEach(s -> System.out.println(romanToInt(s)));//O(N)
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {//O(N)
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }
}
