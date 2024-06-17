package fundamentals.java.lambda.dragons;


public class RunGame {
    public static void main(String[] args) {

        Dragon dragon = s -> {
            return s + "Lightning Shoot!!!";
        };
        fire(dragon);
    }

    public static void fire(Dragon dragon){
        System.out.println(dragon.attack("Sky Dragon:"));
    }
}
