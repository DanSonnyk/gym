package fundamentals.chalengers.leetcode.palindrome;

public class PalindromeString {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1230321));
    }
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }

}
