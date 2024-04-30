package fundamentals;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//Given you need apply a process to a large list of elements, you can parallelize the process
public class ParallelStreamsTickets {
    public static void main(String[] args) {
        parallelStreamsExample();
    }
    private static void parallelStreamsExample() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        //In this point whe use parallelStream call to distribute the execution of isPrime in various threads
        long count = numbers.parallelStream()
                .filter(ParallelStreamsTickets::isPrime)
                .count();

        System.out.println("Total prime numbers: " + count);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
