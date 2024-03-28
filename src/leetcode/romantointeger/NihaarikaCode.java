package leetcode.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class NihaarikaCode {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("V"));
//        System.out.println(romanToInt("X"));
//        System.out.println(romanToInt("L"));
//        System.out.println(romanToInt("C"));
//        System.out.println(romanToInt("D"));
//        System.out.println(romanToInt("M"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("IX"));
//        System.out.println(romanToInt("XC"));
//        System.out.println(romanToInt("CM"));
//        System.out.println(romanToInt("MCMXCIV"));
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

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }
}
