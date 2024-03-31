package leetcode.romantointeger;

import java.util.Arrays;

public class RomanToInteger {
    public static void main(String[] args) {
        String[] romanNumerals = {"MCDLXXVI","XL", "V", "X", "L", "C", "D", "M", "IV", "IX", "XC", "CM", "MCMXCIV"};
        Arrays.stream(romanNumerals).forEach(s -> System.out.println(romanToInt(s)));
    }
    public static int romanToInt(String s) {
        char[] rs = s.toCharArray();
        int length = rs.length;
        String[] ri = new String[length];

        for (int i = 0; i < length; i++) {
            if (isCandidate(rs, i)) {
                ri[i] = returnNumberC(rs, i);
                    i++;
            } else {
                ri[i] = returnNumber(rs[i]);
            }
        }
        return calculateRoman(ri);
    }

    private static int calculateRoman(String[] ri) {
        int v = 0;

        for (String s : ri) {
            if (s != null && !s.isEmpty()) {
                v = v + Integer.parseInt(s);
            }
        }
        return v;
    }

    private static String returnNumber(char r) {
        return switch (r) {
            case 'I' -> "1";
            case 'V' -> "5";
            case 'X' -> "10";
            case 'L' -> "50";
            case 'C' -> "100";
            case 'D' -> "500";
            case 'M' -> "1000";
            default -> "0";
        };
    }

    private static boolean isCandidate(char[] rs, int i) {
        String[] cs = {"CM","CD","XC", "XL", "IX", "IV"};

        char r = rs[i];
        if(i + 1 < rs.length){
            String next = rs[i] +String.valueOf(rs[i+1]);
            if(r != rs[i+1] && Arrays.asList(cs).contains(next)){
                return (r == 'C') || (r == 'X') || ((r == 'I'));
            }
        }
        return false;
    }

    private static String returnNumberC(char[] rs, int i) {
        String cc = rs[i] + String.valueOf(rs[i + 1]);
            return switch (cc) {
                    case "CM" -> "900";
                    case "CD" -> "400";
                    case "XC" -> "90";
                    case "XL" -> "40";
                    case "IX" ->"9";
                    case "IV" ->"4";
                    default -> "";
                };
    }
}