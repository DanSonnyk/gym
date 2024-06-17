package fundamentals.java.lambda;

public class Execute {
    public static void main(String[] args) {
        Printable printable = s -> {
            return "Meow!" + s;
        };
        System.out.println(printable.print("Animal: "));



    }
}
