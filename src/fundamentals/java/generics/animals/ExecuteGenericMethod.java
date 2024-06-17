package fundamentals.java.generics.animals;

public class ExecuteGenericMethod {
    public static void main(String[] args) {
        shout("Auau");
        shout(123);
    }

    private static <T> void shout (T toShout){
        System.out.println(toShout);
    }

}
