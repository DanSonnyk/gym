package leetcode.various;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {

        System.out.println(permutationContainString("cbabcacabca","abc"));
}

    private static int permutationContainString(String bigString, String smallString) {
        int ssLenght = smallString.length();
        char[] bsChars = bigString.toCharArray();
        int bsLenght = bigString.length();
        int counter=0;
        boolean isPermutation = true;

        for (int i = 0; i < bsLenght-(ssLenght-1); i++) {
            String cPerm = String.valueOf(bsChars[i]) +
                    bsChars[i + 1] +
                    bsChars[i + 2];

            for (int j = 0; j <= ssLenght-1; j++) {
                String s = String.valueOf(smallString.charAt(j));
                if(!cPerm.contains(s)){
                    isPermutation=false;
                    break;
                }
            }

            if(isPermutation) {
                counter++;
            }

            isPermutation = true;
        }
        return counter;
    }
}
