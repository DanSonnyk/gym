package fundamentals.chalengers;

import java.util.*;

public class TimeComplexity {

    public static void main(String[] args) {

    }

    private static void O1(){
    //  Array
        int[] nums = new int[10];
        List<Integer> listNums = new ArrayList<>(List.of(1,2,3,4));
        listNums.set(5, 12);//set to specific index
        nums[0] = 1; //set to specific index
        listNums.removeLast(); //lookup
        System.out.println(listNums.get(3));//look to a specific index

    // HashMap / Set
        HashMap<Double, String> prices = new HashMap<>();
        prices.put(10.12, "Shirt" ); // insert
        prices.get(10.12); //lookup
    }

    private static void On(){
    //Sum arrays with loop
        int[] nums = new int[]{2,4,5,6,};
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }

    //insert middle
        List<Integer> listNums = new ArrayList<>(List.of(1,2,3,4));
        listNums.add(3, 100);

    //remove middle
        listNums.remove(3);

    //search middle ?
        listNums.contains(12);

    // build PriorityQueue (heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);

    // sometimes even nested loops can be O(n)
    // (e.g. monotonic stack or sliding window)

    }

    private static void On2(){
    //Traverse a square grid
        int[][] scorePosition = new int[2][3];
        for(int[] i : scorePosition){
            for (int j : i){
                System.out.println(j);
            }
        }


    //Get every pair of elements in array
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,0};

        for(int i : nums){
            for (int j = i+1; j < nums.length; j++) {
                System.out.println(i+j);
            }
        }

    //Insertion sort (insert in middle n times -> n^2)
    }

    private static void Onxm(){
    //Get every pair of elements from two arrays
        int[] nums1 = new int[]{1,2,3,4,5,6,7,8,9,0};
        int[] nums2 = new int[]{12,32,54,65,76,8,97};

        for (int n1 : nums1){
            for (int n2 : nums2){
                System.out.println(n1+n2);
            }
        }

    //Traverse rectangle grid
        int[][] grid = new int[3][2];
        for (int[] lg : grid){
            for (int i = 0; i < grid.length; i++) {
                System.out.println(lg[i]);
            }
        }

    //O( n^3 )
    //Get every triplet of elements in array
        int[] nums = new int[]{12,32,54,65,76,8,97};
        for (int i = 0; i < nums.length; i++) {
            for (int j = + 1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    System.out.println(nums[i] + nums[j] + nums[k]);
                }
            }
        }
    }

    private static void OlogN() {
        //Binary search
        int[] nums = new int[]{12, 32, 54, 65, 76, 8, 97};
        int target = 97;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                System.out.println(nums[m]);
            }
        }

        //Binary Search on BST

        //Heap Push and Pop PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.poll();
        pq.peek();

    }

    private static void ONlogN(){
    //# HeapSort
    //import heapq
    //        nums = [1, 2, 3, 4, 5]
    //        heapq.heapify(nums)     # O(n)
    //        while nums:
    //        heapq.heappop(nums) # O(logn)
    //
    //# MergeSort (and most built-in sorting functions)
    }

    private static void O2n(){
    //Recursion, tree height n, two branches
        O2n();
    //        def recursion(i, nums):
    //        if i == len(nums):
    //        return 0
    //        branch1 = recursion(i + 1, nums)
    //        branch2 = recursion(i + 2, nums)
    }

    private static void Ocn(){
//    # c branches, where c is sometimes n.
//        def recursion(i, nums, c):
//        if i == len(nums):
//        return 0
//
//        for j in range(i, i + c):
//        branch = recursion(j + 1, nums)

    }

    private static void OsqrtN(){
    //# Get all factors of n
    //import math
    //                n = 12
    //        factors = set()
    //        for i in range(1, int(math.sqrt(n)) + 1):
    //        if n % i == 0:
    //        factors.add(i)
    //        factors.add(n // i)
    //                O( n! )
    //# Permutations
    //# Travelling Salesman Problem
    }


}
