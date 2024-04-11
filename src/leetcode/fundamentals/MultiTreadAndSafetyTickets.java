package leetcode.fundamentals;

import leetcode.various.JavaConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiTreadAndSafetyTickets {
    public static void main(String[] args) {
        //You can use by ExecutorService interface or directly with Thread class
        threadSafetyExample("ExecutorService");
    }

    private static void threadSafetyExample(String type) {
        MultiTreadAndSafetyTickets.Counter tickets = new MultiTreadAndSafetyTickets.Counter();

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
