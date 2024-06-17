package fundamentals.java.ds.collections;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class Collections {

    @Test
   public void allTests() {
        //Collection Interface Implementations
            treeSet(); //ordered
            priorityQueue(); //ordered
            list(); //ordered of insert
            arrayList(); //ordered of insert
            linkedList(); //ordered of insert (place at the end)
            vector(); //ordered of insert
            arrayDeque(); //ordered of insert
            linkedHashSet(); //ordered of insert
            SortedSet(); //ascending ordered
            queue(); //FIFO
            stack(); //LIFO
            dequeue(); //LIFO
            hashSet(); //unordered
            set(); //unordered

//            //Map Interface Implementations:
            hashMap(); //unordered
            treeMap(); //ordered
            SortedMap(); //ascending ordered
            linkedHashMap(); //ordered of insert
            hashTable(); //unordered
    }

    private static void hashTable() {
        //Legacy hash table-based implementation of the Map interface.
        //Unordered - Does not allow duplicate keys - Does not allow null keys or values: - ThreadSafe
        // Example: Consider a multi-threaded server application that needs to maintain a shared cache of user sessions.
        // In this scenario, Hashtable would be the best option to use. You can use a Hashtable to store the user sessions,
        // where each session ID serves as the key and the session attributes (such as username, last access time, and shopping
        // cart items) serve as the value. Because Hashtable is thread-safe, it can safely handle concurrent access and
        // modification by multiple threads, ensuring data integrity and consistency in the shared cache.
        Hashtable<Integer, String> userSessionCashe = new Hashtable<>();
        userSessionCashe.put(1112323, "UserID1636");
        userSessionCashe.put(3213, "UserID567");
        userSessionCashe.put(12, "UserID153461");
        userSessionCashe.put(3213123, "UserID12432");

        ExecutorService executor = newFixedThreadPool(2);

        executor.submit(() -> {
            userSessionCashe.remove(1112323);
        });
        executor.submit(() -> {
            userSessionCashe.put(1112323, "UserID1636");
        });
    }

    private static void treeMap() {
        //Red-Black tree-based implementation of the NavigableMap interface.
        //Ordered: Yes - Does not allow duplicate keys - Allows null keys and values
        // Example: Consider a scheduling application that needs to maintain a sorted list of upcoming events based on their
        // start times. In this scenario, TreeMap would be the best option to use. You can use a TreeMap to store the events,
        // where each entry consists of a start time (as the key) and the corresponding event details (as the value).
        // By using a TreeMap, you ensure that the events are stored in sorted order based on their start times.
        // This allows you to efficiently retrieve and display the upcoming events in chronological order.
        TreeMap<LocalDateTime, String> eventsMap = new TreeMap<>();
        eventsMap.put(LocalDateTime.now(), "Carnival");
        eventsMap.put(LocalDateTime.now().plusMonths(12), "New Year");
        eventsMap.put(LocalDateTime.now().plusMonths(6), "Holidays");

        eventsMap.forEach((localDateTime, s) -> System.out.println(localDateTime+s));
    }

    private static void linkedHashMap() {
        //Hash table and linked list implementation of the Map interface, maintains the insertion order of elements
        //Does not allow duplicate keys - Allows null keys and values
        // Example:  Consider a web application that needs to maintain a cache of recently accessed database query results.
        // In this scenario, LinkedHashMap would be the best option to use. You can use a LinkedHashMap to store the query
        // results, where each entry consists of a query string (as the key) and the corresponding result set (as the value).
        // By using a LinkedHashMap, you ensure that the query results are stored in the order they were accessed. This allows
        // you to efficiently manage the cache and evict the least recently used entries when the cache reaches its capacity
        LinkedHashMap<String, String> cacheQuery = new LinkedHashMap<>();
        cacheQuery.put("SELECT * FROM TABLEA","{| RESULT A | RESULT | RESULT | RESULT}");
        cacheQuery.put("SELECT * FROM TABLEC","{| RESULT C | RESULT | RESULT | RESULT}");
        cacheQuery.put("SELECT * FROM TABLED","{| RESULT D | RESULT | RESULT | RESULT}");
        cacheQuery.put("SELECT * FROM TABLEF","{| RESULT F | RESULT | RESULT | RESULT}");
    }

    private static void SortedMap() {
        //Map that maintains its mappings in ascending order of the keys does not allow null keys but does allow null values.
        // Example: Maintaining a sorted map of product prices in an e-commerce platform.
        SortedMap<Double, String> prices = new TreeMap<>();
        prices.put(12.00, "shoes" );
        prices.put(15.00, "pants" );
        prices.put(10.00, "Shirt" );

        prices.firstKey(); // 10.00
    }

    private static void hashMap() {
        //Interface representing a mapping between keys and values. Example: Storing key-value pairs of user session attributes in a web application.
        HashMap<Integer, String> userSession = new HashMap<>();
        userSession.put(123321, "User Name");

        //Hash table-based implementation of the Map interface, Unordered, Allows null keys and values Does not allow duplicate keys.
        // Example: Consider a web application that needs to store user session information. In this scenario,
        // HashMap would be the best option to use. You can use a HashMap to associate each user's session ID with their
        // session attributes (such as username, last access time, and shopping cart items). This allows for efficient
        // retrieval of session attributes based on the session ID. Additionally, because HashMap allows null values,
        // you can handle cases where certain session attributes may be null, such as when a user has not yet added items to
        // their shopping cart. Overall, HashMap provides an efficient and flexible way to manage user sessions in a web application.
        HashMap<String, String> sessionInfo = new HashMap<>();
        sessionInfo.put("uuid123","CartId123123");
        sessionInfo.put("uuid334","CartId13242");
        sessionInfo.put("uuid234","CartId5434");
    }

    private static void stack() {
        //Subclass of Vector representing a last-in, first-out (LIFO) stack of elements.
        //Ordered: Stack maintains the order of elements in a last-in, first-out (LIFO)
        //Allows duplicate elements - Allows null elements:
        // Example: Consider a text editor application that provides support for undoing and redoing text edits.
        // In this scenario, Stack would be the best option to use. You can use a Stack to maintain a stack of text edit
        // commands, where each command object represents a text edit operation performed by the user. When the user
        // performs an edit, such as typing new text or deleting existing text, a corresponding command object is created
        // and pushed onto the stack. If the user wants to undo an edit, the top command object is popped from the stack and
        // executed in reverse to revert the edit. Similarly, if the user wants to redo an undone edit, previously undone
        // command objects can be pushed back onto the stack and executed again.
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();

        undo.add("New image");
        undo.add("Write Text A");
        undo.add("Write Text B");
        undo.add("New Video");

        redo.add(undo.pop());
        redo.add(undo.pop());
        redo.add(undo.pop());
    }

    @Test
    public void vector() {
        //Synchronized resizable array implementation of the List interface.
        //Thread-safe - Allows null elements - Allows duplicate elements - maintains the order they were inserted
        // Example: Consider a multi-threaded web server application that needs to maintain a shared list of incoming
        // HTTP requests. In this scenario, Vector would be the best option to use. You can use a Vector to store the
        // incoming HTTP requests, where each request object represents an HTTP request received by the server.
        // Because Vector is thread-safe, it can safely handle concurrent access and modification by multiple threads,
        // ensuring that all incoming requests are properly stored and processed without the risk of data corruption.
        Vector<String> requests = new Stack<>();
        requests.add("HTTP Request");
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            requests.add("HTTP RequestA");
        });

        service.submit(() -> {
            requests.add("HTTP RequestB");
        });

        requests.forEach(System.out::println);
    }

    private static void treeSet() {
        // NavigableSet implementation backed by a TreeMap instance elements must be unique..
        // Example: Consider a music streaming application that needs to maintain a playlist of songs in sorted order based
        // on their titles. In this scenario, TreeSet would be the best option to use. You can create a TreeSet of Song objects,
        // where each Song contains information such as title, artist, and duration. By providing a custom comparator that sorts
        // the Song objects based on their titles, you can ensure that the songs in the playlist are always sorted
        // alphabetically by title. Additionally, because TreeSet does not allow duplicate songs, you can guarantee that each
        // song appears in the playlist only once. This ensures a unique and sorted playlist for the users of the music
        // streaming application.
        TreeSet<String> songsName = new TreeSet<>();
        songsName.add("Yes i do not care");
        songsName.add("if you stay");
        songsName.add("Nine degree of beer");
        songsName.add("Nine degree of beer");
        songsName.add("Believe in myself");

        songsName.forEach(System.out::println); //  Believe in myself
    }

    @Test
    public void linkedList() {
        // Doubly-linked list implementation of the List interface.  maintains the insertion order of elements at the end of list, accepts null values.
        // Example: Implementing a playlist songs where you can add and delete, the best choice to insertions and deletions.
        LinkedList<String> jobsToRun = new LinkedList<>();
        jobsToRun.add("For un the bell tolls - Metallica");
        jobsToRun.add("City of Rock - Kiss");
        jobsToRun.add("Remember you - SkidRow");
        jobsToRun.add(null);
        jobsToRun.add("Point of Authority - Linking Park");
        jobsToRun.getFirst(); // City of Rock
    }

    private static void linkedHashSet() {
        //Hash table and linked list implementation of the Set interface, maintains the insertion order of elements
        // Example: Consider a web application that tracks user activity. You want to maintain a set of unique URLs that
        // users have visited, while also preserving the order in which they were accessed
        LinkedHashSet<String> stepsUser = new LinkedHashSet<>();
        stepsUser.add("Home Page");
        stepsUser.add("Cart - Page");
        stepsUser.add(null);
        stepsUser.add("Checkout - Page");
    }

    private static void hashSet() {
        //Hash table-based implementation of the Set interface. Unordered, accept null values.
        // Example: Storing a collection of unique email addresses in an email subscription list.
        HashSet<String> uniqueId = new HashSet<>();
        uniqueId.add("10000");
        uniqueId.add("20000");
        uniqueId.add("10000"); // Value already exist
        uniqueId.add(null);

        int[] nums = new int[]{1,2,3,1};

        HashSet<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (uniques.contains(nums[i])) System.out.println("Contains Duplicates");;
            uniques.add(nums[i]);
        }
        System.out.println("Not contains Duplicates");
    }

    private static void arrayList() {
        //Concrete Implementations:
        //Resizable array implementation of the List interface.
        // Example: Storing a list of user preferences in a web application. Ordered, accepts null values.
        ArrayList<String> list = new ArrayList();
        list.add("Smith Adam ");
        list.add("Dan Sam");
        list.add("Adam Dan");
        list.add(null);

        list.getFirst(); // Adam Dan
    }

    private static void SortedSet() {
        //Set that maintains its elements in ascending order does not allow duplicate values, but it does accept null values.
        // Example: Storing a sorted set of timestamps for event scheduling.
        SortedSet<Integer> timestamp = new TreeSet<>();
        timestamp.add(12312311);
        timestamp.add(00000122);
        timestamp.add(00123121);

        timestamp.getFirst(); // 00000122
    }

    private static void arrayDeque() {
        // Resizable-array implementation of the Deque interface.
        // Good for sliding window is a common technique
        // Maintains the order of elements in which they were inserted. - Allows null elements - Allow duplicate elements
        // Example: Good for sliding window is a common technique
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(8);
        numbers.add(10);

        numbers.poll();
        numbers.pop();
        numbers.pollFirst();
        numbers.pollLast();
    }

    private static void priorityQueue() {
        //Unbounded priority queue based on a priority heap.
        //Does not allow duplicate elements:  - Does not allow null elements: - Ordered
        // Example:  is commonly used in scenarios where elements need to be processed in order of priority. For example:
        //Job scheduling in an operating system, where processes with higher priority are executed before those with lower priority.
        //Dijkstra's algorithm for finding the shortest path in a graph, where nodes with lower distances are explored first.
        PriorityQueue<Integer> listOfJobs = new PriorityQueue<>();
        listOfJobs.add(32);
        listOfJobs.add(2);
        listOfJobs.add(5);
        listOfJobs.add(16);
        listOfJobs.add(23);

        List<Integer> kafka = new ArrayList<>();

        while(!listOfJobs.isEmpty()){
            kafka.add(listOfJobs.poll());
            System.out.println(kafka.getLast());
        }
    }

    private static void dequeue() {
        //Double-ended queue that supports insertion and removal of elements at both ends LIFO.
        // Example: Implementing a deque for storing browser history in a web browser.
        Deque<String> history = new ArrayDeque<>();
        history.add("google");
        history.add("amazon");
        history.add("shoppe");

        history.peek(); // shoppe
    }

    private static void queue() {
        //Ordered collection used to hold elements before processing FIFO.
        // Example: Implementing a queue for processing tasks in a job scheduler.
        Queue<String> jobs = new LinkedList<>();
        jobs.add("payment1");
        jobs.add("payment2");
        jobs.add("payment3");

        jobs.peek(); // payment1
        jobs.poll();
    }

    private static void set() {
        //Unordered collection that contains no duplicate elements and does not allow null values.
        // Example: Storing a set of unique email addresses in an email subscription list.
        Set<String> emails = new HashSet<>();
        emails.add("danielsimi@hotmail.com");
    }


    private static void list() {
        //Ordered collection (allows duplicate elements) that can contain null values.
        // Example: Storing a list of student names in a class roster.
        List<String> students = new ArrayList<>();
        students.add("Daniel");
    }
}
