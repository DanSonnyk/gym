package leetcode.fundamentals;

public class ImmutableObjects {
    public static void main(String[] args) {
        immutableObjectsExample();
    }

    private static void immutableObjectsExample() {
        ImmutableObjects.Person person = new ImmutableObjects.Person("John", 30);
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

}
