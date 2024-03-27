package leetcode.palindrome;

public class PalindromeWhile {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1230321));
    }
    public static boolean isPalindrome(int x) {
        char[] sn = String.valueOf(x).toCharArray();

        int i = 0;
        int j = sn.length-1;

        while(i<j){

            if(sn[i]!=sn[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
