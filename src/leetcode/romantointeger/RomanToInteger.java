package leetcode.romantointeger;

public class RomanToInteger {
    public static void main(String[] args) {
        String[] romanAlgarisms = {"III", "V", "X", "L", "C", "D", "M", "IV", "IX", "XC", "CM", "MCMXCIV"};

        for (String r : romanAlgarisms) {
            System.out.println(romanToInt(r));
        }
    }
    public static int romanToInt(String s) {
        char[] rs = s.toCharArray();
        int length = rs.length;
        String[] ri = new String[length];

        for (int i = 0; i < length; i++) {
            if (isCandidate(rs[i]) && i + 1 < length) {
                ri[i] = returnNumberC(rs, i);
                if (!ri[i].isEmpty()) {
                    i++;
                } else {
                    ri[i] = returnNumber(rs[i]);
                }
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

    private static boolean isCandidate(char r) {
        return r == 'C' || r == 'X' || r == 'I';
    }

    private static String returnNumberC(char[] rs, int i) {
        String[] cs = {"CM", "XC", "IX", "IV"};
        String cc = String.valueOf(rs[i]) + (i + 1 < rs.length ? String.valueOf(rs[i + 1]) : "");

        for (String c : cs) {
            if (cc.equals(c)) {
            return switch (c) {
                    case "CM" -> "900";
                    case "XC" -> "90";
                    case "IX" ->"9";
                    case "IV" ->"4";
                    default -> "";
                };
            }
        }
        return "";
    }
}