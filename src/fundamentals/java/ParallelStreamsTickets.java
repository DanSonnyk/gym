package fundamentals.java;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
                .filter(n -> isPrime(n))
                .count();

        System.out.println("Total prime numbers: " + count);
        Scanner sc = new Scanner(System.in);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void logAllThreads() {
        // Get all threads and their stack traces
        Map<Thread, StackTraceElement[]> allThreads = Thread.getAllStackTraces();

        // Iterate over all threads
        for (Map.Entry<Thread, StackTraceElement[]> entry : allThreads.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTrace = entry.getValue();

            // Log thread information
            System.out.println("Thread: " + thread.getName() + " | State: " + thread.getState());
            System.out.println("StackTrace:");
            for (StackTraceElement element : stackTrace) {
                System.out.println("\t" + element);
            }
            System.out.println();
        }
    }
}
