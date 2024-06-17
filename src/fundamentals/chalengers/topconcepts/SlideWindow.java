package fundamentals.chalengers.topconcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlideWindow {
    public static void main(String[] args) {
        //slide window
        // fixed size
        //Maximum sum of a contiguous subarray of size 3
        //O(N^2) Solution
//            int subSize = 3;
//            List<Integer> numsfs = new ArrayList<>(List.of(4,2,1,7,8,1,2,8,1,0));
//            int max = Integer.MIN_VALUE;
//
//            for (int i = 0; i < numsfs.size()-subSize ; i++) {
//                int cSum = 0;
//                for (int j = i; j < i+subSize; j++) {
//                    cSum += numsfs.get(j);
//                }
//                if(max<cSum){
//                    max=cSum;
//                }
//            }
//            System.out.println(max);

        //O(N) Solution
        //currSum = 0
        //maxSum = 16
        // i
        // 4 2 1 7 8 1 2 8 1 0
        //
        List<Integer> numsfs = new ArrayList<>(List.of(-4, 3, 12, 7, 8, 14, 2, 8, 1, -200));
        Collections.sort(numsfs);
        System.out.println(numsfs);
        int target = 2;
        int r = numsfs.size()-1;
        int m;
        int l = 0;

        while(l<=r){
            m = (l+r)/2;
            if(target > numsfs.get(m)){
                l = m + 1;
            }else if(target < numsfs.get(m)){
                r = m - 1 ;
            }else{
                System.out.println(numsfs.get(m));
            }
        }

//        int sizeSub = 3;
//        int currSum = 0;
//        int maxSum = Integer.MIN_VALUE;
//
//        for (int i = 0; i < numsfs.size(); i++) {
//            currSum += numsfs.get(i); // append the next value of next subArray
//            if(i >= sizeSub-1){ // sum the first window
//                maxSum = Math.max(maxSum, currSum);
//                currSum -= numsfs.get(i - (sizeSub-1));
//            }
//        }
//
//        System.out.println(maxSum);

//        int maxSum = Integer.MIN_VALUE;
//        int currSum = 0;
//
//        // iterate entire array from left to right
//        for (int i = 0; i < numsfs.size(); i++) {
//            currSum += numsfs.get(i);// sum of the next number instead of was subtracted
//            if(i >= sizeSub - 1){//verify if my first window starts, after starts ever will be true
//                maxSum = Math.max(currSum, maxSum);//Verify maxSum between vars
//                currSum -= numsfs.get(i - (sizeSub - 1)); //subtraction of the first number of sub array
//            }
//
//        }
//        System.out.println(maxSum);

        //Dynamically size

    }
}
