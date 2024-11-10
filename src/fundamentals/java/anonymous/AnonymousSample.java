package fundamentals.java.anonymous;

public class AnonymousSample {
    public static void main(String[] args) {
        // Creating an anonymous class implementing the Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };

        // Calling the method
        greeting.sayHello();
    }
}
