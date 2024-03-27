package leetcode.palindrome;

public class PalindromeMath {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        int original =x;
        int rev=0;
        while(x>0){
            int x1=x%10;
            rev=rev*10+x1;
            x=x/10;
        }
        return rev==original;

    }
}
