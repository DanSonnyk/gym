package fundamentals.chalengers.leetcode.various;

import java.util.*;

public class Ranked {
    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(200); // Gera um número aleatório entre 0 e 300
            ranked.add(n);
        }

        List<Integer> played = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            int n = random.nextInt(300); // Gera um número aleatório entre 0 e 300
            played.add(n);
        }

        System.out.println(climbingLeaderboard(ranked, played));
    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();

        for (int ps : player) {
            ranked.addLast(ps);
            int[][] scorePosition = new int[ranked.size()][2];
            result.add(0);
            ranked.sort(Collections.reverseOrder());
            int l = 0;
            int p = 1;

            for (int r = 0; r <= ranked.size() - 1; r++) {

                if(r < ranked.size() - 1){
                    if (ranked.get(r) == ranked.get(r + 1)) {
                        scorePosition[l][0] = ranked.get(r);
                        scorePosition[l][1] = p;

                        scorePosition[l + 1][0] = ranked.get(r + 1);
                        scorePosition[l + 1][1] = p;

                        l += 2;

                        p++;
                        r++;
                    }else{
                        scorePosition[l][0] = ranked.get(r);
                        scorePosition[l][1] = p;

                        p++;
                        l++;
                    }
                }else{
                        scorePosition[l][0] = ranked.get(r);
                        scorePosition[l][1] = p;

                        p++;
                        l++;
                    }
                }

            result.add(findPosition(scorePosition, ps));
            ranked.remove((Integer) ps);
        }
        result.sort(Collections.reverseOrder());
        return result;
    }

    private static int findPosition(int[][] scorePosition, int ps) {
        for (int[] ints : scorePosition) {
            for (int ignored : ints) {
                if (ints[0] == ps) {
                    return ints[1];
                }
            }
        }
        return 0;
    }
}