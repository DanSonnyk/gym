package fundamentals.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//In this example, the WebServer class represents a web server that needs to handle multiple incoming requests
// concurrently. It creates an ExecutorService with a fixed thread pool size to process the requests concurrently.
// Each incoming request is submitted to the executor service as a task, which is executed asynchronously.
//
//A CountDownLatch is used to wait for all requests to be processed. Each time a request is processed, the latch count
// is decremented. The main thread waits for the latch count to reach zero, indicating that all requests
// have been processed.
public class ConcurrencyThreads {
    private static final int NUM_REQUESTS = 100;

        public static void main(String[] args) {
            // Create a thread pool to handle incoming requests
            ExecutorService executorService = Executors.newFixedThreadPool(NUM_REQUESTS);

            // CountDownLatch to wait for all requests to be processed
            CountDownLatch latch = new CountDownLatch(NUM_REQUESTS);

            // Simulate incoming requests
            for (int i = 0; i < NUM_REQUESTS; i++) {
                executorService.submit(() -> {
                    // Process the incoming request
                    processRequest();

                    // Signal that the request has been processed
                    latch.countDown();
                });
            }

            try {
                // Wait for all requests to be processed
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Shutdown the executor service
                executorService.shutdown();
            }

            // All requests have been processed
            System.out.println("All requests have been processed.");
        }

        private static void processRequest() {
            // Simulate processing of an incoming request
            System.out.println("Processing request from thread: " + Thread.currentThread().getName());
            // Perform request processing tasks...
        }
}

