package fundamentals.java.generics.animals;

public class ExecuteGenericClass {
    public static void main(String[] args) {
        Printer<Cat> printerCat = new Printer<>(new Cat());
        printerCat.print();
    }
}
