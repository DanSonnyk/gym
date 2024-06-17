package fundamentals.java;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaConcepts {

    public static void main(String[] args) {
        // Thread Safety can be done by ExecutorService or Tread classes
        threadSafetyExample("byExecutorService");

        // Parallel Streams
        parallelStreamsExample();

        // Asynchronous Methods
        asynchronousMethodsExample();

        // Immutable Objects
        immutableObjectsExample();

        // Concurrency Utilities
        concurrencyUtilitiesExample();

        // Atomic Operations
        atomicOperationsExample();

        // Non-blocking Algorithms
        nonBlockingAlgorithmsExample();

        // Memory Management
        // No explicit code example needed

        // Error Handling
        errorHandlingExample();

        // Networking
        // No explicit code example needed
    }

    // Example of Thread Safety: Ensuring Thread Safety in a Shared Resource
    //Suppose that we have an app to sell tickets and the variable tickets is shared with all threads
    private static void threadSafetyExample(String type) {
        Counter tickets = new Counter();

        if(type.equals("ExecutorService")){
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(() -> {
                for (int i = 0; i < 1000; i++) {
                    tickets.decrement();
                }
            });
            executor.submit(() -> {
                for (int i = 0; i < 1000; i++) {
                    tickets.decrement();
                }
            });

            executor.shutdownNow();
            try {
                executor.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Counter value: " + tickets.getCount());
        }else{
            Runnable code = () -> {
                for (int i = 0; i < 1000; i++) {
                    tickets.decrement();
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            Thread t1 = new Thread(code);
            Thread t2 = new Thread(code);

            t1.start();
            t2.start();

            try {
                //will make the program wait the thread kills to proceed
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    // Example of Parallel Streams: Processing Data in Parallel
    private static void parallelStreamsExample() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        //In this point whe use parallelStream call to distribute the execution of isPrime in various threads
        long count = numbers.parallelStream()
                .filter(JavaConcepts::isPrime)
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

    // Example of Asynchronous Methods: Executing Tasks Asynchronously
    private static void asynchronousMethodsExample() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate long-running computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        future.thenAccept(result -> System.out.println("Result of asynchronous computation: " + result));
    }

    // Example of Immutable Objects: Creating Immutable Objects
    private static void immutableObjectsExample() {
        Person person = new Person("John", 30);
        System.out.println("Original person: " + person);
        // Cannot modify person's state
    }

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // Example of Concurrency Utilities: Using Executors for Concurrent Execution
    private static void concurrencyUtilitiesExample() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Executing task 1"));
        executor.submit(() -> System.out.println("Executing task 2"));
        executor.shutdown();
    }

    // Example of Atomic Operations: Using AtomicInteger for Atomic Operations
    private static void atomicOperationsExample() {
        AtomicInteger counter = new AtomicInteger(0);
        counter.incrementAndGet();
        System.out.println("Counter value: " + counter.get());
    }

    // Example of Non-blocking Algorithms: Using Non-blocking Data Structures
    private static void nonBlockingAlgorithmsExample() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("item1");
        queue.offer("item2");
        System.out.println("Queue size: " + queue.size());
    }

    // Example of Error Handling: Handling Exceptions in Concurrent Code
    private static void errorHandlingExample() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            try {
                int result = 1 / 0; // ArithmeticException
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        });
        executor.shutdown();
    }

    // Inner class representing a thread-safe counter
    static class Counter {
        private int count = 2000;

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
